package chapter17_middle;

public class Q17_7 {

	static String[] numberToString = new String[] { "one", "two", "three",
			"four", "five", "six", "seven", "eight", "nine", "ten" };
	static String[] tens = new String[] { "ten", "twenty", "thirty", "fourty",
			"fifty", "sixty", "seventy", "eighty", "nighty" };

	static String[] teens = new String[] { "eleven", "twelve", "thirteen",
			"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nighteen" };

	static String[] up = new String[] { "thourand", "million", "billion" };

	public static String count(int a) {
		String ret = new String();

		int steps = 0;

		while (a > 0) {
			int temp = a % 1000;
			String tempCount = count100(temp);

			if (steps > 0) {
				ret = tempCount + up[steps - 1] + ", " + ret;
			} else {
				ret = tempCount;
			}
			steps++;
			a = a / 1000;
		}

		return ret;
	}

	private static String count100(int temp) {
		StringBuilder sb = new StringBuilder();
		int h = temp / 100;
		if (h > 0)
			sb.append(numberToString[h - 1]).append(" hundred ");
		int ten = temp % 100;
		if (ten >= 11 && ten <= 19) {
			sb.append(teens[ten % 10 - 1]).append(" ");
		} else {
			sb.append(tens[ten / 10]).append(" ");
			if (ten % 10 > 1) {
				sb.append(numberToString[ten % 10 - 1]).append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(count(19323948));
	}
}
