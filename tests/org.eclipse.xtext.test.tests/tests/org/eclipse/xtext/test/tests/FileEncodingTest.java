/**
 * 
 */
package org.eclipse.xtext.test.tests;

import java.nio.charset.Charset;

import junit.framework.TestCase;

/**
 * @author huebner
 * 
 */
public class FileEncodingTest extends TestCase {

	private static final String ISO_8859_1 = "ISO-8859-1";

	public void testDefautEncodingIsProperlySet() {
		assertEquals(
				"Required Encoding is ISO-8859-1. build server: pass -Dfile.encoding=ISO-8859-1 as argLine.  local: change settings->general->workspace encoding",
				ISO_8859_1, Charset.defaultCharset().name());
	}
}
