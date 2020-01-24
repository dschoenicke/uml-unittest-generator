package outputjunit.converter;

import junit.JunitPackage;
import junit.JunitParent;
import junit.JunitRepresentation;
import lombok.experimental.UtilityClass;
import outputjunit.converter.temporary.TemporaryModel;
import test.TestPackage;
import test.TestParent;
import test.TestRepresentation;

/**
 * Provdides static methods to convert {@link test.TestPackage}s to a {@link junit.JunitPackage}s.
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class PackageConverter {

	/**
	 * Static method to convert {@link test.TestPackage}s of a given {@link test.TestParent} to a {@link junit.JunitPackage}.
	 * 
	 * @param testParent the {@link test.TestParent} of the {@link test.TestPackage}s, can be {@link test.TestRepresentation} or {@link test.TestPackage}.
	 * @param junitParent the {@link junit.JunitParent} of the {@link junit.JunitPackage}s, can be {@link junit.JunitRepresentation} or {@link junit.JunitPackage}.
	 * @param tmpModel the {@link outputjunit.converter.temporary.TemporaryModel} to add the converted {@link junit.JunitPackage}s to
	 */
	public static void convertPackages(TestParent testParent, JunitParent junitParent, TemporaryModel tmpModel) {
		if (testParent instanceof TestRepresentation) {
			for (TestPackage testPackage : ((TestRepresentation) testParent).getPackages()) {
				convertPackage(testPackage, junitParent, tmpModel);
			}
		}
		else {
			for (TestPackage testPackage : ((TestPackage) testParent).getPackages()) {
				convertPackage(testPackage, junitParent, tmpModel);
			}
		}
	}
	
	/**
	 * Static method to convert a given {@link test.TestPackage} to a {@link junit.JunitPackage} and adds it to the given {@link junit.JunitParent}.
	 * 
	 * @param testPackage the {@link test.TestPackage} to be converted.
	 * @param junitParent the {@link junit.JunitParent} to which to converted {@link junit.JunitPackage} should be added, can be {@link junit.JunitRepresentation} of {@link junit.JunitPackage}.
	 * @param tmpModel the {@link outputjunit.converter.temporary.TemporaryModel} to add the converted {@link junit.JunitPackage}s to
	 * @return the converted {@link test.TestPackage}
	 */
	static JunitPackage convertPackage(TestPackage testPackage, JunitParent junitParent, TemporaryModel tmpModel) {
		JunitPackage junitPackage = new JunitPackage(testPackage.getName(), junitParent);
		
		if (junitParent instanceof JunitRepresentation) {
			((JunitRepresentation) junitParent).addPackage(junitPackage);
		}
		else {
			((JunitPackage) junitParent).addPackage(junitPackage);
		}
		
		convertPackages(testPackage, junitPackage, tmpModel);
		tmpModel.addConvertedPackage(testPackage, junitPackage);
		
		return junitPackage;
	}
}
