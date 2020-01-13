package umlcodeconverter;

import static org.junit.Assert.assertFalse;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

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
	
	/**
	 * Converts a given {@link uml.UmlModel} to a {@link code.CodeRepresentation}.<br>
	 * Delegates the conversion of {@link uml.UmlPackage}s to the {@link umlcodeconverter.packages.PackageConverter}<br>
	 * Delegates the conversion of {@link uml.UmlElement}s to the {@link umlcodeconverter.element.ElementConverter}<br>
	 * Delegates the definite conversion of {@link uml.UmlTemplateBinding}s to the {@link umlcodeconverter.element.TemplateBindingConverter}<br>
	 * Delegates the conversion of {@link uml.UmlRelationship} to the {@link umlcodeconverter.relationship.RelationshipConverter}
	 * 
	 * @param umlModel the {@link uml.UmlModel} to be converted
	 * @return the converted {@link code.CodeRepresentation}
	 */
	public CodeRepresentation convertUmlToCodeRepresentation(UmlModel umlModel) {
		CodeRepresentation codeRepresentation =  new CodeRepresentation(umlModel.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		
		if (!umlModel.getElements().isEmpty()) {
			umlModel.getPackagesAsList().forEach((umlPackage) -> {
				assertFalse("Could not convert UmlModel " + umlModel.getName() + "!\n"
						+ "UmlModel " + umlModel.getName() + " contains a package with the model name\n"
						+ "while containing UmlElements, which are not assigned to a UmlPackage.\n"
						+ "For these elements, a CodePackage with the name of the model would be created,\n"
						+ "which would be a duplicate.",
						umlPackage.getName().equals(umlModel.getName()));
			});
		}
		
		PackageConverter.convertPackages(umlModel.getPackages(), codeRepresentation, tmpModel);
		ElementConverter.convertElements(umlModel, codeRepresentation, tmpModel);
		TemplateBindingConverter.finishTemplateBindingConversions(tmpModel);
		RelationshipConverter.convertRelationships(umlModel.getRelationshipsAsList(), tmpModel);
		return codeRepresentation;
	}
	
	/**
	 * Converts a given {@link uml.UmlModel} to a {@link code.CodeRepresentation}.<br>
	 * Resolves fully qualified names with the mappings of the given MapDB database.<br>
	 * Resolves association attribute data types with given collection types out of the given MapDB database.<br>
	 * 
	 * Delegates the conversion of {@link uml.UmlPackage}s to the {@link umlcodeconverter.packages.PackageConverter}<br>
	 * Delegates the conversion of {@link uml.UmlElement}s to the {@link umlcodeconverter.element.ElementConverter}<br>
	 * Delegates the definite conversion of {@link uml.UmlTemplateBinding}s to the {@link umlcodeconverter.element.TemplateBindingConverter}<br>
	 * Delegates the conversion of {@link uml.UmlRelationship} to the {@link umlcodeconverter.relationship.RelationshipConverter}
	 * 
	 * @param umlModel the {@link uml.UmlModel} to be converted
	 * @param dbPath the path to the MapDB database containing the mappings to resolve the fully qualified names and association attribute collection types
	 * @return the converted {@link code.CodeRepresentation}
	 */
	public CodeRepresentation convertUmlToCodeRepresentation(UmlModel umlModel, String dbPath) {
		DB database = DBMaker.fileDB(dbPath).make();
		
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		
		umlModel.getElementsAsList().forEach(umlElement -> {
			if (qualifiedNames.containsKey(umlElement.getName())) {
				umlElement.setName(qualifiedNames.get(umlElement.getName()));
			}
			
			umlElement.getAttributes().forEach(umlAttribute -> {
				if (qualifiedNames.containsKey(umlAttribute.getType())) {
					umlAttribute.setType(qualifiedNames.get(umlAttribute.getType()));
				}
				
				if (associationTypes.containsKey(umlElement.getName() + "." + umlAttribute.getName())) {
					umlAttribute.setType(associationTypes.get(umlElement.getName() + "." + umlAttribute.getName()) + "<" + umlAttribute.getType() + ">");
				}
			});
			
			umlElement.getTemplateParameters().forEach(umlTemplateParameter -> {
				if (qualifiedNames.containsKey(umlTemplateParameter.getType())) {
					umlTemplateParameter.setType(qualifiedNames.get(umlTemplateParameter.getType()));
				}
			});
			
			umlElement.getOperations().forEach(umlOperation -> {
				if (qualifiedNames.containsKey(umlOperation.getName())) {
					umlOperation.setName(qualifiedNames.get(umlOperation.getName()));
				}
				
				umlOperation.getParameters().forEach(umlParameter -> {
					if (qualifiedNames.containsKey(umlParameter.getType())) {
						umlParameter.setType(qualifiedNames.get(umlParameter.getType()));
					}
				});
			});
		});
		
		return convertUmlToCodeRepresentation(umlModel);
	}
}
