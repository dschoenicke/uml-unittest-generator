package core.options;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.junit.Test;

import core.CoreTests;

/**
 * Tests {@link TestCreator}
 * 
 * @author dschoenicke
 *
 */
public class TestCreatorTest extends CoreTests {

	/**
	 * Tests {@link TestCreator#addTestCreatorOptions}
	 */
	@Test
	public void testAddTestCreatorOptions() {
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		assertEquals(3, options.getOptions().size());
	}
	
	@Test
	public void testParseOptions() throws Exception {
		Options options = new Options();
		TestCreator.addTestCreatorOptions(options);
		DefaultParser parser = new DefaultParser();
		String[] ctargs = {"-ct", "f", "f", "f", "f"};
		CommandLine cmd = parser.parse(options, ctargs);
		TestCreator.parseOptions(cmd, ctargs);
		assertTrue(TestCreator.parseOptions(cmd, ctargs));
		String[] inargs = {"-inputtypes"};
		cmd = parser.parse(options, inargs);
		TestCreator.parseOptions(cmd, inargs);
		assertTrue(TestCreator.parseOptions(cmd, inargs));
		String[] outargs = {"-outputtypes"};
		cmd = parser.parse(options, outargs);
		TestCreator.parseOptions(cmd, outargs);
		assertTrue(TestCreator.parseOptions(cmd, outargs));
		String[] invalidargs = {"invalid"};
		cmd = parser.parse(options, invalidargs);
		TestCreator.parseOptions(cmd, invalidargs);
		assertFalse(TestCreator.parseOptions(cmd, invalidargs));
	}
	
	/**
	 * Tests {@link TestCreator#evaluateArguments}
	 */
	@Test
	public void testEvaluateArguments() {
		File mockInput = new File(System.getProperty("user.dir") + File.separator + "test.xml");
		TestCreator.showOutputs();
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
}
