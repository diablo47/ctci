package chapter1;

public class Q1_2 {

	public static String reverse(String s) {
		char[] chars = s.toCharArray();
		int start = 0, end = chars.length - 1;
		while (start < end) {
			char temp = chars[start];
			chars[start++] = chars[end];
			chars[end--] = temp;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(reverse("hahea 3423"));

	}

}
