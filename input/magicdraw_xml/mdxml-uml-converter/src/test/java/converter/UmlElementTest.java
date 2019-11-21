package converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

import model.PackagedElement;
import model.UmlAttribute;
import model.UmlElement;
import model.UmlMultiplicityValue;
import model.UmlOperation;

public class UmlElementTest extends MdxmlUmlConverterTest {

	private PackagedElement mdxmlPackagedElement;
	private UmlElement umlPackagedElement;
	
	@Before
	public void initializePackagedElements() {
		mdxmlPackagedElement = getMdxmlRepresentation().getXmi().getModel().getPackagedElements().get(0);
		umlPackagedElement = ClassFinder.findUmlElementByName("PackagedElement", getUmlModel());
		assertNotNull(mdxmlPackagedElement);
		assertNotNull(umlPackagedElement);
	}
	
	@Test
	public void testElementAttributes() {
		for (Field field : mdxmlPackagedElement.getClass().getDeclaredFields()) {
			boolean found = false;
			
			for (UmlAttribute attribute : umlPackagedElement.getAttributes()) {
				if (attribute.getName().equals(field.getName())) {
					assertEquals(attribute.isFinal(), Modifier.isFinal(field.getModifiers()));
					assertEquals(attribute.isStatic(), Modifier.isStatic(field.getModifiers()));
					
					if (attribute.getUpperValue() == UmlMultiplicityValue.INFINITE) {
						if (field.getType().isArray()) {
							assertEquals(attribute.getType() + "[]", field.getType().getSimpleName());
						}
						else {
							assertEquals(attribute.getType(), convertGenericTypeString(field.getGenericType().toString()));
						}
					}
					
					found = true;
				}
			}
			
			assertTrue(found);
		}
	}
	
	@Test
	public void testElementOperations() {
		for (Method method : mdxmlPackagedElement.getClass().getDeclaredMethods()) {
			boolean found = false;
			
			for (UmlOperation operation : umlPackagedElement.getOperations()) {
				if (operation.getName().equals(method.getName())) {
					assertEquals(operation.isAbstract(), Modifier.isAbstract(method.getModifiers()));
					assertEquals(operation.isStatic(), Modifier.isStatic(method.getModifiers()));
					assertEquals(operation.isFinal(), Modifier.isFinal(method.getModifiers()));
					//TODO: Parameter testen
					
					found = true;
				}
			}
			
			assertTrue(found);
		}
	}
	
	private String convertGenericTypeString(String typeString) {
		String result = typeString;
		result = result.substring(result.lastIndexOf("<") + 1, result.lastIndexOf(">"));
		result = result.substring(result.lastIndexOf(".") + 1);
		return result;
	}
}
