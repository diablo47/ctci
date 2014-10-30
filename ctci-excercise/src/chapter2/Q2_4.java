package chapter2;

public class Q2_4 {

	public static <T extends Comparable<T>> ListNode<T> smallBig(
			ListNode<T> head, T t) {

		ListNode<T> sh = null;
		ListNode<T> se = null;

		ListNode<T> bh = null;
		ListNode<T> be = null;

		ListNode<T> temp = head;

		while (temp != null) {
			T data = temp.data;
			ListNode<T> next = temp.next;
			temp.next = null;
			if (data.compareTo(t) < 0) {
				if (sh == null) {
					sh = temp;
					se = temp;
				} else {
					se.next = temp;
					se = temp;
				}
			} else {
				if (bh == null) {
					bh = temp;
					be = temp;
				} else {
					be.next = temp;
					be = temp;
				}
			}
			temp = next;
		}
		se.next = bh;
		// be.next = null;
		return sh;

	}

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<Integer>(1);
		ListNode<Integer> head = list;
		for (int i = 20; i >= 0; i--) {
			ListNode<Integer> temp = new ListNode<Integer>(i % 25);
			head.next = temp;
			head = temp;
		}
		System.out.println(list.printList());
		System.out.println(smallBig(list, 10).printList());
	}

}
