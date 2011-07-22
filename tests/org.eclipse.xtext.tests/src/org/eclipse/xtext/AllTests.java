/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author huebner - Initial contribution and API
 */
public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(AllContentsPerformanceTest.class);
		suite.addTestSuite(EcoreUtil2Test.class);
		suite.addTestSuite(GrammarUtilGetReferenceTest.class);
		suite.addTestSuite(GrammarUtilTest.class);
		suite.addTestSuite(XtextGrammarTest.class);
		//$JUnit-END$
		return suite;
	}

}
