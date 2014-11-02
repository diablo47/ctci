package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BucketStack<E> extends Stack<E> {

	int capacity;
	int crusor = 0;
	int size = 00;
	List<Stack<E>> buckets;

	public BucketStack(int capacity) {
		this.capacity = capacity;
		this.buckets = new ArrayList<Stack<E>>();
	}

	public E push(E e) {
		if (buckets.get(crusor).size() == capacity) {
			capacity++;
		}
		if (buckets.get(crusor) == null) {
			buckets.add(new Stack<E>());
		}
		size++;
		return this.buckets.get(crusor).push(e);
	}

	public E pop() {
		Stack<E> stack = buckets.get(crusor);
		if (stack.isEmpty())
			if (crusor == 0)
				return null;
			else
				crusor--;
		size--;
		E ret = stack.pop();
		return ret;
	}

	public E pop(int index) {
		if (crusor == index) {
			return pop();
		} else if (crusor > index && index > 0) {
			return buckets.get(index).pop();
		} else
			return null;
	}

	public E peak() {
		return buckets.get(crusor).peek();
	}

}

public class Q3_3 {

}
