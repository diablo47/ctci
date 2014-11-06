package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Q4_9 {

	public static List<List<TreeNode<Integer>>> findPathes(
			TreeNode<Integer> root, int sum) {
		if (root == null)
			return new ArrayList<List<TreeNode<Integer>>>();
		List<TreeNode<Integer>> nodes = new ArrayList<TreeNode<Integer>>();
		List<List<TreeNode<Integer>>> pathes = new ArrayList<List<TreeNode<Integer>>>();
		findPathes(root, nodes, sum, pathes);
		pathes.addAll(findPathes(root.left, sum));
		pathes.addAll(findPathes(root.right, sum));
		return pathes;
	}

	public static void findPathes(TreeNode<Integer> root,
			List<TreeNode<Integer>> nodes, int sum,
			List<List<TreeNode<Integer>>> pathes) {
		if (root == null)
			return;

		nodes.add(root);
		if (sum(nodes) == sum) {
			// List<TreeNode<Integer>> temp = new ArrayList<TreeNode<Integer>>(
			// nodes);
			// pathes.add(temp);
			pathes.add(nodes);
		}
		findPathes(root.left, new ArrayList<TreeNode<Integer>>(nodes), sum,
				pathes);
		findPathes(root.right, new ArrayList<TreeNode<Integer>>(nodes), sum,
				pathes);
	}

	private static int sum(List<TreeNode<Integer>> nodes) {
		int ret = 0;
		for (TreeNode<Integer> temp : nodes) {
			ret += temp.data;
		}
		return ret;
	}

	public static void findSum(TreeNode<Integer> root, int sum, int[] path,
			int level) {
		if (root == null)
			return;
		path[level] = root.data;
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}
		findSum(root.left, sum, path, level + 1);
		findSum(root.right, sum, path, level + 1);
//		path[level] = Integer.MIN_VALUE;
	}

	private static void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + ", ");
		}
		System.out.println();
	}

	public static void findSum(TreeNode<Integer> root, int sum) {
		int depth = TreeNode.height(root);
		int[] path = new int[depth];
		findSum(root, sum, path, 0);
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
		System.out.println(findPathes(head, 19));
		findSum(head, 19);
	}
}
