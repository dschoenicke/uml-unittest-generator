package mdxml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit tests validating the correct parsing of {@link mdxml.OwnedOperation}s
 * 
 * @author dschoenicke
 *
 */
public class OwnedOperationTest extends MdxmlRepresentationTests {
	
	@Test
	public void testOwnedOperations() {
		OwnedOperation ownedOperation = mdxmlGenericClass.getOwnedOperations().get(0);
		assertNotNull(ownedOperation);
		assertEquals("_19_0_1_62d0212_1574772596071_455414_4852", ownedOperation.getId());
		assertEquals("GenericClass", ownedOperation.getName());
		assertEquals("public", ownedOperation.getVisibility());
		assertEquals(1, ownedOperation.getOwnedParameters().size());
		assertNull(ownedOperation.getIsAbstract());
		assertNull(ownedOperation.getIsStatic());
		assertNull(ownedOperation.getIsFinal());
		
		ownedOperation = mdxmlBigEnum.getOwnedOperations().get(1);
		assertNotNull(ownedOperation);
		assertEquals("true", ownedOperation.getIsAbstract());
		assertEquals("true", ownedOperation.getIsStatic());
	}
}
