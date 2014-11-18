package chapter11;

public class Q11_1 {

	public static void merge(int[] a, int[] b) {
		int end = a.length - 1;
		int endB = b.length - 1;
		int endA = end - endB - 1;
		while (endA >= 0 && endB >= 0) {
			if (a[endA] > b[endB]) {
				a[end] = a[endA];
				endA--;
			} else {
				a[end] = b[endB];
				endB--;
			}
			end--;
		}
		if (endB >= 0) {
			for (int i = 0; i <= endB; i++) {
				a[i] = b[i];
			}
		}
	}

	public static void print(int[] a) {
		for (int b : a) {
			System.out.print(b + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 6, 8, 10, 0, 0, 0, 0, 0 };
		int[] b = new int[] { 1, 3, 5, 7, 9 };
		print(a);
		merge(a, b);
		print(a);
	}
}
