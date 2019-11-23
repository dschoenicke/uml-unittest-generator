package mdxmlconverter.element;

import mdxml.Actual;
import mdxml.DataType;
import mdxml.Extension;
import mdxmlconverter.temporary.TemporaryModel;

public class DataTypeConverter {
	
	public static String convertDataType(String elementReference, DataType dataType) {
		if (elementReference != null) {
			return elementReference;
		}
		
		return generateDataTypeString(dataType.getExtension());
	}
	
	public static String convertDataType(String elementReference, Actual actual) {
		if (elementReference != null) {
			return elementReference;
		}
		
		return generateDataTypeString(actual.getExtension());
	}
	
	private static String generateDataTypeString(Extension extension) {
		String result = "";
		
		try {
			result = extension.getReferenceExtension().getReferentPath();
			result = result.substring(result.lastIndexOf("::") + 2);
		}
		catch(NullPointerException np) {}
		
		return result;
	}

	public static String convertElementID(String elementID, TemporaryModel tmpModel) {
		if (tmpModel.getElementIDs().containsKey(elementID)) {
			return tmpModel.getElementIDs().get(elementID).getName();
		}
		
		return elementID;
	}
}
