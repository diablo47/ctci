package chapter1;

import java.util.Arrays;

public class Q1_6 {

	public static void rolatile(int a[][], int n) {

		for (int i = 0; i < n; i++) {
			System.out.println("before " + Arrays.toString(a[i]));
		}

		int layer = n / 2;
		for (int offset = 0; offset < layer; offset++) {
			int length = n - 2 * offset;
			int max = n - offset - 1;
			System.out.println("level:" + offset);
			System.out.println("max value of the level:" + max);

			for (int j = offset; j < max; j++) {
				int temp = a[offset][j];
				a[offset][j] = a[max - j][offset];
				a[max - j][offset] = a[max][max - j];
				a[max][max - j] = a[j][max];
				a[j][max] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println("after " + Arrays.toString(a[i]));
		}

	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int more = 0;
		int la = a.length();
		int lb = b.length();
		int loop = Math.max(la, lb);
		for (int i = 0; i < loop; i++) {
			int tempa = getInt(a, la - i);
			int tempb = getInt(b, lb - i);
			int tempv = tempa + tempb + more;
			more = tempv / 2;
			sb.append(tempv % 2);
		}
		if(more!=0){
			sb.append(more);
		}
		return sb.reverse().toString();
	}

	static int getInt(String a, int number) {
		if (number > a.length() || number <= 0)
			return 0;
		else {
			char c = a.charAt(number - 1);
			if (c == '1')
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) {

		int[][] aha = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		rolatile(aha, 4);
		int[][] hoho = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 2, 3, 4, 5, 6 } };
		rolatile(hoho, 5);

		int a = '0';
		System.out.println(addBinary("11", "1"));
	}
}
