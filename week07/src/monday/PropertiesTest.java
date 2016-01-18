package monday;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesTest {

	private static Map<String, String> testMap;

	@BeforeClass
	public static void initMap() throws IOException {
		testMap = new HashMap<>();
		testMap = Properties.parseProperties(new File("/home/polinakk/Desktop/untitled.txt"));
	}

	@AfterClass
	public static void destroyMap() {
		testMap = null;
	}

	@Test
	public void testParseProperties() {
		String expectedKey = "a1";
		String expectedValue = "b1";
		String actualValue = testMap.get(expectedKey);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test(expected = IOException.class)
	public void testFileNotFoundException() throws IOException{
		Properties.parseProperties(new File("/home/polinakk/Desktop/untitled3.txt"));
	}

}
