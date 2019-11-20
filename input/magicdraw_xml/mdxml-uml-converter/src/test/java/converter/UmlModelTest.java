package converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UmlModelTest extends MdxmlUmlConverterTest {

	@Test
	public void ModelNameTest() {
		assertEquals(getUmlModel().getName(), "mdxml");
	}
}
