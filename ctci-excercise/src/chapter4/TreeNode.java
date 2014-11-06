package chapter4;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;

	public TreeNode() {

	}

	public TreeNode(TreeNode<T> left, TreeNode<T> right) {
		this.left = left;
		this.right = right;
	}

	public static <E> TreeNode<E> createFromList(List<E> list) {
		return createFromList(list, 0, list.size() - 1);
	}

	public String toString() {
		return data.toString();
	}

	private static <E> TreeNode<E> createFromList(List<E> list, int begin,
			int end) {
		if (end < begin)
			return null;
		int middle = (begin + end) / 2;
		TreeNode<E> ret = new TreeNode<E>();
		ret.data = list.get(middle);
		// if (middle - 1 >= begin)
		ret.left = createFromList(list, begin, middle - 1);
		if (ret.left != null)
			ret.left.parent = ret;
		// if (middle + 1 <= end)
		ret.right = createFromList(list, middle + 1, end);
		if (ret.right != null)
			ret.right.parent = ret;
		return ret;

	}

	public static int height(TreeNode<?> head) {
		if (head == null)
			return 0;
		else
			return Math.max(height(head.left), height(head.right)) + 1;

	}

	// 中序, visit left, then root, then right
	public static <E> String inOrder(TreeNode<E> head) {
		StringBuilder sb = new StringBuilder();
		if (head == null)
			return sb.toString();
		sb.append(inOrder(head.left));
		sb.append(head.data);
		sb.append(",");
		sb.append(inOrder(head.right));
		return sb.toString();

	}

	// 前序，visit root then left, then right
	public static <E> String preOrder(TreeNode<E> head) {
		StringBuilder sb = new StringBuilder();
		if (head == null)
			return sb.toString();
		sb.append(head.data);
		sb.append(",");
		sb.append(preOrder(head.left));
		sb.append(preOrder(head.right));
		return sb.toString();
	}

	// 后续，left, right, root
	public static <E> String postOrder(TreeNode<E> head) {
		StringBuilder sb = new StringBuilder();
		if (head == null)
			return sb.toString();
		sb.append(postOrder(head.left));
		sb.append(postOrder(head.right));
		sb.append(head.data);
		sb.append(",");
		return sb.toString();
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = createFromList(list);

		System.out.println(height(head));
		System.out.println(TreeNode.inOrder(head));
		System.out.println(TreeNode.preOrder(head));
		System.out.println(TreeNode.postOrder(head));
	}
}
