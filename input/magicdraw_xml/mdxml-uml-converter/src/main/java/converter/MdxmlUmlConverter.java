package converter;

import converter.diagram.DiagramConverter;
import converter.diagram.PackageConverter;
import converter.element.ElementConverter;
import converter.relationship.RelationshipConverter;
import converter.temporary.TemporaryDiagram;
import converter.temporary.TemporaryModel;
import mdxml.MdxmlRepresentation;
import model.Model;
import model.UmlDiagram;
import model.UmlModel;

public class MdxmlUmlConverter implements UmlRepresentationConverter {

	private MdxmlRepresentation mdxmlRepresentation;
 	
	public MdxmlUmlConverter(MdxmlRepresentation mdxmlRepresentation) {
		this.mdxmlRepresentation = mdxmlRepresentation;
	}

	@Override
	public UmlModel convertToUmlRepresentation(UmlInputRepresentation inputRepresentation) {
		Model xmlModel = mdxmlRepresentation.getXmi().getModel();
		TemporaryModel tmpModel = new TemporaryModel(xmlModel.getName());
		
		PackageConverter.convertPackages(xmlModel, tmpModel);
		DiagramConverter.convertDiagrams(xmlModel, tmpModel);
		ElementConverter.convertElements(xmlModel.getPackagedElements(), tmpModel);
		RelationshipConverter.convertRelationships(xmlModel, tmpModel);
		
		return convertTemporaryToUmlModel(tmpModel);
	}
	
	private UmlModel convertTemporaryToUmlModel(TemporaryModel tmpModel) {
		UmlModel umlModel = new UmlModel(tmpModel.getName());
		
		for (TemporaryDiagram tmpDiagram : tmpModel.getTemporaryDiagrams()) {
			UmlDiagram diagram = new UmlDiagram(tmpDiagram.getName());
			
			for (String elementID : tmpDiagram.getUsedElements()) {
				diagram.addElement(tmpModel.getElementIDs().get(elementID));
			}
			
			umlModel.addDiagram(diagram);
		}
		
		return umlModel;
	}
}
