package chapter9;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q9_4 {

	public static List<List<String>> getAll(List<String> set) {
		List<List<String>> ret;
		ret = new ArrayList<List<String>>();
		if (set.isEmpty()) {
			ret.add(new ArrayList<String>());
			return ret;
		}
		String s = set.get(set.size() - 1);
		set.remove(set.size() - 1);
		List<List<String>> previous = getAll(set);
		for (List<String> previousone : previous) {
			List<String> thisone = new ArrayList<String>(previousone);
			thisone.add(s);
			ret.add(thisone);
		}
		ret.addAll(previous);
		return ret;
	}

	public static List<List<String>> getAll2(List<String> set) {
		List<List<String>> ret;
		ret = new ArrayList<List<String>>();
		int a = set.size();

		int temp = (1 << a) - 1;
		while (temp >= 0) {
			List<String> thisone = new ArrayList<String>();
			int innderTemp = temp;
			int index = 0;
			while (innderTemp > 0) {
				if ((innderTemp & 1) == 1) {
					thisone.add(set.get(index));
				}
				innderTemp = innderTemp >> 1;
				index++;
			}
			ret.add(thisone);
			temp = temp - 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.asList("a1", "a2", "a3"));
		System.out.println(getAll(new ArrayList<String>(Arrays.asList("a1",
				"a2", "a3", "a4"))));
		System.out.println(getAll2(new ArrayList<String>(Arrays.asList("a1",
				"a2", "a3", "a4"))));
	}

}
