package chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q9_6 {

	public static Set<String> funny(int n) {
		Set<String> ret = new HashSet<String>();
		if (n == 0)
			return ret;
		if (n == 1)
			ret.add("()");
		Set<String> previous = funny(n - 1);
		for (String s : previous) {
			for (int i = 0; i < s.length(); i++) {
				ret.add(s.substring(0, i) + "()" + s.substring(i));
			}
		}
		return ret;
	}

	public static Collection<String> funny2(int n) {
		Collection<String> result = new HashSet<String>();
		char[] temp = new char[2 * n];
		funny2(result, n, n, temp, 0);
		return result;
	}

	public static void funny2(Collection<String> result, int left, int right,
			char[] temp, int index) {
		if (left < 0 || right < left)
			return;
		if (left == 0 && right == 0) {
			result.add(new String(temp));
		}
		if (left > 0) {
			temp[index] = '(';
			funny2(result, left - 1, right, temp, index + 1);
		}
		if (right > left) {
			temp[index] = ')';
			funny2(result, left, right - 1, temp, index + 1);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(funny(n));
		System.out.println(funny2(n));
	}

}
