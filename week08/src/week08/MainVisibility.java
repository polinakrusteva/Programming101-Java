package week08;

public class MainVisibility {

	public static void main(String[] args) throws InterruptedException {
		VisibilityThread thread = new VisibilityThread();
		thread.start();
		
		thread.sleep(1000);
		
		thread.setToFalse();
		System.out.println("Set to false.");
	}
	
}
