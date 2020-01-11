package mdxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a interface realization with the {@link Supplier} as the contract and the {@link Client}
 * 
 * @author dschoenicke
 *
 */
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class InterfaceRealization {
	
	/**
	 * The id of the InterfaceRealization
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	private String id;
	
	/**
	 * The id of the {@link PackagedElement} which acts as the contract of the interface realization
	 */
	@XmlAttribute
	private String contract;
	
	/**
	 * The {@link Client} which holds a reference to the {@link PackagedElement} which implements the class
	 */
	@XmlElement(name = "client")
	private Client client;
	
	/**
	 * The {@link Supplier} which holds a reference to the {@link PackagedElement} which acts as the interface
	 */
	@XmlElement(name = "supplier")
	private Supplier supplier;
}
