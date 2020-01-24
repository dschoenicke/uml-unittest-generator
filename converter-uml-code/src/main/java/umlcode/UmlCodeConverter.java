package umlcode;

import static org.junit.Assert.assertFalse;

import java.util.Map;

import code.CodePackage;
import code.CodeRepresentation;
import lombok.NoArgsConstructor;
import uml.UmlModel;
import umlcode.converter.element.ElementConverter;
import umlcode.converter.element.FieldConverter;
import umlcode.converter.element.PackageConverter;
import umlcode.converter.element.QualifiedNamesConverter;
import umlcode.converter.element.TemplateBindingConverter;
import umlcode.converter.relationship.RelationshipConverter;

/**
 * Main class of the converter 
 * 
 * @author dschoenicke
 *
 */
@NoArgsConstructor
public class UmlCodeConverter 
{	
	/**
	 * Converts a given {@link uml.UmlModel} to a {@link code.CodeRepresentation}.<br>
	 * Resolves fully qualified names with the mappings of the given MapDB database.<br>
	 * Resolves association attribute data types with given collection types out of the given MapDB database.<br>
	 * 
	 * Delegates the conversion of {@link uml.UmlPackage}s to the {@link umlcode.converter.element.PackageConverter}<br>
	 * Delegates the conversion of {@link uml.UmlElement}s to the {@link umlcode.converter.element.ElementConverter}<br>
	 * Delegates the definite conversion of {@link uml.UmlTemplateBinding}s to the {@link umlcode.converter.element.TemplateBindingConverter}<br>
	 * Delegates the conversion of {@link uml.UmlRelationship} to the {@link umlcode.converter.relationship.RelationshipConverter}
	 * 
	 * @param umlModel the {@link uml.UmlModel} to be converted
	 * @param qualifiedNames the map containing mappings from class names to fully qualified names
	 * @param associationTypes the map containing mappings from field names to collection types
	 * @return the converted {@link code.CodeRepresentation}
	 */
	public CodeRepresentation convertUmlToCodeRepresentation(UmlModel umlModel, Map<String, String> qualifiedNames, Map<String, String> associationTypes) {
		CodeRepresentation codeRepresentation =  new CodeRepresentation(umlModel.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		
		if (!umlModel.getElements().isEmpty()) {
			umlModel.getPackagesAsList().forEach(umlPackage -> 
				assertFalse("Could not convert UmlModel " + umlModel.getName() + "!\n"
						+ "UmlModel " + umlModel.getName() + " contains a package with the model name\n"
						+ "while containing UmlElements, which are not assigned to a UmlPackage.\n"
						+ "For these elements, a CodePackage with the name of the model would be created,\n"
						+ "which would be a duplicate.",
						umlPackage.getName().equals(umlModel.getName()))
			);
		}
		
		PackageConverter.convertPackages(umlModel.getPackages(), codeRepresentation, tmpModel);
		ElementConverter.convertElements(umlModel, codeRepresentation, tmpModel);
		TemplateBindingConverter.finishTemplateBindingConversions(tmpModel);
		RelationshipConverter.convertRelationships(umlModel.getRelationshipsAsList(), tmpModel);
		codeRepresentation.getElementsAsList().forEach(codeElement -> {
			if (codeElement.getName().contains("<") || codeElement.getName().contains("[")) {
				((CodePackage) codeElement.getParent()).getElements().remove(codeElement);
			}
		});
		
		FieldConverter.applyCollectionTypes(codeRepresentation, associationTypes);
		QualifiedNamesConverter.resolveQualifiedNames(codeRepresentation, qualifiedNames);
		return codeRepresentation;
	}
}
