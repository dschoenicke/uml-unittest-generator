package md_jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Xmi;

public class JaxbRepresentation 
{
	private Xmi xmi;
	
	public JaxbRepresentation(String filepath) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Xmi.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        xmi = (Xmi)jaxbUnmarshaller.unmarshal(new File(filepath));
	}
	
	public Xmi getXmi() {
		return xmi;
	}
	
	public void setXmi(Xmi xmi) {
		this.xmi = xmi;
	}
}
