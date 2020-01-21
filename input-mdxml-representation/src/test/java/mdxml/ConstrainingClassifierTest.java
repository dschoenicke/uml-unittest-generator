package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ConstrainingClassifierTest extends MdxmlRepresentationTests {

	@Test
	public void testFirstConstrainingClassifier() {
		ConstrainingClassifier classifier = mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(0).getConstrainingClassifier();
		assertNotNull(classifier);
		assertEquals(classifier.getIdref(), mdxmlTopLevelClass.getId());
		assertNull(classifier.getExtension());
	}
	
	@Test
	public void testSecondConstrainingClassifier() {
		ConstrainingClassifier classifier = mdxmlGenericClass.getOwnedTemplateSignature().getOwnedParameters().get(1).getConstrainingClassifier();
		assertNotNull(classifier);
		assertNotNull(classifier.getExtension());
		assertNull(classifier.getIdref());
	}
}
