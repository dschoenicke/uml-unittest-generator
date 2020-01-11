package mdxml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.Data;
import uml.converterinterface.UmlInputRepresentation;

/**
 * Class to provide an interface for the md-xml representation.
 * Takes a String as path to a xml file and generates the representation with
 * {@link Xmi} as root node
 * 
 * @author dschoenicke
 *
 */
@Data
public class MdxmlRepresentation implements UmlInputRepresentation
{
	/**
	 * The representation of the root node of the xml file
	 */
	private Xmi xmi;
	
	/**
	 * Constructor which creates the representation out of the given xml file
	 * 
	 * @param filepath the path to the xml file
	 * @throws JAXBException {@link JAXBException} could be thrown if the xml file is invalid
	 */
	public MdxmlRepresentation(String filepath) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Xmi.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        xmi = (Xmi)jaxbUnmarshaller.unmarshal(new File(filepath));
	}
}
