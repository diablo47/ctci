package chatper5;

public class Bits {

	public static int clear(int x, int i) {
		System.out.println("before clear: " + Integer.toBinaryString(x));
		x = x & ~(1 << i);
		System.out.println("after  clear: " + Integer.toBinaryString(x));
		return x;
	}

	public static int get(int x, int i) {
		System.out.println("before get: " + Integer.toBinaryString(x));
		x = x & (1 << i);
		return x != 0 ? 1 : 0;
	}

	public static int set(int x, int i, int value) {
		System.out.println("before set: " + Integer.toBinaryString(x));
		x = x | (1 << i);
		System.out.println("after  set: " + Integer.toBinaryString(x));
		return x;
	}

	public static int setZeroBefore(int x, int i) {
		System.out.println("before set: " + Integer.toBinaryString(x));
		x = x & ((1 << i) - 1);
		System.out.println("after  set: " + Integer.toBinaryString(x));
		return x;
	}
	
	public static int setZeroAfter(int x, int i) {
		System.out.println("before set: " + Integer.toBinaryString(x));
		x = x & ~((1 << (i+1)) - 1);
		System.out.println("after  set: " + Integer.toBinaryString(x));
		return x;
	}

	public static void main(String[] args) {
		System.out.println(get(1234, 4));
		clear(1234, 4);
		set(1234, 3, 0);
		setZeroBefore(1234, 6);
		setZeroAfter(1234, 6);
	}
}
