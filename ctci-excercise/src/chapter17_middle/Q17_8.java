package chapter17_middle;

public class Q17_8 {

	public static void main(String[] args) {

//		int[] a = new int[] { 2, 3, -8, -1, 2, 4, -2, 3 };
		int[] a = new int[] {2, -8, 3, -2, 4, -10};

		int max = 0;
		int temp = 0;
		int start = 0, end = 0, tempStart = 0;
		for (int i = 0; i < a.length; i++) {
			temp = temp + a[i];
			if (temp > max) {
				max = temp;
				start = tempStart;
				end = i;
			}
			if (temp < 0) {
				tempStart = i + 1;
				temp = 0;
			}
		}
		System.out.println(max);
		System.out.println("start: " + start);
		System.out.println("end: " + end);
	}

}
