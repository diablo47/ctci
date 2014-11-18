package chapter18;

import java.util.concurrent.Semaphore;

class TestA {

	Semaphore s1;
	Semaphore s2;
	Semaphore s3;

	public TestA() {
		s1 = new Semaphore(1);
		s2 = new Semaphore(1);
		s3 = new Semaphore(1);

		try {
			s1.acquire();
			s2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void methodA() {
		try {
			s3.acquire();
			System.out.println("A");
			s1.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void methodB() {
		try {
			s1.acquire();
			System.out.println("B");
			s2.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void methodC() {
		try {
			s2.acquire();
			System.out.println("C");
			s3.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class Multi {

	public static void main(String[] args) {

		final TestA test = new TestA();
		Thread s1 = new Thread() {

			public void run() {
				while (true) {
					test.methodA();
				}
			}
		};
		Thread s2 = new Thread() {

			public void run() {
				while (true) {
					test.methodB();
				}
			}
		};
		Thread s3 = new Thread() {

			public void run() {
				while (true) {
					test.methodC();
				}
			}
		};

		s1.start();
		s2.start();
		s3.start();

		try {
			// Thread.currentThread().join();
			Thread.sleep(1000);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
