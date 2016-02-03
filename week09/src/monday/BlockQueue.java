package monday;

import java.util.LinkedList;
import java.util.Queue;

public class BlockQueue<T> {

	private final Queue<T> q = new LinkedList<T>();
	private final int limit;

	public BlockQueue(int limit) {
		if (limit > 0) {
			this.limit = limit;
		} else {
			throw new IllegalArgumentException("Limit cannot be 0 or negative!");
		}
	}

	public int getLimit() {
		return this.limit;
	}

	public T get() throws InterruptedException {
		synchronized (q) {
			while (q.isEmpty()) {
				q.wait();
			}
			q.notifyAll();
			return q.poll();
		}
	}

	public void put(T el) throws InterruptedException {
		synchronized (q) {
			while (q.size() == limit) {
				q.wait();
			}
			q.add(el);
			q.notifyAll();
		}
	}

}
