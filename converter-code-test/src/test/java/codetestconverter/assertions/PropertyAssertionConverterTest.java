package codetestconverter.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestAssertionType;

/**
 * Tests the {@link PropertyAssertionConverter}.
 * 
 * @author dschoenicke
 *
 */
public class PropertyAssertionConverterTest extends AssertionTests {

	/**
	 * Tests {@link PropertyAssertionConverter#createPropertyAssertions}.
	 */
	@Test
	public void testPropertyAssertionConverter() {
		PropertyAssertionConverter.createPropertyAssertions(mockCodeClass, mockTestMethod);
		PropertyAssertionConverter.createPropertyAssertions(mockCodeInterface, mockTestMethod);
		PropertyAssertionConverter.createPropertyAssertions(mockCodeEnumeration, mockTestMethod);
		assertEquals(mockTestMethod.getAssertions().size(), 10);
	
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.CLASSEXISTS);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.MODIFIERS);
		assertEquals(mockTestMethod.getAssertions().get(2).getAssertionType(), TestAssertionType.ISCLASS);
		
		assertEquals(mockTestMethod.getAssertions().get(3).getAssertionType(), TestAssertionType.CLASSEXISTS);
		assertEquals(mockTestMethod.getAssertions().get(4).getAssertionType(), TestAssertionType.MODIFIERS);
		assertEquals(mockTestMethod.getAssertions().get(5).getAssertionType(), TestAssertionType.ISINTERFACE);
		
		assertEquals(mockTestMethod.getAssertions().get(6).getAssertionType(), TestAssertionType.CLASSEXISTS);
		assertEquals(mockTestMethod.getAssertions().get(7).getAssertionType(), TestAssertionType.MODIFIERS);
		assertEquals(mockTestMethod.getAssertions().get(8).getAssertionType(), TestAssertionType.ISENUMERATION);
		assertEquals(mockTestMethod.getAssertions().get(9).getAssertionType(), TestAssertionType.HASNESTHOST);
	}
}
