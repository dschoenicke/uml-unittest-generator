package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRepresentationTest extends TestRepresentationTests {

	@Test
	public void getTestClassesAsList() {
		assertEquals(9, testRepresentation.getTestClassesAsList().size());
	}
}
