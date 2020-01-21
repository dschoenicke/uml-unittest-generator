package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GeneralizationTest extends MdxmlRepresentationTests {

	@Test
	public void testGeneralization() {
		Generalization generalization = mdxmlSubClass.getGeneralization();
		assertNotNull(generalization);
		assertEquals("_19_0_1_62d0212_1574772156452_799567_4737", generalization.getId());
		assertEquals(mdxmlTopLevelClass.getId(), generalization.getGeneral());
	}
}
