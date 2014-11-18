package chapter18;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Q18_6 {
	public static int find(int[] a, int start, int end, int n) {
		Random ran = new Random(System.currentTimeMillis());
		int random = start + ran.nextInt(end - start);
		int privot = a[random];
		int position = partition(a, start, end, privot);
		int leftSize = position - start + 1;
		if (leftSize == n)
			return position;
		else if (leftSize > n) {
			return find(a, start, position, n);
		} else {
			return find(a, position + 1, end, n - leftSize);
		}
	}

	private static int partition(int[] a, int start, int end, int privot) {
		int s = start, e = end;
		while (true) {
			while (s <= e && a[s] <= privot) {
				s++;
			}
			while (s <= e && a[e] > privot) {
				e--;
			}
			if (s > e) {
				return s - 1;
			}
			int temp = a[s];
			a[s] = a[e];
			a[e] = temp;
		}

	}

	public static void print(int[] a) {
		for (int b : a) {
			System.out.print(b + ", ");
		}
		System.out.println();
	}

	public static void print(int[] a, int end) {
		for (int i = 0; i <= end; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}

	public static void usingHeap(int a[], int n) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n,
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return 0 - o1.compareTo(o2);
					}
				});
		for (int i : a) {
			if (queue.size() == n) {
				if (i < queue.peek()) {
					queue.poll();
					queue.add(i);
				}
			} else {
				queue.add(i);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(queue.poll() + ",");
		}
	}

	public static void main(String[] args) {
		int n = 10000000;
		int m = 100;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = n - i;
		}
		int end = find(a, 0, n - 1, m);
		print(a, end);
		System.out.println();
		usingHeap(a, m);
	}
}
