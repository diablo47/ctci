package chapter2;

public class Q2_6 {

	public static <T> ListNode<T> findLoopStart(ListNode<T> head) {
		ListNode<T> ret = null;
		ListNode<T> tempHead = head;

		ListNode<T> runner = head;
		ListNode<T> fastRunner = head;
		ListNode<T> joinPoint = null;
//		while (true) {
//			if (runner == runner.next)
//				return runner;
//			if (fastRunner.next == fastRunner)
//				return fastRunner;
//			runner = runner.next;
//			ListNode<T> fastNext = fastRunner.next;
//			if (fastNext == null)
//				return null;
//			if (fastNext.next == null)
//				return null;
//			if (fastNext.next == fastNext)
//				return fastNext;
//			fastRunner = fastNext.next;
//			if (runner == fastRunner) {
//				joinPoint = runner;
//				break;
//			}
//		}
		while (runner != null && fastRunner.next != null) {
			runner = runner.next;
			fastRunner = fastRunner.next.next;
			if (runner == fastRunner) {
				joinPoint = runner;
				break;
			}
		}
		System.out.println(joinPoint);
		while (tempHead != joinPoint) {
			tempHead = tempHead.next;
			joinPoint = joinPoint.next;
		}
		return tempHead;
	}

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<Integer>(1);
		ListNode<Integer> head = list;
		ListNode<Integer> loop = null;
		ListNode<Integer> end = null;

		int n = 100;
		for (int i = 2; i <= n; i++) {
			ListNode<Integer> temp = new ListNode<Integer>(i);
			head.next = temp;
			head = temp;
			if (i == n / 2)
				loop = temp;
			if (i == n) {
				end = temp;
			}
		}
		end.next = loop;
		System.out.println(findLoopStart(list).toString());
	}
}
