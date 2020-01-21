package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class InterfaceRealizationTest extends MdxmlRepresentationTests {

	@Test
	public void testInterfaceRealization() {
		InterfaceRealization interfaceRealization = mdxmlTopLevelClass.getInterfaceRealizations().get(0);
		assertNotNull(interfaceRealization);
		assertEquals("_19_0_1_62d0212_1574772094037_401288_4693", interfaceRealization.getId());
		assertEquals(mdxmlTopLevelInterface.getId(), interfaceRealization.getContract());
		assertNotNull(interfaceRealization.getClient());
		assertNotNull(interfaceRealization.getSupplier());
	}
}
