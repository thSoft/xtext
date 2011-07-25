/**
 * 
 */
package org.eclipse.xtext.test.tests;

import junit.framework.TestCase;

import org.eclipse.ui.PlatformUI;

/**
 * @author huebner
 * 
 */
public class UiAvaiableTest extends TestCase {

	/**
	 * Tests Workbench is loaded
	 */
	public void testWorkbench() {
		assertNotNull(PlatformUI.getWorkbench());
	}
}
