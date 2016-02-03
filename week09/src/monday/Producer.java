package monday;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private final BlockQueue<Integer> sharedQueue;
	private static AtomicInteger counter = new AtomicInteger();

	public Producer(BlockQueue<Integer> queue, int counter) {
		this.sharedQueue = queue;
		Producer.counter.set(counter);
	}

	@Override
	public void run() {
		int element;
		while ((element = counter.getAndDecrement()) > 0) {
			try {
				sharedQueue.put(element);
				System.out.println("Produced: " + element + " by " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
