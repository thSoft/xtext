/**
 * 
 */
package org.eclipse.xtext.test.tests;

import junit.framework.Test;
import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

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

	/**
	 * Load some xtext.util class
	 */
	public void testXtext() {
		Pair<String, String> pair = Tuples.create("first", "second");
		assertEquals("first", pair.getFirst());
		assertEquals("second", pair.getSecond());
	}
}
