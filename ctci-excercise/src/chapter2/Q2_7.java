package chapter2;

import java.util.Stack;

public class Q2_7 {

	public static <T> ListNode<T> reverse(ListNode<T> list) {
		ListNode<T> ret = list;
		ListNode<T> tempHead = list.next;
		ret.next = null;
		while (tempHead != null) {
			ListNode<T> next = tempHead.next;
			tempHead.next = ret;
			ret = tempHead;
			tempHead = next;
		}
		return ret;
	}

	public static <T> boolean isMirror(ListNode<T> list) {
		Stack<ListNode<T>> stack = new Stack<ListNode<T>>();
		ListNode<T> runner = list;
		ListNode<T> fastRunner = list;
		while (fastRunner != null && fastRunner.next != null) {
			stack.push(runner);
			runner = runner.next;
			fastRunner = fastRunner.next.next;
		}
		if (fastRunner != null) {
			runner = runner.next;
		}
		System.out.println(runner);
		System.out.println(stack);
		while (runner != null) {
			if (!runner.data.equals(stack.pop().data))
				return false;
			runner = runner.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode<Integer> list = null;
		ListNode<Integer> head = list;
		ListNode<Integer> loop = null;
		ListNode<Integer> end = null;
		float d = 3 / 2;
		System.out.println(d);
		System.out.println(Math.ceil(d));
		int n = 5;
		int middle = n % 2 == 0 ? n / 2 : n / 2 + 1;
		boolean isEven = n % 2 == 0;
		for (int i = 1; i <= n; i++) {
			if (list == null) {
				list = new ListNode<Integer>(i);
				head = list;
			} else {
				int j = i;
				if (i > middle) {
					if (isEven)
						j = n - i + 1;
					else
						j = 2 * middle - i;
				}
				ListNode<Integer> temp = new ListNode<Integer>(j);
				head.next = temp;
				head = temp;
			}
		}

		System.out.println(list.printList());
		System.out.println(isMirror(list));
	}
}
