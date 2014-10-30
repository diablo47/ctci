package chapter2;

public class Q2_2 {

	public static <T> T findLastK(ListNode<T> list, int k) {
		ListNode<T> runner = list;
		ListNode<T> runnerk = list;
		for (int i = 0; i < k; i++) {
			runner = runner.next;
		}
		while (runner != null) {
			runner = runner.next;
			runnerk = runnerk.next;
		}
		return runnerk.data;
	}

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<Integer>(1);
		ListNode<Integer> head = list;
		for (int i = 2; i <= 100; i++) {
			ListNode<Integer> temp = new ListNode<Integer>(i);
			head.next = temp;
			head = temp;
		}
		System.out.println(list.printList());
		System.out.println(findLastK(list, 99));
	}

}
