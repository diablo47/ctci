package chapter11;

public class Q11_3 {

	public static int find(int[] a, int start, int end, int n) {
		if (end < start)
			return -1;
		int mid = (end + start) / 2;
		int middle = a[mid];
		if (middle == n)
			return mid;
		if (middle < a[start]) { // turning point in the left
			if (n < middle || n >= a[start])
				return find(a, start, mid - 1, n);
			else
				return find(a, mid + 1, end, n);
		} else {
			if (n >= a[start] && n < middle)
				return find(a, start, mid - 1, n);
			else
				return find(a, mid + 1, end, n);
		}
//		else if (n > middle) {
//			if (middle < a[start]) {
//				if (n >= a[end])
//					return find(a, start, mid - 1, n);
//				else
//					return find(a, mid + 1, end, n);
//			} else
//				return find(a, mid + 1, end, n);
//		} else {
//			if (middle < a[start]) {
//				return find(a, start, mid - 1, n);
//			} else {
//				if (n >= a[start]) {
//					return find(a, start, mid - 1, n);
//				} else
//					return find(a, mid + 1, end, n);
//			}
//		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		System.out.println(find(a, 0, a.length - 1, 16));
	}
}
