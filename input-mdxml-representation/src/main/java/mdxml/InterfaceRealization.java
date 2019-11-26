package mdxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a interface realization with the {@link Supplier} as the contract and the {@link Client}
 * 
 * @author dschoenicke
 *
 */
public class InterfaceRealization {
	
	/**
	 * The id of the InterfaceRealization
	 */
	private String id;
	
	/**
	 * The id of the {@link PackagedElement} which acts as the contract of the interface realization
	 */
	private String contract;
	
	/**
	 * The {@link Client} which holds a reference to the {@link PackagedElement} which implements the class
	 */
	private Client client;
	
	/**
	 * The {@link Supplier} which holds a reference to the {@link PackagedElement} which acts as the interface
	 */
	private Supplier supplier;

	/**
	 * Default constructor
	 */
	public InterfaceRealization() {}
	
	/**
	 * Gets the id of the InterfaceRealization
	 * 
	 * @return the id of the InterfaceRealization
	 */
	@XmlAttribute(namespace = "http://www.omg.org/spec/XMI/20131001", name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the InterfaceRealization
	 * 
	 * @param id the id of the InterfaceRealization
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id of the contract
	 * 
	 * @return the id of the contract
	 */
	@XmlAttribute
	public String getContract() {
		return contract;
	}

	/**
	 * Sets the id of the contract
	 * 
	 * @param contract the id of the contract
	 */
	public void setContract(String contract) {
		this.contract = contract;
	}
	
	/**
	 * Gets the {@link Client} of the interface realization
	 * 
	 * @return the {@link Client} of the interface realization
	 */
	@XmlElement(name = "client")
	public Client getClient() {
		return client;
	}
	
	/**
	 * Sets the {@link Client} of the interface realization
	 * 
	 * @param client the {@link Client} of the interface realization
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * Gets the {@link Supplier} of the interface realization
	 * 
	 * @return the {@link Supplier} of the interface realization
	 */
	@XmlElement(name = "supplier") 
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * Sets the {@link Supplier} of the interface realization
	 * 
	 * @param supplier the {@link Supplier} of the interface realization
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
