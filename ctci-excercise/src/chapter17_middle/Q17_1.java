package chapter17_middle;

public class Q17_1 {

	public static void swap(int a, int b) {
		a = a - b;
		b = b + a;
		a = b - a;

		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	

	public static void swap2(int a, int b) {
		
		a = a^b;
		b = a^b;
		a = b^a;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}


	public static void main(String[] args) {
		swap(9,5);
		swap2(9,5);
	}

}
