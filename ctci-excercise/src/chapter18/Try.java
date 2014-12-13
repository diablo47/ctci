package chapter18;

import java.util.Collection;

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
	
	public Object[] remove(Object[] objs){
		return new Object[1];
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
		
        short v1 = 18;
        Long v2 = new Long("18");
        Long v3 = new Long(18);
        Short v4 = new Short(v1);
        
        System.out.println(v1==v2);
        System.out.println(v2==v3);
        System.out.println(v3.equals(v1));
        System.out.println(v3.equals(v4));
	}
}
