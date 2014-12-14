package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import chapter4.GraphNode.State;

public class Q4_2 {

	public static boolean df(GraphNode<?> start, GraphNode<?> end) {
		boolean ret = false;
		if (start == end)
			return true;
		start.state = State.Visited;
		System.out.print(start.data.toString() + " ");
		for (GraphNode<?> sub : start.neighbours) {
			if (sub.state != State.Visited) {
				ret = ret || df(sub, end);
				if (ret)
					break;
			}
		}
		return ret;
	}

	public static <T> boolean bf(GraphNode<T> start, GraphNode<?> end) {
		boolean ret = false;
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		System.out.print(start.data + " ");
		start.state = State.Visited;
		if (start == end)
			return true;
		queue.add(start);
		Stack<GraphNode<?>> path = new Stack<GraphNode<?>>();
		while (!queue.isEmpty()) {
			GraphNode<T> node = queue.poll();
			path.push(node);
			for (GraphNode<T> neighbour : node.neighbours) {
				if (neighbour.state != State.Visited) {
					// path.push(neighbour);
					neighbour.previous = node;
					System.out.print(neighbour.data + " ");
					if (neighbour.data.equals(end.data)) {
						path.push(neighbour);
						System.out.println(path);
						return true;
					}
					neighbour.state = State.Visited;
					queue.add(neighbour);
				}
			}
			path.pop();
		}
		System.out.println(path);
		return false;
	}

	public static void main(String[] args) {
		List<GraphNode<Integer>> nodes = new ArrayList<GraphNode<Integer>>();
		nodes.add(0, null);
		for (int i = 1; i <= 13; i++) {
			GraphNode<Integer> node = new GraphNode<Integer>();
			node.data = i;
			nodes.add(i, node);
		}

		for (GraphNode<Integer> node : nodes)
			System.out.print(node == null ? null + " " : node.data + " ");

		System.out.println();

		nodes.get(1).addNeighbour(nodes.get(2));
		nodes.get(1).addNeighbour(nodes.get(4));
		nodes.get(1).addNeighbour(nodes.get(7));

		nodes.get(2).addNeighbour(nodes.get(1));
		nodes.get(2).addNeighbour(nodes.get(3));
		nodes.get(2).addNeighbour(nodes.get(4));
		nodes.get(2).addNeighbour(nodes.get(5));
		nodes.get(2).addNeighbour(nodes.get(6));

		nodes.get(3).addNeighbour(nodes.get(2));
		nodes.get(3).addNeighbour(nodes.get(6));
		nodes.get(3).addNeighbour(nodes.get(10));

		nodes.get(4).addNeighbour(nodes.get(1));
		nodes.get(4).addNeighbour(nodes.get(2));
		nodes.get(4).addNeighbour(nodes.get(5));
		nodes.get(4).addNeighbour(nodes.get(9));
		nodes.get(4).addNeighbour(nodes.get(7));

		nodes.get(5).addNeighbour(nodes.get(2));
		nodes.get(5).addNeighbour(nodes.get(6));
		nodes.get(5).addNeighbour(nodes.get(10));
		nodes.get(5).addNeighbour(nodes.get(4));

		nodes.get(6).addNeighbour(nodes.get(2));
		nodes.get(6).addNeighbour(nodes.get(3));
		nodes.get(6).addNeighbour(nodes.get(9));
		nodes.get(6).addNeighbour(nodes.get(5));

		nodes.get(7).addNeighbour(nodes.get(1));
		nodes.get(7).addNeighbour(nodes.get(3));
		nodes.get(7).addNeighbour(nodes.get(8));
		nodes.get(7).addNeighbour(nodes.get(11));

		nodes.get(8).addNeighbour(nodes.get(7));
		nodes.get(8).addNeighbour(nodes.get(9));
		nodes.get(8).addNeighbour(nodes.get(12));
		nodes.get(8).addNeighbour(nodes.get(11));

		nodes.get(9).addNeighbour(nodes.get(4));
		nodes.get(9).addNeighbour(nodes.get(6));
		nodes.get(9).addNeighbour(nodes.get(10));
		nodes.get(9).addNeighbour(nodes.get(12));
		nodes.get(9).addNeighbour(nodes.get(8));

		nodes.get(10).addNeighbour(nodes.get(5));
		nodes.get(10).addNeighbour(nodes.get(3));
		nodes.get(10).addNeighbour(nodes.get(12));
		nodes.get(10).addNeighbour(nodes.get(9));

		nodes.get(11).addNeighbour(nodes.get(7));
		nodes.get(11).addNeighbour(nodes.get(8));
		nodes.get(11).addNeighbour(nodes.get(12));

		nodes.get(12).addNeighbour(nodes.get(11));
		nodes.get(12).addNeighbour(nodes.get(8));
		nodes.get(12).addNeighbour(nodes.get(9));
		nodes.get(12).addNeighbour(nodes.get(10));

		// System.out.println(df(nodes.get(1),nodes.get(13)));
		GraphNode<Integer> end = nodes.get(12);
		System.out.println(bf(nodes.get(1), nodes.get(12)));
		Stack<GraphNode<?>> path = new Stack<GraphNode<?>>();
		while (end != null) {
			path.push(end.previous);
			end = end.previous;
		}
//		System.out.println(path);

		// System.out.println(df(nodes.get(1),nodes.get(6)));
		// System.out.println(bf(nodes.get(1),nodes.get(6)));

	}

}
