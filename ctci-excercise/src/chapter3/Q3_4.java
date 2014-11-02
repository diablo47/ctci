package chapter3;

import java.util.Stack;

class Tower<E> {

	int level;

	public Stack<E> left;
	public Stack<E> middle;
	public Stack<E> right;

	public Tower(int level) {
		this.level = level;
		left = new Stack<E>();
		middle = new Stack<E>();
		right = new Stack<E>();
	}

	public void move(Stack<E> from, Stack<E> buffer, Stack<E> destiny, int level) {
		if (level == 1) {
			E e = from.pop();
			destiny.push(e);
		} else {
			move(from, destiny, buffer, level - 1);
			E e = from.pop();
			destiny.push(e);
			System.out.println("Moving:");
			print();
			move(buffer, from, destiny, level - 1);
		}

	}

	public void print() {
		System.out.println(left);
		System.out.println(middle);
		System.out.println(right);
	}
}

public class Q3_4 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			Tower<Integer> t = new Tower<Integer>(i);
			for (int j = i; j >= 1; j--)
				t.left.push(j);
			System.out.println("before: ");
			t.print();
			t.move(t.left, t.middle, t.right, i);
			System.out.println("after: ");
			t.print();
		}
	}
}
