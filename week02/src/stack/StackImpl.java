package stack;

public class StackImpl implements IStack{
	
	private Node top;
	private int size;
	
	public StackImpl() {
		this.top = null;
		this.size = 0;
	}
	
	@Override
	public void push(int element) {
		Node temp = new Node(element);
		temp.setNext(top);
		top = temp;
		this.size++;
	}

	@Override
	public int pop() {
		if(top != null) {
			int value = top.getValue();
			top = top.getNext();
			this.size--;
			return value;
		}
		return -1;
	}

	@Override
	public int peek() {
		if(this.top == null) {
			throw new RuntimeException("Stack is empty!");
		}
		return this.top.getValue();
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int length() {
		return this.size;
	}
}
