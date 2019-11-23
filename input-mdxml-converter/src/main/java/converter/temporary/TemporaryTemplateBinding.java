package converter.temporary;

import java.util.HashMap;

import uml.UmlTemplateBinding;

public class TemporaryTemplateBinding extends UmlTemplateBinding {
	
	private HashMap<String, String> parameterSubstitutionMap;
	
	public TemporaryTemplateBinding() {
		parameterSubstitutionMap = new HashMap<>();
	}	
	
	public HashMap<String, String> getParameterSubstitutionMap() {
		return parameterSubstitutionMap;
	}
	
	public void addTemporarySubstitution(String templateParameter, String substitutionType) {
		parameterSubstitutionMap.put(templateParameter, substitutionType);
	}
}
