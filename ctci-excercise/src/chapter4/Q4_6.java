package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Q4_6 {

	public static <T> TreeNode<T> findNext(TreeNode<T> node) {
		if (node.right != null) {
			return findLeftChildren(node.right);
		}
		TreeNode<T> parent = node.parent;
		TreeNode<T> current = node;
		while (parent != null && parent.left != current) {
			current = parent;
			parent = parent.parent;
		}
		return parent;
	}

	public static <T> TreeNode<T> findLeftChildren(TreeNode<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);

		System.out.println(TreeNode.inOrder(head));
		System.out.println(TreeNode.height(head));
		System.out.println(findNext(head.left.right));
		System.out.println(findNext(head.right.left));
		System.out.println(findNext(head.right.right.right));
	}
}
