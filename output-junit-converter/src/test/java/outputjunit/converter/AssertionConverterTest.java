package outputjunit.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.JunitConstructorUnderTest;
import junit.JunitFieldUnderTest;
import junit.JunitMethodUnderTest;
import junit.JunitTemplateParameterUnderTest;
import outputjunit.OutputJunitConverterTests;

public class AssertionConverterTest extends OutputJunitConverterTests {

	@Test
	public void testCreatePropertyAssertions() {
		AssertionConverter.createPropertyAssertions(mockClass1, mockJunitTestClass1);
		assertEquals(7, mockJunitTestClass1.getPropertyAssertions().size());
		assertEquals("true", mockJunitTestClass1.getPropertyAssertions().get(0).getExpectedValue());
		assertEquals("classUnderTest.isInterface()", mockJunitTestClass1.getPropertyAssertions().get(0).getActualValue());
		assertEquals("app.firstpackage.firstclass must be an interface!", mockJunitTestClass1.getPropertyAssertions().get(0).getMessage());
		assertEquals("\"app.firstpackage.firstclass\"", mockJunitTestClass1.getPropertyAssertions().get(1).getExpectedValue());
		assertEquals("classUnderTest.getNestHost().getName()", mockJunitTestClass1.getPropertyAssertions().get(1).getActualValue());
		assertEquals("app.firstpackage.firstclass must not be an inner class!", mockJunitTestClass1.getPropertyAssertions().get(1).getMessage());
		assertEquals("false", mockJunitTestClass1.getPropertyAssertions().get(2).getExpectedValue());
		assertEquals("Modifier.isPublic(classUnderTest.getModifiers())", mockJunitTestClass1.getPropertyAssertions().get(2).getActualValue());
		assertEquals("app.firstpackage.firstclass must not be public!", mockJunitTestClass1.getPropertyAssertions().get(2).getMessage());
		assertEquals("false", mockJunitTestClass1.getPropertyAssertions().get(3).getExpectedValue());
		assertEquals("Modifier.isPrivate(classUnderTest.getModifiers())", mockJunitTestClass1.getPropertyAssertions().get(3).getActualValue());
		assertEquals("app.firstpackage.firstclass must not be private!", mockJunitTestClass1.getPropertyAssertions().get(3).getMessage());
		assertEquals("false", mockJunitTestClass1.getPropertyAssertions().get(4).getExpectedValue());
		assertEquals("Modifier.isProtected(classUnderTest.getModifiers())", mockJunitTestClass1.getPropertyAssertions().get(4).getActualValue());
		assertEquals("app.firstpackage.firstclass must not be protected!", mockJunitTestClass1.getPropertyAssertions().get(4).getMessage());
		assertEquals("false", mockJunitTestClass1.getPropertyAssertions().get(5).getExpectedValue());
		assertEquals("Modifier.isFinal(classUnderTest.getModifiers())", mockJunitTestClass1.getPropertyAssertions().get(5).getActualValue());
		assertEquals("app.firstpackage.firstclass must not be final!", mockJunitTestClass1.getPropertyAssertions().get(5).getMessage());
		assertEquals("false", mockJunitTestClass1.getPropertyAssertions().get(6).getExpectedValue());
		assertEquals("Modifier.isAbstract(classUnderTest.getModifiers())", mockJunitTestClass1.getPropertyAssertions().get(6).getActualValue());
		assertEquals("app.firstpackage.firstclass must not be abstract!", mockJunitTestClass1.getPropertyAssertions().get(6).getMessage());
		
		AssertionConverter.createPropertyAssertions(mockClass2, mockJunitTestClass2);
		assertEquals("true", mockJunitTestClass2.getPropertyAssertions().get(0).getExpectedValue());
		assertEquals("!(classUnderTest.isEnum() || classUnderTest.isInterface())", mockJunitTestClass2.getPropertyAssertions().get(0).getActualValue());
		assertEquals("app.secondpackage.secondclass must be a class!", mockJunitTestClass2.getPropertyAssertions().get(0).getMessage());
		assertEquals("true", mockJunitTestClass2.getPropertyAssertions().get(2).getExpectedValue());
		assertEquals("app.secondpackage.secondclass must be public!", mockJunitTestClass2.getPropertyAssertions().get(2).getMessage());
		assertEquals("true", mockJunitTestClass2.getPropertyAssertions().get(3).getExpectedValue());
		assertEquals("app.secondpackage.secondclass must be private!", mockJunitTestClass2.getPropertyAssertions().get(3).getMessage());
		assertEquals("true", mockJunitTestClass2.getPropertyAssertions().get(4).getExpectedValue());
		assertEquals("app.secondpackage.secondclass must be protected!", mockJunitTestClass2.getPropertyAssertions().get(4).getMessage());
		assertEquals("true", mockJunitTestClass2.getPropertyAssertions().get(5).getExpectedValue());
		assertEquals("app.secondpackage.secondclass must be final!", mockJunitTestClass2.getPropertyAssertions().get(5).getMessage());
		assertEquals("true", mockJunitTestClass2.getPropertyAssertions().get(6).getExpectedValue());
		assertEquals("app.secondpackage.secondclass must be abstract!", mockJunitTestClass2.getPropertyAssertions().get(6).getMessage());
		
		AssertionConverter.createPropertyAssertions(mockInnerClass, mockJunitInnerTestClass);
		assertEquals("true", mockJunitInnerTestClass.getPropertyAssertions().get(0).getExpectedValue());
		assertEquals("classUnderTest.isEnum()", mockJunitInnerTestClass.getPropertyAssertions().get(0).getActualValue());
		assertEquals("app.secondpackage.secondclass$innerclass must be an enumeration!", mockJunitInnerTestClass.getPropertyAssertions().get(0).getMessage());
		assertEquals("\"app.secondpackage.secondclass\"", mockJunitInnerTestClass.getPropertyAssertions().get(1).getExpectedValue());
		assertEquals("app.secondpackage.secondclass$innerclass must be an inner class of app.secondpackage.secondclass!", mockJunitInnerTestClass.getPropertyAssertions().get(1).getMessage());
	}
	
