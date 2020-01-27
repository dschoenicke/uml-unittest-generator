package inputmdxml.converter.element;

import static org.junit.Assert.assertNotNull;

import inputmdxml.converter.relationship.GeneralizationConverter;
import inputmdxml.converter.relationship.InterfaceRealizationConverter;
import inputmdxml.temporary.TemporaryModel;
import lombok.experimental.UtilityClass;
import mdxml.PackagedElement;
import uml.UmlClass;
import uml.UmlElement;
import uml.UmlEnumeration;
import uml.UmlInterface;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;

/**
 * Class providing a static method to convert {@link mdxml.PackagedElement} to an {@link uml.UmlElement}
 * 
 * @author dschoenicke
 *
 */
@UtilityClass
public class ElementConverter {
	
	/**
	 * Static method to convert a given {@link mdxml.PackagedElement} with the type 'uml:Class', 'uml:Interface' or 'uml:Enumeration' to an {@link UmlElement}, which will be added to the {@link inputmdxml.temporary.TemporaryModel}
	 * Delegates the conversion of {@link mdxml.Generalization}s and {@link mdxml.InterfaceRealization}s to the corresponding {@link inputmdxml.converter.relationship.GeneralizationConverter} or {@link inputmdxml.converter.relationship.InterfaceRealizationConverter}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param tmpModel the {@link inputmdxml.temporary.TemporaryModel} to add the converted element to
	 * @param parent the parent {@link uml.UmlParent} to add the converted {@link uml.UmlElement} to
	 * @return the converted {@link uml.UmlElement}
	 */
	public static UmlElement convertElement(PackagedElement packagedElement, TemporaryModel tmpModel, UmlParent parent) {
		assertNotNull(packagedElement.getId(), "The name of a PackagedElement must not be null!\nOccurance in PackagedElement with id " + packagedElement.getName());
		UmlElement element = instantiateUmlElement(packagedElement);
		
		if (element != null) {
			if (element instanceof UmlEnumeration) {
				LiteralConverter.convertLiterals(packagedElement, element);
			}
			
			AttributeConverter.convertAttributes(packagedElement, element, tmpModel);
			OperationConverter.convertOperations(packagedElement, element, tmpModel);
			TemplateParameterConverter.convertTemplateParameters(packagedElement.getOwnedTemplateSignature(), element, tmpModel);
			TemplateBindingConverter.convertTemplateBindings(packagedElement.getTemplateBindings(), element);
			NestedElementConverter.convertNestedElements(packagedElement, element, parent, tmpModel);
			GeneralizationConverter.convertNestedGeneralizations(packagedElement, tmpModel, parent);
			InterfaceRealizationConverter.convertInterfaceRealizations(packagedElement.getInterfaceRealizations(), tmpModel, parent);
			
			if (packagedElement.getGeneralization() != null) {
				GeneralizationConverter.convertGeneralization(packagedElement, tmpModel, parent);
			}
			
			if (parent instanceof UmlModel) {
				((UmlModel) parent).addElement(element);
			}
			else {
				((UmlPackage) parent).addElement(element);
			}
			
			tmpModel.addElement(packagedElement.getId(), element);
		}
		
		return element;
	}
	
	/**
	 * Instantiates an {@link uml.UmlElement} out of the given {@link mdxml.PackagedElement}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to be converted
	 * @return the instantiated {@link uml.UmlElement}
	 */
	static UmlElement instantiateUmlElement(PackagedElement packagedElement) {
			switch (packagedElement.getType()) {
			case "uml:Class": return new UmlClass(packagedElement.getName(), 
						ModifierConverter.convertAccessModifier(packagedElement.getVisibility()), 
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsStatic()),
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsFinal()),
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsAbstract()));
			case "uml:Interface": return new UmlInterface(packagedElement.getName(), 
						ModifierConverter.convertAccessModifier(packagedElement.getVisibility()), 
						ModifierConverter.convertNonAccessModifier(packagedElement.getIsAbstract()));
			case "uml:Enumeration": return new UmlEnumeration(packagedElement.getName(), 
						ModifierConverter.convertAccessModifier(packagedElement.getVisibility()));
			default: return null;
		}
	}
}
