package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Q4_7 {

	public static <T> TreeNode<T> findAncester(TreeNode<T> root, TreeNode<T> p,
			TreeNode<T> q) {
		if (root == null)
			return null;
		if (root == q && root == q)
			return root;

		TreeNode<T> left = findAncester(root.left, p, q);
		if (left != null && left != p && left != q) {
			return left;
		}

		TreeNode<T> right = findAncester(root.right, p, q);
		if (right != null && right != p && right != q) {
			return right;
		}

		if (left != null && right != null)
			return root;
		else if (root == p || root == q)
			return root;
		else {
			return left == null ? right : left;
		}

	}

	public static <T> TreeNode<T> findAncester2(TreeNode<T> root,
			TreeNode<T> p, TreeNode<T> q) {
		if (root == null)
			return null;
		if (root == q && root == p)
			return root;
		TreeNode<T> left = findAncester(root.left, p, q);
		if (left != null && left != q && left != p) {
			return left;
		}

		TreeNode<T> right = findAncester(root.right, p, q);
		if (right != null && right != p && right != q) {
			return right;
		}
		if (left != null && right != null)
			return root;
		else if (root == q || root == q) {
			return root;
		} else
			return left == null ? right : left;
	}

	public static <T> boolean covers(TreeNode<T> root, TreeNode<T> p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		else
			return covers(root.left, p) || covers(root.right, p);
	}

	public static <T> TreeNode<T> findAncester3(TreeNode<T> root,
			TreeNode<T> p, TreeNode<T> q) {
		if (root == null)
			return null;
		if (root == p && root == q)
			return root;
		boolean pOnLeft = covers(root.left, p);
		boolean qOnRight = covers(root.left, q);
		if (pOnLeft != qOnRight)
			return root;
		TreeNode<T> next = pOnLeft ? root.left : root.right;
		return findAncester3(next, p, q);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		TreeNode<Integer> p = null;
		TreeNode<Integer> q = null;
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);

		System.out.println(TreeNode.inOrder(head));
		System.out.println(TreeNode.height(head));
		System.out.println(findAncester3(head, head.right.left,
				head.right.right.right));
	}
}
