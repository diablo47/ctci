package chapter9;

import java.util.HashMap;
import java.util.Map;

public class Q9_11 {

	public static int count(String express, int expected) {
		if (isUnit(express)) {
			int value = calculate(express);
			return value == expected ? 1 : 0;
		}

		int count = 0;
		for (int i = 1; i < express.length(); i += 2) {
			char operator = express.charAt(i);
			String left = express.substring(0, i);
			String right = express.substring(i + 1);
			if (expected == 1) {
				switch (operator) {
				case '&':
					count += count(left, 1) * count(right, 1);
					break;
				case '|':
					count += count(left, 1) * count(right, 1) + count(left, 1)
							* count(right, 0) + count(left, 0)
							* count(right, 1);
					break;
				case '^':
					count += count(left, 1) * count(right, 0) + count(left, 0)
							* count(right, 1);
					break;
				default:
					break;
				}
			} else {
				switch (operator) {
				case '&':
					count += count(left, 0) * count(right, 0) + count(left, 1)
							* count(right, 0) + count(left, 0)
							* count(right, 1);
					;
					break;
				case '|':
					count += count(left, 0) * count(right, 0);
					break;
				case '^':
					count += count(left, 1) * count(right, 1) + count(left, 0)
							* count(right, 0);
					break;
				default:
					break;
				}
			}
		}
		return count;
	}

	public static int countDp(String express, int expected,
			Map<String, Integer> cache) {
		int count = 0;
		if (cache.get(express) != null)
			return cache.get(express);
		if (isUnit(express)) {
			int value = calculate(express);
			count = value == expected ? 1 : 0;
			cache.put(express, count);
			return count;
		}

		for (int i = 1; i < express.length(); i += 2) {
			char operator = express.charAt(i);
			String left = express.substring(0, i);
			String right = express.substring(i + 1);
			if (expected == 1) {
				switch (operator) {
				case '&':
					count += count(left, 1) * count(right, 1);
					break;
				case '|':
					count += count(left, 1) * count(right, 1) + count(left, 1)
							* count(right, 0) + count(left, 0)
							* count(right, 1);
					break;
				case '^':
					count += count(left, 1) * count(right, 0) + count(left, 0)
							* count(right, 1);
					break;
				default:
					break;
				}
			} else {
				switch (operator) {
				case '&':
					count += count(left, 0) * count(right, 0) + count(left, 1)
							* count(right, 0) + count(left, 0)
							* count(right, 1);
					;
					break;
				case '|':
					count += count(left, 0) * count(right, 0);
					break;
				case '^':
					count += count(left, 1) * count(right, 1) + count(left, 0)
							* count(right, 0);
					break;
				default:
					break;
				}
			}
		}
		cache.put(express, count);
		return count;
	}

	public static boolean isUnit(String s) {
		if (s.length() == 1 || s.length() == 3)
			return true;
		else
			return false;
	}

	public static int calculate(String s) {
		if (s.length() == 1)
			return Integer.valueOf(s);
		else {
			int left = s.charAt(0) == '1' ? 1 : 0;
			int right = s.charAt(2) == '1' ? 1 : 0;
			char c = s.charAt(1);
			if (c == '|')
				return left | right;
			else if (c == '^')
				return left ^ right;
			else
				return left & right;
		}

	}

	public static void main(String[] args) {
		String terms = "0^0|1&1^1|0|1";
		boolean result = true;
		Map<String, Integer> cache = new HashMap<String, Integer>();
		System.out.println(count(terms, 1));
		System.out.println(countDp(terms, 1, cache));
		System.out.println(count("1&1", 1));
	}
}
