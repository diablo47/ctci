package newones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder2 {

	static Map<String, List<String>> map;
	static List<List<String>> results = new ArrayList<List<String>>();
	List<String> list;

	public static List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> ret = new ArrayList<List<String>>();
		if (start == null || start.length() == 0)
			return ret;
		if (end == null || end.length() == 0)
			return ret;

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		Map<String, Integer> steps = new HashMap<String, Integer>();
		dict.add(end);
		for (String s : dict) {
			steps.put(s, Integer.MAX_VALUE);
		}
		steps.put(start, 0);
		wordQueue.add(start);
		distanceQueue.add(1);

		map = new HashMap<String, List<String>>();
		int minStep = Integer.MAX_VALUE;
		while (!wordQueue.isEmpty()) {
			String currentWord = wordQueue.pop();
			Integer currentDistance = steps.get(currentWord) + 1;
			if (currentDistance > minStep)
				break;
			for (int i = 0; i < currentWord.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					String newWord = currentWord.substring(0, i) + c
							+ currentWord.substring(i + 1);

					if (dict.contains(newWord)) {
						if (currentDistance > steps.get(newWord)) {
							continue;
						} else if (currentDistance < steps.get(newWord)) {
							wordQueue.add(newWord);
							steps.put(newWord, currentDistance);
						}

						if (map.containsKey(newWord)) {
							map.get(newWord).add(currentWord);
						} else {
							List<String> temp = new LinkedList<String>();
							temp.add(currentWord);
							map.put(newWord, temp);
						}
						if (newWord.equals(end)) {
							minStep = currentDistance;
						}
					}
				}
			}

		}
		getResults(end, start, new LinkedList<String>());
		return results;
	}

	public static void getResults(String word, String start, List<String> path) {
		if (word.equals(start)) {
			path.add(0, start);
			results.add(new ArrayList<String>(path));
			path.remove(0);
			return;
		}
		path.add(0, word);
		List<String> currentNodes = map.get(word);
		if (currentNodes != null) {
			for (String node : currentNodes) {
				getResults(node, start, path);
			}
		}
		path.remove(0);
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		System.out.println(findLadders(start, end, dict));
	}
}
