package converter.diagram;

import converter.temporary.TemporaryDiagram;
import converter.temporary.TemporaryModel;
import model.Model;
import model.OwnedDiagram;

/**
 * Class providing a static method to convert {@link model.OwnedDiagram}s to {@link converter.temporary.TemporaryDiagram}s with a list of used elements
 * 
 * @author dschoenicke
 *
 */
public class DiagramConverter {

	/**
	 * Converts {@link model.OwnedDiagram}s of a {@link model.Model} to {@link converter.temporary.TemporaryDiagram}s
	 * 
	 * @param xmlModel the {@link model.Model} containing all the {@link model.OwnedDiagram}s
	 * @param tmpModel the {@link converter.temporary.TemporaryModel} where the {@link converter.temporary.TemporaryDiagram}s are added to
	 */
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
