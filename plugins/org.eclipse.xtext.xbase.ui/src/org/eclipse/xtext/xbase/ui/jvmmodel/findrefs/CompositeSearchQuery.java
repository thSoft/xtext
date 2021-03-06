/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.findrefs;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.internal.ui.search.JavaSearchQuery;
import org.eclipse.jdt.internal.ui.search.SearchResultUpdater;
import org.eclipse.jdt.ui.search.QuerySpecification;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.xtext.xbase.ui.internal.XtypeActivator;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CompositeSearchQuery extends JavaSearchQuery {

	private List<ISearchQuery> children = newArrayList();
	
	private CompositeSearchResult searchResult;
	
	private String label;

	public CompositeSearchQuery(QuerySpecification data) {
		super(data);
	}
	
	public void addChild(ISearchQuery child) {
		children.add(child);
	}
	
	@Override
	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(monitor, children.size());
		MultiStatus multiStatus = new MultiStatus(getPluginId(), 
				IStatus.OK, "Composite search state", null);
		for(ISearchQuery child: children) {
			IStatus status = child.run(progress.newChild(1));
			multiStatus.add(status);
			if(progress.isCanceled())
				multiStatus.add(new Status(IStatus.WARNING, getPluginId(), "Search operation canceled by user"));
		}
		return multiStatus;
	}

	protected String getPluginId() {
		return XtypeActivator.getInstance().getBundle().getSymbolicName();
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public boolean canRerun() {
		for(ISearchQuery child: children) 
			if(!child.canRerun())
				return false;
		return true;
	}

	@Override
	public boolean canRunInBackground() {
		for(ISearchQuery child: children) 
			if(!child.canRunInBackground())
				return false;
		return true;
	}

	@Override
	public ISearchResult getSearchResult() {
		if(searchResult == null) {
			searchResult = new CompositeSearchResult(this);
			new SearchResultUpdater(searchResult);
		}
		return searchResult;
	}

	public List<ISearchQuery> getChildren() {
		return children;
	}
	
}
