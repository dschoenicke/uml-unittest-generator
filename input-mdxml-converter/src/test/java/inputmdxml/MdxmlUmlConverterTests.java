package inputmdxml;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import inputmdxml.MdxmlUmlConverter;
import inputmdxml.temporary.TemporaryModel;
import mdxml.MdxmlRepresentation;
import mdxml.MdxmlRepresentationTests;
import mdxml.PackagedElement;
import uml.UmlClass;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlModelTests;
import uml.UmlPackage;
import uml.UmlRelationship;

public class MdxmlUmlConverterTests {
	
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
	
	protected MdxmlRepresentationTests mdxmlRepresentationTests;
	protected UmlModelTests umlModelTests;
	protected TemporaryModel mockTmpModel;
	protected MdxmlUmlConverter converter;
	protected ExpectedException thrown;
	
	@Before
	public void initTestData() {
		mdxmlRepresentationTests = new MdxmlRepresentationTests();
		mdxmlRepresentationTests.initMdxmlRepresentation();
		umlModelTests = new UmlModelTests();
		umlModelTests.initializeUmlModel();
		thrown = mdxmlRepresentationTests.thrown;
		mdxmlRepresentation = mdxmlRepresentationTests.getMdxmlRepresentation();
		mdxmlTopLevelPackage = mdxmlRepresentationTests.getMdxmlTopLevelPackage();
		mdxmlTopLevelInterface = mdxmlRepresentationTests.getMdxmlTopLevelInterface();
		mdxmlTopLevelClass = mdxmlRepresentationTests.getMdxmlTopLevelClass();
		mdxmlSubClass = mdxmlRepresentationTests.getMdxmlSubClass();
		mdxmlSubInterface = mdxmlRepresentationTests.getMdxmlSubInterface();
		mdxmlGenericClass = mdxmlRepresentationTests.getMdxmlGenericClass();
		mdxmlBindingClass = mdxmlRepresentationTests.getMdxmlBindingClass();
		mdxmlSubPackage = mdxmlRepresentationTests.getMdxmlSubPackage();
		mdxmlSubPackageClass = mdxmlRepresentationTests.getMdxmlSubPackageClass();
		mdxmlEnumeration = mdxmlRepresentationTests.getMdxmlEnumeration();
		mdxmlBigEnum = mdxmlRepresentationTests.getMdxmlBigEnum();
		mdxmlSubPackageClassAssociation = mdxmlRepresentationTests.getMdxmlSubPackageClassAssociation();
		mdxmlBigEnumAssociation = mdxmlRepresentationTests.getMdxmlBigEnumAssociation();
		mdxmlDependency = mdxmlRepresentationTests.getMdxmlDependency();
		
		umlModel = umlModelTests.getUmlModel();
		umlTopLevelPackage = umlModelTests.getUmlTopLevelPackage();
		umlTopLevelInterface = umlModelTests.getUmlTopLevelInterface();
		umlTopLevelClass = umlModelTests.getUmlTopLevelClass();
		umlSubClass = umlModelTests.getUmlSubClass();
		umlSubInterface = umlModelTests.getUmlSubInterface();
		umlGenericClass = umlModelTests.getUmlGenericClass();
		umlBindingClass = umlModelTests.getUmlBindingClass();
		umlSubPackage = umlModelTests.getUmlSubPackage();
		umlSubPackageClass = umlModelTests.getUmlSubPackageClass();
		umlEnumeration = umlModelTests.getUmlEnumeration();
		umlBigEnum = umlModelTests.getUmlBigEnum();
		umlSubPackageClassAssociation = umlModelTests.getUmlSubPackageClassAssociation();
		umlBigEnumAssociation = umlModelTests.getUmlBigEnumAssociation();
		umlInterfaceRealization = umlModelTests.getUmlInterfaceRealization();
		umlClassGeneralization = umlModelTests.getUmlClassGeneralization();
		umlInterfaceGeneralization = umlModelTests.getUmlInterfaceGeneralization();
		umlDependency = umlModelTests.getUmlDependency();
		
		mockTmpModel = new TemporaryModel();
		converter = new MdxmlUmlConverter();
	}
	
	@After
	public void cleanup() {
		thrown = ExpectedException.none();
	}
}
