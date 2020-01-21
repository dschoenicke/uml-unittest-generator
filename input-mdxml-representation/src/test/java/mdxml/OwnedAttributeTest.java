package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit tests validating the correct parsing of {@link mdxml.OwnedAttribute}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedAttributeTest extends MdxmlRepresentationTests {
	
	@Test
	public void testOwnedAttributes() {
		OwnedAttribute ownedAttribute = mdxmlSubClass.getOwnedAttributes().get(0);
		assertNotNull(ownedAttribute);
		assertEquals("_19_0_1_62d0212_1574772163299_852189_4738", ownedAttribute.getId());
		assertEquals("testString", ownedAttribute.getName());
		assertEquals("private", ownedAttribute.getVisibility());
		assertNotNull(ownedAttribute.getDataType());
		assertNotNull(ownedAttribute.getLowerValue());
		assertEquals(1, ownedAttribute.getExtensions().size());
		
		ownedAttribute = mdxmlGenericClass.getOwnedAttributes().get(0);
		assertNotNull(ownedAttribute);
		assertNull(ownedAttribute.getDataType());
		assertEquals(mdxmlSubPackageClass.getId(), ownedAttribute.getAssociationType());
		assertEquals("shared", ownedAttribute.getAggregation());
		assertNotNull(ownedAttribute.getUpperValue());
		assertEquals(1, ownedAttribute.getExtensions().size());
	}
}
