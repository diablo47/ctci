package newones;

import java.util.Arrays;
import java.util.Stack;

public class CalculateMaxMartrix {

	public static int biggest2(char[][] matrix) {
		int ret = 0;

		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int cols = matrix[0].length;

		int[][] a = new int[rows][cols];
		int[][] b = new int[rows][cols];
		int[][] c = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (matrix[row][col] == '0') {
					b[row][col] = 0;
					a[row][col] = 0;
				} else {
					if (col == 0) {
						a[row][col] = 1;
					} else {
						a[row][col] = a[row][col - 1] + 1;
					}

					if (row == 0) {
						b[row][col] = 1;
					} else {
						b[row][col] = b[row - 1][col] + 1;
					}
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			System.out.println("a " + Arrays.toString(a[i]));
		}
		System.out.println();
		for (int i = 0; i < rows; i++) {
			System.out.println("b " + Arrays.toString(b[i]));
		}
		int max = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (row == 0 || col == 0) {
					c[row][col] = matrix[row][col] == '1' ? 1 : 0;
				} else {
					c[row][col] = Math.min(c[row-1][col-1]+1, Math.min(a[row][col], b[row][col]));
				}
				max = Math.max(max, c[row][col]);
			}
		}
		
		for (int i = 0; i < rows; i++) {
			System.out.println("c " + Arrays.toString(c[i]));
		}
		return max;
	}

	public static int biggest(char[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] a = new int[rows][cols];

		for (int col = 0; col < cols; col++) {
			for (int row = rows - 1; row >= 0; row--) {
				if (matrix[row][col] == '0')
					a[row][col] = 0;
				else {
					if (row == rows - 1) {
						a[row][col] = 1;
					} else {
						a[row][col] = a[row + 1][col] + 1;
					}
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			System.out.println("after " + Arrays.toString(a[i]));
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = a[0][0];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (col == 0) {
					stack.push(0);
				} else if (a[row][col] > a[row][stack.peek()]) {
					stack.push(col);
				} else if (stack.size() == 1
						&& a[row][col] == a[row][stack.peek()]) {
					stack.pop();
					stack.push(col);
				} else {
					while (!stack.isEmpty()
							&& a[row][col] < a[row][stack.peek()]) {
						int tempCol = stack.pop();
						if (stack.isEmpty()) {
							max = Math.max(max, a[row][tempCol] * col);
						} else {
							max = Math.max(max,
									a[row][tempCol] * (col - stack.peek() - 1));
						}
					}
					stack.push(col);
				}
			}
			while (!stack.isEmpty()) {
				int tempCol = stack.pop();
				if (stack.isEmpty()) {
					max = Math.max(max, a[row][tempCol] * cols);
				} else {
					max = Math.max(max, a[row][tempCol]
							* (cols - stack.peek() - 1));
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		char[][] matrix = new char[][] { { '0', '1', '0', '1', '0' },
				{ '0', '1', '1', '0', '0' }, { '0', '1', '1', '1', '0' },
				{ '0', '1', '1', '1', '0' }, { '0', '0', '0', '0', '0' } };

		char[][] matrix2 = new char[][] { "11111111".toCharArray(),
				"11111110".toCharArray(), "11111110".toCharArray(),
				"11111000".toCharArray(), "01111000".toCharArray()

		};

		for (int i = 0; i < matrix.length; i++) {
			System.out.println("after " + Arrays.toString(matrix[i]));
		}
		System.out.println();
		System.out.println(biggest2(matrix2));
	}
}
