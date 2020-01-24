package code;

import java.util.List;

import org.junit.Before;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CodeRepresentationTests {

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
	
	public void initializeCodeRepresentation() {
		codeRepresentation = new CodeRepresentation("Model");
		codeModelPackage = new CodePackage("Model", codeRepresentation);
		codeRepresentation.addPackage(codeModelPackage);
		
		codeTopLevelInterface = new CodeInterface("TopLevelInterface", codeModelPackage, 1);
		codeTopLevelInterface.setQualifiedName("Model.TopLevelInterface");
		codeTopLevelClass = new CodeClass("TopLevelClass", codeModelPackage, 1);
		codeTopLevelClass.setQualifiedName("Model.TopLevelClass");
		codeTopLevelClass.addInterface(codeTopLevelInterface);
		codeModelPackage.getElements().addAll(List.of(codeTopLevelInterface, codeTopLevelClass));
		
		codeTopLevelPackage = new CodePackage("TopLevelPackage", codeModelPackage);
		codeModelPackage.addPackage(codeTopLevelPackage);
		codeSubInterface = new CodeInterface("SubInterface", codeTopLevelPackage, 1);
		codeSubInterface.setQualifiedName("Model.TopLevelPackage.SubInterface");
		codeSubInterface.addInterface(codeTopLevelInterface);

		codeSubClass = new CodeClass("SubClass", codeTopLevelPackage, 1);
		codeSubClass.setSuperClass(codeTopLevelClass);
		codeSubClass.setQualifiedName("Model.TopLevelPackage.SubClass");
		codeSubClass.addField(new CodeField("testString", "String", 2, "", true, false, codeSubClass));
		
		codeGenericClass = new CodeClass("GenericClass", codeTopLevelPackage, 1);
		codeGenericClass.setQualifiedName("Model.TopLevelPackage.GenericClass");
		codeGenericClass.addField(new CodeField("subPackageClass", "Model.TopLevelPackage.SubPackage.SubPackageClass", 2, "", false, true, codeGenericClass));
		codeGenericClass.addField(new CodeField("bigEnum", "Model.TopLevelPackage.SubPackage.BigEnum", 2, "", false, false, codeGenericClass));
		codeGenericClass.addConstructor(new CodeConstructor(codeGenericClass, 1));
		CodeParameter param = new CodeParameter("", "void", 0, false, false, codeGenericClass.getConstructors().get(0));
		codeGenericClass.getConstructors().get(0).getParameters().add(param);
		codeGenericClass.getMethods().addAll(List.of(
				new CodeMethod("getSubPackageClasses", codeGenericClass, null, true, 1),
				new CodeMethod("addSubPackageClass", codeGenericClass, null, false, 1)
			));
		
		param = new CodeParameter("", "Model.TopLevelPackage.SubPackage.SubPackageClass", 0, false, true, codeGenericClass.getMethods().get(0));
		codeGenericClass.getMethods().get(0).setReturnType(param);
		param = new CodeParameter("", "void", 0, false, false, codeGenericClass.getMethods().get(1));
		codeGenericClass.getMethods().get(1).setReturnType(param);
		param = new CodeParameter("subPackageClass", "Model.TopLevelPackage.SubPackage.SubPackageClass", 0, false, false, codeGenericClass.getMethods().get(1));
		codeGenericClass.getMethods().get(1).getParameters().add(param);
		codeGenericClass.getTemplateParameters().addAll(List.of(
				new CodeTemplateParameter("T", codeGenericClass, "Model.TopLevelClass"),
				new CodeTemplateParameter("O", codeGenericClass, "java.lang.Object")
			));
		
		codeBindingClass = new CodeClass("BindingClass", codeTopLevelPackage, 1);
		codeBindingClass.setQualifiedName("Model.TopLevelPackage.BindingClass");
		codeBindingClass.addConstructor(new CodeConstructor(codeBindingClass, 1));
		codeBindingClass.addTemplateBinding(new CodeTemplateBinding());
		codeBindingClass.getTemplateBindings().get(0).addParameterSubstitution(codeGenericClass.getTemplateParameters().get(0), "Model.TopLevelPackage.SubClass");
		codeTopLevelPackage.getElements().addAll(List.of(codeSubInterface, codeSubClass, codeGenericClass, codeBindingClass));
		
		codeSubPackage = new CodePackage("SubPackage", codeTopLevelPackage);
		codeTopLevelPackage.addPackage(codeSubPackage);
		codeSubPackageClass = new CodeClass("SubPackageClass", codeSubPackage, 1);
		codeSubPackageClass.setQualifiedName("Model.TopLevelPackage.SubPackage.SubPackageClass");
		codeEnumeration = new CodeEnumeration("Enumeration", codeSubPackageClass, 1);
		codeEnumeration.setQualifiedName("Model.TopLevelPackage.SubPackage.SubPackageClass$Enumeration");
		codeEnumeration.getLiterals().addAll(List.of(new CodeLiteral("FIRST", codeEnumeration), new CodeLiteral("SECOND",codeEnumeration)));
		codeSubPackageClass.addNestedElement(codeEnumeration);
		codeBigEnum = new CodeEnumeration("BigEnum", codeSubPackage, 1);
		codeBigEnum.setQualifiedName("Model.TopLevelPackage.SubPackage.BigEnum");
		codeBigEnum.addCodeLiteral(new CodeLiteral("BIGFIRST", codeBigEnum));
		codeBigEnum.addField(new CodeField("value", "int", 18, "10", false, false, codeBigEnum));
		codeBigEnum.addConstructor(new CodeConstructor(codeBigEnum, 1));
		codeBigEnum.getConstructors().get(0).getParameters().add(new CodeParameter("value", "int", 0, false, false, codeBigEnum.getConstructors().get(0)));
		codeBigEnum.addMethod(new CodeMethod("someOperation", codeBigEnum, null, false, 1));
		codeBigEnum.getMethods().get(0).setReturnType(new CodeParameter("", "void", 0, false, false, codeBigEnum.getMethods().get(0)));
		codeSubPackage.getElements().addAll(List.of(codeSubPackageClass, codeBigEnum));
	}
	
	@Before
	public void init() {
		initializeCodeRepresentation();
	}
}
