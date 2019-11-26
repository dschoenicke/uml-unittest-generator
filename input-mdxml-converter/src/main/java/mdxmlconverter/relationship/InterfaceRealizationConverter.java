package mdxmlconverter.relationship;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import mdxml.InterfaceRealization;
import mdxml.PackagedElement;
import mdxmlconverter.temporary.TemporaryModel;
import mdxmlconverter.temporary.TemporaryRelationship;
import uml.UmlModel;
import uml.UmlPackage;
import uml.UmlParent;
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
	public static void convertInterfaceRealizations(ArrayList<InterfaceRealization> realizations, TemporaryModel tmpModel, UmlParent parent) {
		for (InterfaceRealization realization : realizations) {
			assertNotNull("The client of an interfaceRealization must not be null!\nOccurance in interfaceRealization " + realization.getId());
			assertNotNull("The contract of an interfaceRealization must not be null!\nOccurance in interfaceRealization " + realization.getId());
			
			TemporaryRelationship tmpRelationship = new TemporaryRelationship(realization.getClient().getIdref(),
					realization.getContract(),
					UmlRelationshipType.INTERFACEREALIZATION);
			
			tmpModel.addRelationship(tmpRelationship);
			
			if (parent instanceof UmlModel) {
				((UmlModel) parent).addRelationship(tmpRelationship);
			}
			else if (parent instanceof UmlPackage) {
				((UmlPackage) parent).addRelationship(tmpRelationship);
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
	public static void convertNestedInterfaceRealizations(PackagedElement packagedElement, TemporaryModel tmpModel, UmlParent parent) {
		for (PackagedElement innerElement : packagedElement.getNestedClassifiers()) {
			if (!innerElement.getInterfaceRealizations().isEmpty()) {
				convertInterfaceRealizations(innerElement.getInterfaceRealizations(), tmpModel, parent);
			}
		}
	}
}
