package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClientTest extends MdxmlRepresentationTests {

	@Test
	public void testClient() {
		Client client = mdxmlTopLevelClass.getInterfaceRealizations().get(0).getClient();
		assertNotNull(client);
		assertEquals(client.getIdref(), mdxmlTopLevelClass.getId());
	}
}
