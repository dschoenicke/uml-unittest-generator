package mdxmlconverter.relationship;

import java.util.ArrayList;

import core.representation.Node;
import mdxml.InterfaceRealization;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlRelationshipType;

/**
 * Class providing static methods to convert {@link mdxml.InterfaceRealization}s to {@link mdxmlconverter.temporary.TemporaryRelationship}s with type {@link uml.UmlRelationshipType#INTERFACEREALIZATION}
 * 
 * @author dschoenicke
 *
 */
public class InterfaceRealizationConverter {

	/**
	 * Static method converting the {@link mdxml.InterfaceRealization}s of a {@link mdxml.PackagedElement} to a {@link mdxmlconverter.temporary.TemporaryRelationship} with references to the contract and the element itself
	 * 
	 * @param realizations the list of {@link mdxml.InterfaceRealization}s which should be converted
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship} should be added
	 * @param parentNode the {@link core.representation.Node} representing the {uml.UmlModel} or {@link uml.UmlPackage} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship} should be added
	 */
	public static void convertInterfaceRealizations(ArrayList<InterfaceRealization> realizations, TemporaryModel tmpModel, Node parentNode) {
		for (InterfaceRealization realization : realizations) {
			TemporaryRelationship tmpRelationship = new TemporaryRelationship(realization.getClient().getIdref(),
					realization.getContract(),
					UmlRelationshipType.INTERFACEREALIZATION);
			
			tmpModel.addRelationship(tmpRelationship);
			
			if (parentNode instanceof UmlModel) {
				((UmlModel) parentNode).addRelationship(tmpRelationship);
			}
			else if (parentNode instanceof UmlPackage) {
				((UmlPackage) parentNode).addRelationship(tmpRelationship);
			}
		}
	}
	
	/**
	 * Static method converting the {@link mdxml.InterfaceRealization}s of nested elements of a given {@link mdxml.PackagedElement} to {@link mdxmlconverter.temporary.TemporaryRelationship}s with references to the contract and the element itself
	 * 
	 * @param packagedElement the {@link mdxml.PackagedElement} containing the nested elements which {@link mdxml.InterfaceRealization}s should be converted
	 * @param tmpModel the {@link mdxmlconverter.temporary.TemporaryModel} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship}s should be added
	 * @param parentNode the {@link core.representation.Node} representing the {uml.UmlModel} or {@link uml.UmlPackage} to which the converted {@link mdxmlconverter.temporary.TemporaryRelationship}s should be added
	 */
	public static void convertNestedInterfaceRealizations(PackagedElement packagedElement, TemporaryModel tmpModel, Node parentNode) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (!innerElement.getInterfaceRealizations().isEmpty()) {
				convertInterfaceRealizations(innerElement.getInterfaceRealizations(), tmpModel, parentNode);
			}
		}
	}
}
