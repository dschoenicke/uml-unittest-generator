package code;

/**
 * Represents a template parameter of a {@link CodeElement} or {@link CodeMethod}
 * 
 * @author dschoenicke
 *
 */
public class CodeTemplateParameter {

	/**
	 * The name of the template parameter
	 */
	private String name;
	
	/**
	 * The {@link CodeParent} of the template parameter
	 */
	private CodeParent parent;
	
	/**
	 * The constraining type of the template parameter
	 * Is empty if there is no constrain
	 */
	private String type;
	
	/**
	 * Constructor with the name and {@link CodeParent} only, if there is no constraining type
	 * In this case the type is left empty
	 * 
	 * @param name the name of the template parameter
	 * @param parent the {@link CodeParent} of the template parameter
	 */
	public CodeTemplateParameter(String name, CodeParent parent) {
		this.name = name;
		this.parent = parent;
		type = "";
	}
	
	/**
	 * Constructor with the name, {@link CodeParent} and a constraining type
	 * 
	 * @param name the name of the template parameter
	 * @param parent the {@link CodeParent} of the template parameter
	 * @param type the constraining type of the template parameter
	 */
	public CodeTemplateParameter(String name, CodeParent parent, String type) {
		this.name = name;
		this.parent = parent;
		this.type = type;
	}
	
	/**
	 * Gets the name of the template parameter
	 * 
	 * @return the name of the template parameter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the template parameter
	 * 
	 * @param name the name of the template parameter
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the constraining type of the template parameter
	 * 
	 * @return the constraining type of the template parameter
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the constraining type of the template parameter
	 * 
	 * @param type the constraining type of the template parameter
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the {@link CodeParent} of the template parameter
	 * 
	 * @return the {@link CodeParent} of the template parameter
	 */
	public CodeParent getParent() {
		return parent;
	}
	
	/**
	 * Sets the {@link CodeParent} of the template parameter
	 * 
	 * @param parent the {@link CodeParent} of the template parameter
	 */
	public void setCodeParent(CodeParent parent) {
		this.parent = parent;
	}
}
