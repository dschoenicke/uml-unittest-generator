package code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class testing the {@link code.CodeModifier#convertModifierValue}
 * 
 * @author dschoenicke
 *
 */
public class CodeModifierTest {

	/**
	 * Test method creating a sample class and validating the calculated modifier
	 */
	@Test
	public void testModifierValueConversion() {
		CodeClass codeClass = new CodeClass("test", null, CodeVisibility.PROTECTED, true, false, true);
		assertEquals(codeClass.getModifiers(), 1044);
		assertTrue("codeClass is expected to be protected!", CodeModifier.isProtected(codeClass.getModifiers()));
		assertTrue("codeClass is expected to be abstract!", CodeModifier.isAbstract(codeClass.getModifiers()));
		assertFalse("codeClass is expected to be not static!", CodeModifier.isStatic(codeClass.getModifiers()));
		assertTrue("codeClass is expected to be final!", CodeModifier.isFinal(codeClass.getModifiers()));
	}
	
	/**
	 * Test method creating a sample class with default access modifier and validating the result
	 */
	@Test
	public void testDefaultAccess() {
		CodeClass codeClass = new CodeClass("test", null, CodeVisibility.PACKAGE, true, false, true);
		assertTrue("codeClass is expected to have default access!", CodeModifier.hasDefaultAccess(codeClass.getModifiers()));
	}
}
