package mdxmlconverter;

import javax.xml.bind.JAXBException;

import org.junit.Before;

import mdxml.MdxmlRepresentationTests;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationship;
import uml.UmlRelationshipType;

public class MdxmlUmlConverterTests extends MdxmlRepresentationTests {
	
	protected UmlModel umlModel;
	protected UmlPackage umlTopLevelPackage;
	protected UmlInterface umlTopLevelInterface;
	protected UmlClass umlTopLevelClass;
	protected UmlClass umlSubClass;
	protected UmlInterface umlSubInterface;
	protected UmlClass umlGenericClass;
	protected UmlClass umlBindingClass;
	protected UmlPackage umlSubPackage;
	protected UmlClass umlSubPackageClass;
	protected UmlEnumeration umlEnumeration;
	protected UmlEnumeration umlBigEnum;
	protected UmlRelationship umlSubPackageClassAssociation;
	protected UmlRelationship umlBigEnumAssociation;
	protected UmlRelationship umlInterfaceRealization;
	protected UmlRelationship umlClassGeneralization;
	protected UmlRelationship umlInterfaceGeneralization;
	protected UmlRelationship umlDependency;
	protected TemporaryModel mockTmpModel;
	protected MdxmlUmlConverter converter;
	
	@Before
	public void initUmlModel() throws JAXBException {
		converter = new MdxmlUmlConverter();
		umlModel = converter.convertToUmlRepresentation(getClass().getClassLoader().getResource("md_test.xml").getFile());
		umlTopLevelPackage = umlModel.getPackages().get(0);
		umlTopLevelInterface = (UmlInterface) umlModel.getElements().stream().filter(e -> e.getName().equals("TopLevelInterface")).findFirst().get();
		umlTopLevelClass = (UmlClass) umlModel.getElements().stream().filter(e -> e.getName().equals("TopLevelClass")).findFirst().get();
		umlSubClass = (UmlClass) umlTopLevelPackage.getElements().stream().filter(e -> e.getName().equals("SubClass")).findFirst().get();
		umlSubInterface = (UmlInterface) umlTopLevelPackage.getElements().stream().filter(e -> e.getName().equals("SubInterface")).findFirst().get();
		umlGenericClass = (UmlClass) umlTopLevelPackage.getElements().stream().filter(e -> e.getName().equals("GenericClass")).findFirst().get();
		umlBindingClass = (UmlClass) umlTopLevelPackage.getElements().stream().filter(e -> e.getName().equals("BindingClass")).findFirst().get();
		umlSubPackage = umlTopLevelPackage.getPackages().stream().filter(e -> e.getName().equals("SubPackage")).findFirst().get();
		umlSubPackageClass = (UmlClass) umlSubPackage.getElements().stream().filter(e -> e.getName().equals("SubPackageClass")).findFirst().get();
		umlEnumeration = (UmlEnumeration) umlSubPackageClass.getInnerElements().get(0);
		umlBigEnum = (UmlEnumeration) umlSubPackage.getElements().stream().filter(e -> e.getName().equals("BigEnum")).findFirst().get();
		umlSubPackageClassAssociation = umlTopLevelPackage.getRelationships().stream().filter(r -> r.getType().equals(UmlRelationshipType.AGGREGATION)).findFirst().get();
		umlBigEnumAssociation = umlTopLevelPackage.getRelationships().stream().filter(r -> r.getType().equals(UmlRelationshipType.ASSOCIATION)).findFirst().get();
		umlInterfaceRealization = umlModel.getRelationships().stream().filter(r -> r.getType().equals(UmlRelationshipType.INTERFACEREALIZATION)).findFirst().get();
		umlClassGeneralization = umlTopLevelPackage.getRelationships().stream().filter(r -> r.getType().equals(UmlRelationshipType.GENERALIZATION) && r.getClient().equals(umlSubClass)).findFirst().get();
		umlInterfaceGeneralization = umlTopLevelPackage.getRelationships().stream().filter(r -> r.getType().equals(UmlRelationshipType.GENERALIZATION) && r.getClient().equals(umlSubInterface)).findFirst().get();
		umlDependency = umlTopLevelPackage.getRelationships().stream().filter(r -> r.getType().equals(UmlRelationshipType.DEPENDENCY)).findFirst().get();
		mockTmpModel = new TemporaryModel();
	}
}
