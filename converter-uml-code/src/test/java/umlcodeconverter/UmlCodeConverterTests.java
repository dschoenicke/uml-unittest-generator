package umlcodeconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import code.CodeClass;
import code.CodeEnumeration;
import code.CodeInterface;
import code.CodePackage;
import code.CodeRepresentation;
import code.CodeRepresentationTests;
import uml.UmlClass;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlModelTests;
import uml.UmlPackage;
import uml.UmlRelationship;
import umlcodeconverter.temporary.TemporaryModel;

public class UmlCodeConverterTests {
	
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
	
	protected CodeRepresentation codeRepresentation;
	protected CodePackage codeModelPackage;
	protected CodePackage codeTopLevelPackage;
	protected CodeInterface codeTopLevelInterface;
	protected CodeClass codeTopLevelClass;
	protected CodeClass codeSubClass;
	protected CodeInterface codeSubInterface;
	protected CodeClass codeGenericClass;
	protected CodeClass codeBindingClass;
	protected CodePackage codeSubPackage;
	protected CodeClass codeSubPackageClass;
	protected CodeEnumeration codeEnumeration;
	protected CodeEnumeration codeBigEnum;
	
	protected UmlModelTests umlModelTests;
	protected CodeRepresentationTests codeRepresentationTests;
	protected TemporaryModel mockTmpModel;
	protected UmlCodeConverter converter;
	protected ExpectedException thrown;
	
	@Before
	public void initTestData() {
		codeRepresentationTests = new CodeRepresentationTests();
		codeRepresentationTests.initializeCodeRepresentation();
		umlModelTests = new UmlModelTests();
		umlModelTests.initializeUmlModel();
		thrown = umlModelTests.thrown;
		codeRepresentation = codeRepresentationTests.getCodeRepresentation();
		codeTopLevelPackage = codeRepresentationTests.getCodeTopLevelPackage();
		codeTopLevelInterface = codeRepresentationTests.getCodeTopLevelInterface();
		codeTopLevelClass = codeRepresentationTests.getCodeTopLevelClass();
		codeSubClass = codeRepresentationTests.getCodeSubClass();
		codeSubInterface = codeRepresentationTests.getCodeSubInterface();
		codeGenericClass = codeRepresentationTests.getCodeGenericClass();
		codeBindingClass = codeRepresentationTests.getCodeBindingClass();
		codeSubPackage = codeRepresentationTests.getCodeSubPackage();
		codeSubPackageClass = codeRepresentationTests.getCodeSubPackageClass();
		codeEnumeration = codeRepresentationTests.getCodeEnumeration();
		codeBigEnum = codeRepresentationTests.getCodeBigEnum();
		
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
		converter = new UmlCodeConverter();
	}
	
	@After
	public void cleanup() {
		thrown = ExpectedException.none();
	}
}
