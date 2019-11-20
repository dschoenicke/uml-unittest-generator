package converter.element;

import model.UmlVisibility;

public class VisibilityConverter {

	public static UmlVisibility convertVisibility(String visibility) {
		UmlVisibility umlVisibility;
		
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
