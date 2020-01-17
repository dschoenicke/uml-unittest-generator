package outputjunit.converter;

import java.lang.reflect.Modifier;

import junit.JunitAssertion;
import junit.JunitConstructorUnderTest;
import junit.JunitFieldUnderTest;
import junit.JunitMethodUnderTest;
import junit.JunitTemplateParameterUnderTest;
import junit.JunitTestClass;
import test.testobjects.ClassUnderTest;
import test.testobjects.ClassUnderTest.ClassUnderTestType;
import test.testobjects.ConstructorUnderTest;
import test.testobjects.FieldUnderTest;
import test.testobjects.MethodUnderTest;

/**
 * Provides static methods to create {@link junit.JunitAssertion}s for {@link junit.JunitTestClass}, {@link junit.JunitFieldUnderTest}, {@link junit.JunitConstructorUnderTest} and {@link junit.JunitMethodUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class AssertionConverter {

	private AssertionConverter() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * Creates property {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information for the property {@link junit.JunitAssertion}s
	 * @param testClass the {@link junit.JunitTestClass} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createPropertyAssertions(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		String className = testClass.getClassName();
		
		switch(classUnderTest.getType()) {
			case ENUM:
				testClass.addPropertyAssertion(new JunitAssertion("true", "classUnderTest.isEnum()", className + " must be an enumeration!"));
				break;
		
			case INTERFACE:
				testClass.addPropertyAssertion(new JunitAssertion("true", "classUnderTest.isInterface()", className + " must be an interface!"));
				break;
		
			default:
				testClass.addPropertyAssertion(new JunitAssertion("true", "!(classUnderTest.isEnum() || classUnderTest.isInterface())", className + " must be a class!"));
				break;
		}
		
		ClassUnderTest nesthost = classUnderTest.getNestHost().orElse(classUnderTest);
		
		if (classUnderTest.getNestHost().isPresent()) {
			testClass.addPropertyAssertion(new JunitAssertion("\"" + nesthost.getQualifiedName() + "\"", "classUnderTest.getNestHost().getName()", className + " must be an inner class of " + nesthost.getQualifiedName() + "!"));
		}
		else {
			testClass.addPropertyAssertion(new JunitAssertion("\"" + className + "\"", "classUnderTest.getNestHost().getName()", testClass.getClassName() + " must not be an inner class!"));
		}
		
		int modifiers = classUnderTest.getModifiers();
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(classUnderTest.getModifiers())", AssertionMessageConverter.getClassModifierAssertionMessage(className, Modifier.isPublic(modifiers), Modifier.PUBLIC)));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(classUnderTest.getModifiers())", AssertionMessageConverter.getClassModifierAssertionMessage(className, Modifier.isPrivate(modifiers), Modifier.PRIVATE)));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(classUnderTest.getModifiers())", AssertionMessageConverter.getClassModifierAssertionMessage(className, Modifier.isProtected(modifiers), Modifier.PROTECTED)));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isStatic(modifiers)), "Modifier.isStatic(classUnderTest.getModifiers())", AssertionMessageConverter.getClassModifierAssertionMessage(className, Modifier.isStatic(modifiers), Modifier.STATIC)));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isFinal(modifiers)), "Modifier.isFinal(classUnderTest.getModifiers())", AssertionMessageConverter.getClassModifierAssertionMessage(className, Modifier.isFinal(modifiers), Modifier.FINAL)));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isAbstract(modifiers)), "Modifier.isAbstract(classUnderTest.getModifiers())", AssertionMessageConverter.getClassModifierAssertionMessage(className, Modifier.isAbstract(modifiers), Modifier.ABSTRACT)));
	}
	
	/**
	 * Creates relationship {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information for the relationship {@link junit.JunitAssertion}s
	 * @param testClass the {@link junit.JunitTestClass} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createRelationshipAssertions(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		String superclass = classUnderTest.getSuperClass().orElse("Object");
		
		if (classUnderTest.getSuperClass().isPresent()) {
			testClass.addRelationshipAssertion(new JunitAssertion("\"" + superclass + "\"", "classUnderTest.getSuperclass().getSimpleName()", testClass.getClassName() + " must extend " + superclass + "!"));
		}
		else {
			testClass.addRelationshipAssertion(new JunitAssertion("\"" + superclass + "\"", "classUnderTest.getSuperclass().getSimpleName()", testClass.getClassName() + " must not extend any superclass!"));
		}
		
		testClass.addRelationshipAssertion(new JunitAssertion(String.valueOf(classUnderTest.getInterfaces().size()), "classUnderTest.getInterfaces().length", testClass.getClassName() + " must implement exactly " + classUnderTest.getInterfaces().size() + " interfaces!"));
		classUnderTest.getInterfaces().forEach(testInterface -> 
			testClass.addRelationshipAssertion(new JunitAssertion("true", "java.util.Arrays.asList(classUnderTest.getInterfaces()).stream().filter(i -> i.getName().equals(\"" + testInterface + "\")).findFirst().isPresent()", testClass.getClassName() + " must implement the interface " + testInterface + "!"))
		);
	}
	
	/**
	 * Creates template parameter {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information about the owning class of the {@link junit.JunitTemplateParameterUnderTest}
	 * @param templateParameter the {@link junit.JunitFieldUnderTest} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createTemplateParameterAssertions(ClassUnderTest classUnderTest, JunitTemplateParameterUnderTest templateParameter) {
		templateParameter.addAssertion(new JunitAssertion("true", "typeParameterUnderTest.isPresent()", classUnderTest.getQualifiedName() + " must have a template parameter with name " + templateParameter.getName() + "!"));
		templateParameter.addAssertion(new JunitAssertion("\"" + templateParameter.getBoundedType() + "\"", "typeParameterUnderTest.get().getBounds()[0].getTypeName()", "The template parameter " + templateParameter.getName() + " of " + classUnderTest.getQualifiedName() + " must extend " + templateParameter.getBoundedType() + "!"));
	}
	
	/**
	 * Creates enum constant {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information for the enum constant {@link junit.JunitAssertion}s
	 * @param testClass the {@link junit.JunitTestClass} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createEnumConstantAssertions(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		if (classUnderTest.getType() == ClassUnderTestType.ENUM) {
			testClass.addEnumConstantAssertion(new JunitAssertion(String.valueOf(classUnderTest.getEnumConstants().size()), "classUnderTest.getEnumConstants().length", testClass.getClassName() + " must have exactly " + classUnderTest.getEnumConstants().size() + " enum constants!"));
			classUnderTest.getEnumConstants().forEach(enumConstant -> 
				testClass.addEnumConstantAssertion(new JunitAssertion("true", "java.util.Arrays.asList(classUnderTest.getEnumConstants()).stream().filter(e -> e.toString().equals(\"" + enumConstant.getName() + "\")).findFirst().isPresent()", testClass.getClassName() + " must have an enum constant named " + enumConstant.getName() + "!"))
			);
		}
	}
	
	/**
	 * Creates field {@link junit.JunitAssertion}s for a given {@link junit.JunitFieldUnderTest}
	 * 
	 * @param fieldUnderTest the {@link test.testobjects.FieldUnderTest} containing the information for the field {@link junit.JunitAssertion}s
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information about the owning class of the {@link junit.JunitFieldUnderTest}
	 * @param field the {@link junit.JunitFieldUnderTest} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createFieldAssertions(FieldUnderTest fieldUnderTest, ClassUnderTest classUnderTest, JunitFieldUnderTest field) {
		String className = classUnderTest.getQualifiedName();
		int modifiers = fieldUnderTest.getModifiers();
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(fieldUnderTest.getModifiers())", AssertionMessageConverter.getFieldModifierAssertionMessage(className, field.getName(), Modifier.isPublic(modifiers), Modifier.PUBLIC)));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(fieldUnderTest.getModifiers())", AssertionMessageConverter.getFieldModifierAssertionMessage(className, field.getName(), Modifier.isPrivate(modifiers), Modifier.PRIVATE)));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(fieldUnderTest.getModifiers())", AssertionMessageConverter.getFieldModifierAssertionMessage(className, field.getName(), Modifier.isProtected(modifiers), Modifier.PROTECTED)));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isStatic(modifiers)), "Modifier.isStatic(fieldUnderTest.getModifiers())", AssertionMessageConverter.getFieldModifierAssertionMessage(className, field.getName(), Modifier.isStatic(modifiers), Modifier.STATIC)));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isFinal(modifiers)), "Modifier.isFinal(fieldUnderTest.getModifiers())", AssertionMessageConverter.getFieldModifierAssertionMessage(className, field.getName(), Modifier.isFinal(modifiers), Modifier.FINAL)));
	}
	
	/**
	 * Creates constructor {@link junit.JunitAssertion}s for a given {@link junit.JunitConstructorUnderTest}
	 * 
	 * @param constructorUnderTest the {@link test.testobjects.ConstructorUnderTest} containing the information for the constructor {@link junit.JunitAssertion}s
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information about the owning class of the {@link junit.JunitConstructorUnderTest}
	 * @param constructor the {@link junit.JunitConstructorUnderTest} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createConstructorAssertions(ConstructorUnderTest constructorUnderTest, ClassUnderTest classUnderTest, JunitConstructorUnderTest constructor) {
		int modifiers = constructorUnderTest.getModifiers();
		String className = classUnderTest.getQualifiedName();
		String parameters = ParameterConverter.createParameterTypes(constructorUnderTest.getParameters());
		constructor.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(constructorUnderTest.getModifiers())", AssertionMessageConverter.getConstructorModifierAssertionMessage(className, parameters, Modifier.isPublic(modifiers), Modifier.PUBLIC)));
		constructor.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(constructorUnderTest.getModifiers())", AssertionMessageConverter.getConstructorModifierAssertionMessage(className, parameters, Modifier.isPrivate(modifiers), Modifier.PRIVATE)));
		constructor.addAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(constructorUnderTest.getModifiers())", AssertionMessageConverter.getConstructorModifierAssertionMessage(className, parameters, Modifier.isProtected(modifiers), Modifier.PROTECTED)));
	}
	
	/**
	 * Creates method {@link junit.JunitAssertion}s for a given {@link junit.JunitMethodUnderTest}
	 * 
	 * @param methodUnderTest the {@link test.testobjects.MethodUnderTest} containing the information for the method {@link junit.JunitAssertion}s
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information about the owning class of the {@link junit.JunitMethodUnderTest}
	 * @param method the {@link junit.JunitMethodUnderTest} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createMethodAssertions(MethodUnderTest methodUnderTest, ClassUnderTest classUnderTest, JunitMethodUnderTest method) {
		int modifiers = methodUnderTest.getModifiers();
		String methodName = methodUnderTest.getName();
		String className = classUnderTest.getQualifiedName();
		String parameters = ParameterConverter.createParameterTypes(methodUnderTest.getParameters());
		method.addAssertion(new JunitAssertion("\"" + method.getReturnType() + "\"", "methodUnderTest.getReturnType().getSimpleName()", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must return " + method.getReturnType() + "!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(methodUnderTest.getModifiers())", AssertionMessageConverter.getMethodModifierAssertionMessage(className, methodName, parameters, Modifier.isPublic(modifiers), Modifier.PUBLIC)));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(methodUnderTest.getModifiers())", AssertionMessageConverter.getMethodModifierAssertionMessage(className, methodName, parameters, Modifier.isPrivate(modifiers), Modifier.PRIVATE)));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(methodUnderTest.getModifiers())", AssertionMessageConverter.getMethodModifierAssertionMessage(className, methodName, parameters, Modifier.isProtected(modifiers), Modifier.PROTECTED)));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isStatic(modifiers)), "Modifier.isStatic(methodUnderTest.getModifiers())", AssertionMessageConverter.getMethodModifierAssertionMessage(className, methodName, parameters, Modifier.isStatic(modifiers), Modifier.STATIC)));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isFinal(modifiers)), "Modifier.isFinal(methodUnderTest.getModifiers())", AssertionMessageConverter.getMethodModifierAssertionMessage(className, methodName, parameters, Modifier.isFinal(modifiers), Modifier.FINAL)));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isAbstract(modifiers)), "Modifier.isAbstract(methodUnderTest.getModifiers())", AssertionMessageConverter.getMethodModifierAssertionMessage(className, methodName, parameters, Modifier.isAbstract(modifiers), Modifier.ABSTRACT)));
	}
}
