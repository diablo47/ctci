package chapter2;

public class ListNode<T> {

	public T data;

	public ListNode<T> next;

	public ListNode<T> previous;

	public ListNode(T t) {
		this.data = t;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public String printList() {
		StringBuilder sb = new StringBuilder();
		sb.append(data.toString());
		ListNode<T> temp = next;
		while (temp != null) {
			sb.append(" -> ");
			sb.append(temp.data.toString());
			temp = temp.next;
		}
		return sb.toString();
	}
}
