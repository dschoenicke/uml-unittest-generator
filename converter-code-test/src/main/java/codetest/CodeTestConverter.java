package codetest;

import code.CodeRepresentation;
import codetest.converters.PackageConverter;
import codetest.converters.TestClassConverter;
import lombok.NoArgsConstructor;
import test.TestRepresentation;

/**
 * Main class of the converter 
 * 
 * @author dschoenicke
 *
 */
@NoArgsConstructor
public class CodeTestConverter {
	
	/**
	 * Converts a given {@link code.CodeRepresentation} to a {@link test.TestRepresentation}.<br>
	 * Delegates the creation of {@link test.TestPackage}s to the {@link codetest.converters.PackageConverter}.
	 * Delegates the creation of {@link test.TestClass}es to the {@link codetest.converters.TestClassConverter}.
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} to be converted
	 * @return the converted {@link test.TestRepresentation}
	 */
	public TestRepresentation convertCodeToTestRepresentation(CodeRepresentation codeRepresentation) {
		TestRepresentation testRepresentation = new TestRepresentation(codeRepresentation.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		PackageConverter.convertPackages(codeRepresentation, testRepresentation, tmpModel);
		TestClassConverter.convertTestClasses(tmpModel);
		return testRepresentation;
	}
}
