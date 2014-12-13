package newones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Writer implements Runnable {

	private int data;

	private List<Integer> target;

	private static CyclicBarrier barrier;

	public Writer(int data, CyclicBarrier barrier, List<Integer> target) {
		this.data = data;
		Writer.barrier = barrier;
		this.target = target;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					target.add(data);
				}
				barrier.await();
			}
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getTarget() {
		return target;
	}

	public void setTarget(List<Integer> target) {
		this.target = target;
	}

}

public class FourThreadsFourFiles {
	public static void main(String[] args) {
		final List<Integer> one = new ArrayList<Integer>();
		final List<Integer> two = new ArrayList<Integer>();
		final List<Integer> three = new ArrayList<Integer>();
		final List<Integer> four = new ArrayList<Integer>();
		final List<Writer> writers = new ArrayList<Writer>();
		ExecutorService executer = Executors.newCachedThreadPool();
		CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
			int rounds = 0;

			@Override
			public void run() {
				System.out.println("Rounds : " + rounds);
				rounds++;
				System.out.println(one);
				System.out.println(two);
				System.out.println(three);
				System.out.println(four);
				System.out.println("Switching targets ");
//				int tempRound = rounds % 4;
				writers.get(rounds % 4).setTarget(one);
				writers.get((rounds+1) % 4).setTarget(two);
				writers.get((rounds+2) % 4).setTarget(three);
				writers.get((rounds+3) % 4).setTarget(four);
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		});
		writers.add(new Writer(1, barrier, one));
		writers.add(new Writer(2, barrier, two));
		writers.add(new Writer(3, barrier, three));
		writers.add(new Writer(4, barrier, four));
		for (Writer writer : writers) {
			executer.execute(writer);
		}
	}
}
