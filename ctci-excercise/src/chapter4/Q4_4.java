package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q4_4 {

	public static <T> List<List<TreeNode<T>>> levelTravasal(TreeNode<T> head) {
		List<List<TreeNode<T>>> ret = new ArrayList<List<TreeNode<T>>>();
		Queue<TreeNode<T>> one = new LinkedList<TreeNode<T>>();
		Queue<TreeNode<T>> two = new LinkedList<TreeNode<T>>();
		one.add(head);

		Queue<TreeNode<T>> currentLevel = one;
		Queue<TreeNode<T>> nextLevel = two;
		Queue<TreeNode<T>> temp;
		while (!currentLevel.isEmpty()) {
			List<TreeNode<T>> first = new ArrayList<TreeNode<T>>();
			while (!currentLevel.isEmpty()) {
				TreeNode<T> current = currentLevel.poll();
				first.add(current);
				if (current.left != null)
					nextLevel.add(current.left);
				if (current.right != null)
					nextLevel.add(current.right);
			}
			ret.add(first);
			temp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = temp;
		}

		return ret;
	}

	public static <T> List<List<TreeNode<T>>> levelTravasal2(TreeNode<T> head) {
		List<List<TreeNode<T>>> ret = new ArrayList<List<TreeNode<T>>>();
		ret.add(0, new ArrayList<TreeNode<T>>());
		return levelTravasal2(ret, head, 0);
	}

	public static <T> List<List<TreeNode<T>>> levelTravasal2(
			List<List<TreeNode<T>>> lists, TreeNode<T> head, int level) {
		if (head == null)
			return lists;
		List<TreeNode<T>> currentLevel = null;
		try {
			currentLevel = lists.get(level);
		} catch (Exception e) {

		}
		if (currentLevel == null) {
			currentLevel = new ArrayList<TreeNode<T>>();
			lists.add(level, currentLevel);
		}
		currentLevel.add(head);
		levelTravasal2(lists, head.left, level + 1);
		levelTravasal2(lists, head.right, level + 1);
		return lists;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);

		System.out.println(TreeNode.inOrder(head));
		System.out.println(TreeNode.height(head));
		System.out.println(levelTravasal(head));
		System.out.println(levelTravasal2(head));
	}

}
