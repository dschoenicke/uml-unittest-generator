package mdxmlconverter.relationship;

import static org.junit.Assert.assertNotNull;

import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;
import uml.UmlRelationshipType;

/**
 * Class providing static methods to convert {@link mdxml.Generalization}s to {@link mdxmlconverter.temporary.TemporaryRelationship}s with type {@link uml.UmlRelationshipType#GENERALIZATION}
 * 
 * @author dschoenicke
 *
 */
public class GeneralizationConverter {

	/**
	 * Static method converting the {@link mdxml.Generalization} of a given {@link mdxml.PackagedElement} to a {@link mdxmlconverter.temporary.TemporaryRelationship} with references to the general and the element itself
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which {@link mdxml.Generalization} should be converted
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship} should be added
	 * @param parent the {@link core.representation.Node} representing the {uml.UmlModel} or {@link uml.UmlPackage} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship} should be added
	 */
	public static void convertGeneralization(PackagedElement packagedElement, TemporaryModel tmpModel, UmlParent parent) {
		assertNotNull("The general of a generalization must not be null!\nOccurance in packagedElement " + packagedElement.getName());
		TemporaryRelationship tmpRelationship = new TemporaryRelationship(packagedElement.getId(),
				packagedElement.getGeneralization().getGeneral(),
				UmlRelationshipType.GENERALIZATION);
		
		tmpModel.addRelationship(tmpRelationship);
	
		if (parent instanceof UmlModel) {
			((UmlModel) parent).addRelationship(tmpRelationship);
		}
		else if (parent instanceof UmlPackage) {
			((UmlPackage) parent).addRelationship(tmpRelationship);
		}
	}
	
	/**
	 * Static method converting the {@link mdxml.Generalization}s of nested elements of a given {@link mdxml.PackagedElement} to {@link mdxmlconverter.temporary.TemporaryRelationship}s with references to the general and the element itself
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} containing the nested elements which {@link mdxml.Generalization}s should be converted
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship}s should be added
	 * @param parent the {@link core.representation.Node} representing the {uml.UmlModel} or {@link uml.UmlPackage} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship}s should be added
	 */
	public static void convertNestedGeneralizations(PackagedElement packagedElement, TemporaryModel tmpModel, UmlParent parent) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (innerElement.getGeneralization() != null) {
				convertGeneralization(innerElement, tmpModel, parent);
			}
		}
	}
}
