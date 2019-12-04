package codetestconverter.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestAssertionType;

/**
 * Tests the {@link FieldAssertionConverter}.
 * 
 * @author dschoenicke
 *
 */
public class FieldAssertionConverterTest extends AssertionTests {

	/**
	 * Tests {@link FieldAssertionConverter#createFieldAssertions}.
	 */
	@Test
	public void testFieldAssertionConverter() {
		FieldAssertionConverter.createFieldAssertions(mockCodeClass, mockTestMethod);
		assertEquals(mockTestMethod.getAssertions().size(), 7);
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.HASFIELD);
		assertEquals(mockTestMethod.getAssertions().get(2).getAssertionType(), TestAssertionType.HASTYPE);
		assertEquals(mockTestMethod.getAssertions().get(3).getAssertionType(), TestAssertionType.MODIFIERS);
		assertEquals(mockTestMethod.getAssertions().get(4).getAssertionType(), TestAssertionType.HASFIELD);
		assertEquals(mockTestMethod.getAssertions().get(5).getAssertionType(), TestAssertionType.HASTYPE);
		assertEquals(mockTestMethod.getAssertions().get(6).getAssertionType(), TestAssertionType.MODIFIERS);
	}
	
	/**
	 * Tests {@link FieldAssertionConverter#createEnumConstantAssertions}.
	 */
	@Test
	public void testEnumConstantAssertionConverter() {
		FieldAssertionConverter.createEnumConstantAssertions(mockCodeEnumeration, mockTestMethod);
		assertEquals(mockTestMethod.getAssertions().size(), 3);
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.HASENUMCONSTANT);
		assertEquals(mockTestMethod.getAssertions().get(2).getAssertionType(), TestAssertionType.HASENUMCONSTANT);
	}
}
