package mdxmlconverter.element;

import static org.junit.Assert.assertNotNull;

import mdxml.Actual;
import mdxml.DataType;
import mdxml.Extension;
import mdxmlconverter.temporary.TemporaryModel;

/**
 * Class providing static methods to convert strings representing data types or replaces the id of a {@link mdxml.PackagedElement} with its name, if the datatype is a reference
 * 
 * @author dschoenicke
 *
 */
public class DataTypeConverter {
	
	private DataTypeConverter() {
		throw new IllegalStateException("utility class");
	}
	
	/**
	 * Static method converting the string representing the data type of a given {@link mdxml.Extension} or sets the data type to the id of a {@link mdxml.PackagedElement} if the data type is a reference
	 * 
	 * @param elementReference the id of a {@link mdxml.PackagedElement} if the data type is a reference, is {@literal Null} otherwise
	 * @param dataType the {@link mdxml.Actual} holding the data type string to be converted if the data type is primitive, is {@literal Null} otherwise
	 * @return the converted data type name or the element reference
	 */
	public static String convertDataType(String elementReference, DataType dataType) {
		if (elementReference != null) {
			return elementReference;
		}
		
		assertNotNull("The dataType must not be null!", dataType);
		assertNotNull("The extension of the dataType must not be null!", dataType.getExtension());
		return generateDataTypeString(dataType.getExtension());
	}
	
	/**
	 * Static method converting the string representing the data type of a given {@link mdxml.Actual} or sets the data type to the id of a {@link mdxml.PackagedElement} if the data type is a reference
	 * 
	 * @param elementReference the id of a {@link mdxml.PackagedElement} if the data type is a reference, is {@literal Null} otherwise
	 * @param actual the {@link mdxml.Actual} holding the data type string to be converted if the data type is primitive, is {@literal Null} otherwise
	 * @return the converted data type name or the element reference
	 */
	public static String convertDataType(String elementReference, Actual actual) {
		if (elementReference != null) {
			return elementReference;
		}
		
		assertNotNull("The dataType must not be null!", actual);
		assertNotNull("The extension of the actual must not be null!", actual.getExtension());
		return generateDataTypeString(actual.getExtension());
	}
	
	/**
	 * Static method converting the qualified Magic Draw XML name of a primitive type to its simple name 
	 * 
	 * @param extension the {@link mdxml.Extension} containing the {@link mdxml.ReferenceExtension} which contains the qualified name
	 * @return the simple name of the data type
	 */
	public static String generateDataTypeString(Extension extension) {
		assertNotNull("The ReferenceExtension of the Extension must not be null!", extension.getReferenceExtension());
		assertNotNull("The ReferentPath of the ReferenceExtension must not be null!", extension.getReferenceExtension().getReferentPath());
		String result = extension.getReferenceExtension().getReferentPath();
		result = result.substring(result.lastIndexOf("::") + 2);
		
		return result;
	}

	/**
	 * Static method converting references to {@link mdxml.PackagedElement}s to the name of the corresponding {@link uml.UmlElement}
	 * 
	 * @param elementID the id of the {@link mdxml.PackagedElement}
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} containing a mapping of element ids and {@link uml.UmlElement}s
	 * @return the converted element name if the elementID was a reference or the input string if it is an already converted primitive type
	 */
	public static String convertElementID(String elementID, TemporaryModel tmpModel) {
		if (tmpModel.getElementIDs().containsKey(elementID)) {
			return tmpModel.getElementIDs().get(elementID).getName();
		}
		
		return elementID;
	}
}
