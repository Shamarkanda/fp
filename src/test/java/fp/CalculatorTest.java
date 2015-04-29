package fp;

import static fp.Calculator.checkMyBet;
import static fp.Calculator.divisors;
import static fp.Calculator.isLeapYear;
import static fp.Calculator.isValidDate;
import static fp.Calculator.sin;
import static fp.Calculator.speakToMe;
import static fp.Calculator.stepThisNumber;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {

	@Test
	public void testSin() {
		Assert.assertNotNull(sin(0));
		Assert.assertEquals(sin(30), Double.valueOf(0.5));
		Assert.assertEquals(sin(90), Double.valueOf(1));
		Assert.assertEquals(sin(270), Double.valueOf(-1));
		Assert.assertEquals(sin(810), Double.valueOf(1));
		System.out.println("1P");
	}

	@Test
	public void testStepThisNumber() {
		Assert.assertNotNull(stepThisNumber(0, 0));
		Assert.assertArrayEquals(stepThisNumber(5, 1), new int[] { 4, 3, 2, 1 });
		Assert.assertArrayEquals(stepThisNumber(5, 2), new int[] { 3, 1 });
		Assert.assertArrayEquals(stepThisNumber(12, 3), new int[] { 9, 6, 3 });
		System.out.println("1P");
	}

	@Test
	public void testDivisors() {
		Assert.assertNull(divisors(0));
		Assert.assertArrayEquals(divisors(1), new int[] { 1 });
		Assert.assertArrayEquals(divisors(12), new int[] { 12, 6, 4, 3, 2, 1 });
		Assert.assertArrayEquals(divisors(20), new int[] { 20, 10, 5, 2, 1 });
		System.out.println("1P");
	}

	@Test
	public void testCheckMyBet() {
		Assert.assertNotNull(checkMyBet(null, null));
		Assert.assertEquals(
				checkMyBet(Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(1, 2, 3, 4, 5, 6)), Integer.valueOf(6));
		Assert.assertEquals(
				checkMyBet(Arrays.asList(2, 1, 4, 3, 6, 5),
						Arrays.asList(1, 2, 3, 4, 5, 6)), Integer.valueOf(0));
		Assert.assertEquals(
				checkMyBet(Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(5, 5, 5, 5, 5, 5)), Integer.valueOf(1));
		Assert.assertEquals(
				checkMyBet(Arrays.asList(1, 2, 3, 4, 7, 6),
						Arrays.asList(5, 5, 5, 5, 5, 5)), Integer.valueOf(0));
		Assert.assertEquals(
				checkMyBet(Arrays.asList(1, 1, 2, 2, 3, 3),
						Arrays.asList(6, 6, 2, 5, 3, 5)), Integer.valueOf(2));
		System.out.println("1P");
	}

	@Test
	public void testSpeakToMe() {
		Assert.assertNotNull(speakToMe(0));
		Assert.assertEquals(speakToMe(0), "Cero");
		Assert.assertEquals(speakToMe(10), "Diez");
		Assert.assertEquals(speakToMe(20), "Veinte");
		Assert.assertEquals(speakToMe(60), "Sesenta");
		Assert.assertEquals(speakToMe(61), "Sesenta y uno");
		Assert.assertEquals(speakToMe(90), "Noventa");
		Assert.assertEquals(speakToMe(93), "Noventa y tres");
		System.out.println("2P");
	}

	@Test
	public void testIsLeapYear() {
		Assert.assertNotNull(isLeapYear(""));
		Assert.assertTrue(isLeapYear("01-01-1904"));
		Assert.assertTrue(isLeapYear("01-01-1928"));
		Assert.assertFalse(isLeapYear("01-01-2100"));
		Assert.assertTrue(isLeapYear("01-01-2000"));
		System.out.println("1P");
	}

	@Test
	public void testIsValidDate() {
		Assert.assertNotNull(isValidDate(""));
		Assert.assertTrue(isValidDate("01-01-0001"));
		Assert.assertTrue(isValidDate("31-12-2015"));
		Assert.assertFalse(isValidDate(""));
		Assert.assertFalse(isValidDate("asdasd"));
		Assert.assertFalse(isValidDate("21-12"));
		Assert.assertFalse(isValidDate("12-2000"));
		Assert.assertFalse(isValidDate("00-12-2000"));
		Assert.assertFalse(isValidDate("32-12-2000"));
		Assert.assertFalse(isValidDate("31-13-2000"));
		Assert.assertFalse(isValidDate("01-00-2000"));
		Assert.assertFalse(isValidDate("01-01-0000"));
		System.out.println("2P");
	}

}
