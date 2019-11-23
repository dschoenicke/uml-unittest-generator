package converter.element;

import uml.UmlVisibility;

public class VisibilityConverter {

	public static UmlVisibility convertVisibility(String visibility) {
		UmlVisibility umlVisibility;
		
		if (visibility == null) {
			return UmlVisibility.NONE;
		}
		
		switch(visibility) {
			case "public": {
				umlVisibility = UmlVisibility.PUBLIC;
				break;
			}
			case "private": {
				umlVisibility = UmlVisibility.PRIVATE;
				break;
			}
			case "protected": {
				umlVisibility = UmlVisibility.PROTECTED;
				break;
			}
			case "package": {
				umlVisibility = UmlVisibility.PACKAGE;
				break;
			}
			default: {
				umlVisibility = UmlVisibility.NONE;
				break;
			}
		}
		
		return umlVisibility;
	}
	
}
