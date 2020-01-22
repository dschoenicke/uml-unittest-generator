package mdxmlconverter;

import static org.junit.Assert.assertNotNull;

import javax.xml.bind.JAXBException;

import lombok.NoArgsConstructor;
import mdxml.MdxmlRepresentation;
import mdxml.Model;
import mdxml.PackagedElement;
import mdxmlconverter.element.DataTypeConverter;
import mdxmlconverter.element.ElementConverter;
import mdxmlconverter.packages.PackageConverter;
import mdxmlconverter.relationship.RelationshipConverter;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlModel;
import uml.UmlParent;
import uml.converterinterface.UmlRepresentationConverter;

/**
 * Main class of the converter implementing the {@link uml.converterinterface.UmlRepresentationConverter} interface of the uml representation
 * 
 * @author dschoenicke
 *
 */
@NoArgsConstructor
public class MdxmlUmlConverter implements UmlRepresentationConverter {
	
	@Override
	public UmlModel convertToUmlRepresentation(String inputPath) throws JAXBException {
		MdxmlRepresentation mdxmlRepresentation = null;
		mdxmlRepresentation = new MdxmlRepresentation(inputPath);
		assertNotNull("The XMI of the MdxmlRepresentation must not be null!", mdxmlRepresentation.getXmi());
		assertNotNull("The Model of the MdxmlRepresentation must not be null!", mdxmlRepresentation.getXmi().getModel());
		
		Model xmlModel = mdxmlRepresentation.getXmi().getModel();
		assertNotNull("The name of the mdxml.Model must not be null!", xmlModel.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		UmlModel umlModel = new UmlModel(xmlModel.getName());
		
		for (PackagedElement packagedElement : xmlModel.getPackagedElements()) {
			convertPackagedElement(packagedElement, tmpModel, umlModel);
		}
		
		resolveDataTypeReferences(tmpModel);
		return umlModel;
	}
	
	/**
	 * Static method to delegate the conversion of a given {@link PackagedElement} to the corresponding converter
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to add the converted element to
	 * @param parent the parent {@link uml.UmlParent} where the converted element should be added to
	 */
	public static void convertPackagedElement(PackagedElement packagedElement, TemporaryModel tmpModel, UmlParent parent) {
		assertNotNull("The id of a PackagedElement must not be null!", packagedElement.getId());
		assertNotNull("The xmi:type of a PackagedElement must not be null!\nOccurance in PackagedElement with id " + packagedElement.getType(), packagedElement.getId());
		
		switch (packagedElement.getType()) {
			case "uml:Package":
				PackageConverter.convertPackage(packagedElement, parent, tmpModel);
				break;
		
			case "uml:Class": 
			case "uml:Interface":
			case "uml:Enumeration":
				ElementConverter.convertElement(packagedElement, tmpModel, parent);
				break;

			case "uml:Association":
			case "uml:Usage":
				RelationshipConverter.convertRelationship(packagedElement, parent, tmpModel);
				break;
			
			default: 
				throw new IllegalStateException(parent.getName() + " is not a valid parent element for a relationship! Occurance: packagedElement with id: " + packagedElement.getId());
		}
	}
	
	/**
	 * Auxiliary method to resolve references to {@link uml.UmlElement} to their name in {@link uml.UmlAttribute}-, {@link uml.UmlTemplateParameter}- and {@link uml.UmlParameter} types
	 *  
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} containing the mappings from ids to their respective elements
	 */
	void resolveDataTypeReferences(TemporaryModel tmpModel) {
		tmpModel.getRelationships().forEach(relationship -> {
			if (relationship instanceof TemporaryRelationship) {
				RelationshipConverter.convertTemporaryRelationship((TemporaryRelationship)relationship, tmpModel);
			}
		});
		
		tmpModel.getAttributeIDs().forEach((attributeID, attribute) -> 
			attribute.setType(DataTypeConverter.convertElementID(attribute.getType(), tmpModel))
		);
		
		tmpModel.getParameters().forEach(parameter -> 
			parameter.setType(DataTypeConverter.convertElementID(parameter.getType(), tmpModel))
		);
		
		tmpModel.getTemplateParameterIDs().forEach((parameterid, templateParameter) -> 
			templateParameter.setType(DataTypeConverter.convertElementID(templateParameter.getType(), tmpModel))
		);
	}
}
