/**
 * 
 */
package org.eclipse.xtext.test.tests;

import junit.framework.Test;
import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

/**
 * @author huebner
 * 
 */
public class DependenciesAvailableTest extends TestCase {
	public void testEmfRegistryInitialized() {
		System.out.println("EmfAvaiableTest.testEmfRegistryInitialized()"
				+ EcorePackageImpl.init());
		assertFalse(Registry.INSTANCE.isEmpty());
	}

	public void testEasyMock() {
		Test niceMock = EasyMock.createNiceMock(Test.class);
		assertNotNull(niceMock);
	}

}
