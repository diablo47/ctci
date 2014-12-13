package chapter17_middle;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {

	public DictionaryNode head;

	public boolean isWordPrefix(String word) {
		boolean ret = true;
		DictionaryNode start = head;
		for (char cc : word.toCharArray()) {
			if (start.chilrens.containsKey(cc)) {
				start = start.chilrens.get(cc);
			} else
				return false;

		}
		return ret;
	}

	public boolean isWord(String word) {
		DictionaryNode start = head;
		for (char cc : word.toCharArray()) {
			if (start.chilrens.containsKey(cc)) {
				start = start.chilrens.get(cc);
			} else
				return false;

		}
		return start.isWord;
	}

	public static Dictionary build(Collection<String> words) {
		Dictionary ret = new Dictionary();
		DictionaryNode head = new DictionaryNode();
		head.chilrens = new TreeMap<Character, Dictionary.DictionaryNode>();
		ret.head = head;
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
		return ret;
	}

	static class DictionaryNode {
		public Character c;
		boolean isWord;
		public Map<Character, DictionaryNode> chilrens;
	}

	public static void main(String[] args) {
		Set<String> data = new HashSet<String>();
		data.add("cat");
		data.add("cats");
		data.add("and");
		data.add("sand");
		data.add("dog");

		Dictionary dic = Dictionary.build(data);
		System.out.println(dic.isWordPrefix("ca"));
		System.out.println(dic.isWord("cat"));
		System.out.println(dic.isWord("cats"));
		System.out.println(dic.isWordPrefix("cats1"));
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
