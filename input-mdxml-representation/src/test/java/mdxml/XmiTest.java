package mdxml;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class XmiTest extends MdxmlRepresentationTests {

	@Test
	public void testXmi() {
		Xmi xmi = mdxmlRepresentation.getXmi();
		assertNotNull(xmi);
		assertNotNull(xmi.getModel());
	}
}
