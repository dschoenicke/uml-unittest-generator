package mdxmlconverter.multiplicity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mdxml.LowerValue;
import mdxml.UpperValue;
import uml.UmlMultiplicityValue;

public class MultiplicityConverterTest {

	private LowerValue mockLowerValue1;
	private LowerValue mockLowerValue2;
	private LowerValue mockLowerValue3;
	private UpperValue mockUpperValue1;
	private UpperValue mockUpperValue2;
	private UpperValue mockUpperValue3;
	
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
	
	@Test
	public void convertLowerValueTest() {
		assertEquals(UmlMultiplicityValue.ZERO, MultiplicityConverter.convertLowerValue(mockLowerValue1));
		assertEquals(UmlMultiplicityValue.ZERO, MultiplicityConverter.convertLowerValue(mockLowerValue2));
		assertEquals(UmlMultiplicityValue.ONE, MultiplicityConverter.convertLowerValue(mockLowerValue3));
		assertEquals(UmlMultiplicityValue.ONE, MultiplicityConverter.convertLowerValue(null));
	}
	
	@Test
	public void convertUpperValueTest() {
		assertEquals(UmlMultiplicityValue.ONE, MultiplicityConverter.convertUpperValue(mockUpperValue1));
		assertEquals(UmlMultiplicityValue.INFINITE, MultiplicityConverter.convertUpperValue(mockUpperValue2));
		assertEquals(UmlMultiplicityValue.INFINITE, MultiplicityConverter.convertUpperValue(mockUpperValue3));
		assertEquals(UmlMultiplicityValue.ONE, MultiplicityConverter.convertUpperValue(null));
	}
}
