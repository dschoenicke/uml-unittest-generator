package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests validating the correct parsing of {@link mdxml.PackagedElement}s
 * 
 * @author dschoenicke
 *
 */
public class PackagedElementTest extends MdxmlRepresentationTests {

	@Test
	public void testPackagedElements() {
		assertNotNull(mdxmlTopLevelPackage);
		assertEquals("_19_0_1_62d0212_1574772109161_216184_4696", mdxmlTopLevelPackage.getId());
		assertEquals("TopLevelPackage", mdxmlTopLevelPackage.getName());
		assertEquals("uml:Package", mdxmlTopLevelPackage.getType());
		assertEquals(8, mdxmlTopLevelPackage.getPackagedElements().size());
		
		assertNotNull(mdxmlSubPackageClass);
		assertEquals(mdxmlEnumeration, mdxmlSubPackageClass.getNestedClassifiers().get(0));
		
		assertNotNull(mdxmlSubPackageClassAssociation);
		assertEquals("uml:Association", mdxmlSubPackageClassAssociation.getType());
		assertEquals(2, mdxmlSubPackageClassAssociation.getMemberEnds().size());
		assertNotNull(mdxmlSubPackageClassAssociation.getOwnedEnd());
	}
}
