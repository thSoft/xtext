/**
 * 
 */
package org.eclipse.xtext.test.tests;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

/**
 * @author huebner
 * 
 */
public class DependenciesAvaiableTest extends TestCase {
	public void testEmfRegistryInitialized() {
		System.out.println("EmfAvaiableTest.testEmfRegistryInitialized()"
				+ EcorePackageImpl.init());
		assertFalse(Registry.INSTANCE.isEmpty());
	}

}
