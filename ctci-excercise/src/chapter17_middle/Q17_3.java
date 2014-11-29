package chapter17_middle;

public class Q17_3 {

	public static void main(String[] args) {

		int n = 100;
		int count = 0;
		for (int i = 5; i <= n; i++) {
			count += count5(i);
		}
		System.out.println("count: " + count);
		int count2 = 0;
		for (int i = 5; i <= n; i = i * 5) {
			count2 += n / i;
		}
		System.out.println("count2: " + count2);
	}

	public static int count5(int n) {
		int ret = 0;
		while (n % 5 == 0) {
			ret++;
			n = n / 5;
		}
		return ret;
	}
}
