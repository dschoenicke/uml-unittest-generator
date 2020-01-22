package umlcodeconverter.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import code.CodeField;
import uml.UmlAttribute;
import umlcodeconverter.UmlCodeConverterTests;

/**
 * Tests the {@link FieldConverter}.
 * 
 * @author dschoenicke
 *
 */
public class FieldConverterTest extends UmlCodeConverterTests {

	@Test
	public void testFieldConverter() {
		codeGenericClass.getFields().clear();
		codeSubClass.getFields().clear();
		FieldConverter.convertFields(umlGenericClass, codeGenericClass);
		FieldConverter.convertFields(umlSubClass, codeSubClass);
		assertEquals(umlGenericClass.getAttributes().size(), codeGenericClass.getFields().size());
		UmlAttribute firstAttribute = umlGenericClass.getAttributes().get(0);
		UmlAttribute secondAttribute = umlSubClass.getAttributes().get(0);
		CodeField firstField = codeGenericClass.getFields().get(0);
		CodeField secondField = codeSubClass.getFields().get(0);
		
		assertEquals(firstAttribute.getName(), firstField.getName());
		assertEquals(firstAttribute.getType(), firstField.getType());
		assertEquals(Integer.valueOf(2), firstField.getModifiers());
		assertTrue(firstField.getDefaultValue().isEmpty());
		assertFalse(firstField.getCanBeNull());
		assertTrue(firstField.getHasMultiplicity());
		assertEquals(firstField.getParent(), codeGenericClass);
		
		assertEquals(secondAttribute.getName(), secondField.getName());
		assertEquals(secondAttribute.getType(), secondField.getType());
		assertEquals(Integer.valueOf(2), secondField.getModifiers());
		assertTrue(secondField.getDefaultValue().isEmpty());
		assertTrue(secondField.getCanBeNull());
		assertFalse(secondField.getHasMultiplicity());
		assertEquals(secondField.getParent(), codeSubClass);
	}
	
	@Test
	public void testApplyCollectionTypes() {
		Map<String, String> collections = new HashMap<>();
		collections.put("GenericClass.subPackageClass", "java.util.List");
		FieldConverter.applyCollectionTypes(codeRepresentation, collections);
		assertEquals("java.util.List<Model.TopLevelPackage.SubPackage.SubPackageClass>", codeGenericClass.getFields().get(0).getType());
	}
}
