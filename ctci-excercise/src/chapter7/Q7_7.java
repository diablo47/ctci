package chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_7 {

	public static Integer find(int q) {
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		q3.add(3);
		q5.add(5);
		q7.add(7);
		Integer min = 1;
		for (int i = 1; i <= q; i++) {
			Integer v3 = q3.peek();
			Integer v5 = q5.peek();
			Integer v7 = q7.peek();
			min = Math.min(v3, Math.min(v5, v7));
			if (min.equals(v3)) {
				q3.remove();
				q3.add(3 * min);
				q5.add(5 * min);
			} else if (min.equals(v5)) {
				q5.remove();
				q5.add(5 * min);
			} else if (min.equals(v7)){
				q7.remove();
			}
			q7.add(7 * min);
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(find(1));
		System.out.println(find(2));
		System.out.println(find(3));
		System.out.println(find(4));
		System.out.println(find(99));
	}

}
