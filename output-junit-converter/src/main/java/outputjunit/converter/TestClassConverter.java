package outputjunit.converter;

import junit.JunitPackage;
import junit.JunitRepresentation;
import junit.JunitTestClass;
import outputjunit.converter.temporary.TemporaryModel;
import test.TestClass;

/**
 * Provides static methods to convert {@link test.TestClass}es of the {@link test.TestPackage}s in the {@link outputjunit.converter.temporary.TemporaryModel} to {@link junit.JunitTestClass}es.
 * 
 * @author dschoenicke
 *
 */
public class TestClassConverter {

	/**
	 * Static methods to convert {@link test.TestClass}es of the {@link test.TestPackage}s in the {@link outputjunit.converter.temporary.TemporaryModel} to {@link junit.JunitTestClass}es.
	 * 
	 * @param junitRepresentation the {@link junit.JunitRepresentation}
	 * @param tmpModel the {@link outputjunit.converter.temporary.TemporaryModel} containing a map of {@link test.TestPackage}s and the corresponding converted {@link junit.JunitPackage}s.
	 */
	public static void convertTestClasses(JunitRepresentation junitRepresentation, TemporaryModel tmpModel) {
		tmpModel.getConvertedPackages().forEach((testPackage, junitPackage) -> {
			testPackage.getTestClassesAsList().forEach(testClass -> {
				convertTestClass(testClass, junitPackage, junitRepresentation);
			});
		});
	}
	
	/**
	 * Static method converting a given {@link test.TestClass} to a {@link junit.JunitTestClass} and adds it to the given {@link junit.JunitPackage}.
	 * Delegates the conversion of {@link junit.JunitAssertion}s to the {@link AssertionConverter}.
	 * Delegates the conversion of {@link junit.JunitFieldUnderTest}s to the {@link FieldConverter}.
	 * Delegates the conversion of {@link junit.JunitConstructorUnderTest}s to the {@link ConstructorConverter}.
	 * Delegates the conversion of {@link junit.JunitMethodUnderTest}s to the {@link MethodConverter}.
	 * 
	 * @param testClass the {@link test.TestClass} to be converted.
	 * @param parent the {@link junit.JunitPackage} containing the converted {@link junit.JunitTestClass}.
	 * @param junitRepresentation the {@link junit.JunitRepresentation}
	 */
	static void convertTestClass(TestClass testClass, JunitPackage parent, JunitRepresentation junitRepresentation) {
		JunitTestClass junitTestClass = new JunitTestClass(testClass.getName(), testClass.getClassUnderTest().getQualifiedName(), junitRepresentation.getName() + "Structure." + testClass.getPackagePath(), parent);
		parent.addTestClass(junitTestClass);
		
		AssertionConverter.createPropertyAssertions(testClass.getClassUnderTest(), junitTestClass);
		AssertionConverter.createRelationshipAssertions(testClass.getClassUnderTest(), junitTestClass);
		TemplateParameterConverter.convertTemplateParameters(testClass.getClassUnderTest(), junitTestClass);
		AssertionConverter.createEnumConstantAssertions(testClass.getClassUnderTest(), junitTestClass);
		FieldConverter.convertFields(testClass.getClassUnderTest(), junitTestClass);
		ConstructorConverter.convertConstructors(testClass.getClassUnderTest(), junitTestClass);
		MethodConverter.convertMethods(testClass.getClassUnderTest(), junitTestClass);
	}
}
