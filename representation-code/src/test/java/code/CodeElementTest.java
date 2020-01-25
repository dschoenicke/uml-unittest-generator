package code;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CodeElementTest extends CodeRepresentationTests {

	@Test
	public void testGetNestedElementsAsList() {
		CodeClass nestedClass= new CodeClass("nestedClass", codeEnumeration, 0);
		codeEnumeration.addNestedElement(nestedClass);
		List<CodeElement> elements = codeSubPackageClass.getNestedElementsAsList();
		assertTrue(elements.contains(codeEnumeration));
		assertTrue(elements.contains(nestedClass));
	}
}
