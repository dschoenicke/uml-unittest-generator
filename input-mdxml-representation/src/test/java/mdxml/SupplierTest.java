package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SupplierTest extends MdxmlRepresentationTests {

	@Test
	public void testSupplier() {
		Supplier supplier = mdxmlTopLevelClass.getInterfaceRealizations().get(0).getSupplier();
		assertNotNull(supplier);
		assertEquals(mdxmlTopLevelInterface.getId(), supplier.getIdref());
	}
}
