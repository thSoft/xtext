/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.LanguageInfo;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class LanguageAwareTaskMarkerTypeProvider extends TaskMarkerTypeProvider {

	private String taskMarkerType;

	@Inject
	public void initialize(LanguageInfo languageInfo, AbstractUIPlugin uiPlugin) {
		String bundleName = uiPlugin.getBundle().getSymbolicName();
		String languageName = languageInfo.getShortName().toLowerCase();
		taskMarkerType = bundleName + "." + languageName + ".task";
	}

	@Override
	public String getMarkerType() {
		return taskMarkerType;
	}

}
