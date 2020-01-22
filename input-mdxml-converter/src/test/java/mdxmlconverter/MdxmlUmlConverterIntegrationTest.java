package mdxmlconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MdxmlUmlConverterIntegrationTest extends MdxmlUmlConverterTests {

	@Test
	public void verifyModelStructure() {
		assertEquals(mdxmlRepresentation.getXmi().getModel().getName(), umlModel.getName());
		assertEquals(mdxmlRepresentation.getXmi().getModel().getPackagedElements().size(), umlModel.getPackages().size() + umlModel.getElements().size());
		assertEquals(mdxmlTopLevelPackage.getName(), umlTopLevelPackage.getName());
		assertEquals(mdxmlTopLevelInterface.getName(), umlTopLevelInterface.getName());
		assertEquals(mdxmlTopLevelClass.getName(), umlTopLevelClass.getName());
		assertEquals(1, umlModel.getRelationships().size());
		assertEquals(mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> p.getType().equals("uml:Package")).toArray().length, umlTopLevelPackage.getPackages().size());
		assertEquals(mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> (p.getType().equals("uml:Class") || p.getType().equals("uml:Interface"))).toArray().length, umlTopLevelPackage.getElements().size());
		assertEquals(mdxmlSubPackage.getName(), umlSubPackage.getName());
		assertEquals(mdxmlSubPackage.getPackagedElements().stream().filter(p -> p.getType().equals("uml:Package")).toArray().length, umlSubPackage.getPackages().size());
		assertEquals(mdxmlSubPackage.getPackagedElements().stream().filter(p -> (p.getType().equals("uml:Class") || p.getType().equals("uml:Enumeration"))).toArray().length, umlSubPackage.getElements().size());
		assertEquals(mdxmlSubPackageClass.getNestedClassifiers().size(), umlSubPackageClass.getInnerElements().size());
		assertEquals(mdxmlSubPackageClass.getNestedClassifiers().get(0).getName(), umlEnumeration.getName());
	}
}
