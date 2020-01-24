package codetest.converters;

import code.CodeElement;
import code.CodeEnumeration;
import code.CodeField;
import code.CodeLiteral;
import lombok.experimental.UtilityClass;
import test.testobjects.ClassUnderTest;
import test.testobjects.EnumConstantUnderTest;
import test.testobjects.FieldUnderTest;

/**
 * Provides a static method to convert {@link code.CodeField}s of a given {@link code.CodeElement} to {@link test.testobjects.FieldUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class FieldUnderTestConverter {
	
	/**
	 * Static method to convert {@link code.CodeField}s of a given {@link code.CodeElement} to {@link test.testobjects.FieldUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
	 * 
	 * @param codeElement the {@link code.CodeElement} containing the {@link code.CodeField}s to be converted.
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} to which the converted {@link test.testobjects.FieldUnderTest} should be added to.
	 */
	public static void convertFieldsUnderTest(CodeElement codeElement, ClassUnderTest classUnderTest) {
		for (CodeField field : codeElement.getFields()) {
			new FieldUnderTest(field.getName(), 
					field.getType(), 
					field.getModifiers(),
					classUnderTest,
					field.getCanBeNull(),
					field.getHasMultiplicity());
		}
	}
	
	/**
	 * Static method to convert enum constants of a given {@link code.CodeEnumeration} to {@link test.testobjects.EnumConstantUnderTest} and adding them to a {@link test.testobjects.ClassUnderTest}.
	 * 
	 * @param codeEnumeration the {@link code.CodeEnumeration} containing the enum constants to be converted.
	 * @param classUnderTest the {@link test.testobjects.ClassUnderTest} to which the converted {@link test.testobjects.EnumConstantUnderTest} should be added to.
	 */
	 public static void convertEnumConstantsUnderTest(CodeEnumeration codeEnumeration, ClassUnderTest classUnderTest) {
		 for (CodeLiteral enumConstant : codeEnumeration.getLiterals()) {
			 new EnumConstantUnderTest(enumConstant.getName(), classUnderTest);
		 }
	 }
}
