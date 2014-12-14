package chapter2;

import java.util.HashMap;
import java.util.Map;

public class Q2_1 {

	public static <T> void removeDuplicate(ListNode<T> head) {
		Map<T, Object> map = new HashMap<T, Object>();
		map.put(head.data, new Object());
		ListNode<T> temp = head;
		while (temp.next != null) {
			ListNode<T> next = temp.next;
			T data = next.data;
			if (map.get(data) == null) {
				map.put(data, new Object());
				temp = temp.next;
			} else {
				temp.next = next.next;
			}
		}
	}

	public static <T> void removeDuplicate2(ListNode<T> head) {
		ListNode<T> current = head;
		while (current != null) {
			ListNode<T> runner = current;
			while (runner.next != null) {
				if (runner.next.data.equals(current.data)) {
					runner.next = runner.next.next;
				} else
					runner = runner.next;
			}
			current = current.next;
		}
	}

	public static <T> void removeDuplicate1(ListNode<T> head) {
		ListNode<T> temp = head.next;
		head.next = null;
		ListNode<T> tempHead = head;
		while (temp != null) {
			T data = temp.data;
			if (!dataExists(head, data)) {
				tempHead.next = temp;
				tempHead = temp;
				temp = temp.next;
				tempHead.next = null;
			} else
				temp = temp.next;
		}
	}

	public static <T> boolean dataExists(ListNode<T> head, T data) {
		ListNode<T> temp = head;
		while (temp != null) {
			if (temp.data.equals(data))
				return true;
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<Integer>(1);
		ListNode<Integer> head = list;
		for (int i = 0; i < 100; i++) {
			ListNode<Integer> temp = new ListNode<Integer>(i % 25);
			head.next = temp;
			head = temp;
		}
		System.out.println(list.printList());
		// removeDuplicate(list);
		removeDuplicate2(list);
		System.out.println(list.printList());
	}
}
