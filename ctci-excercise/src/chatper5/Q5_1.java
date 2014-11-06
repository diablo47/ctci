package chatper5;

public class Q5_1 {

	public static int replace(int n, int m, int i, int j) {
		System.out.println("N: " + Integer.toBinaryString(n));
		System.out.println("M: " + Integer.toBinaryString(m));
		int k = j - i + 1;
		int ones = 1 << k;
		ones = ones - 1;
		ones = ~ones;
		n = n & ones;
		n = n | m << i;
		System.out.println("N: " + Integer.toBinaryString(n));
		return n;
	}

	public static void main(String[] args) {
		int n = Integer.valueOf("1000000000000", 2);
		int m = Integer.valueOf("10011", 2);
		replace(n, m, 2, 6);
	}

}