	/**
	 * Tests {@link AssertionConverter#createRelationshipAssertions}
	 */
	@Test
	public void testCreateRelationshipAssertions() {
		AssertionConverter.createRelationshipAssertions(mockClass1, mockJunitTestClass1);
		assertEquals(1, mockJunitTestClass1.getRelationshipAssertions().size());
		assertEquals("0", mockJunitTestClass1.getRelationshipAssertions().get(0).getExpectedValue());
		assertEquals("classUnderTest.getInterfaces().length", mockJunitTestClass1.getRelationshipAssertions().get(0).getActualValue());
		assertEquals("app.firstpackage.firstclass must extend exactly 0 interfaces!", mockJunitTestClass1.getRelationshipAssertions().get(0).getMessage());
	
		AssertionConverter.createRelationshipAssertions(mockSubClass, mockJunitSubTestClass);
		assertEquals("\"firstclass\"", mockJunitSubTestClass.getRelationshipAssertions().get(0).getExpectedValue());
		assertEquals("classUnderTest.getSuperclass().getSimpleName()", mockJunitSubTestClass.getRelationshipAssertions().get(0).getActualValue());
		assertEquals("app.firstpackage.subpackage.subclass must extend firstclass!", mockJunitSubTestClass.getRelationshipAssertions().get(0).getMessage());
		
		AssertionConverter.createRelationshipAssertions(mockInnerClass, mockJunitInnerTestClass);
		assertEquals(3, mockJunitInnerTestClass.getRelationshipAssertions().size());
		assertEquals("true", mockJunitInnerTestClass.getRelationshipAssertions().get(2).getExpectedValue());
		assertEquals("java.util.Arrays.asList(classUnderTest.getInterfaces()).stream().filter(i -> i.getName().equals(\"app.firstpackage.firstclass\")).findFirst().isPresent()", mockJunitInnerTestClass.getRelationshipAssertions().get(2).getActualValue());
		assertEquals("app.secondpackage.secondclass$innerclass must implement the interface app.firstpackage.firstclass!", mockJunitInnerTestClass.getRelationshipAssertions().get(2).getMessage());
	}
	
