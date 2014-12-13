package newones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordLetter2 {
	public List<String> wordBreak(String s, Set<String> dict) {
		if (s == null || s.isEmpty())
			return new ArrayList<String>();
		Dictionary myDictionary = new Dictionary(dict);
		List<Deque<String>> data = recover(s, myDictionary);
		List<String> ret = new ArrayList<>();
		for (Deque<String> d : data) {
			if (!d.isEmpty()) {
				StringBuilder builder = new StringBuilder();
				for (String sub : d) {
					builder.append(sub).append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				ret.add(builder.toString());
			}
		}
		return ret;
	}

	private List<Deque<String>> recover(String input, Dictionary myDictionary) {
		Map<Integer, List<Deque<String>>> cache = new HashMap<Integer, List<Deque<String>>>();
		return recover(input, 0, myDictionary, cache);
	}

	private List<Deque<String>> recover(String input, int startPosition,
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
		cache.put(startPosition, ret);
		return ret;
	}

	static class Dictionary {

		public DictionaryNode head;

		public Dictionary(Collection<String> words) {
			DictionaryNode head = new DictionaryNode();
			head.chilrens = new HashMap<Character, Dictionary.DictionaryNode>();
			this.head = head;
			for (String word : words) {
				DictionaryNode start = head;
				for (char cc : word.toCharArray()) {
					DictionaryNode children = start.chilrens.get(cc);
					if (children == null) {
						children = new DictionaryNode();
						children.c = cc;
						children.chilrens = new TreeMap<Character, DictionaryNode>();
						start.chilrens.put(cc, children);
					}
					start = children;
				}
				start.isWord = true;
			}
		}

		static class DictionaryNode {
			public Character c;
			boolean isWord;
			public Map<Character, DictionaryNode> chilrens;
		}

		public boolean isWordPrefix(String input, int startPosition, int end) {
			boolean ret = true;
			DictionaryNode startNode = head;
			for (int s = startPosition; s <= end; s++) {
				Character cc = input.charAt(s);
				if (startNode.chilrens.containsKey(cc)) {
					startNode = startNode.chilrens.get(cc);
				} else
					return false;

			}
			return ret;
		}

		public boolean isWord(String input, int startPosition, int end) {
			DictionaryNode startNode = head;
			for (int s = startPosition; s <= end; s++) {
				Character cc = input.charAt(s);
				if (startNode.chilrens.containsKey(cc)) {
					startNode = startNode.chilrens.get(cc);
				} else
					return false;

			}
			return startNode.isWord;
		}

	}
}
