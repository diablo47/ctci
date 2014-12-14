package chatper5;

public class Q5_3 {

	public static int findBig(int n) {
		System.out.println("N: " + Integer.toBinaryString(n));
		int tail0s = 0;
		int tail1s = 0;
		int temp = n;
		while ((temp & 1) == 0) {
			tail0s++;
			temp = temp >> 1;
		}
		while ((temp & 1) == 1) {
			tail1s++;
			temp = temp >> 1;
		}
		System.out.println("tail 0s:" + tail0s);
		System.out.println("tail 1s:" + tail1s);
		if (temp == 0)
			return -1;
		int change = tail0s + tail1s;
		n = n | 1 << change;
		n = n & ~((1 << change) - 1);
		n = n | ((1 << (tail1s - 1)) - 1);

		System.out.println("N: " + Integer.toBinaryString(n));
		return n;
	}

	public static int findSmall(int n) {
		System.out.println("N: " + Integer.toBinaryString(n));
		int tail0s = 0;
		int tail1s = 0;
		int temp = n;
		while ((temp & 1) == 1) {
			tail1s++;
			temp = temp >> 1;
		}
		if (temp == 0)
			return -1;
		while ((temp & 1) == 0) {
			tail0s++;
			temp = temp >> 1;
		}
		System.out.println("tail 0s:" + tail0s);
		System.out.println("tail 1s:" + tail1s);
		int change = tail0s + tail1s;
		n = n & ~((1 << (change + 1)) - 1);
		n = n | (((1 << (tail1s + 1)) - 1) << (tail0s - 1));

		System.out.println("N: " + Integer.toBinaryString(n));
		return n;
	}

	public static void main(String[] args) {
		int n = Integer.valueOf("10011110000011", 2);
		System.out.println(n);
		int m = Integer.valueOf("10011", 2);
		findBig(13948);
		findSmall(n);
		System.out.println(n);
	}

}
