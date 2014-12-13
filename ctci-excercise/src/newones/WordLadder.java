package newones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

	public static int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || start.length() == 0)
			return 0;
		if (end == null || end.length() == 0)
			return 0;

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(start);
		distanceQueue.add(1);
//		dict.add(end);
		while (!wordQueue.isEmpty()) {
			String currentWord = wordQueue.pop();
			Integer currentDistance = distanceQueue.pop();
			for (int i = 0; i < currentWord.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					String newWord = currentWord.substring(0, i) + c
							+ currentWord.substring(i + 1);
					if(newWord.equals(end))
						return currentDistance+1;
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currentDistance + 1);
						dict.remove(newWord);
					}
				}
			}

		}

		return 0;
	}

	public static void main(String[] args) {
//		String start = "hit";
//		String end = "cog";
//		Set<String> dict = new HashSet<String>();
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
		
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		System.out.println(ladderLength(start, end, dict));
	}
}
