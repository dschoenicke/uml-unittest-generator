package converter.element;

import converter.temporary.TemporaryModel;
import model.Actual;
import model.DataType;
import model.Extension;

public class DataTypeConverter {
	
	public static String convertDataType(String elementReference, DataType dataType) {
		return generateDataTypeString(elementReference, dataType.getExtension());
	}
	
	public static String convertDataType(String elementReference, Actual actual) {
		return generateDataTypeString(elementReference, actual.getExtension());
	}
		
	private static String generateDataTypeString(String elementReference, Extension extension) {
		if (elementReference != null) {
			return elementReference;
		}
		
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
