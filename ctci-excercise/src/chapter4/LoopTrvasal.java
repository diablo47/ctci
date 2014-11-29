package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LoopTrvasal {

	public static <T> List<TreeNode<T>> inOrderLoop(TreeNode<T> head) {
		List<TreeNode<T>> ret = new ArrayList<TreeNode<T>>();
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> temp = head;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			if (!stack.isEmpty()) {
				temp = stack.pop();
				ret.add(temp);
				temp = temp.right;
			}
		}
		return ret;
	}

	public static <T> List<TreeNode<T>> preOrderLoop(TreeNode<T> head) {
		List<TreeNode<T>> ret = new ArrayList<TreeNode<T>>();
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> temp = head;
		stack.push(head);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			ret.add(temp);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		return ret;
	}

	public static <T> List<TreeNode<T>> postOrderLoop(TreeNode<T> head) {
		List<TreeNode<T>> ret = new ArrayList<TreeNode<T>>();
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> previous = null;
		TreeNode<T> temp = null;
		stack.push(head);
		while (!stack.isEmpty()) {
			temp = stack.peek();
			if ((temp.left == null && temp.right == null)
					|| (previous != null && (previous == temp.left || previous == temp.right))) {
				temp = stack.pop();
				ret.add(temp);
				previous = temp;
			} else {

				if (temp.right != null)
					stack.push(temp.right);
				if (temp.left != null)
					stack.push(temp.left);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);
		System.out.println(TreeNode.inOrder(head));
		System.out.println(inOrderLoop(head));

		System.out.println(TreeNode.preOrder(head));
		System.out.println(preOrderLoop(head));

		System.out.println(TreeNode.postOrder(head));
		System.out.println(postOrderLoop(head));

	}

}
