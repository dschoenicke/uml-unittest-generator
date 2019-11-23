package mdxmlconverter.element;

import core.representation.Node;
import mdxml.PackagedElement;
import mdxmlconverter.relationship.GeneralizationConverter;
import mdxmlconverter.relationship.InterfaceRealizationConverter;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;

/**
 * Class providing a static method to convert {@link mdxml.PackagedElement} to an {@link uml.UmlElement}
 * 
 * @author dschoenicke
 *
 */
public class ElementConverter {

	/**
	 * Static method to convert a given {@link mdxml.PackagedElement} with the type 'uml:Class', 'uml:Interface' or 'uml:Enumeration' to an {@link UmlElement}, which will be added to the {@link mdxmlconverter.temporary.TemporaryModel}
	 * Delegates the conversion of {@link mdxml.Generalization}s and {@link mdxml.InterfaceRealization}s to the corresponding {@link mdxmlconverter.relationship.GeneralizationConverter} or {@link mdxmlconverter.relationship.InterfaceRealizationConverter}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to add the converted element to
	 * @param parentNode the parent {@link core.representation.Node} to add the converted {@link uml.UmlElement} to
	 * @return the converted {@link uml.UmlElement}
	 */
	public static UmlElement convertElement(PackagedElement packagedElement, TemporaryModel tmpModel, Node parentNode) {
		UmlElement element = null;
		
		switch (packagedElement.getType()) {
			case "uml:Class": {
				element = new UmlClass(packagedElement.getName(), 
						VisibilityConverter.convertVisibility(packagedElement.getVisibility()), 
						ClassifierConverter.convertClassifier(packagedElement.getIsStatic()),
						ClassifierConverter.convertClassifier(packagedElement.getIsFinal()),
						ClassifierConverter.convertClassifier(packagedElement.getIsAbstract())
					);
				break;
			}
			case "uml:Interface": {
				element = new UmlInterface(packagedElement.getName(), 
						VisibilityConverter.convertVisibility(packagedElement.getVisibility()), 
						ClassifierConverter.convertClassifier(packagedElement.getIsAbstract())
					);
				break;
			}
			case "uml:Enumeration": {
				element = new UmlEnumeration(packagedElement.getName(), 
						VisibilityConverter.convertVisibility(packagedElement.getVisibility())
					);
				LiteralConverter.convertLiterals(packagedElement, element);
				break;
			}
			default: break;
		}
		
		if (element != null) {
			AttributeConverter.convertAttributes(packagedElement, element, tmpModel);
			OperationConverter.convertOperations(packagedElement, element, tmpModel);
			TemplateParameterConverter.convertTemplateParameters(packagedElement.getOwnedTemplateSignature(), element, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(packagedElement.getTemplateBindings(), element);
			InnerElementConverter.convertInnerElements(packagedElement, element, tmpModel, parentNode);
			GeneralizationConverter.convertInnerGeneralizations(packagedElement, tmpModel, parentNode);
			InterfaceRealizationConverter.convertInnerInterfaceRealizations(packagedElement, tmpModel, parentNode);
			
			if (packagedElement.getGeneralization() != null) {
				GeneralizationConverter.convertGeneralization(packagedElement, tmpModel, parentNode);
			}
			
			if (!packagedElement.getInterfaceRealizations().isEmpty()) {
				InterfaceRealizationConverter.convertInterfaceRealizations(packagedElement.getInterfaceRealizations(), tmpModel, parentNode);
			}
			
			tmpModel.addElement(packagedElement.getId(), element);
		}
		
		return element;
	}
}
