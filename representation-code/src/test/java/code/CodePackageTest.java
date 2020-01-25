package code;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CodePackageTest extends CodeRepresentationTests {

	@Test
	public void testGetPackagesAsList() {
		CodePackage subsubPackage = new CodePackage("SubSubPackage", codeSubPackage);
		codeSubPackage.addPackage(subsubPackage);
		List<CodePackage> packages = codeTopLevelPackage.getPackagesAsList();
		assertTrue(packages.contains(codeSubPackage));
		assertTrue(packages.contains(subsubPackage));
	}
}
