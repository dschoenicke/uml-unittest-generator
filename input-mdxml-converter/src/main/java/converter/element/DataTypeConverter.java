package converter.element;

import converter.temporary.TemporaryModel;
import model.Actual;
import model.DataType;
import model.Extension;

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
