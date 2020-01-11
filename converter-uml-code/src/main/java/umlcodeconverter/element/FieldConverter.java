package umlcodeconverter.element;

import code.CodeElement;
import code.CodeField;
import code.CodeModifier;
import uml.UmlAttribute;
import uml.UmlElement;
import uml.UmlMultiplicityValue;

/**
 * Class providing a static method to convert the {@link uml.UmlAttribute}s of a given {@link uml.UmlElement} to {@link code.CodeField}s and adding them to the {@link code.CodeElement}
 * 
 * @author dschoenicke
 *
 */
public class FieldConverter {

	/**
	 * Static method to convert the {@link uml.UmlAttribute}s of a given {@link uml.UmlElement} to {@link code.CodeField}s and adding them to the {@link code.CodeElement}
	 * 
	 * @param element the {@link uml.UmlElement} which {@link uml.UmlAttribute} to be converted
	 * @param codeElement the {@link code.CodeElement} to which the converted {@link code.CodeField}s should be added to
	 */
	public static void convertFields(UmlElement element, CodeElement codeElement) {
		for (UmlAttribute attribute : element.getAttributes()) {
			codeElement.addField(new CodeField(attribute.getName(),
					attribute.getType(),
					Integer.valueOf(CodeModifier.convertModifierValue(ModifierConverter.convertAccessModifier(attribute.getVisibility()), 
							attribute.isStatic(), 
							attribute.isFinal(), 
							false)),
					attribute.getDefaultValue(),
					Boolean.valueOf(attribute.getLowerValue() == UmlMultiplicityValue.ZERO),
					Boolean.valueOf(attribute.getUpperValue() == UmlMultiplicityValue.INFINITE),
					codeElement
				));
		}
	}
	
}
