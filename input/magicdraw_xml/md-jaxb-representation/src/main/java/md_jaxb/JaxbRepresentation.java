package md_jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Xmi;

/**
 * Class to provide an interface for the md-jaxb representation.
 * Takes a String as path to a xml file and generates the representation with
 * {@link Xmi} as root node
 * 
 * @author dschoenicke
 *
 */
public class JaxbRepresentation
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
	public JaxbRepresentation(String filepath) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Xmi.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        xmi = (Xmi)jaxbUnmarshaller.unmarshal(new File(filepath));
	}
	
	/**
	 * Gets the {@link Xmi} which acts as the root node of the xml file
	 * 
	 * @return the {@link Xmi}
	 */
	public Xmi getXmi() {
		return xmi;
	}
	
	/**
	 * Sets the {@link Xmi} which acts as the root node of the xml file
	 * 
	 * @param xmi the {@link Xmi}
	 */
	public void setXmi(Xmi xmi) {
		this.xmi = xmi;
	}
}
