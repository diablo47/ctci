package chapter18;

public class Q18_1 {

	public static int sum(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		System.out.println("sum : " + sum);
		System.out.println("carry : " + carry);
		return sum(sum, carry);
	}

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(5^(-2));
		System.out.println(5&(-2));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(Integer.toBinaryString(~-5));
		System.out.println(Integer.toBinaryString(~-5+1));

//		System.out.println(sum(-5, -2));
	}
}
