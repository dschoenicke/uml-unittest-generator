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
import org.apache.commons.cli.ParseException;
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
	
	/**
	 * Tests {@link TestCreator#parseOptions}
	 */
	@Test
	public void testParseOptions() {
		Options options = new Options();
		
		try {
			DefaultParser parser = new DefaultParser();
			String[] args = {"-fail"};
			CommandLine cmd = parser.parse(options, args);
			assertFalse(TestCreator.parseOptions(cmd, args));
			String[] ctargs = {"-ct", "-", "-", "-", "-"};
			cmd = parser.parse(options, ctargs);
			assertTrue(TestCreator.parseOptions(cmd, ctargs));
			String[] inargs = {"-inputtypes"};
			cmd = parser.parse(options, inargs);
			assertTrue(TestCreator.parseOptions(cmd, inargs));
			String[] outargs = {"-outputtypes"};
			cmd = parser.parse(options, outargs);
			assertTrue(TestCreator.parseOptions(cmd, outargs));
			String[] exargs = {"-ct"};
			cmd = parser.parse(options, exargs);
			assertTrue(TestCreator.parseOptions(cmd, exargs));
		} catch (ParseException e) {
			
		}
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