	/**
	 * Tests {@link AssertionConverter#createTemplateParameterAssertions}
	 */
	@Test
	public void testCreateTemplateParameterAssertions() {
		JunitTemplateParameterUnderTest templateParameter = new JunitTemplateParameterUnderTest("T", "app.firstpackage.firstclass");
		AssertionConverter.createTemplateParameterAssertions(mockClass2, templateParameter);
		assertEquals(2, templateParameter.getAssertions().size());
		assertEquals("true", templateParameter.getAssertions().get(0).getExpectedValue());
		assertEquals("typeParameterUnderTest.isPresent()", templateParameter.getAssertions().get(0).getActualValue());
		assertEquals("app.secondpackage.secondclass must have a template parameter with name T!", templateParameter.getAssertions().get(0).getMessage());
		assertEquals("\"app.firstpackage.firstclass\"", templateParameter.getAssertions().get(1).getExpectedValue());
		assertEquals("typeParameterUnderTest.get().getBounds()[0].getTypeName()", templateParameter.getAssertions().get(1).getActualValue());
		assertEquals("The template parameter T of app.secondpackage.secondclass must extend app.firstpackage.firstclass!", templateParameter.getAssertions().get(1).getMessage());
	}
	
	/**
	 * Tests {@link AssertionConverter#createEnumConstantAssertions}
	 */
	@Test
	public void testCreateEnumConstantAssertions() {
		AssertionConverter.createEnumConstantAssertions(mockClass1, mockJunitTestClass1);
		assertEquals(0, mockJunitTestClass1.getEnumConstantAssertions().size());
		
		AssertionConverter.createEnumConstantAssertions(mockInnerClass, mockJunitInnerTestClass);
		assertEquals(3, mockJunitInnerTestClass.getEnumConstantAssertions().size());
		assertEquals("2", mockJunitInnerTestClass.getEnumConstantAssertions().get(0).getExpectedValue());
		assertEquals("classUnderTest.getEnumConstants().length", mockJunitInnerTestClass.getEnumConstantAssertions().get(0).getActualValue());
		assertEquals("app.secondpackage.secondclass$innerclass must have exactly 2 enum constants!", mockJunitInnerTestClass.getEnumConstantAssertions().get(0).getMessage());
		assertEquals("true", mockJunitInnerTestClass.getEnumConstantAssertions().get(1).getExpectedValue());
		assertEquals("java.util.Arrays.asList(classUnderTest.getEnumConstants()).stream().filter(e -> e.toString().equals(\"TEST1\")).findFirst().isPresent()", mockJunitInnerTestClass.getEnumConstantAssertions().get(1).getActualValue());
		assertEquals("app.secondpackage.secondclass$innerclass must have an enum constant named TEST1!", mockJunitInnerTestClass.getEnumConstantAssertions().get(1).getMessage());
	}
	
