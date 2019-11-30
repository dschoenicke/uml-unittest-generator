package umlcodeconverter;

import static org.junit.Assert.assertFalse;

import code.CodeRepresentation;
import uml.UmlModel;
import umlcodeconverter.element.ElementConverter;
import umlcodeconverter.element.TemplateBindingConverter;
import umlcodeconverter.packages.PackageConverter;
import umlcodeconverter.relationship.RelationshipConverter;
import umlcodeconverter.temporary.TemporaryModel;

/**
 * Main class of the converter 
 * 
 * @author dschoenicke
 *
 */
public class UmlCodeConverter 
{
    
	/**
	 * Default constructor
	 */
	public UmlCodeConverter() {}
	
	/**
	 * Converts a given {@link uml.UmlModel} to a {@link code.CodeRepresentation}.<br>
	 * Delegates the conversion of {@link uml.UmlPackage}s to the {@link umlcodeconverter.packages.PackageConverter}<br>
	 * Delegates the conversion of {@link uml.UmlElement}s to the {@link umlcodeconverter.element.ElementConverter}<br>
	 * Delegates the definite conversion of {@link uml.UmlTemplateBinding}s to the {@link umlcodeconverter.element.TemplateBindingConverter}<br>
	 * Delegates the conversion of {@link uml.UmlRelationship} to the {@link umlcodeconverter.relationship.RelationshipConverter}
	 * 
	 * @param umlModel the {@link uml.UmlModel} to be converted
	 * @return the converted {@link code.CodeRepresentation}
	 */
	public CodeRepresentation convertUmlToCodeRepresentation(UmlModel umlModel) {
		CodeRepresentation codeRepresentation =  new CodeRepresentation(umlModel.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		
		if (!umlModel.getElements().isEmpty()) {
			umlModel.getPackagesAsList().forEach((umlPackage) -> {
				assertFalse("Could not convert UmlModel " + umlModel.getName() + "!\n"
						+ "UmlModel " + umlModel.getName() + " contains a package with the model name\n"
						+ "while containing UmlElements, which are not assigned to a UmlPackage.\n"
						+ "For these elements, a CodePackage with the name of the model would be created,\n"
						+ "which would be a duplicate.",
						umlPackage.getName().equals(umlModel.getName()));
			});
		}
		
		PackageConverter.convertPackages(umlModel.getPackages(), codeRepresentation, tmpModel);
		ElementConverter.convertElements(umlModel, codeRepresentation, tmpModel);
		TemplateBindingConverter.finishTemplateBindingConversions(tmpModel);
		RelationshipConverter.convertRelationships(umlModel.getRelationshipsAsList(), tmpModel);
		return codeRepresentation;
	}
}
