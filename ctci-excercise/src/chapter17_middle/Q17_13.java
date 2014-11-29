package chapter17_middle;

import java.util.ArrayList;
import java.util.List;

import chapter4.TreeNode;

public class Q17_13 {

	public static <T> TreeNode<T> toList(TreeNode<T> head) {

		if (head == null)
			return null;

		TreeNode<T> left = toList(head.left);
		TreeNode<T> right = toList(head.right);
		TreeNode<T> ret = merge(left, head, right);
		return ret;
	}

	public static <T> TreeNode<T> merge(TreeNode<T> left, TreeNode<T> middle,
			TreeNode<T> right) {
		TreeNode<T> ret = left;
		if (left == null) {
			ret = middle;
		} else {
			TreeNode<T> temp = left;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = middle;
			middle.left = temp;
		}
		if (right != null) {
			middle.right = right;
			right.left = middle;
		}
		return ret;
	}

	public static <T> TreeNode<T> toList2(TreeNode<T> head) {
		if (head == null)
			return null;
		TreeNode<T> ret ;
		TreeNode<T> left = toList2(head.left);
		TreeNode<T> right = toList2(head.right);
		if (left == null && right == null) {
			head.left = head;
			return head;
		}
		if (left != null) { // left buweikong
			TreeNode<T> tail = left.left;
			head.left = tail;
			tail.right = head;

			left.left = head;
			ret = left;
		} else {
			ret  = head;
		}
		if (right != null) {
			TreeNode<T> tail = right.left;
			head.right = right;
			right.left = head;
			
			ret.left = tail;
		}

		return ret;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);
		System.out.println(TreeNode.preOrder(head));
		System.out.println(TreeNode.height(head));
//		TreeNode<Integer> result = toList(head);
		TreeNode<Integer> result2 = toList2(head);
		head.left = null;
		System.out.println(result2);
	}

}
