package mdxmlconverter.element;

import mdxml.PackagedElement;
import mdxmlconverter.relationship.GeneralizationConverter;
import mdxmlconverter.relationship.InterfaceRealizationConverter;
import mdxmlconverter.temporary.TemporaryModel;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlParent;

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
	public static UmlElement convertElement(PackagedElement packagedElement, TemporaryModel tmpModel, UmlParent parent) {
		UmlElement element = null;
		
		switch (packagedElement.getType()) {
			case "uml:Class": {
				element = new UmlClass(packagedElement.getName(), 
						ModifierConverter.convertAccessModifier(packagedElement.getVisibility()), 
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsStatic()),
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsFinal()),
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsAbstract())
					);
				break;
			}
			case "uml:Interface": {
				element = new UmlInterface(packagedElement.getName(), 
						ModifierConverter.convertAccessModifier(packagedElement.getVisibility()), 
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsAbstract())
					);
				break;
			}
			case "uml:Enumeration": {
				element = new UmlEnumeration(packagedElement.getName(), 
						ModifierConverter.convertAccessModifier(packagedElement.getVisibility())
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
			NestedElementConverter.convertNestedElements(packagedElement, element, tmpModel, parent);
			GeneralizationConverter.convertNestedGeneralizations(packagedElement, tmpModel, parent);
			InterfaceRealizationConverter.convertNestedInterfaceRealizations(packagedElement, tmpModel, parent);
			
			if (packagedElement.getGeneralization() != null) {
				GeneralizationConverter.convertGeneralization(packagedElement, tmpModel, parent);
			}
			
			if (!packagedElement.getInterfaceRealizations().isEmpty()) {
				InterfaceRealizationConverter.convertInterfaceRealizations(packagedElement.getInterfaceRealizations(), tmpModel, parent);
			}
			
			tmpModel.addElement(packagedElement.getId(), element);
		}
		
		return element;
	}
}
