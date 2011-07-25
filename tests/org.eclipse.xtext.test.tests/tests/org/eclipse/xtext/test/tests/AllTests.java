package org.eclipse.xtext.test.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		// $JUnit-BEGIN$
		suite.addTestSuite(UiAvaiableTest.class);
		suite.addTestSuite(SimpleJunitTestTest.class);
		// $JUnit-END$
		return suite;
	}

}
