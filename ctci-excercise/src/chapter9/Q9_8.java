package chapter9;

public class Q9_8 {
	
	
	
	public static void main(String[] args) {
		int n = 100;
		int ways = 0;
		for (int no25 = n / 25; no25 >= 0; no25--) {
			int firstRemain = n - no25 * 25;
			for (int no10 = firstRemain / 10; no10 >= 0; no10--) {
				int secondRemain = firstRemain - no10 * 10;
				ways += secondRemain / 5 + 1;
			}
		}
		System.out.println(ways);
	}
}
