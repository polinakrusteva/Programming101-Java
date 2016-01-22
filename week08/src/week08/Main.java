package week08;

public class Main {

	private static class myThread extends Thread {

		public void run() {
			for (int i = 0; i < 1_000_000; i++) {
				Counter.increment();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
	
		myThread threadOne = new myThread();
		myThread threadTwo = new myThread();

		threadOne.start();
		threadTwo.start();

		threadOne.join();
		threadTwo.join();

		System.out.println(Counter.getCounter());
		
		//test thread sort 
		
		long start = System.currentTimeMillis();
		
		MyRunnable myRunnable = new MyRunnable();
		Thread sortThread = new Thread(myRunnable);
		sortThread.start();
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}
}
