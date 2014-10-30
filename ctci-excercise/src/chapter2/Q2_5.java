package chapter2;

import java.io.ObjectInputStream.GetField;

public class Q2_5 {

	public static ListNode<Integer> add(ListNode<Integer> l1,
			ListNode<Integer> l2) {
		ListNode<Integer> ret = null;
		ListNode<Integer> temp = null;
		int up = 0;
		while (l1 != null || l2 != null) {
			int v1 = getValue(l1);
			int v2 = getValue(l2);
			int addValue = v1 + v2 + up;
			up = addValue / 10;
			ListNode<Integer> tempNode = new ListNode<Integer>(addValue % 10);
			if (ret == null) {
				ret = tempNode;
				temp = tempNode;
			} else {
				temp.next = tempNode;
				temp = tempNode;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (up != 0) {
			ListNode<Integer> tempNode = new ListNode<Integer>(up);
			temp.next = tempNode;
		}
		return ret;
	}

	public static Integer getValue(ListNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return node.data;
	}

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<Integer>(1);
		ListNode<Integer> head = list;
		ListNode<Integer> list2 = new ListNode<Integer>(1);
		ListNode<Integer> head2 = list2;
		for (int i = 20; i > 0; i--) {
			ListNode<Integer> temp = new ListNode<Integer>(i);
			head.next = temp;
			head = temp;

			ListNode<Integer> temp2 = new ListNode<Integer>(i);
			head2.next = temp2;
			head2 = temp2;
		}
		System.out.println(list.printList());
		System.out.println(list2.printList());
		System.out.println(add(list, list2).printList());

	}

}
