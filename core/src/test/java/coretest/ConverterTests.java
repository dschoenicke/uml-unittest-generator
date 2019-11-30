package coretest;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import code.CodeElement;
import code.CodePackage;
import code.CodeRepresentation;
import coretest.auxiliary.CodeRepresentationMaps;
import coretest.auxiliary.UmlModelMaps;
import coretest.umlcodeconverter.UmlCodeConverterTests;
import mdxml.MdxmlRepresentation;
import mdxmlconverter.MdxmlUmlConverter;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.converterinterface.UmlInputRepresentation;
import uml.converterinterface.UmlRepresentationConverter;
import umlcodeconverter.UmlCodeConverter;

/**
 * This class converts executes for each given {@link uml.converterinterface.UmlInputRepresentation} with its corresponding
 * {@link uml.converterinterface.UmlRepresentationConverter} the tests for each of the following converters:<br>
 * {@link umlcodeconverter.UmlCodeConverter}<br>
 * <br>
 * To add a new sample diagram representation to the test suite, the input file has to be added to the resources-folder
 * and the {@link uml.converterinterface.UmlInputRepresentation} and {@link uml.converterinterface.UmlRepresentationConverter}
 * have to be added to the parameter array in {@link coretest.ConverterTests#data}.
 * 
 * @author dschoenicke
 *
 */
@RunWith(Parameterized.class)
public class ConverterTests {
	
	/**
	 * The {@link uml.converterinterface.UmlInputRepresentation} assigned for each test run
	 */
	private UmlInputRepresentation inputRepresentation;
	
	/**
	 * The {@link uml.converterinterface.UmlRepresentationConverter} assigned for each test run
	 */
	private UmlRepresentationConverter inputConverter;
	
	/**
	 * The {@link uml.UmlModel} converted out of each {@link uml.converterinterface.UmlInputRepresentation} to be tested
	 */
	private UmlModel umlModel;
	
	/**
	 * The {@link code.CodeRepresentation} converted out of each {@link uml.converterinterface.UmlInputRepresentation} to be tested
	 */
	private CodeRepresentation codeRepresentation;
	
	/**
	 * Constructor assigning the {@link uml.converterinterface.UmlInputRepresentation} and {@link uml.converterinterface.UmlRepresentationConverter} for each test run
	 * 
	 * @param inputRepresentation the {@link uml.converterinterface.UmlInputRepresentation} for each test run
	 * @param inputConverter the the {@link uml.converterinterface.UmlRepresentationConverter} for each test run
	 */
	public ConverterTests(UmlInputRepresentation inputRepresentation, UmlRepresentationConverter inputConverter) {
		this.inputRepresentation = inputRepresentation;
		this.inputConverter = inputConverter;
	}
	
	/**
	 * Method to define the {@link uml.converterinterface.UmlInputRepresentation} and the {@link uml.converterinterface.UmlRepresentationConverter} for each test run
	 * 
	 * @return the collection containing all the {@link uml.converterinterface.UmlInputRepresentation} - {@link uml.converterinterface.UmlRepresentationConverter} pairs
	 * @throws JAXBException thrown if the input Magic Draw project file is invalid
	 */
	@Parameters
	public static Collection<Object[]> data() throws JAXBException {
		ClassLoader classLoader = ConverterTests.class.getClassLoader();
		Object[][] data = {
			{new MdxmlRepresentation(classLoader.getResource("md_test.xml").getFile()), new MdxmlUmlConverter()}
		};
		
		return Arrays.asList(data);
	}
	
	/**
	 * Initializes the representations to be used in the tests
	 */
	@Before
	public void init() {
		umlModel = inputConverter.convertToUmlRepresentation(inputRepresentation);
		codeRepresentation = new UmlCodeConverter().convertUmlToCodeRepresentation(umlModel);
	}
	
	/**
	 * Coordinator method delegating the tests for each converter to the respective class
	 */
	@Test
	public void testWithInputRepresentation() {
		HashMap<String, UmlPackage> umlPackages = UmlModelMaps.createUmlPackageMap(umlModel);
		HashMap<String, UmlElement> umlElements = UmlModelMaps.createUmlElementMap(umlModel);
		HashMap<String, CodePackage> codePackages = CodeRepresentationMaps.createCodePackageMap(codeRepresentation);
		HashMap<String, CodeElement> codeElements = CodeRepresentationMaps.createCodeElementMap(codeRepresentation);
		
		UmlCodeConverterTests.test(umlPackages, umlElements, codePackages, codeElements, umlModel, codeRepresentation);
	}
}
