package umlcode.converter.element;

import java.util.Map;

import code.CodeElement;
import code.CodeField;
import code.CodeRepresentation;
import lombok.experimental.UtilityClass;
import uml.UmlAttribute;
import uml.UmlElement;
import uml.UmlMultiplicityValue;

/**
 * Class providing a static method to convert the {@link uml.UmlAttribute}s of a given {@link uml.UmlElement} to {@link code.CodeField}s and adding them to the {@link code.CodeElement}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
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
					ModifierConverter.convertModifierValue(attribute.getVisibility(), 
							attribute.getIsStatic(), 
							attribute.getIsFinal(), 
							false),
					attribute.getDefaultValue(),
					Boolean.valueOf(attribute.getLowerValue() == UmlMultiplicityValue.ZERO),
					Boolean.valueOf(attribute.getUpperValue() == UmlMultiplicityValue.INFINITE),
					codeElement
				));
		}
	}
	
	/**
	 * Replaces the type attribute of all {@link code.CodeField}s of the given {@link code.CodeRepresentation} with a potential matching collection type of the given MapDB database.
	 * 
	 * @param codeRepresentation the {@link code.CodeRepresentation} containing the {@link code.CodeElement}s which {@link code.CodeField} type attributes should be replaced
	 * @param collectionTypes the map of the MapDB database containing collection types for association attributes
	 */
	public static void applyCollectionTypes(CodeRepresentation codeRepresentation, Map<String, String> collectionTypes) {
		codeRepresentation.getElementsAsList().forEach(codeElement -> 
			codeElement.getFields().forEach(codeField -> {
				if (collectionTypes.containsKey(codeElement.getName() + "." + codeField.getName())) {
					codeField.setType(collectionTypes.get(codeElement.getName() + "." + codeField.getName()) + "<" + codeField.getType() + ">");
				}
			})
		);
	}
}
