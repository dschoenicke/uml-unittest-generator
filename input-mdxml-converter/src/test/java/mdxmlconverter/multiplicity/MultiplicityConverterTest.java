package mdxmlconverter.multiplicity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mdxml.LowerValue;
import mdxml.UpperValue;
import uml.UmlMultiplicityValue;

/**
 * Tests the {@link MultiplicityConverter} functions
 * 
 * @author dschoenicke
 *
 */
public class MultiplicityConverterTest {

	/**
	 * Mocks a {@link mdxml.LowerValue} to be used for {@link MultiplicityConverter#convertLowerValue}.
	 */
	private LowerValue mockLowerValue1;
	
	/**
	 * Mocks a {@link mdxml.LowerValue} to be used for {@link MultiplicityConverter#convertLowerValue}.
	 */
	private LowerValue mockLowerValue2;
	
	/**
	 * Mocks a {@link mdxml.LowerValue} to be used for {@link MultiplicityConverter#convertLowerValue}.
	 */
	private LowerValue mockLowerValue3;
	
	/**
	 * Mocks a {@link mdxml.UpperValue} to be used for {@link MultiplicityConverter#convertUpperValue}.
	 */
	private UpperValue mockUpperValue1;
	
	/**
	 * Mocks a {@link mdxml.UpperValue} to be used for {@link MultiplicityConverter#convertUpperValue}.
	 */
	private UpperValue mockUpperValue2;
	
	/**
	 * Mocks a {@link mdxml.UpperValue} to be used for {@link MultiplicityConverter#convertUpperValue}.
	 */
	private UpperValue mockUpperValue3;
	
	/**
	 * Initializes the mock values.
	 */
	@Before
	public void init() {
		mockLowerValue1 = new LowerValue();
		mockLowerValue1.setValue("0");
		mockLowerValue2 = new LowerValue();
		mockLowerValue2.setType("uml:LiteralInteger");
		mockLowerValue3 = new LowerValue();
		mockUpperValue1 = new UpperValue();
		mockUpperValue1.setValue("1");
		mockUpperValue2 = new UpperValue();
		mockUpperValue2.setType("uml:LiteralUnlimitedNatural");
		mockUpperValue3 = new UpperValue();
		mockUpperValue3.setValue("*");
	}
	
	/**
	 * Tests {@link MultiplicityConverter#convertLowerValue} with different inputs.
	 */
	@Test
	public void convertLowerValueTest() {
		assertEquals(MultiplicityConverter.convertLowerValue(mockLowerValue1), UmlMultiplicityValue.ZERO);
		assertEquals(MultiplicityConverter.convertLowerValue(mockLowerValue2), UmlMultiplicityValue.ZERO);
		assertEquals(MultiplicityConverter.convertLowerValue(mockLowerValue3), UmlMultiplicityValue.ONE);
		assertEquals(MultiplicityConverter.convertLowerValue(null), UmlMultiplicityValue.ONE);
	}
	
	/**
	 * Tests {@link MultiplicityConverter#convertUpperValue} with different inputs.
	 */
	@Test
	public void convertUpperValueTest() {
		assertEquals(MultiplicityConverter.convertUpperValue(mockUpperValue1), UmlMultiplicityValue.ONE);
		assertEquals(MultiplicityConverter.convertUpperValue(mockUpperValue2), UmlMultiplicityValue.INFINITE);
		assertEquals(MultiplicityConverter.convertUpperValue(mockUpperValue3), UmlMultiplicityValue.INFINITE);
		assertEquals(MultiplicityConverter.convertUpperValue(null), UmlMultiplicityValue.ONE);
	}
}
