package junit;

public class Assert {

	public static void assertEquals(java.lang.String message, double expected, double actual) {
		if(expected != actual){
			new AssertionError("Not equal");
		}
	}
	
	public static void assertEquals(java.lang.String message, Object expected, Object actual) {
		if(!expected.equals(actual)){
			new AssertionError("Not equal");
		}
	}

}
