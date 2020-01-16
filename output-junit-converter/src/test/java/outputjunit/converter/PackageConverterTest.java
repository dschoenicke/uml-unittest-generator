package outputjunit.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.JunitPackage;
import outputjunit.OutputJunitConverterTests;
import outputjunit.converter.temporary.TemporaryModel;

/**
 * Tests {@link PackageConverter}
 * 
 * @author dschoenicke
 *
 */
public class PackageConverterTest extends OutputJunitConverterTests {

	/**
	 * Tests {@link PackageConverter#convertPackages}
	 */
	@Test
	public void testConvertPackages() {
		TemporaryModel tmpModel = new TemporaryModel();
		mockJunitRepresentation.getPackages().clear();
		PackageConverter.convertPackages(mockTestRepresentation, mockJunitRepresentation, tmpModel);
		assertEquals(2, mockJunitRepresentation.getPackages().size());
		assertEquals(1, mockJunitPackage1.getPackages().size());
	}
	
	/**
	 * Tests {@link PackageConverter#convertPackage}
	 */
	@Test
	public void testConvertPackage() {
		TemporaryModel tmpModel = new TemporaryModel();
		JunitPackage convertedPackage1 = PackageConverter.convertPackage(mockTestPackage1, mockJunitRepresentation, tmpModel);
		assertEquals(convertedPackage1.getName(), mockJunitPackage1.getName());
		assertEquals(convertedPackage1.getParent(), mockJunitRepresentation);
		
		JunitPackage convertedPackage2 = PackageConverter.convertPackage(mockSubTestPackage, mockJunitPackage1, tmpModel);
		assertEquals(convertedPackage2.getName(), mockJunitSubPackage.getName());
		assertEquals(convertedPackage2.getParent(), mockJunitPackage1);
		
		assertEquals(2, tmpModel.getConvertedPackages().size());
		assertTrue(tmpModel.getConvertedPackages().containsKey(mockTestPackage1));
		assertTrue(tmpModel.getConvertedPackages().containsKey(mockSubTestPackage));
	}
}
