package umlcodeconverter;

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
	
	public CodeRepresentation convertUmlToCodeRepresentation(UmlModel umlModel) {
		CodeRepresentation codeRepresentation =  new CodeRepresentation(umlModel.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		
		PackageConverter.convertPackages(umlModel.getPackages(), codeRepresentation);
		ElementConverter.convertElements(umlModel.getElements(), codeRepresentation, tmpModel);
		TemplateBindingConverter.finishTemplateBindingConversions(tmpModel);
		RelationshipConverter.convertRelationships(umlModel.getRelationshipsAsList(), tmpModel);
		return codeRepresentation;
	}
}
