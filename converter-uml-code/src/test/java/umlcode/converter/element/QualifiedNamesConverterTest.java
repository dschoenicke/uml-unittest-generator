package umlcode.converter.element;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import code.CodeClass;
import code.CodeConstructor;
import code.CodeMethod;
import code.CodeParameter;
import code.CodeTemplateParameter;
import umlcode.UmlCodeConverterTests;

public class QualifiedNamesConverterTest extends UmlCodeConverterTests {
	
	@Test
	public void testQualifiedNamesConverter() {
		Map<String, String> qualifiedNames = new HashMap<>();
		qualifiedNames.put("SubPackageClass", "QualifiedName");
		qualifiedNames.put("Model.TopLevelPackage.SubPackage.SubPackageClass", "QualifiedName");
		qualifiedNames.put("TestClass", "test.test");
		CodeClass codeClass = new CodeClass("TestClass<Test>", codeTopLevelPackage, 0);
		codeTopLevelPackage.addElement(codeClass);
		CodeConstructor constructor = codeGenericClass.getConstructors().get(0);
		CodeMethod method = codeGenericClass.getMethods().get(0);
		method.getParameters().add(new CodeParameter("test", "SubPackageClass", 0, false, false));
		method.getReturnType().setType("SubPackageClass");
		CodeTemplateParameter templateParameter = new CodeTemplateParameter("Test", "SubPackageClass");
		codeGenericClass.addTemplateParameter(templateParameter);
		constructor.getParameters().add(new CodeParameter("test", "SubPackageClass", 0, false, false));
		QualifiedNamesConverter.resolveQualifiedNames(codeRepresentation, qualifiedNames);
		
		assertEquals("QualifiedName", codeSubPackageClass.getQualifiedName());
		assertEquals("Model.TopLevelPackage.SubClass", codeSubClass.getQualifiedName());
		assertEquals("QualifiedName", method.getReturnType().getType());
		assertEquals("QualifiedName", method.getParameters().get(0).getType());
		assertEquals("QualifiedName", constructor.getParameters().get(1).getType());
		assertEquals("QualifiedName", templateParameter.getType());
		assertEquals("test.test<Test>", codeClass.getQualifiedName());
	}
	
	@Test
	public void testConstructorParameterQualifiedName() {
		CodeParameter arrayParam = new CodeParameter("arrayParam", "String", 0, false, true);
		CodeParameter arrayClassParam = new CodeParameter("arrayClassParam", "String[]", 0, false, true);
		CodeParameter collectionParam = new CodeParameter("collectionParam", "Collection<String>", 0, false, true);
		codeGenericClass.getConstructors().get(0).getParameters().add(arrayParam);
		codeGenericClass.getConstructors().get(0).getParameters().add(arrayClassParam);
		codeGenericClass.getConstructors().get(0).getParameters().add(collectionParam);
		QualifiedNamesConverter.resolveElementConstructorParameters(codeGenericClass);
		assertEquals("String[]", codeGenericClass.getConstructors().get(0).getParameters().get(1).getType());
		assertEquals("String[]", codeGenericClass.getConstructors().get(0).getParameters().get(2).getType());
		assertEquals("Collection<String>", codeGenericClass.getConstructors().get(0).getParameters().get(3).getType());
	}
	
	@Test
	public void testMethodParameterQualifiedName() {
		CodeParameter arrayParam = new CodeParameter("arrayParam", "String", 0, false, true);
		CodeParameter arrayClassParam = new CodeParameter("arrayClassParam", "String[]", 0, false, true);
		CodeParameter collectionParam = new CodeParameter("collectionParam", "Collection<String>", 0, false, true);
		codeGenericClass.getMethods().get(0).getParameters().add(arrayParam);
		codeGenericClass.getMethods().get(0).getParameters().add(arrayClassParam);
		codeGenericClass.getMethods().get(0).getParameters().add(collectionParam);
		QualifiedNamesConverter.resolveElementMethodParameters(codeGenericClass);
		assertEquals("String[]", codeGenericClass.getMethods().get(0).getParameters().get(0).getType());
		assertEquals("String[]", codeGenericClass.getMethods().get(0).getParameters().get(1).getType());
		assertEquals("Collection<String>", codeGenericClass.getMethods().get(0).getParameters().get(2).getType());
	}
}
