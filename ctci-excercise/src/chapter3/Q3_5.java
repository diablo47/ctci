package chapter3;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

public class Q3_5 {

	public static <E extends Comparable<E>> void sort(Stack<E> s) {

		Stack<E> buffer = new Stack<E>();
		while (!s.isEmpty()) {
			E e = s.pop();
			while (!buffer.isEmpty()) {
				E temp = buffer.peek();
				if (temp.compareTo(e) < 0) {
					temp = buffer.pop();
					s.push(temp);
				} else {
					break;
				}
			}
			buffer.push(e);
		}
		while (!buffer.isEmpty()) {
			s.push(buffer.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println("");
		System.out.println(stack.toString());
		sort(stack);
		System.out.println(stack.toString());
	}
}
