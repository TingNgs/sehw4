package sehw4;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class letterGradeTest {
	private letterGrade myGrade;

	@Before
	public void setUp() throws Exception {
		myGrade = new letterGrade();
	}

	@After
	public void tearDown() throws Exception {
		myGrade = null;
	}

	@Test
	public void test() {
		assertEquals('X', myGrade.letterGrade(-1));
		assertEquals('F', myGrade.letterGrade(0));
		assertEquals('F', myGrade.letterGrade(1));
		assertEquals('F', myGrade.letterGrade(59));
		assertEquals('D', myGrade.letterGrade(60));
		assertEquals('D', myGrade.letterGrade(61));
		assertEquals('D', myGrade.letterGrade(69));
		assertEquals('C', myGrade.letterGrade(70));
		assertEquals('C', myGrade.letterGrade(71));
		assertEquals('C', myGrade.letterGrade(79));
		assertEquals('B', myGrade.letterGrade(80));
		assertEquals('B', myGrade.letterGrade(81));
		assertEquals('B', myGrade.letterGrade(89));
		assertEquals('A', myGrade.letterGrade(90));
		assertEquals('A', myGrade.letterGrade(91));
		assertEquals('A', myGrade.letterGrade(99));
		assertEquals('A', myGrade.letterGrade(100));
		assertEquals('X', myGrade.letterGrade(101));
	}

}