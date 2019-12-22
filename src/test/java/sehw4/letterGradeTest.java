package sehw4;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class letterGradeTest {
	private letterGrade getLetterGrade = new letterGrade();

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private ByteArrayInputStream testIn;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void test() {
		assertEquals('X', getLetterGrade.letterGrade(-1));
		assertEquals('F', getLetterGrade.letterGrade(0));
		assertEquals('F', getLetterGrade.letterGrade(1));
		assertEquals('F', getLetterGrade.letterGrade(59));
		assertEquals('D', getLetterGrade.letterGrade(60));
		assertEquals('D', getLetterGrade.letterGrade(61));
		assertEquals('D', getLetterGrade.letterGrade(69));
		assertEquals('C', getLetterGrade.letterGrade(70));
		assertEquals('C', getLetterGrade.letterGrade(71));
		assertEquals('C', getLetterGrade.letterGrade(79));
		assertEquals('B', getLetterGrade.letterGrade(80));
		assertEquals('B', getLetterGrade.letterGrade(81));
		assertEquals('B', getLetterGrade.letterGrade(89));
		assertEquals('A', getLetterGrade.letterGrade(90));
		assertEquals('A', getLetterGrade.letterGrade(91));
		assertEquals('A', getLetterGrade.letterGrade(99));
		assertEquals('A', getLetterGrade.letterGrade(100));
		assertEquals('X', getLetterGrade.letterGrade(101));
	}

	@Test
	public void testNumberFormatException() {
		final String testString = "E";
		provideInput(testString);
		getLetterGrade.main(new String[0]);
		assertEquals("Enetr the score = Not an integer!", outContent.toString().replaceAll("\r|\n", ""));
	}

	@Test
	public void testWithoutException() {
		final String testString = "1";
		provideInput(testString);
		getLetterGrade.main(new String[0]);
		assertEquals("Enetr the score = The grade of 1 is F", outContent.toString().replaceAll("\r|\n", ""));
	}

	@Test
	public void testIOException() throws IOException {
		final InputStream mis = new InputStream() {
			@Override
			public int read() throws IOException {
				throw new IOException();
			}
		};
		System.setIn(mis);
		getLetterGrade.main(new String[0]);

	}

}