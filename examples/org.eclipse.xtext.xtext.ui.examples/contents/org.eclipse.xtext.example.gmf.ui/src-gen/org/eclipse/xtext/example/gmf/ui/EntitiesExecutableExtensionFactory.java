/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.gmf.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EntitiesExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipse.xtext.example.gmf.ui.internal.EntitiesActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.eclipse.xtext.example.gmf.ui.internal.EntitiesActivator.getInstance().getInjector("org.eclipse.xtext.example.gmf.Entities");
	}
	
}
