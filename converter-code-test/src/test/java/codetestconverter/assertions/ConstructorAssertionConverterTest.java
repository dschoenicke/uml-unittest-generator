package codetestconverter.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestAssertionType;

/**
 * Tests the {@link ConstructorAssertionConverter}.
 * 
 * @author dschoenicke
 *
 */
public class ConstructorAssertionConverterTest extends AssertionTests {

	/**
	 * Tests {@link ConstructorAssertionConverter#createConstructorAssertions}.
	 */
	@Test
	public void testConstructorAssertionConverter() {
		ConstructorAssertionConverter.createConstructorAssertions(mockCodeClass, mockTestMethod);
		assertEquals(mockTestMethod.getAssertions().size(), 5);
		
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.HASCONSTRUCTOR);
		assertEquals(mockTestMethod.getAssertions().get(2).getAssertionType(), TestAssertionType.MODIFIERS);
		assertEquals(mockTestMethod.getAssertions().get(3).getAssertionType(), TestAssertionType.HASCONSTRUCTOR);
		assertEquals(mockTestMethod.getAssertions().get(4).getAssertionType(), TestAssertionType.MODIFIERS);
	}
}
