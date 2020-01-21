package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OwnedEndTest extends MdxmlRepresentationTests {

	@Test
	public void testOwnedEnds() {
		OwnedEnd ownedEnd = mdxmlSubPackageClassAssociation.getOwnedEnd();
		assertNotNull(ownedEnd);
		assertEquals(mdxmlSubPackageClassAssociation.getId(), ownedEnd.getAssociation());
		assertEquals(mdxmlGenericClass.getId(), ownedEnd.getAssociationType());
		assertEquals(mdxmlSubPackageClassAssociation.getMemberEnds().get(1).getIdref(), ownedEnd.getId());
		assertEquals("uml:Property", ownedEnd.getEndType());
		assertEquals("private", ownedEnd.getVisibility());
	}
}
