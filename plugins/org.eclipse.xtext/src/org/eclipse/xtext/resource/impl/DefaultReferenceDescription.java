/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultReferenceDescription implements IReferenceDescription {

	private int indexInList = -1;
	private URI sourceEObjectUri;
	private URI targetEObjectUri;
	private EReference eReference;
	private URI containerEObjectURI;

	public DefaultReferenceDescription(EObject from, EObject to, EReference eReference, int i, URI containerEObjectURI) {
		this.sourceEObjectUri = EcoreUtil2.getPlatformResourceOrNormalizedURI(from);
		this.targetEObjectUri = EcoreUtil2.getPlatformResourceOrNormalizedURI(to);
		this.eReference = eReference;
		this.indexInList = i;
		this.containerEObjectURI = containerEObjectURI;
	}

	/**
	 * @since 2.4
	 */
	public DefaultReferenceDescription(URI sourceEObjectUri, URI targetEObjectUri, EReference eReference,
			int indexInList, URI containerEObjectURI) {
		super();
		this.sourceEObjectUri = sourceEObjectUri;
		this.targetEObjectUri = targetEObjectUri;
		this.eReference = eReference;
		this.indexInList = indexInList;
		this.containerEObjectURI = containerEObjectURI;
	}


	public int getIndexInList() {
		return indexInList;
	}

	public URI getSourceEObjectUri() {
		return sourceEObjectUri;
	}

	public URI getTargetEObjectUri() {
		return targetEObjectUri;
	}

	public EReference getEReference() {
		return eReference;
	}

	public URI getContainerEObjectURI() {
		return containerEObjectURI;
	}

}
