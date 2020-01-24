package core.options;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.junit.After;
import org.junit.Test;

import core.Core;

public class QualifiedNamesMapperTest {

	@Test
	public void testParseOptions() throws Exception {
		Options options = new Options();
		QualifiedNamesMapper.addQualifiedNamesMapperOptions(options);
		DefaultParser parser = new DefaultParser();
		String[] aqnargs = {"-aqn", "f", "f"};
		CommandLine cmd = parser.parse(options, aqnargs);
		QualifiedNamesMapper.parseOptions(cmd, aqnargs);
		assertTrue(QualifiedNamesMapper.parseOptions(cmd, aqnargs));
		String[] rqnargs = {"-rqn", "f", "f"};
		cmd = parser.parse(options, rqnargs);
		assertTrue(QualifiedNamesMapper.parseOptions(cmd, rqnargs));
		String[] dqnargs = {"-dqn", "f"};
		cmd = parser.parse(options, dqnargs);
		assertTrue(QualifiedNamesMapper.parseOptions(cmd, dqnargs));
		String[] cqnargs = {"-cqn"};
		cmd = parser.parse(options, cqnargs);
		assertTrue(QualifiedNamesMapper.parseOptions(cmd, cqnargs));
		String[] sqnargs = {"-sqn"};
		cmd = parser.parse(options, sqnargs);
		assertTrue(QualifiedNamesMapper.parseOptions(cmd, sqnargs));
		String[] invalidargs = {"invalid"};
		cmd = parser.parse(options, invalidargs);
		QualifiedNamesMapper.parseOptions(cmd, invalidargs);
		assertFalse(QualifiedNamesMapper.parseOptions(cmd, invalidargs));
	}
	
	@Test
	public void testAddQualifiedName() {
		Map<String, String> testMap = QualifiedNamesMapper.showQualifiedNames();
		assertFalse(testMap.containsKey("123"));
		testMap = QualifiedNamesMapper.addQualifiedName("123", "123.123");
		assertTrue(testMap.containsKey("123"));
		assertEquals("123.123", testMap.get("123"));
		assertEquals(testMap.size(), QualifiedNamesMapper.addQualifiedName("123", "123.123").size());
	}
	
	@Test
	public void testReplaceQualifiedName() {
		Map<String, String> testMap = QualifiedNamesMapper.showQualifiedNames();
		testMap = QualifiedNamesMapper.addQualifiedName("123", "123.123");
		assertTrue(testMap.containsKey("123"));
		assertEquals("123.123", testMap.get("123"));
		assertEquals("456.456", QualifiedNamesMapper.replaceQualifiedName("123", "456.456").get("123"));
	}
	
	@Test
	public void testDeleteQualifiedName() {
		Map<String, String> testMap = QualifiedNamesMapper.showQualifiedNames();
		testMap = QualifiedNamesMapper.addQualifiedName("123", "List");
		assertTrue(testMap.containsKey("123"));
		assertTrue(QualifiedNamesMapper.deleteQualifiedName("123").isEmpty());
	}
	
	@Test
	public void testClearQualifiedNames() {
		QualifiedNamesMapper.addQualifiedName("123", "123.123");
		QualifiedNamesMapper.addQualifiedName("456", "456.456");
		assertEquals(2, QualifiedNamesMapper.showQualifiedNames().size());
		assertTrue(QualifiedNamesMapper.clearQualifiedNames().isEmpty());
	}
	
	@After
	public void cleanup() {
		new File(Core.DB_PATH).delete();
	}
}
