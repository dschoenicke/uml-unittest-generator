package codetestconverter.assertions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import test.TestAssertion;
import test.TestAssertionType;

/**
 * Tests the {@link RelationshipAssertionConverter}.
 * 
 * @author dschoenicke
 *
 */
public class RelationshipAssertionConverterTest extends AssertionTests {

	/**
	 * Tests {@link RelationshipAssertionConverter#createSuperClassAssertion}.
	 */
	@Test
	public void testCreateSuperClassAssertion() {
		assertEquals(RelationshipAssertionConverter.createSuperClassAssertion(mockCodeClass, null).getMessage(),
				mockCodeClass.getName() + " is expected to extend no super class!");
		assertEquals(RelationshipAssertionConverter.createSuperClassAssertion(mockCodeClass, mockCodeClass).getMessage(),
				mockCodeClass.getName() + " is expected to extend " + mockCodeClass.getQualifiedName() + "!");
	}
	
	/**
	 * Tests {@link RelationshipAssertionConverter#createSuperInterfaceAssertions}.
	 */
	@Test
	public void testCreateSuperInterfaceAssertions() {
		ArrayList<TestAssertion> convertedAssertions = RelationshipAssertionConverter.createSuperInterfaceAssertions(mockCodeClass, mockCodeClass.getInterfaces());
		assertEquals(convertedAssertions.size(), 2);
		assertEquals(convertedAssertions.get(0).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(convertedAssertions.get(1).getAssertionType(), TestAssertionType.HASSUPERINTERFACE);
	}
	
	/**
	 * Tests {@link RelationshipAssertionConverter#createRelationshipAssertions}.
	 */
	@Test
	public void testCreateRelationshipAssertions() {
		mockCodeClass.setSuperClass(mockCodeClass);
		mockCodeInterface.addInterface(mockCodeInterface);
		mockCodeEnumeration.addInterface(mockCodeInterface);
		
		RelationshipAssertionConverter.createRelationshipAssertions(mockCodeClass, mockTestMethod);
		RelationshipAssertionConverter.createRelationshipAssertions(mockCodeInterface, mockTestMethod);
		RelationshipAssertionConverter.createRelationshipAssertions(mockCodeEnumeration, mockTestMethod);
	
		assertEquals(mockTestMethod.getAssertions().size(), 7);
		assertEquals(mockTestMethod.getAssertions().get(0).getAssertionType(), TestAssertionType.HASSUPERCLASS);
		assertEquals(mockTestMethod.getAssertions().get(1).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(2).getAssertionType(), TestAssertionType.HASSUPERINTERFACE);
		assertEquals(mockTestMethod.getAssertions().get(3).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(4).getAssertionType(), TestAssertionType.HASSUPERINTERFACE);
		assertEquals(mockTestMethod.getAssertions().get(5).getAssertionType(), TestAssertionType.COUNT);
		assertEquals(mockTestMethod.getAssertions().get(6).getAssertionType(), TestAssertionType.HASSUPERINTERFACE);
	}
}
