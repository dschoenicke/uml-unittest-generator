package codetestconverter.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestAssertionType;

/**
 * Tests the {@link MethodAssertionConverter}.
 * 
 * @author dschoenicke
 *
 */
public class MethodAssertionConverterTest extends AssertionTests {

	/**
	 * Tests {@link MethodAssertionConverter#createMethodAssertions}.
	 */
	@Test
	public void testMethodAssertionConverter() {
		MethodAssertionConverter.createMethodAssertions(mockCodeClass, mockTestMethod);
		assertEquals(mockTestMethod.getAssertions().size(), 7);
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.HASMETHOD);
		assertEquals(mockTestMethod.getAssertions().get(2).getAssertionType(), TestAssertionType.HASTYPE);
		assertEquals(mockTestMethod.getAssertions().get(3).getAssertionType(), TestAssertionType.MODIFIERS);
		assertEquals(mockTestMethod.getAssertions().get(4).getAssertionType(), TestAssertionType.HASMETHOD);
		assertEquals(mockTestMethod.getAssertions().get(5).getAssertionType(), TestAssertionType.HASTYPE);
		assertEquals(mockTestMethod.getAssertions().get(6).getAssertionType(), TestAssertionType.MODIFIERS);
	}
}
