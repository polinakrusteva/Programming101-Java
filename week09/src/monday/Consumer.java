package monday;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {

	private final BlockQueue<Integer> sharedQueue;
	private static AtomicInteger counter = new AtomicInteger();
	
	public Consumer(BlockQueue<Integer> queue, int counter) {
		this.sharedQueue = queue;
		Consumer.counter.set(counter);
	}

	@Override
	public void run() {
		while (counter.getAndDecrement() > 0) {
			try {
				System.out.println("Consumed: " + sharedQueue.get() + " by " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
