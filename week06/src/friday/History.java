package friday;

public class History {

	private class Node {

		private String value;
		private Node next;

		public Node(String value) {
			this.value = value;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;
	private int MAX_CAPACITY = 5;

	public History() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void add(String value) {
		if (this.size == MAX_CAPACITY) {
			removeOldest();
		}
		Node temp = tail;
		tail = new Node(value);
		if (isEmpty()) {
			head = tail;
		} else {
			temp.next = tail;
		}
		this.size++;
	}

	public String removeOldest() {
		if (head != null) {
			String value = head.value;
			head = head.next;
			this.size--;
			return value;
		}
		return null;
	}

	public String getNewest() {
		if (tail != null) {
			return tail.value;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void showHistory() {
		Node temp = head;
		while (temp.next != null) {
			System.out.println(temp.value);
		}
	}
}
