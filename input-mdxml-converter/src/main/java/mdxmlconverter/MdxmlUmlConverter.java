package mdxmlconverter;

import core.representation.Node;
import mdxml.MdxmlRepresentation;
import mdxml.Model;
import mdxml.PackagedElement;
import mdxmlconverter.element.DataTypeConverter;
import mdxmlconverter.element.ElementConverter;
import mdxmlconverter.packages.PackageConverter;
import mdxmlconverter.relationship.RelationshipConverter;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlElement;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationship;
import uml.converterinterface.UmlInputRepresentation;
import uml.converterinterface.UmlRepresentationConverter;

/**
 * Main class of the converter implementing the {@link uml.converterinterface.UmlRepresentationConverter} interface of the uml representation
 * 
 * @author dschoenicke
 *
 */
public class MdxmlUmlConverter implements UmlRepresentationConverter {

	/**
	 * The {@link mdxml.MdxmlRepresentation} which should be converted
	 */
	private MdxmlRepresentation mdxmlRepresentation;
 	
	/**
	 * Constructor, expecting a {@link mdxml.MdxmlRepresentation} which will be converted
	 * 
	 * @param mdxmlRepresentation the {@link mdxml.MdxmlRepresentation} to be converted
	 */
	public MdxmlUmlConverter(MdxmlRepresentation mdxmlRepresentation) {
		this.mdxmlRepresentation = mdxmlRepresentation;
	}

	@Override
	public UmlModel convertToUmlRepresentation(UmlInputRepresentation inputRepresentation) {
		Model xmlModel = mdxmlRepresentation.getXmi().getModel();
		TemporaryModel tmpModel = new TemporaryModel();
		UmlModel umlModel = new UmlModel(xmlModel.getName());
		
		for (Node node : xmlModel.getPackagedElements()) {
			if (node instanceof PackagedElement) {
				convertPackagedElement((PackagedElement) node, tmpModel, umlModel);
			}
		}
		
		resolveDataTypeReferences(tmpModel);
		return umlModel;
	}
	
	/**
	 * Static method to delegate the conversion of a given {@link PackagedElement} to the corresponding converter
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} to convert
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to add the converted element to
	 * @param parent the parent {@link core.representation.Node} where the converted element should be added to
	 */
	private void convertPackagedElement(PackagedElement packagedElement, TemporaryModel tmpModel, Node parent) {
		switch (packagedElement.getType()) {
			case "uml:Package": {
				UmlPackage umlPackage = PackageConverter.convertPackage(packagedElement);
				
				for (PackagedElement childElement : packagedElement.getPackagedElements()) {
					convertPackagedElement(childElement, tmpModel, umlPackage);
				}
				
				if (parent instanceof UmlModel) {
					((UmlModel) parent).addPackage(umlPackage);
				}
				else if (parent instanceof UmlPackage) {
					((UmlPackage) parent).addPackage(umlPackage);
				}
				
				break;
			}
			case "uml:Class": 
			case "uml:Interface":
			case "uml:Enumeration": {
				UmlElement element = ElementConverter.convertElement(packagedElement, tmpModel, parent);
				
				if (parent instanceof UmlModel) {
					((UmlModel) parent).addElement(element);
				}
				else if (parent instanceof UmlPackage) {
					((UmlPackage) parent).addElement(element);
				}
				
				break;
			}
			case "uml:Association":
			case "uml:Usage": {
				UmlRelationship relationship = RelationshipConverter.convertRelationship(packagedElement, tmpModel);
			
				if (parent instanceof UmlModel) {
					((UmlModel) parent).addRelationship(relationship);
				}
				else if (parent instanceof UmlPackage) {
					((UmlPackage) parent).addRelationship(relationship);
				}
				
				break;
			}
		}
	}
	
	/**
	 * Auxiliary method to resolve references to {@link uml.UmlElement} to their name in {@link uml.UmlAttribute}- and {@link uml.UmlParameter} types
	 *  
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} containing the mappings from ids to their respective elements
	 */
	private void resolveDataTypeReferences(TemporaryModel tmpModel) {
		tmpModel.getRelationships().forEach((relationship) -> {
			if (relationship instanceof TemporaryRelationship) {
				RelationshipConverter.convertTemporaryRelationship((TemporaryRelationship)relationship, tmpModel);
			}
		});
		
		tmpModel.getAttributeIDs().forEach((attributeID, attribute) -> {
			attribute.setType(DataTypeConverter.convertElementID(attribute.getType(), tmpModel));
		});
		
		tmpModel.getParameters().forEach((parameter) -> {
			parameter.setType(DataTypeConverter.convertElementID(parameter.getType(), tmpModel));
		});
	}
}
