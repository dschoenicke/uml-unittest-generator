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

public class AssociationTypeMapperTest {
	
	@Test
	public void testParseOptions() throws Exception {
		Options options = new Options();
		AssociationTypeMapper.addAssociationTypeMapperOptions(options);
		DefaultParser parser = new DefaultParser();
		String[] aatargs = {"-aat", "f", "f"};
		CommandLine cmd = parser.parse(options, aatargs);
		AssociationTypeMapper.parseOptions(cmd, aatargs);
		assertTrue(AssociationTypeMapper.parseOptions(cmd, aatargs));
		String[] ratargs = {"-rat", "f", "f"};
		cmd = parser.parse(options, ratargs);
		assertTrue(AssociationTypeMapper.parseOptions(cmd, ratargs));
		String[] datargs = {"-dat", "f"};
		cmd = parser.parse(options, datargs);
		assertTrue(AssociationTypeMapper.parseOptions(cmd, datargs));
		String[] catargs = {"-cat"};
		cmd = parser.parse(options, catargs);
		assertTrue(AssociationTypeMapper.parseOptions(cmd, catargs));
		String[] satargs = {"-sat"};
		cmd = parser.parse(options, satargs);
		assertTrue(AssociationTypeMapper.parseOptions(cmd, satargs));
		String[] invalidargs = {"invalid"};
		cmd = parser.parse(options, invalidargs);
		AssociationTypeMapper.parseOptions(cmd, invalidargs);
		assertFalse(AssociationTypeMapper.parseOptions(cmd, invalidargs));
	}
	
	@Test
	public void testAddAssociationType() {
		Map<String, String> testMap = AssociationTypeMapper.showAssociationTypes();
		assertFalse(testMap.containsKey("123"));
		testMap = AssociationTypeMapper.addAssociationType("123", "List");
		assertTrue(testMap.containsKey("123"));
		assertEquals("List", testMap.get("123"));
		assertEquals(testMap.size(), AssociationTypeMapper.addAssociationType("123", "List").size());
	}
	
	@Test
	public void testReplaceAssociationType() {
		Map<String, String> testMap = AssociationTypeMapper.showAssociationTypes();
		testMap = AssociationTypeMapper.addAssociationType("123", "List");
		assertTrue(testMap.containsKey("123"));
		assertEquals("List", testMap.get("123"));
		assertEquals("Map", AssociationTypeMapper.replaceAssociationType("123", "Map").get("123"));
	}
	
	@Test
	public void testDeleteAssociationType() {
		Map<String, String> testMap = AssociationTypeMapper.showAssociationTypes();
		testMap = AssociationTypeMapper.addAssociationType("123", "List");
		assertTrue(testMap.containsKey("123"));
		assertTrue(AssociationTypeMapper.deleteAssociationType("123").isEmpty());
	}
	
	@Test
	public void testClearAssociationTypes() {
		AssociationTypeMapper.addAssociationType("123", "List");
		AssociationTypeMapper.addAssociationType("456", "List");
		assertEquals(2, AssociationTypeMapper.showAssociationTypes().size());
		assertTrue(AssociationTypeMapper.clearAssociationTypes().isEmpty());
	}
	
	@After
	public void cleanup() {
		new File(Core.DB_PATH).delete();
	}
}
