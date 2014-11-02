package chapter2;

import java.util.Stack;

class Result<T> {
	public ListNode<T> node;
	public boolean result;

	public Result() {
	}

	public Result(ListNode<T> t, boolean result) {
		this.node = t;
		this.result = result;
	}
}

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

	public static <T> Result<T> isMirror2(ListNode<T> list, int length) {
		Result<T> temp = null;
		if (list == null || length == 0) {
			return new Result(null, true);
		}
		if (length == 1) {
			temp = new Result<T>(list.next, true);
			return temp;
		}
		if (length == 2) {
			temp = new Result<T>();
			temp.node = list.next.next;
			temp.result = list.data.equals(list.next.data);
			return temp;
		}
		temp = isMirror2(list.next, length - 2);
		boolean compare = list.data.equals(temp.node.data);
		temp.result = compare && temp.result;
		temp.node = temp.node.next;
		return temp;
	}

	public static void main(String[] args) {
		ListNode<Integer> list = null;
		ListNode<Integer> head = list;
		ListNode<Integer> loop = null;
		ListNode<Integer> end = null;
		float d = 3 / 4;
		System.out.println(d);
		System.out.println(Math.ceil(d));
		int n = 99;
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
		System.out.println(isMirror2(list, n).result);
	}
}
