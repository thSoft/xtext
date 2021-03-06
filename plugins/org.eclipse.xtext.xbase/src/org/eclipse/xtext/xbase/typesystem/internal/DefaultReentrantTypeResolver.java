/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.scoping.batch.FeatureScopes;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.validation.FeatureNameValidator;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class DefaultReentrantTypeResolver extends AbstractRootedReentrantTypeResolver {

	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private ITypeComputer typeComputer;
	
	@Inject
	private ScopeProviderAccess scopeProviderAccess;
	
	@Inject
	private IBatchScopeProvider batchScopeProvider;
	
	@Inject
	private ExpressionArgumentFactory expressionArgumentFactory;
	
	@Inject
	private FeatureNameValidator featureNameValidator;
	
	@Inject
	private IssueSeveritiesProvider issueSeveritiesProvider;
	
	@Inject(optional = true)
	private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;
	
	@Inject
	private FeatureScopes featureScopes;
	
	private EObject root;
	
	private boolean resolving = false;
	
	public final void initializeFrom(EObject root) {
		if (this.root != null) {
			throw new IllegalStateException("Cannot reinitialize. Resolver has already a root: " + this.root);
		}
		this.root = root;
	}

	@Override
	protected final EObject getRoot() {
		return root;
	}
	
	@Override
	protected boolean isHandled(EObject context) {
		return EcoreUtil.getRootContainer(context) == getRoot();
	}

	@Override
	protected boolean isHandled(XExpression expression) {
		return EcoreUtil.getRootContainer(expression) == getRoot();
	}
	
	@Override
	protected boolean isHandled(JvmIdentifiableElement identifiableElement) {
		return EcoreUtil.getRootContainer(identifiableElement) == getRoot();
	}
	
	protected IssueSeverities getIssueSeverities() {
		Resource resource = root == null ? null : root.eResource();
		return issueSeveritiesProvider.getIssueSeverities(resource);
	}
	
	public IResolvedTypes reentrantResolve() {
		if (resolving) {
			throw new UnsupportedOperationException("TODO: import a functional handle on the type resolution that delegates to the best available (current, but evolving) result");
		}
		StoppedTask task = Stopwatches.forTask("DefaultReentrantTypeResolver.resolve");
		try {
			task.start();
			resolving = true;
			return resolve();
		} finally {
			resolving = false;
			task.stop();
		}
	}
	
	protected IResolvedTypes resolve() {
		if (isInvalidRoot()) {
			return IResolvedTypes.NULL;
		}
		RootResolvedTypes result = createResolvedTypes();
		IFeatureScopeSession session = batchScopeProvider.newSession(root.eResource());
		computeTypes(result, session);
		result.resolveUnboundTypeParameters();
		result.resolveProxies();
		result.addDiagnostics(root.eResource());
		return result;
	}

	private boolean isInvalidRoot() {
		return root == null || root.eResource() == null || root.eResource().getResourceSet() == null;
	}

	protected RootResolvedTypes createResolvedTypes() {
		return new RootResolvedTypes(this);
	}

	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		computeTypes(resolvedTypes, session, root);
	}
	
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session, EObject element) {
		if (element instanceof XExpression) {
			_computeTypes(resolvedTypes, session, (XExpression) element);
		} else {
			throw new IllegalArgumentException("element: " + element);
		}
	}

	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session, XExpression expression) {
		ExpressionBasedRootTypeComputationState state = new ExpressionBasedRootTypeComputationState(resolvedTypes, session, expression);
		state.computeTypes();
	}
	
	protected boolean isShadowingAllowed(QualifiedName name) {
		return featureNameValidator.isShadowingAllowed(name);
	}
	
	protected boolean isDisallowedName(QualifiedName name) {
		return featureNameValidator.isDisallowedName(name);
	}
	
	protected boolean isDiscouragedName(QualifiedName name) {
		return featureNameValidator.isDiscouragedName(name);
	}
	
	protected ITypeComputer getTypeComputer() {
		return typeComputer;
	}

	protected void setTypeComputer(ITypeComputer typeComputer) {
		this.typeComputer = typeComputer;
	}
	
	protected ScopeProviderAccess getScopeProviderAccess() {
		return scopeProviderAccess;
	}

	protected IBatchScopeProvider getBatchScopeProvider() {
		return batchScopeProvider;
	}
	
	protected ExpressionArgumentFactory getExpressionArgumentFactory() {
		return expressionArgumentFactory;
	}

	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	protected BoundTypeArgumentMerger getTypeArgumentMerger() {
		return services.getBoundTypeArgumentMerger();
	}

	protected EObject getSourceElement(EObject element) {
		return element;
	}
	
	protected XbaseFactory getXbaseFactory() {
		return xbaseFactory;
	}
	
	protected FeatureScopes getFeatureScopes() {
		return featureScopes;
	}
}
