package umlcodeconverter;

import static org.junit.Assert.assertFalse;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import code.CodePackage;
import code.CodeRepresentation;
import lombok.NoArgsConstructor;
import uml.UmlModel;
import umlcodeconverter.element.ElementConverter;
import umlcodeconverter.element.FieldConverter;
import umlcodeconverter.element.QualifiedNamesConverter;
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
@NoArgsConstructor
public class UmlCodeConverter 
{	
	/**
	 * Converts a given {@link uml.UmlModel} to a {@link code.CodeRepresentation}.<br>
	 * Delegates the conversion of {@link uml.UmlPackage}s to the {@link umlcodeconverter.packages.PackageConverter}<br>
	 * Delegates the conversion of {@link uml.UmlElement}s to the {@link umlcodeconverter.element.ElementConverter}<br>
	 * Delegates the definite conversion of {@link uml.UmlTemplateBinding}s to the {@link umlcodeconverter.element.TemplateBindingConverter}<br>
	 * Delegates the conversion of {@link uml.UmlRelationship} to the {@link umlcodeconverter.relationship.RelationshipConverter}<br>
	 * Removes {@link code.CodeElement}s from the {@link code.CodeRepresentation} which names contain '&lt;' or '[' since they are considered to be representatives of generic types or arrays
	 * 
	 * @param umlModel the {@link uml.UmlModel} to be converted
	 * @return the converted {@link code.CodeRepresentation}
	 */
	public CodeRepresentation convertUmlToCodeRepresentation(UmlModel umlModel) {
		CodeRepresentation codeRepresentation =  new CodeRepresentation(umlModel.getName());
		TemporaryModel tmpModel = new TemporaryModel();
		
		if (!umlModel.getElements().isEmpty()) {
			umlModel.getPackagesAsList().forEach(umlPackage -> 
				assertFalse("Could not convert UmlModel " + umlModel.getName() + "!\n"
						+ "UmlModel " + umlModel.getName() + " contains a package with the model name\n"
						+ "while containing UmlElements, which are not assigned to a UmlPackage.\n"
						+ "For these elements, a CodePackage with the name of the model would be created,\n"
						+ "which would be a duplicate.",
						umlPackage.getName().equals(umlModel.getName()))
			);
		}
		
		PackageConverter.convertPackages(umlModel.getPackages(), codeRepresentation, tmpModel);
		ElementConverter.convertElements(umlModel, codeRepresentation, tmpModel);
		TemplateBindingConverter.finishTemplateBindingConversions(tmpModel);
		RelationshipConverter.convertRelationships(umlModel.getRelationshipsAsList(), tmpModel);
		codeRepresentation.getElementsAsList().forEach(codeElement -> {
			if (codeElement.getName().contains("<") || codeElement.getName().contains("[")) {
				((CodePackage) codeElement.getParent()).getElements().remove(codeElement);
			}
		});
		
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
		CodeRepresentation codeRepresentation = convertUmlToCodeRepresentation(umlModel);
		
		DB database = DBMaker.fileDB(dbPath).make();
		BTreeMap<String, String> qualifiedNames = database.treeMap("qualifiedNames")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		BTreeMap<String, String> associationTypes = database.treeMap("associationTypes")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		FieldConverter.applyCollectionTypes(codeRepresentation, associationTypes);
		QualifiedNamesConverter.resolveQualifiedNames(codeRepresentation, qualifiedNames);
		return codeRepresentation;
	}
}
