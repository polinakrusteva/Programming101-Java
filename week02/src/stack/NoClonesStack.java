package stack;

import java.util.LinkedList;

public class NoClonesStack implements IStack {

	private LinkedList<Integer> stack;

	public NoClonesStack() {
		stack = new LinkedList<>();
	}

	@Override
	public void push(int element) {
		if (stack.contains(element)) {
			throw new IllegalArgumentException("Element already in stack!");
		}
		stack.addLast(element);
	}

	@Override
	public int pop() {
		if(stack.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stack.removeLast();
	}

	@Override
	public int peek() {
		if (stack.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		return stack.getLast();
	}

	@Override
	public boolean isEmpty() {
		return stack.size() == 0;
	}

	@Override
	public int length() {
		return stack.size();
	}
}
