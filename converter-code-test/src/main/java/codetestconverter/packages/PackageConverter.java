package codetestconverter.packages;

import static org.junit.Assert.assertTrue;

import code.CodePackage;
import code.CodeParent;
import code.CodeRepresentation;
import codetestconverter.temporary.TemporaryModel;
import test.TestPackage;
import test.TestParent;
import test.TestRepresentation;

/**
 * Provdides static methods to convert {@link code.CodePackage}s of a {@link code.CodeParent} to a {@link test.TestPackage}.
 * 
 * @author dschoenicke
 *
 */
public class PackageConverter {

	/**
	 * Static method to convert {@link code.CodePackage}s of a given {@link code.CodeParent} to a {@link test.TestPackage}.
	 * 
	 * @param codeParent the {@link code.CodeParent} of the {@link code.CodePackage}s, can be {@link code.CodeRepresentation} or {@link code.CodePackage}.
	 * @param testParent the {@link test.TestParent} of the {@link test.TestPackage}s, can be {@link test.TestRepresentation} of {@link test.TestPackage}.
	 * @param tmpModel the {@link codetestconverter.temporary.TemporaryModel} to add the converted {@link test.TestPackage}s to
	 */
	public static void convertPackages(CodeParent codeParent, TestParent testParent, TemporaryModel tmpModel) {
		if (codeParent instanceof CodeRepresentation) {
			for (CodePackage codePackage : ((CodeRepresentation) codeParent).getPackages()) {
				convertPackage(codePackage, testParent, tmpModel);
			}
		}
		else if (codeParent instanceof CodePackage) {
			for (CodePackage codePackage : ((CodePackage) codeParent).getPackages()) {
				convertPackage(codePackage, testParent, tmpModel);
			}
		}
		
		assertTrue("The CodeParent " + codeParent.getName() + " must be an instance of CodeRepresentation or CodePackage!", (codeParent instanceof CodePackage || codeParent instanceof CodeRepresentation));
	}
	
	/**
	 * Static method to convert a given {@link code.CodePackage} to a {@link test.TestPackage} and adds it to the given {@link test.TestParent}.
	 * 
	 * @param codePackage the {@link code.CodePackage} to be converted.
	 * @param testParent the {@link test.TestParent} to which to converted {@link test.TestPackage} should be added, can be {@link test.TestRepresentation} of {@link test.TestPackage}.
	 * @param tmpModel the {@link codetestconverter.temporary.TemporaryModel} to add the converted {@link test.TestPackage}s to
	 * @return the converted {@link test.TestPackage}
	 */
	private static TestPackage convertPackage(CodePackage codePackage, TestParent testParent, TemporaryModel tmpModel) {
		TestPackage testPackage = new TestPackage(codePackage.getName(), testParent);
		
		if (testParent instanceof TestRepresentation) {
			((TestRepresentation) testParent).addPackage(testPackage);
		}
		else {
			((TestPackage) testParent).addPackage(testPackage);
		}
		
		convertPackages(codePackage, testPackage, tmpModel);
		tmpModel.addConvertedPackage(codePackage, testPackage);
		
		return testPackage;
	}
}
