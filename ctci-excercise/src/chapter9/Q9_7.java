package chapter9;

public class Q9_7 {

	enum Color {
		Black, White, Yellow, Green, Purple
	}

	public static boolean fill(Color[][] screen, int x, int y, Color original,
			Color newColor) {
		if (x < 0 || y < 0 || y >= screen.length || x >= screen[0].length) {
			return true;
		}
		Color c = screen[x][y];
		if (c == original) {
			screen[x][y] = newColor;
			fill(screen, x + 1, y, original, newColor);
			fill(screen, x - 1, y, original, newColor);
			fill(screen, x, y + 1, original, newColor);
			fill(screen, x, y - 1, original, newColor);
		}
		return true;
	}

	public static void pringScreen(Color[][] screen) {
		int col = screen.length;
		int row = screen[0].length;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++)
				System.out.printf("%8s", screen[i][j]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int x = 10, y = 10;
		Color[][] screen = new Color[10][10];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				screen[i][j] = Color.Black;
		screen[2][3] = Color.Green;
		screen[7][8] = Color.Yellow;
		screen[6][6] = Color.Purple;
		pringScreen(screen);
		fill(screen, 5, 5, Color.Black, Color.White);
		pringScreen(screen);
	}

}
