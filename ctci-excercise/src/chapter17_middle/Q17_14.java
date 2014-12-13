package chapter17_middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q17_14 {

	public static List<String> recover(String input, Set<String> dictionary) {
		Dictionary myDictionary = Dictionary.build(dictionary);
		List<Deque<String>> data = recover(input, myDictionary);
		List<String> ret = new ArrayList<>();
		for (Deque<String> d : data) {
			if (!d.isEmpty()) {
				StringBuilder builder = new StringBuilder();
				for (String s : d) {
					builder.append(s).append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				ret.add(builder.toString());
			}
		}
		return ret;
	}

	private static List<Deque<String>> recover(String input,
			Dictionary myDictionary) {
		Map<Integer, List<Deque<String>>> cache = new HashMap<Integer, List<Deque<String>>>();
		return recover(input, 0, myDictionary, cache);
	}

	private static List<Deque<String>> recover(String input, int startPosition,
			Dictionary myDictionary, Map<Integer, List<Deque<String>>> cache) {
		List<Deque<String>> ret = new ArrayList<Deque<String>>();
		if (startPosition == input.length()) {
			ret.add(new LinkedList<String>());
		}
		if (cache.get(startPosition) != null) {
			return cache.get(startPosition);
		}
		for (int end = startPosition; end < input.length(); end++) {
			if (myDictionary.isWordPrefix(input, startPosition, end)) {
				if (myDictionary.isWord(input, startPosition, end)) {
					String newWord = input.substring(startPosition, end + 1);
					List<Deque<String>> tempResults = recover(input, end + 1,
							myDictionary, cache);
					if (!tempResults.isEmpty()) {
						for (Deque<String> tempResult : tempResults) {
							LinkedList<String> newList = new LinkedList<String>(
									tempResult);
							newList.addFirst(newWord);
							ret.add(newList);
						}
					}
				}
			} else {
				break;
			}
		}
		// List<Deque<String>> cacheObjects = new ArrayList<Deque<String>>();
		// for (Deque<String> data : ret) {
		// cacheObjects.add(new LinkedList<String>(data));
		// }
		cache.put(startPosition, ret);
		return ret;
	}

	public static void main(String[] args) {
		Set<String> data = new HashSet<String>();
		data.add("cat");
		data.add("cats");
		data.add("and");
		data.add("sand");
		data.add("dog");

		List<String> ret = recover("catsanddog", data);
		System.out.println(ret);

	}

}
