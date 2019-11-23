package mdxmlconverter.relationship;

import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlRelationshipType;

/**
 * Class providing a static method to convert a {@link mdxml.PackagedElement} to a {@link mdxmlconverter.temporary.TemporaryRelationship} with type {@link uml.UmlRelationshipType#DEPENDENCY}
 * 
 * @author dschoenicke
 *
 */
public class DependencyConverter {

	/**
	 * Static method converting a given {@link mdxml.PackagedElement} with type 'uml:Usage' to a {@link mdxmlconverter.temporary.TemporaryRelationship} with references to the client and supplier and with type {@link uml.UmlRelationshipType#DEPENDENCY}
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} which should be converted
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship} should be added
	 * @return the converted {@link mdxmlconverter.temporary.TemporaryRelationship}
	 */
	public static TemporaryRelationship convertDependency(PackagedElement packagedElement, TemporaryModel tmpModel) {
		TemporaryRelationship dependency = new TemporaryRelationship();
		dependency.setClientId(packagedElement.getClient().getIdref());
		dependency.setSupplierId(packagedElement.getSupplier().getIdref());
		dependency.setType(UmlRelationshipType.DEPENDENCY);
		tmpModel.addRelationship(dependency);
		return dependency;
	}
}
