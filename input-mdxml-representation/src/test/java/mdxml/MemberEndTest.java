package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MemberEndTest extends MdxmlRepresentationTests {

	@Test
	public void testMemberEnd() {
		MemberEnd memberEnd = mdxmlSubPackageClassAssociation.getMemberEnds().get(0);
		assertNotNull(memberEnd);
		assertEquals(mdxmlGenericClass.getOwnedAttributes().get(0).getId(), memberEnd.getIdref());
	}
}
