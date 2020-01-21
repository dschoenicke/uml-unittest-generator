package mdxml;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DataTypeTest extends MdxmlRepresentationTests {

	@Test
	public void testDataTypes() {
		DataType type = mdxmlSubClass.getOwnedAttributes().get(0).getDataType();
		assertNotNull(type);
		assertNotNull(type.getExtension());
		
		type = mdxmlGenericClass.getOwnedOperations().get(0).getOwnedParameters().get(0).getDataType();
		assertNotNull(type);
		assertNotNull(type.getExtension());
	}
}