	/**
	 * Tests {@link AssertionConverter#createFieldAssertions}
	*/
	@Test
	public void testCreateFieldAssertions() {
		JunitFieldUnderTest field1 = new JunitFieldUnderTest("field1", "int", false, false);
		JunitFieldUnderTest field2 = new JunitFieldUnderTest("field2", "String", true, false);
		AssertionConverter.createFieldAssertions(mockClass2.getFields().get(0), mockClass2, field1);
		assertEquals(6, field1.getAssertions().size());
		assertEquals("false", field1.getAssertions().get(0).getExpectedValue());
		assertEquals("Modifier.isPublic(fieldUnderTest.getModifiers())", field1.getAssertions().get(0).getActualValue());
		assertEquals("app.secondpackage.secondclass#field1 must not be public!", field1.getAssertions().get(0).getMessage());
		assertEquals("false", field1.getAssertions().get(1).getExpectedValue());
		assertEquals("Modifier.isPrivate(fieldUnderTest.getModifiers())", field1.getAssertions().get(1).getActualValue());
		assertEquals("app.secondpackage.secondclass#field1 must not be private!", field1.getAssertions().get(1).getMessage());
		assertEquals("false", field1.getAssertions().get(2).getExpectedValue());
		assertEquals("Modifier.isProtected(fieldUnderTest.getModifiers())", field1.getAssertions().get(2).getActualValue());
		assertEquals("app.secondpackage.secondclass#field1 must not be protected!", field1.getAssertions().get(2).getMessage());
		assertEquals("false", field1.getAssertions().get(3).getExpectedValue());
		assertEquals("Modifier.isStatic(fieldUnderTest.getModifiers())", field1.getAssertions().get(3).getActualValue());
		assertEquals("app.secondpackage.secondclass#field1 must not be static!", field1.getAssertions().get(3).getMessage());
		assertEquals("false", field1.getAssertions().get(4).getExpectedValue());
		assertEquals("Modifier.isFinal(fieldUnderTest.getModifiers())", field1.getAssertions().get(4).getActualValue());
		assertEquals("app.secondpackage.secondclass#field1 must not be final!", field1.getAssertions().get(4).getMessage());
		
		AssertionConverter.createFieldAssertions(mockClass2.getFields().get(1), mockClass2, field2);
		assertEquals("true", field2.getAssertions().get(0).getExpectedValue());
		assertEquals("app.secondpackage.secondclass#field2 must be public!", field2.getAssertions().get(0).getMessage());
		assertEquals("true", field2.getAssertions().get(1).getExpectedValue());
		assertEquals("app.secondpackage.secondclass#field2 must be private!", field2.getAssertions().get(1).getMessage());
		assertEquals("true", field2.getAssertions().get(2).getExpectedValue());
		assertEquals("app.secondpackage.secondclass#field2 must be protected!", field2.getAssertions().get(2).getMessage());
		assertEquals("true", field2.getAssertions().get(3).getExpectedValue());
		assertEquals("app.secondpackage.secondclass#field2 must be static!", field2.getAssertions().get(3).getMessage());
		assertEquals("true", field2.getAssertions().get(4).getExpectedValue());
		assertEquals("app.secondpackage.secondclass#field2 must be final!", field2.getAssertions().get(4).getMessage());
	}
	
	/**
	 * Test {@link AssertionConverter#createConstructorAssertions}
	 */
	@Test
	public void testCreateConstructorAssertions() {
		JunitConstructorUnderTest constructor1 = new JunitConstructorUnderTest("int.class", "int");
		JunitConstructorUnderTest constructor2 = new JunitConstructorUnderTest("", "");
		AssertionConverter.createConstructorAssertions(mockClass2.getConstructors().get(0), mockClass2, constructor1);
		assertEquals("true", constructor1.getAssertions().get(0).getExpectedValue());
		assertEquals("Modifier.isPublic(constructorUnderTest.getModifiers())", constructor1.getAssertions().get(0).getActualValue());
		assertEquals("The constructor with parameters () in app.secondpackage.secondclass must be public!", constructor1.getAssertions().get(0).getMessage());
		assertEquals("true", constructor1.getAssertions().get(1).getExpectedValue());
		assertEquals("Modifier.isPrivate(constructorUnderTest.getModifiers())", constructor1.getAssertions().get(1).getActualValue());
		assertEquals("The constructor with parameters () in app.secondpackage.secondclass must be private!", constructor1.getAssertions().get(1).getMessage());
		assertEquals("true", constructor1.getAssertions().get(2).getExpectedValue());
		assertEquals("Modifier.isProtected(constructorUnderTest.getModifiers())", constructor1.getAssertions().get(2).getActualValue());
		assertEquals("The constructor with parameters () in app.secondpackage.secondclass must be protected!", constructor1.getAssertions().get(2).getMessage());
		
		AssertionConverter.createConstructorAssertions(mockClass2.getConstructors().get(1), mockClass2, constructor2);
		assertEquals("false", constructor2.getAssertions().get(0).getExpectedValue());
		assertEquals("The constructor with parameters (List, app.firstpackage.firstclass) in app.secondpackage.secondclass must not be public!", constructor2.getAssertions().get(0).getMessage());
		assertEquals("false", constructor2.getAssertions().get(1).getExpectedValue());
		assertEquals("The constructor with parameters (List, app.firstpackage.firstclass) in app.secondpackage.secondclass must not be private!", constructor2.getAssertions().get(1).getMessage());
		assertEquals("false", constructor2.getAssertions().get(2).getExpectedValue());
		assertEquals("The constructor with parameters (List, app.firstpackage.firstclass) in app.secondpackage.secondclass must not be protected!", constructor2.getAssertions().get(2).getMessage());
	}
	
