package uml;

import java.util.List;

import org.junit.Before;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UmlModelTests {

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
	
	public void initializeUmlModel() {
		umlModel = new UmlModel("Model");
		umlTopLevelInterface = new UmlInterface("TopLevelInterface", UmlVisibility.PUBLIC);
		umlTopLevelClass = new UmlClass("TopLevelClass", UmlVisibility.PUBLIC, false, false, false);
		umlModel.getElements().addAll(List.of(umlTopLevelInterface, umlTopLevelClass));
		umlInterfaceRealization = new UmlRelationship(umlTopLevelClass, umlTopLevelInterface, UmlRelationshipType.INTERFACEREALIZATION);
		umlModel.addRelationship(umlInterfaceRealization);
		
		umlTopLevelPackage = new UmlPackage("TopLevelPackage");
		umlModel.addPackage(umlTopLevelPackage);
		umlSubInterface = new UmlInterface("SubInterface", UmlVisibility.PUBLIC);
		umlSubClass = new UmlClass("SubClass", UmlVisibility.PUBLIC, false, false, false);
		umlSubClass.addAttribute(new UmlAttribute("testString", UmlVisibility.PRIVATE, "String", false, false, "", UmlMultiplicityValue.ZERO, UmlMultiplicityValue.ONE));
		umlInterfaceGeneralization = new UmlRelationship(umlSubInterface, umlTopLevelInterface, UmlRelationshipType.GENERALIZATION);
		umlClassGeneralization = new UmlRelationship(umlSubClass, umlTopLevelClass, UmlRelationshipType.GENERALIZATION);
		umlDependency = new UmlRelationship(umlSubClass, umlTopLevelInterface, UmlRelationshipType.DEPENDENCY);
		umlGenericClass = new UmlClass("GenericClass", UmlVisibility.PUBLIC, false, false, false);
		umlGenericClass.addAttribute(new UmlAttribute("subPackageClass", UmlVisibility.PRIVATE, "SubPackageClass", false, false, "", UmlMultiplicityValue.ONE, UmlMultiplicityValue.INFINITE));
		umlGenericClass.addAttribute(new UmlAttribute("bigEnum", UmlVisibility.PRIVATE, "BigEnum", false, false, "", UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		umlGenericClass.getOperations().addAll(List.of(
				new UmlOperation("GenericClass", UmlVisibility.PUBLIC),
				new UmlOperation("getSubPackageClasses", UmlVisibility.PUBLIC),
				new UmlOperation("addSubPackageClass", UmlVisibility.PUBLIC)
			));
		umlGenericClass.getOperations().get(0).addParameter(new UmlParameter("name", "String", UmlParameterDirection.IN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		umlGenericClass.getOperations().get(1).addParameter(new UmlParameter("", "UmlSubPackageClass", UmlParameterDirection.RETURN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.INFINITE));
		umlGenericClass.getOperations().get(2).getParameters().addAll(List.of(
				new UmlParameter("", "void", UmlParameterDirection.RETURN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE),
				new UmlParameter("subPackageClass", "SubPackageClass", UmlParameterDirection.IN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE)
			));
		umlGenericClass.getTemplateParameters().addAll(List.of(
				new UmlTemplateParameter("T", "TopLevelClass"),
				new UmlTemplateParameter("O", "java.lang.Object")
			));
		umlBindingClass = new UmlClass("BindingClass", UmlVisibility.PUBLIC, false, false, false);
		umlBindingClass.addOperation(new UmlOperation("BindingClass", UmlVisibility.PUBLIC));
		umlBindingClass.addTemplateBinding(new UmlTemplateBinding());
		umlBindingClass.getTemplateBindings().get(0).addParameterSubstitution(new UmlParameterSubstitution(umlGenericClass.getTemplateParameters().get(0), "SubClass"));
		umlTopLevelPackage.getElements().addAll(List.of(umlSubInterface, umlSubClass, umlGenericClass, umlBindingClass));
		
		umlSubPackage = new UmlPackage("SubPackage");
		umlTopLevelPackage.addPackage(umlSubPackage);
		umlSubPackageClass = new UmlClass("SubPackageClass", UmlVisibility.PUBLIC, false, false, false);
		umlEnumeration = new UmlEnumeration("Enumeration", UmlVisibility.PUBLIC);
		umlEnumeration.getLiterals().addAll(List.of(new UmlLiteral("FIRST"), new UmlLiteral("SECOND")));
		umlSubPackageClass.addInnerElement(umlEnumeration);
		umlBigEnum = new UmlEnumeration("BigEnum", UmlVisibility.PUBLIC);
		umlBigEnum.addUmlLiteral(new UmlLiteral("BIGFIRST"));
		umlBigEnum.addAttribute(new UmlAttribute("value", UmlVisibility.PRIVATE, "int", false, true, "10", UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		umlBigEnum.addOperation(new UmlOperation("BigEnum", UmlVisibility.PUBLIC));
		umlBigEnum.getOperations().get(0).addParameter(new UmlParameter("value", "int", UmlParameterDirection.IN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		umlBigEnum.addOperation(new UmlOperation("someOperation", UmlVisibility.PUBLIC));
		umlBigEnum.getOperations().get(1).addParameter(new UmlParameter("", "void", UmlParameterDirection.RETURN, false, UmlMultiplicityValue.ONE, UmlMultiplicityValue.ONE));
		umlSubPackage.getElements().addAll(List.of(umlSubPackageClass, umlBigEnum));
		
		umlTopLevelPackage.getRelationships().addAll(List.of(
				new UmlRelationship(umlGenericClass, umlSubPackageClass, UmlRelationshipType.AGGREGATION),
				new UmlRelationship(umlGenericClass, umlBigEnum, UmlRelationshipType.ASSOCIATION)
			));
	}
	
	@Before
	public void init() {
		initializeUmlModel();
	}
}
