package core.options;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.Options;
import org.junit.Test;

import core.CoreTest;

/**
 * Tests {@link TestCreator}
 * 
 * @author dschoenicke
 *
 */
public class TestCreatorTest extends CoreTest {

	/**
	 * Tests {@link TestCreator#addTestCreatorOptions}
	 */
	@Test
	public void testAddTestCreatorOptions() {
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		assertEquals(3, options.getOptions().size());
	}
	
	/**
	 * Tests {@link TestCreator#parseOptions}
	 */
	@Test
	public void testParseOptions() {
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		String[] args = {"-fail"};
		assertFalse(TestCreator.parseOptions(options, args));
		String[] ctargs = {"-ct", "-", "-", "-", "-"};
		assertTrue(TestCreator.parseOptions(options, ctargs));
		String[] inargs = {"-inputtypes"};
		assertTrue(TestCreator.parseOptions(options, inargs));
		String[] outargs = {"-outputtypes"};
		assertTrue(TestCreator.parseOptions(options, outargs));
		String[] exargs = {"-ct"};
		assertTrue(TestCreator.parseOptions(options, exargs));
	}
	
	/**
	 * Tests {@link TestCreator#evaluateArguments}
	 */
	@Test
	public void testEvaluateArguments() {
		File mockInput = new File(System.getProperty("user.dir") + File.separator + "test.xml");
		
		try {
			mockInput.createNewFile();
			String[] allFalse = {"-ct", "false", "false", "false", "false"};
			assertFalse(TestCreator.evaluateArguments(allFalse));
			String[] first = {"-ct", "mdxml", "false", "false", "false"};
			assertFalse(TestCreator.evaluateArguments(first));
			String[] second = {"-ct", "mdxml", mockInput.getAbsolutePath(), "false", "false"};
			assertFalse(TestCreator.evaluateArguments(second));
			String[] third = {"-ct", "mdxml", mockInput.getAbsolutePath(), "junit", "false"};
			assertFalse(TestCreator.evaluateArguments(third));
			String[] all = {"-ct", "mdxml", mockInput.getAbsolutePath(), "junit", System.getProperty("user.dir")};
			assertTrue(TestCreator.evaluateArguments(all));
			assertTrue(mockInput.delete());
		} catch (IOException e) {
			fail();
		}
	}
	
	/**
	 * Tests {@link TestCreator#showInputs()}
	 */
	@Test
	public void testShowInputs() {
		TestCreator.showInputs();
		assertEquals("Supported input diagram formats:\n\tmdxml\n", outstream.toString());
	}
	
	/**
	 * Tests {@link TestCreator#showOutputs()}
	 */
	@Test
	public void testShowOutputs() {
		TestCreator.showOutputs();
		assertEquals("Supported output test formats:\n\tjunit\n", outstream.toString());
	}
}
