package chapter17_middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {
	public int big;
	public int small;

}

public class Q17_6 {

	public static void get(List<Integer> list) {
		int m = 0, n = list.size() - 1;
		int v = list.get(0);
		while (m < n && v <= list.get(m)) {
			v = list.get(m);
			m++;
		}
		if (m == n) {
			System.out.println("m: " + m);
			System.out.println("n: " + n);
			return;
		}
		int vv = list.get(n);
		while (n >= m && vv >= list.get(n)) {
			vv = list.get(n);
			n--;
		}
		m--;
		n++;
		System.out.println("m: " + m);
		System.out.println("n: " + n);
		
		while (m > 0 && n < (list.size() - 1)) {
			Result result = findResult(list, m + 1, n - 1);
			boolean breakloop = true;
			if (list.get(m) > result.small) {
				m--;
				breakloop = false;
			}
			if (list.get(n) < result.big) {
				n++;
				breakloop = false;
			}
			if (breakloop)
				break;
		}
		System.out.println("m: " + m);
		System.out.println("n: " + n);
	}

	private static Result findResult(List<Integer> list, int i, int j) {
		Result ret = new Result();
		int big = list.get(i);
		int small = list.get(i);
		for (int k = i; k <= j; k++) {
			if (big < list.get(k))
				big = list.get(k);
			if (small > list.get(k))
				small = list.get(k);
		}
		ret.big = big;
		ret.small = small;
		return ret;
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 4, 7, 10, 11, 8, 12, 5, 7, 16, 18, 19 };
		List<Integer> list = Arrays.asList(array);
		get(list);
	}
}
