package chapter9;

public class Q9_1 {

	// public static int[] temp = new int[100];

	public static int moves(int a) {
		int[] temp = new int[a + 1];
		return moves(a, temp);
	}

	public static int moves(int a, int[] temp) {
		if (a < 0)
			return 0;
		if (a == 0)
			return 1;
		if (a == 1)
			return 1;
		if (a == 2)
			return 2;
		if (a == 3)
			return 4;
		if (temp[a - 3] == 0)
			temp[a - 3] = moves(a - 3, temp);
		if (temp[a - 2] == 0)
			temp[a - 2] = moves(a - 2, temp);
		if (temp[a - 1] == 0)
			temp[a - 1] = moves(a - 1, temp);
		temp[a] = temp[a - 3] + temp[a - 2] + temp[a - 1];
		return temp[a];
	}

	public static void main(String[] args) {
		System.out.println(moves(3));
		System.out.println(moves(5));
		System.out.println(moves(50));
	}

}
