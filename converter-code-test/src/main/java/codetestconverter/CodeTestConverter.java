package codetestconverter;

import code.CodeRepresentation;
import codetestconverter.packages.PackageConverter;
import codetestconverter.temporary.TemporaryModel;
import codetestconverter.testclass.TestClassConverter;
import test.TestRepresentation;

/**
 * Main class of the converter 
 * 
 * @author dschoenicke
 *
 */
public class CodeTestConverter {

	/**
	 * Default constructor
	 */
	public CodeTestConverter() {}
	
	/**
	 * Converts a given {@link code.CodeRepresentation} to a {@link test.TestRepresentation}.<br>
	 * Delegates the creation of {@link test.TestPackage}s to the {@link codetestconverter.packages.PackageConverter}.
	 * Delegates the creation of {@link test.TestClass}es to the {@link codetestconverter.testclass.TestClassConverter}.
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} to be converted
	 * @return the converted {@link test.TestRepresentation}
	 */
	public TestRepresentation convertCodeToTestRepresentation(CodeRepresentation codeRepresentation) {
		TestRepresentation testRepresentation = new TestRepresentation(codeRepresentation.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		PackageConverter.convertPackages(codeRepresentation, testRepresentation, tmpModel);
		TestClassConverter.convertTestClasses(testRepresentation.getPackages(), tmpModel);
		
		return testRepresentation;
	}
}
