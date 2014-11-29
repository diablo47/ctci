package chapter17_middle;

public class Q17_4 {

	public static int flip(int bit) {
		return 1 ^ bit;
	}

	public static int sign(int a) {
		return (a >> 31) & 0x1;
	}

	public static void main(String[] args) {
		int a = -100, b = -200;
		int k = a - b;
		int m = sign(a - b);
		int n = flip(m);
		System.out.println(n * a + m * b);

		int sina = sign(a);
		int sinb = sign(b);
		int sinc = sign(a - b);

		int usea = sina ^ sinb;
		
		int usec = flip(usea);

		int kk = usea * sina + usec * sinc;
		System.out.println(kk);
		int qq = flip(kk);
		System.out.println(kk * b + qq * a);

	}

}
