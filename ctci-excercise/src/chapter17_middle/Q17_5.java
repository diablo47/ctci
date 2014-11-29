package chapter17_middle;

public class Q17_5 {

	public static void count(char[] check, char[] input) {

		int hits = 0;
		int fakeHits = 0;
		int[] counts = new int[4];
		int[] countsInput = new int[4];
		for (int i = 0; i < 4; i++) {
			if (check[i] == input[i])
				hits++;
			else {
				counts[code(check[i])]++;
				countsInput[code(input[i])]++;
			}
		}
		for (int i = 0; i < 4; i++) {
			fakeHits += Math.min(counts[i], countsInput[i]);
		}

		System.out.println("hits: " + hits);
		System.out.println("fakeHits: " + fakeHits);

	}

	public static int code(char c) {
		switch (c) {
		case 'R':
			return 0;
		case 'Y':
			return 1;
		case 'G':
			return 2;
		case 'B':
			return 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		String a = "RGBY";
		String b = "YGRR";

		count(a.toCharArray(), b.toCharArray());
	}
}
