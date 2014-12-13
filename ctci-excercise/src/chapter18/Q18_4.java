package chapter18;

public class Q18_4 {

	public static int count(int number, int d) {
		int power10 = (int) Math.pow(10, d);
		int digit = number / power10 % 10;
		int right = number % power10;

		int nextPowerof10 = power10 * 10;

		int roundDown = number - number % nextPowerof10;
		int roundUp = roundDown + nextPowerof10;

		if (digit < 2) {
			return roundDown / 10;
		} else if (digit > 2) {
			return roundUp / 10;
		} else {
			return roundDown / 10 + right + 1;
		}

	}

	public static int count(int number) {
		int count = 0;
		String newNumber = String.valueOf(number);
		int length = newNumber.length();
		for (int digit = 0; digit < length; digit++) {
			count = count + count(number, digit);
		}
		return count;
	}

	public static void main(String[] args){
		System.out.println(count(2));
		System.out.println(count(1));
		System.out.println(count(10));
		System.out.println(count(61523));
	}
	
}
