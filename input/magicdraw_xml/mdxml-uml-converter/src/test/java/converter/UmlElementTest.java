package converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.Before;
import org.junit.Test;

import model.PackagedElement;
import model.UmlAttribute;
import model.UmlElement;
import model.UmlMultiplicityValue;
import model.UmlOperation;
import model.UmlParameter;
import model.UmlParameterDirection;

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
					else {
						assertEquals(attribute.getType(), field.getType().getSimpleName());
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
					testOperationReturnType(operation, method);
					testOperationParameters(operation, method);
					found = true;
				}
			}
			
			assertTrue(found);
		}
	}
	
	private void testOperationReturnType(UmlOperation operation, Method method) {
		boolean found = false;
	
		for (UmlParameter umlParameter : operation.getParameters()) {
			if (umlParameter.getDirection() == UmlParameterDirection.RETURN) {
				if (umlParameter.getUpperValue() == UmlMultiplicityValue.INFINITE) {
					if (method.getReturnType().isArray()) {
						assertEquals(umlParameter.getType() + "[]", method.getReturnType().getSimpleName());
					}
					else {
						//TODO: Get Generic Type out of return value
						//System.out.println(method.getReturnType().toGenericString());
					}
				}
				else {
					assertEquals(umlParameter.getType(), method.getReturnType().getSimpleName());
				}
				
				found = true;
			}
		}
		
		assertTrue(found);
	}
		
	private void testOperationParameters(UmlOperation operation, Method method) {
		//TODO: Method parameters always have names arg0, arg1, ..., argn
		/*
		for (Parameter parameter : method.getParameters()) {
			System.out.println("	" + parameter.getName());
			boolean found = false;
			
			for (UmlParameter umlParameter : operation.getParameters()) {
				/*if (umlParameter.getDirection() == UmlParameterDirection.IN) {
					//System.out.println("	" + umlParameter.getName() + " " + parameter.getName());
					
					if (umlParameter.getName().equals(parameter.getName())) {
						assertEquals(umlParameter.isFinal(), Modifier.isFinal(parameter.getModifiers()));
					
						if (umlParameter.getUpperValue() == UmlMultiplicityValue.INFINITE) {
							if (parameter.getType().isArray()) {
								assertEquals(umlParameter.getType() + "[]", parameter.getType().getSimpleName());
							}
							else {
							//assertEquals(umlParameter.getType(), convertGenericTypeString(parameter.getGenericType().toString()));
							}
						}
						else {
							assertEquals(umlParameter.getType(), parameter.getType().getSimpleName());
						}
						
						found = true;
					}
				}
			}
			
			//assertTrue(found);
		}*/
	}
	
	private String convertGenericTypeString(String typeString) {
		String result = typeString;
		result = result.substring(result.lastIndexOf("<") + 1, result.lastIndexOf(">"));
		result = result.substring(result.lastIndexOf(".") + 1);
		return result;
	}
}
