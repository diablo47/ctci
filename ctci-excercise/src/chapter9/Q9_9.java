package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q9_9 {

	public static void queen(List<List<Integer>> results, int[] path,
			int level, int max) {
		if (level == max) {
			List<Integer> temp = new ArrayList<Integer>(8);
			for (int i = 0; i < max; i++) {
				temp.add(i, path[i]);
			}
			results.add(temp);
		}
		for (int i = 0; i < max; i++) {
			boolean valide = true;
			for (int j = 0; j < level; j++) {
				valide = valide && (path[j] != i)
						&& ((level - j) != Math.abs((i - path[j])));
			}
			if (valide) {
				path[level] = i;
				queen(results, path, level + 1, max);
			}
		}
	}

	public static void main(String[] args) {
		int n = 8;
		int[] path = new int[8];
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		queen(results, path, 0, 8);
		System.out.println(results.size());
		for (List<Integer> result : results)
			System.out.println(result);
	}
}