	/**
	 * Test {@link AssertionConverter#createMethodAssertions}
	 */
	@Test
	public void testCreateMethodAssertions() {
		JunitMethodUnderTest method1 = new JunitMethodUnderTest("method1", "void", "int.class, app.firstpackage.firstclass", "int, app.firstpackage.firstclass", false, false);
		JunitMethodUnderTest method2 = new JunitMethodUnderTest("method2", "void", "", "", false, false);
		AssertionConverter.createMethodAssertions(mockClass1.getMethods().get(0), mockClass1, method1);
		assertEquals(7, method1.getAssertions().size());
		assertEquals("\"void\"", method1.getAssertions().get(0).getExpectedValue());
		assertEquals("methodUnderTest.getReturnType().getSimpleName()", method1.getAssertions().get(0).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must return void!", method1.getAssertions().get(0).getMessage());
		assertEquals("true", method1.getAssertions().get(1).getExpectedValue());
		assertEquals("Modifier.isPublic(methodUnderTest.getModifiers())", method1.getAssertions().get(1).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be public!", method1.getAssertions().get(1).getMessage());
		assertEquals("true", method1.getAssertions().get(2).getExpectedValue());
		assertEquals("Modifier.isPrivate(methodUnderTest.getModifiers())", method1.getAssertions().get(2).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be private!", method1.getAssertions().get(2).getMessage());
		assertEquals("true", method1.getAssertions().get(3).getExpectedValue());
		assertEquals("Modifier.isProtected(methodUnderTest.getModifiers())", method1.getAssertions().get(3).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be protected!", method1.getAssertions().get(3).getMessage());
		assertEquals("true", method1.getAssertions().get(4).getExpectedValue());
		assertEquals("Modifier.isStatic(methodUnderTest.getModifiers())", method1.getAssertions().get(4).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be static!", method1.getAssertions().get(4).getMessage());
		assertEquals("true", method1.getAssertions().get(5).getExpectedValue());
		assertEquals("Modifier.isFinal(methodUnderTest.getModifiers())", method1.getAssertions().get(5).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be final!", method1.getAssertions().get(5).getMessage());
		assertEquals("true", method1.getAssertions().get(6).getExpectedValue());
		assertEquals("Modifier.isAbstract(methodUnderTest.getModifiers())", method1.getAssertions().get(6).getActualValue());
		assertEquals("The method method1 with parameters (List, app.firstpackage.firstclass) in app.firstpackage.firstclass must be abstract!", method1.getAssertions().get(6).getMessage());
		
		AssertionConverter.createMethodAssertions(mockClass1.getMethods().get(1), mockClass1, method2);
		assertEquals("false", method2.getAssertions().get(1).getExpectedValue());
		assertEquals("The method method2 with parameters () in app.firstpackage.firstclass must not be public!", method2.getAssertions().get(1).getMessage());
		assertEquals("false", method2.getAssertions().get(2).getExpectedValue());
		assertEquals("The method method2 with parameters () in app.firstpackage.firstclass must not be private!", method2.getAssertions().get(2).getMessage());
		assertEquals("false", method2.getAssertions().get(3).getExpectedValue());
		assertEquals("The method method2 with parameters () in app.firstpackage.firstclass must not be protected!", method2.getAssertions().get(3).getMessage());
		assertEquals("false", method2.getAssertions().get(4).getExpectedValue());
		assertEquals("The method method2 with parameters () in app.firstpackage.firstclass must not be static!", method2.getAssertions().get(4).getMessage());
		assertEquals("false", method2.getAssertions().get(5).getExpectedValue());
		assertEquals("The method method2 with parameters () in app.firstpackage.firstclass must not be final!", method2.getAssertions().get(5).getMessage());
		assertEquals("false", method2.getAssertions().get(6).getExpectedValue());
		assertEquals("The method method2 with parameters () in app.firstpackage.firstclass must not be abstract!", method2.getAssertions().get(6).getMessage());
	}
}
