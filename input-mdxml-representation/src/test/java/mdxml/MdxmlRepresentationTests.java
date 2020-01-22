package mdxml;

import static org.junit.Assert.fail;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MdxmlRepresentationTests
{	
	protected MdxmlRepresentation mdxmlRepresentation;
	protected PackagedElement mdxmlTopLevelPackage;
	protected PackagedElement mdxmlTopLevelInterface;
	protected PackagedElement mdxmlTopLevelClass;
	protected PackagedElement mdxmlSubClass;
	protected PackagedElement mdxmlSubInterface;
	protected PackagedElement mdxmlGenericClass;
	protected PackagedElement mdxmlBindingClass;
	protected PackagedElement mdxmlSubPackage;
	protected PackagedElement mdxmlSubPackageClass;
	protected PackagedElement mdxmlEnumeration;
	protected PackagedElement mdxmlBigEnum;
	protected PackagedElement mdxmlSubPackageClassAssociation;
	protected PackagedElement mdxmlBigEnumAssociation;
	protected PackagedElement mdxmlDependency;
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void initMdxmlRepresentation() {
		try {
			mdxmlRepresentation = new MdxmlRepresentation(getClass().getClassLoader().getResource("md_test.xml").getFile());
			mdxmlTopLevelPackage = mdxmlRepresentation
					.getXmi()
					.getModel()
					.getPackagedElements()
					.stream()
					.filter(p -> (p.getName() != null && p.getName().equals("TopLevelPackage")))
					.findFirst()
					.get();
			
			mdxmlTopLevelClass = mdxmlRepresentation
					.getXmi()
					.getModel()
					.getPackagedElements()
					.stream()
					.filter(p -> (p.getName() != null && p.getName().equals("TopLevelClass")))
					.findFirst()
					.get();
			
			mdxmlTopLevelInterface = mdxmlRepresentation
					.getXmi()
					.getModel()
					.getPackagedElements()
					.stream()
					.filter(p -> (p.getName() != null && p.getName().equals("TopLevelInterface")))
					.findFirst()
					.get();
			
			mdxmlSubClass = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("SubClass"))).findFirst().get();
			mdxmlSubInterface = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("SubInterface"))).findFirst().get();
			mdxmlGenericClass = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("GenericClass"))).findFirst().get();
			mdxmlBindingClass = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("BindingClass"))).findFirst().get();
			mdxmlSubPackage = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("SubPackage"))).findFirst().get();
			mdxmlSubPackageClassAssociation = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> p.getId().equals("_19_0_1_62d0212_1574772702939_729059_4913")).findFirst().get();
			mdxmlBigEnumAssociation = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> p.getId().equals("_19_0_1_62d0212_1579603742988_598963_4693")).findFirst().get();
			mdxmlSubPackageClass = mdxmlSubPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("SubPackageClass"))).findFirst().get();
			mdxmlEnumeration = mdxmlSubPackageClass.getNestedClassifiers().get(0);
			mdxmlBigEnum = mdxmlSubPackage.getPackagedElements().stream().filter(p -> (p.getName() != null && p.getName().equals("BigEnum"))).findFirst().get();
			mdxmlDependency = mdxmlTopLevelPackage.getPackagedElements().stream().filter(p -> p.getType().equals("uml:Usage")).findFirst().get();
		} catch (JAXBException e) {
			fail("Couldn't find a valid test diagram file named md_test.xml!");
		}
	}
	
	@After
	public void cleanup() {
		thrown = ExpectedException.none();
	}
}
