package chapter18;

import java.util.concurrent.Semaphore;

public class BlockingQueueTest {

	Semaphore s;

	public BlockingQueueTest() {
		s = new Semaphore(10);
	}

	public void add() {
		System.out.println(s.availablePermits());
		s.release();
		System.out.println(s.availablePermits());
	}

	public static void main(String[] args) {
		BlockingQueueTest wokao = new BlockingQueueTest();
		wokao.add();
	}
}
