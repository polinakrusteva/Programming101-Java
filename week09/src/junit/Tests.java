package junit;

public class Tests {

	private static ClassToBeTested testObj;

	@Test
	public static void testAdd() {
		Assert.assertEquals("Test if addition works.", 7, testObj.add(2, 5));
	}

	@Test
	public void testSubtract() {
		Assert.assertEquals("Test if subtraction works.", 4, testObj.subtract(8, 4));
	}

	@Test
	public void testDivision() {
		Assert.assertEquals("Test if division works.", 4.5, testObj.divide(9, 2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testCatchesZeroDivision() {
		testObj.divide(2, 0);
	}
}
