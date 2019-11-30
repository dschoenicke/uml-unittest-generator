package umlcodeconverter;

import java.util.ArrayList;

import org.junit.Before;

import code.CodeRepresentation;
import uml.UmlAttribute;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlMultiplicityValue;
import uml.UmlOperation;
import uml.UmlParameter;
import uml.UmlParameterDirection;
import uml.UmlVisibility;

public class UmlCodeConverterTest {
	
	private UmlModel umlModel;
	private CodeRepresentation codeRepresentation;
	private ArrayList<UmlElement> umlElements;
	private ArrayList<UmlOperation> umlOperations;
	private ArrayList<UmlAttribute> umlAttributes;
	
	@Before
	public void init() {
		umlModel = new UmlModel("TestModel");
		UmlClass testClass = new UmlClass("TestClass", UmlVisibility.PUBLIC);
		testClass.addAttribute(new UmlAttribute("TestClassAttribute",
					UmlVisibility.PRIVATE,
					"String",
					true,
					false,
					"",
					UmlMultiplicityValue.ONE,
					UmlMultiplicityValue.INFINITE
				));
		
		UmlOperation testClassConstructor = new UmlOperation("TestModel", UmlVisibility.PROTECTED);
		testClassConstructor.addParameter(new UmlParameter("testParameter", "int", UmlParameterDirection.RETURN, false));
		testClass.addOperation(testClassConstructor);
		
		//UmlInterface testInterface = new UmlInterface() {
			
		//}
	}
	
	public UmlModel getUmlModel() {
		return umlModel;
	}
}