package chapter3;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

class MinStack<E extends Comparable<E>> extends Stack<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Stack<E> minStack = new Stack<E>();

	@Override
	public E pop() {
		E e = super.pop();
		if (e.equals(minStack.peek())) {
			minStack.pop();
		}
		return e;
	}

	public E push(E e) {
		super.push(e);
		if (minStack.isEmpty()) {
			minStack.push(e);
		} else {
			E smallest = minStack.peek();
			if (e.compareTo(smallest) <= 0) {
				minStack.push(e);
			}
		}
		return e;
	}

	public E min() {
		return minStack.peek();
	}
}

public class Q3_2 {
	public static void main(String[] args) {
		MinStack<Integer> stack = new MinStack<Integer>();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println(stack.toString());
		for (int i = 0; i < 15; i++) {
			System.out.println("New min is " + stack.min());
			System.out.println("Popped " + stack.pop());
		}
	}
}
