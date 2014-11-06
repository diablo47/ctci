package chapter4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

	enum State {
		Visited, Unvisited
	};

	public T data;
	public GraphNode<T> previous;
	public List<GraphNode<T>> neighbours;
	public State state = State.Unvisited;

	public GraphNode() {
		neighbours = new ArrayList<GraphNode<T>>();
	}

	public void addNeighbour(GraphNode<T> node) {
		this.neighbours.add(node);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("data: ").append(data.toString()).append(", neibours: [");
		for (GraphNode<T> node : neighbours)
			sb.append(node.data).append(", ");
		sb.append("]");
		return sb.toString();
	}
}
