/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Parameterized Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmParameterizedTypeReference()
 * @model
 * @generated
 */
public interface JvmParameterizedTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmParameterizedTypeReference_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getArguments();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmParameterizedTypeReference_Type()
	 * @model
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

} // JvmParameterizedTypeReference
