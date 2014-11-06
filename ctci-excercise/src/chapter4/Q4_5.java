package chapter4;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class Q4_5 {

	public static int biggest = Integer.MIN_VALUE;

	public static <T extends Comparable<T>> boolean isBSTWrong(TreeNode<T> head) {
		boolean ret = true;
		if (head == null)
			return ret;
		if (head.left != null)
			ret = ret && head.data.compareTo(head.left.data) >= 0;
		if (head.right != null)
			ret = ret && head.data.compareTo(head.right.data) < 0;
		ret = ret && isBSTWrong(head.left);
		ret = ret && isBSTWrong(head.right);
		return ret;
	}

	public static boolean isBST(TreeNode<Integer> head) {
		if (head == null)
			return true;
		if (!isBST(head.left))
			return false;
		if (head.data <= biggest)
			return false;
		biggest = head.data;
		return isBST(head.right);
	}

	public static boolean isBST2(TreeNode<Integer> head) {
		return isBST2(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST2(TreeNode<Integer> head, int minValue,
			int maxValue) {
		if (head == null)
			return true;
		if (head.data >= maxValue || head.data < minValue)
			return false;
		if(!isBST2(head.left, minValue, head.data))
			return false;
		return isBST2(head.right, head.data, maxValue);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);

		System.out.println(TreeNode.inOrder(head));
		System.out.println(TreeNode.height(head));
		System.out.println(isBSTWrong(head));
		System.out.println(isBST(head));
		System.out.println(isBST2(head));
	}

	static class Temp<T> {
		public T t;
	}
}
