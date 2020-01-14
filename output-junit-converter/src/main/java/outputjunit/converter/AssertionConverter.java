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
import test.testobjects.TemplateParameterUnderTest;

/**
 * Provides static methods to create {@link junit.JunitAssertion}s for {@link junit.JunitTestClass}, {@link junit.JunitFieldUnderTest}, {@link junit.JunitConstructorUnderTest} and {@link junit.JunitMethodUnderTest}.
 * 
 * @author dschoenicke
 *
 */
public class AssertionConverter {

	/**
	 * Creates property {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information for the property {@link junit.JunitAssertion}s
	 * @param testClass the {@link junit.JunitTestClass} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createPropertyAssertions(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		switch(classUnderTest.getType()) {
			case ENUM: {
				testClass.addPropertyAssertion(new JunitAssertion("true", "classUnderTest.isEnum()", testClass.getClassName() + " must be an enumeration!"));
				break;
			}
			case INTERFACE: {
				testClass.addPropertyAssertion(new JunitAssertion("true", "classUnderTest.isInterface()", testClass.getClassName() + " must be an interface!"));
				break;
			}
			default: {
				testClass.addPropertyAssertion(new JunitAssertion("true", "!(classUnderTest.isEnum() || classUnderTest.isInterface())", testClass.getClassName() + " must be a class!"));
				break;
			}
		}
		
		if (classUnderTest.getNestHost().isPresent()) {
			testClass.addPropertyAssertion(new JunitAssertion("\"" + classUnderTest.getNestHost().get().getQualifiedName() + "\"", "classUnderTest.getNestHost().getName()", testClass.getClassName() + " must be an inner class of " + classUnderTest.getNestHost().get().getQualifiedName() + "!"));
		}
		else {
			testClass.addPropertyAssertion(new JunitAssertion("\"" + testClass.getClassName() + "\"", "classUnderTest.getNestHost().getName()", testClass.getClassName() + " must not be an inner class!"));
		}
		
		int modifiers = classUnderTest.getModifiers();
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(classUnderTest.getModifiers())", testClass.getClassName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be public!"));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(classUnderTest.getModifiers())", testClass.getClassName() + " must " + (Modifier.isPrivate(modifiers) ? "" : "not ") + "be private!"));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(classUnderTest.getModifiers())", testClass.getClassName() + " must " + (Modifier.isProtected(modifiers) ? "" : "not ") + "be protected!"));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isStatic(modifiers)), "Modifier.isStatic(classUnderTest.getModifiers())", testClass.getClassName() + " must " + (Modifier.isStatic(modifiers) ? "" : "not ") + "be static!"));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isFinal(modifiers)), "Modifier.isFinal(classUnderTest.getModifiers())", testClass.getClassName() + " must " + (Modifier.isFinal(modifiers) ? "" : "not ") + "be final!"));
		testClass.addPropertyAssertion(new JunitAssertion(String.valueOf(Modifier.isAbstract(modifiers)), "Modifier.isAbstract(classUnderTest.getModifiers())", testClass.getClassName() + " must " + (Modifier.isAbstract(modifiers) ? "" : "not ") + "be abstract!"));
	}
	
	/**
	 * Creates relationship {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information for the relationship {@link junit.JunitAssertion}s
	 * @param testClass the {@link junit.JunitTestClass} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createRelationshipAssertions(ClassUnderTest classUnderTest, JunitTestClass testClass) {
		if (classUnderTest.getSuperClass().isPresent()) {
			testClass.addRelationshipAssertion(new JunitAssertion("\"" + classUnderTest.getSuperClass().get() + "\"", "classUnderTest.getSuperclass().getSimpleName()", testClass.getClassName() + " must extend " + classUnderTest.getSuperClass().get() + "!"));
		}
		else {
			testClass.addRelationshipAssertion(new JunitAssertion("\"java.lang.Object\"", "classUnderTest.getSuperclass().getSimpleName()", testClass.getClassName() + " must not extend any superclass!"));
		}
		
		testClass.addRelationshipAssertion(new JunitAssertion("\"" + classUnderTest.getInterfaces().size() + "\"", "classUnderTest.getInterfaces().length", testClass.getClassName() + " must implement exactly " + classUnderTest.getInterfaces().size() + " interfaces!"));
		classUnderTest.getInterfaces().forEach(testInterface -> {
			testClass.addRelationshipAssertion(new JunitAssertion("true", "java.util.Arrays.asList(classUnderTest.getInterfaces()).stream().filter(i -> i.getName().equals(\"" + testInterface + "\")).findFirst().isPresent()", testClass.getClassName() + " must implement the interface " + testInterface + "!"));
		});
	}
	
	/**
	 * Creates template parameter {@link junit.JunitAssertion}s for a given {@link junit.JunitTestClass}
	 * 
	 * @param templateParameterUnderTest the {@link test.testobjects.TemplateParameterUnderTest} containing the information for the template parameter {@link junit.JunitAssertion}s
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} containing the information about the owning class of the {@link junit.JunitTemplateParameterUnderTest}
	 * @param templateParameter the {@link junit.JunitFieldUnderTest} for which the {@link junit.JunitAssertion}s will be created
	 */
	static void createTemplateParameterAssertions(TemplateParameterUnderTest templateParameterUnderTest, ClassUnderTest classUnderTest, JunitTemplateParameterUnderTest templateParameter) {
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
			testClass.addEnumConstantAssertion(new JunitAssertion("\"" + classUnderTest.getEnumConstants().size() + "\"", "classUnderTest.getEnumConstants().length", testClass.getClassName() + " must have exactly " + classUnderTest.getEnumConstants().size() + " enum constants!"));
			classUnderTest.getEnumConstants().forEach(enumConstant -> {
				testClass.addEnumConstantAssertion(new JunitAssertion("true", "java.util.Arrays.asList(classUnderTest.getEnumConstants()).stream().filter(e -> e.toString().equals(\"" + enumConstant.getName() + "\")).findFirst().isPresent()", testClass.getClassName() + " must have an enum constant named " + enumConstant + "!"));
			});
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
		int modifiers = fieldUnderTest.getModifiers();
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(fieldUnderTest.getModifiers())", classUnderTest.getQualifiedName() + "#" + field.getName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be public!"));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(fieldUnderTest.getModifiers())", classUnderTest.getQualifiedName() + "#" + field.getName() + " must " + (Modifier.isPrivate(modifiers) ? "" : "not ") + "be private!"));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(fieldUnderTest.getModifiers())", classUnderTest.getQualifiedName() + "#" + field.getName() + " must " + (Modifier.isProtected(modifiers) ? "" : "not ") + "be protected!"));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isStatic(modifiers)), "Modifier.isStatic(fieldUnderTest.getModifiers())", classUnderTest.getQualifiedName() + "#" + field.getName() + " must " + (Modifier.isStatic(modifiers) ? "" : "not ") + "be static!"));
		field.addAssertion(new JunitAssertion(String.valueOf(Modifier.isFinal(modifiers)), "Modifier.isFinal(fieldUnderTest.getModifiers())", classUnderTest.getQualifiedName() + "#" + field.getName() + " must " + (Modifier.isFinal(modifiers) ? "" : "not ") + "be final!"));
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
		constructor.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(constructorUnderTest.getModifiers())", "The constructor with parameters (" + ParameterConverter.createParameterTypes(constructorUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be public!"));
		constructor.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(constructorUnderTest.getModifiers())", "The constructor with parameters (" + ParameterConverter.createParameterTypes(constructorUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be private!"));
		constructor.addAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(constructorUnderTest.getModifiers())", "The constructor with parameters (" + ParameterConverter.createParameterTypes(constructorUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be protected!"));
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
		method.addAssertion(new JunitAssertion("\"" + method.getReturnType() + "\"", "methodUnderTest.getReturnType().getSimpleName()", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must return " + method.getReturnType() + "!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPublic(modifiers)), "Modifier.isPublic(methodUnderTest.getModifiers())", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be public!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isPrivate(modifiers)), "Modifier.isPrivate(methodUnderTest.getModifiers())", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be private!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isProtected(modifiers)), "Modifier.isProtected(methodUnderTest.getModifiers())", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be protected!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isStatic(modifiers)), "Modifier.isStatic(methodUnderTest.getModifiers())", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be static!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isFinal(modifiers)), "Modifier.isFinal(methodUnderTest.getModifiers())", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be final!"));
		method.addAssertion(new JunitAssertion(String.valueOf(Modifier.isAbstract(modifiers)), "Modifier.isAbstract(methodUnderTest.getModifiers())", "The method " + method.getMethodName() + " with parameters (" + ParameterConverter.createParameterTypes(methodUnderTest.getParameters()) + ") in " + classUnderTest.getQualifiedName() + " must " + (Modifier.isPublic(modifiers) ? "" : "not ") + "be abstract!"));
	}
}
