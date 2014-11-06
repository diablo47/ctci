package chatper5;

public class Q5_6 {
	public static int moves(int n) {
		System.out.println("N: " + Integer.toBinaryString(n));
		int odd = 0xaaaaaaaa;
		int even = 0x55555555;
		int moveOddToEven = (n & odd) >> 1;
		int moveEvenToOdd = (n & even) << 1;
		return moveOddToEven | moveEvenToOdd;
	}

	public static void main(String[] args) {
		int n = Integer.valueOf("101010100", 2);
		int m = Integer.valueOf("10011", 2);
		System.out.println(Integer.toBinaryString(moves(n)));
	}
}
