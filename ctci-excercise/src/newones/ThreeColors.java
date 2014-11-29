package newones;

import java.util.Arrays;

public class ThreeColors {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1, 1, 2, 1 };

		int c = 0, zero = 0, two = a.length - 1;
		while (c <=two) {
			if (a[c] == 0) {
				a[c] = a[zero];
				a[zero] = 0;
				zero++;
				c++;
			} else if (a[c] == 2) {
				a[c] = a[two];
				a[two] = 2;
				two--;
			} else{
				c++;
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
