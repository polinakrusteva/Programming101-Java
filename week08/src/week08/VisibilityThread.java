package week08;

public class VisibilityThread extends Thread{
	volatile boolean keepRunning = true;
	
	public void setToFalse(){
		keepRunning = false;
	}

	public boolean getValue(){
		return keepRunning;
	}
	
	public void run(){
		while(getValue()){
			
		}
		System.out.println("I'm done.");
	}
	
}
