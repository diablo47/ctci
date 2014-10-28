package chapter1;

import CtCILibrary.AssortedMethods;

public class Q1_7 {

	public static void to0(int a[][]) {
		System.out.println("before");
		AssortedMethods.printMatrix(a);
		int rows = a.length;
		int collumns = a[0].length;
		boolean[] rowToZero = new boolean[rows];
		boolean[] colToZero = new boolean[collumns];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < collumns; col++) {
				if (a[row][col] == 0) {
					rowToZero[row] = true;
					colToZero[col] = true;
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < collumns; col++) {
				if (rowToZero[row] || colToZero[col]) {
					a[row][col] = 0;
				}
			}
		}
		System.out.println("after");
		AssortedMethods.printMatrix(a);
	}

	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, 0, 100);
		to0(matrix1);
	}

}
