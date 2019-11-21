package converter.diagram;

import converter.temporary.TemporaryDiagram;
import converter.temporary.TemporaryModel;
import model.Model;
import model.OwnedDiagram;

public class DiagramConverter {

	public static void convertDiagrams(Model xmlModel, TemporaryModel tmpModel) {
		for (OwnedDiagram diagram : xmlModel.getExtension().getModelExtension().getOwnedDiagrams()) {
			if (diagram.getExtension().getDiagramRepresentation().getDiagramRepresentationObject().getType().equals("Class Diagram")) {
				TemporaryDiagram tmpDiagram = new TemporaryDiagram(diagram.getName());
				tmpModel.addTemporaryDiagram(tmpDiagram);
				
				for (String elementid : diagram.getExtension().
						getDiagramRepresentation().
						getDiagramRepresentationObject().
						getDiagramContents().
						getUsedElements()) {
		
					tmpDiagram.addUsedElement(elementid);
				}
			}
		}
	}
}
