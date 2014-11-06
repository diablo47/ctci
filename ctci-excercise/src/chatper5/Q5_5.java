package chatper5;

public class Q5_5 {

	public static int moves(int n, int m) {
		System.out.println("N: " + Integer.toBinaryString(n));
		System.out.println("M: " + Integer.toBinaryString(m));

		int temp = m ^ n;
		int count = 0;
		while (temp != 0) {
			count += temp & 1;
			temp = temp >> 1;
		}
		return count;
	}

	public static int moves2(int n, int m) {
		System.out.println("N: " + Integer.toBinaryString(n));
		System.out.println("M: " + Integer.toBinaryString(m));

		int temp = m ^ n;
		int count = 0;
		while (temp != 0) {
			count++;
			temp = temp & (temp - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.valueOf("1000000000000", 2);
		int m = Integer.valueOf("10011", 2);
		System.out.println(moves(n, m));
		System.out.println(moves2(n, m));
	}

}
