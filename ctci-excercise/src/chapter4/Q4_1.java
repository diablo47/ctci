package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Q4_1 {

	public static boolean isBalance(TreeNode<?> head) {
		if (head == null)
			return true;
		if (isBalance(head.left) && isBalance(head.right))
			return Math.abs(TreeNode.height(head.left)
					- TreeNode.height(head.left)) <= 1;
		else
			return false;
	}

	public static boolean isBalance2(TreeNode<?> head) {
		return checkHeight(head) > -1;
	}

	public static int checkHeight(TreeNode<?> head) {
		if (head == null)
			return 0;
		int leftHeight = checkHeight(head.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(head.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		TreeNode<Integer> head = TreeNode.createFromList(list);

		System.out.println(TreeNode.height(head));
		System.out.println(isBalance(head));
		System.out.println(isBalance2(head));
	}

}
