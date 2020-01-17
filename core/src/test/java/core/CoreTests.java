package core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

/**
 * Tests {@link Core} and provides provides testable output streams
 * 
 * @author dschoenicke
 *
 */
public class CoreTests {

	/**
	 * The output {@link java.io.PrintStream} to test the system's outputs
	 */
	protected final ByteArrayOutputStream outstream = new ByteArrayOutputStream();
	
	/**
	 * Sets the output {@link java.io.PrintStream} to a testable instance
	 */
	@Before
	public void init() {
		System.setOut(new PrintStream(outstream));
	}
	
	/**
	 * Resets the output {@link java.io.PrintStream}
	 */
	@After
	public void reset() {
		System.setOut(System.out);
	}
}
