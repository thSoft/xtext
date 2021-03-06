/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * A value converter that delegates to the {@link org.eclipse.emf.ecore.EFactory} of a {@link EDataType}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EFactoryValueConverter implements IValueConverter<Object> {

	private final EDataType dataType;

	public EFactoryValueConverter(EDataType dataType) {
		this.dataType = dataType;
	}

	public String toString(Object value) {
		return dataType.getEPackage().getEFactoryInstance().convertToString(dataType, value);
	}

	public Object toValue(String string, INode node) throws ValueConverterException {
		try {
			Object value = dataType.getEPackage().getEFactoryInstance().createFromString(dataType, string);
			if (value == null && dataType.getInstanceClass().isPrimitive()) {
				throw new ValueConverterException("Couldn't convert '" + Strings.notNull(string) + "' to "
						+ dataType.getName() + ".", node, null);
			}
			return value;
		} catch (Exception exc) {
			throw new ValueConverterException("Error converting string to value", node, exc);
		}
	}

}
