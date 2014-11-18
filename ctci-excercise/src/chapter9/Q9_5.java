package chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q9_5 {

	public static Set<String> combination(String s) {
		Set<String> ret = new HashSet<String>();
		if (s == null || s.isEmpty())
			return ret;
		if (s.length() == 1) {
			ret.add(s);
			return ret;
		}
		char c = s.charAt(0);
		s = s.substring(1);
		Set<String> previous = combination(s);
		for (String temp : previous) {
			for (int i = 0; i <= temp.length(); i++) {
				String s1 = temp.substring(0, i);
				String s2 = temp.substring(i);
				ret.add(s1 + c + s2);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(combination("abcc").size());
		System.out.println(combination("abcc"));
	}
}
