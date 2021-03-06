/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public abstract class AbstractSessionBasedExecutableScope extends AbstractSessionBasedScope {
	
	private final OperatorMapping operatorMapping;

	protected AbstractSessionBasedExecutableScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, OperatorMapping operatorMapping) {
		super(parent, session, featureCall);
		this.operatorMapping = operatorMapping;
	}
	
	protected OperatorMapping getOperatorMapping() {
		return operatorMapping;
	}
	
	@Override
	protected void processFeatureNames(QualifiedName name, NameAcceptor acceptor) {
		QualifiedName methodName = operatorMapping == null? null : operatorMapping.getMethodName(name);
		if (methodName != null) {
			acceptor.accept(methodName.toString(), 2);
			QualifiedName simpleOperator = operatorMapping.getSimpleOperator(name);
			if (simpleOperator != null) {
				QualifiedName simpleMethodName = operatorMapping.getMethodName(simpleOperator);
				if (simpleMethodName != null) {
					acceptor.accept(simpleMethodName.toString(), 3);
				}
			}
		} else {
			acceptor.accept(name.toString(), 1);
			processAsPropertyNames(name, acceptor);
		}
	}

}
