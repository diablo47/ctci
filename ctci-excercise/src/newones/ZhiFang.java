package newones;

import java.util.Stack;

public class ZhiFang {

	public static int fintBiggest(int[] a) {
		int ret = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int leftIndex, max = a[0];
		int length = a.length;
		int start = 0, end = 0;
		stack.push(0);
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[stack.peek()]) {
				stack.push(i);
			} else {
				int current = a[i];
				while (!stack.isEmpty() && a[stack.peek()] > current) {
					int tempIndex = stack.pop();
					if (stack.isEmpty()) {
						int temp = a[tempIndex] * i;
						if (max < temp) {
							start = 0;
							end = i - 1;
							max = temp;
						}
					} else {
						int temp = a[tempIndex] * (i - stack.peek() - 1);
						if (max < temp) {
							start = tempIndex;
							end = i - 1;
							max = temp;
						}
					}
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int tempIndex = stack.pop();
			if (stack.isEmpty()) {
				int temp = a[tempIndex] * length;
				if (max < temp) {
					start = 0;
					end = length - 1;
					max = temp;
				}
			} else {
				int temp = a[tempIndex] * (length - stack.peek() - 1);
				if (max < temp) {
					start = tempIndex;
					end = length - 1;
					max = temp;
				}
			}
		}
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		return max;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 1, 5, 6, 2, 3, };
		// int[] a = new int[] { 2, 1, 1 };
		System.out.println(fintBiggest(a));
	}

	public int maxProduct(int A[]) {
		int n = A.length;
		if (n == 0) {
			return 0;
		}

		// store the result that is the max we have found so far
		int r = A[0];

		// imax/imin stores the max/min product of
		// subarray that ends with the current number A[i]
		for (int i = 1, imax = r, imin = r; i < n; i++) {
			// multiplied by a negative makes big number smaller, small number
			// bigger
			// so we redefine the extremums by swapping them
			if (A[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			// max/min product for the current number is either the current
			// number itself
			// or the max/min by the previous number times the current one
			imax = Math.max(A[i], imax * A[i]);
			imin = Math.min(A[i], imin * A[i]);

			// the newly computed max value is a candidate for our global result
			r = Math.max(r, imax);
		}
		return r;
	}

}
