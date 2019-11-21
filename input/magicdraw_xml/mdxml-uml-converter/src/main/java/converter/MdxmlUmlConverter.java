package converter;

import converter.diagram.DiagramConverter;
import converter.diagram.PackageConverter;
import converter.element.DataTypeConverter;
import converter.element.ElementConverter;
import converter.relationship.RelationshipConverter;
import converter.temporary.TemporaryDiagram;
import converter.temporary.TemporaryModel;
import mdxml.MdxmlRepresentation;
import model.Model;
import model.UmlAttribute;
import model.UmlDiagram;
import model.UmlModel;
import model.UmlOperation;
import model.UmlParameter;

public class MdxmlUmlConverter implements UmlRepresentationConverter {

	private MdxmlRepresentation mdxmlRepresentation;
 	
	public MdxmlUmlConverter(MdxmlRepresentation mdxmlRepresentation) {
		this.mdxmlRepresentation = mdxmlRepresentation;
	}

	@Override
	public UmlModel convertToUmlRepresentation(UmlInputRepresentation inputRepresentation) {
		Model xmlModel = mdxmlRepresentation.getXmi().getModel();
		TemporaryModel tmpModel = new TemporaryModel(xmlModel.getName());
		
		ElementConverter.convertElements(xmlModel.getPackagedElements(), tmpModel);
		RelationshipConverter.convertRelationships(xmlModel.getPackagedElements(), tmpModel);
		PackageConverter.convertPackages(xmlModel, tmpModel);
		DiagramConverter.convertDiagrams(xmlModel, tmpModel);
		
		return convertTemporaryToUmlModel(xmlModel, tmpModel);
	}
	
	private UmlModel convertTemporaryToUmlModel(Model xmlModel, TemporaryModel tmpModel) {
		UmlModel umlModel = new UmlModel(tmpModel.getName());
		tmpModel.getElementIDs().forEach((elementID, element) -> {
			for (UmlAttribute attribute : element.getAttributes()) {
				attribute.setType(DataTypeConverter.convertElementID(attribute.getType(), tmpModel));
			}
			
			for (UmlOperation operation : element.getOperations()) {
				for (UmlParameter parameter : operation.getParameters()) {
					parameter.setType(DataTypeConverter.convertElementID(parameter.getType(), tmpModel));
				}
			}
		});
		
		for (TemporaryDiagram tmpDiagram : tmpModel.getTemporaryDiagrams()) {
			UmlDiagram diagram = new UmlDiagram(tmpDiagram.getName());
			
			for (String usedElement : tmpDiagram.getUsedElements()) {
				if (tmpModel.getPackageIDs().containsKey(usedElement)) {
					diagram.addPackage(tmpModel.getPackageIDs().get(usedElement));
				}
				else if (tmpModel.getElementIDs().containsKey(usedElement)) {
					diagram.addElement(tmpModel.getElementIDs().get(usedElement));
				}
				else if (tmpModel.getRelationshipIDs().containsKey(usedElement)) {
					diagram.addRelationship(tmpModel.getRelationshipIDs().get(usedElement));
				}
			}
			
			umlModel.addDiagram(diagram);
		}
		
		return umlModel;
	}
}
