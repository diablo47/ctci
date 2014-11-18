package chapter18;

class Test {
	public int i;

	public String toString() {
		return String.valueOf(i);
	}
}

public class Try {

	public static int test() {
		int i = 0;
		try {
			i = 4;
			System.out.println("in Try:" + i);
			return i;
		} finally {
			i = 5;
			System.out.println("in finally:" + i);
		}
	}

	public static Test test2() {
		Test ret = new Test();
		try {
			ret.i = 4;
			System.out.println("in Try:" + ret);
			return ret;
		} finally {
			ret.i = 5;
			System.out.println("in finally:" + ret);
		}
	}

	public static void test(Test obj) {
		obj = new Test();
		obj.i = -1;
	}

	public static void main(String[] args) {
		System.out.println("return: " + test());
		System.out.println("return: " + test2());
		Test aha = new Test();
		aha.i = 1;
		System.out.println(aha);
		test(aha);
		System.out.println(aha);

		int a = 1, b = 2, ret = 0;
		for (int c = 3; c <= 5; c++) {
			ret = a + b;
			a = b;
			b = ret;
		}
		System.out.println(ret);
	}
}
