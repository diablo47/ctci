package chapter7;
public class Q7_4 {

	public static int negate(int a) {
		int ret = 0;
		int b = a > 0 ? -1 : 1;
		while (a != 0) {
			ret += b;
			a = a + b;
		}
		return ret;
	}

	public static int sub(int a, int b) {
		return a + negate(b);
	}

	public static int abs(int a) {
		if (a > 0)
			return a;
		else
			return negate(a);
	}

	public static int multiply(int a, int b) {
		int temp = abs(b);
		int ret = 0;
		while (temp != 0) {
			ret += a;
			temp += -1;
		}
		if (b < 0)
			temp = negate(temp);
		return ret;
	}

	public static int devide(int a, int b) {
		int absa = abs(a);
		int absb = abs(b);
		int ret = 0, temp = absb;
		while (absa >= temp) {
			temp += absb;
			ret++;
		}
		if ((a < 0 && b < 0) || (a > 0 && b > 0))
			return ret;
		else
			return negate(ret);
	}

	public static void main(String[] args) {
		System.out.println(negate(123));
		System.out.println(sub(123, 23));
		System.out.println(multiply(-2, 22));
		System.out.println(devide(4, 3));
	}
}
