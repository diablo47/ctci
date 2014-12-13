package newones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Writer2 implements Runnable {

	private int data;

	private List<Integer> target;

	private Semaphore semaphore;

	private Semaphore notify;

	public Writer2(int data, List<Integer> target, Semaphore semaphore,
			Semaphore notify) {
		this.data = data;
		this.target = target;
		this.semaphore = semaphore;
		this.notify = notify;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				semaphore.acquire();
				synchronized (this) {
					target.add(data);
				}
				notify.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Semaphore getNotify() {
		return notify;
	}

	public void setNotify(Semaphore notify) {
		this.notify = notify;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public List<Integer> getTarget() {
		return target;
	}

	public void setTarget(List<Integer> target) {
		this.target = target;
	}

}

class Coordinate implements Runnable {

	private Semaphore writer1;
	private Semaphore writer2;
	private Semaphore writer3;
	private Semaphore writer4;

	private Semaphore notify1;
	private Semaphore notify2;
	private Semaphore notify3;
	private Semaphore notify4;

	public void run() {
		try {
			while (!Thread.interrupted()) {
				notify1.acquire();
				notify2.acquire();
				notify3.acquire();
				notify4.acquire();

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class FourThreadsFourFiles2 {

	public static void main(String[] args) throws InterruptedException {
		final List<Integer> one = new ArrayList<Integer>();
		final List<Integer> two = new ArrayList<Integer>();
		final List<Integer> three = new ArrayList<Integer>();
		final List<Integer> four = new ArrayList<Integer>();
		final List<Writer2> writers = new ArrayList<Writer2>();
		ExecutorService executer = Executors.newCachedThreadPool();

		final Semaphore writer1 = new Semaphore(1);
		final Semaphore writer2 = new Semaphore(1);
		final Semaphore writer3 = new Semaphore(1);
		final Semaphore writer4 = new Semaphore(1);

		final Semaphore notify1 = new Semaphore(1);
		final Semaphore notify2 = new Semaphore(1);
		final Semaphore notify3 = new Semaphore(1);
		final Semaphore notify4 = new Semaphore(1);

		notify1.acquire();
		notify2.acquire();
		notify3.acquire();
		notify4.acquire();

		Runnable cordiCoordinate = new Runnable() {

			int rounds = 0;

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					try {
						notify1.acquire();
						notify2.acquire();
						notify3.acquire();
						notify4.acquire();
						System.out.println("Rounds : " + rounds);
						rounds++;
						System.out.println(one);
						System.out.println(two);
						System.out.println(three);
						System.out.println(four);
						System.out.println("Switching targets ");
						writers.get(rounds % 4).setTarget(one);
						writers.get((rounds + 1) % 4).setTarget(two);
						writers.get((rounds + 2) % 4).setTarget(three);
						writers.get((rounds + 3) % 4).setTarget(four);
						Thread.sleep(500);
						writer1.release();
						writer2.release();
						writer3.release();
						writer4.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		};
 ;
		writers.add(new Writer2(1, one, writer1, notify1));
		writers.add(new Writer2(2, two, writer2, notify2));
		writers.add(new Writer2(3, three, writer3, notify3));
		writers.add(new Writer2(4, four, writer4, notify4));
		executer.execute(cordiCoordinate);
		for (Writer2 writer : writers) {
			executer.execute(writer);
		}
	}
}
