package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ModelTest extends MdxmlRepresentationTests {

	@Test
	public void testModel() {
		Model model = mdxmlRepresentation.getXmi().getModel();
		assertNotNull(model);
		assertEquals("eee_1045467100313_135436_1", model.getId());
		assertEquals("Model", model.getName());
		assertEquals(3, model.getPackagedElements().size());
	}
}
