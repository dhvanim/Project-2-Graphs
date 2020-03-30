import java.util.ArrayList;
import java.util.HashSet;

public class Graph {

	ArrayList<Node> allNodes = new ArrayList<Node>();
	int N = 0;
		
	void addNode(final int nodeVal) {
		Node node = new Node(nodeVal);
		allNodes.add(node);
		N++;
	}
	
	void addUndirectedEdge(final Node first, final Node second) {
		if (first.neighbors.contains(second))
			return;
		first.neighbors.add(second);
		second.neighbors.add(first);
	}
	
	void removeUndirectedEdge(final Node first, final Node second) {
		first.neighbors.remove(second);
		second.neighbors.remove(first);
	}
	
	HashSet<Node> getAllNodes() {
		HashSet<Node> hashset = new HashSet<Node>();
		for (int i = 0; i < N; i++) 
			hashset.add(allNodes.get(i));
		return hashset;
	}
	
	void printAllNodes() {
		HashSet<Node> hset = this.getAllNodes();
		for (Node n : hset) {
			System.out.print(n.val + ": ");
			if(!n.neighbors.isEmpty()) {
				int i = 0;
				do {
					System.out.print(n.neighbors.get(i).val + " ");
					i++;
				} while (i < n.neighbors.size());
			}
			System.out.println("");
		}
	}
}
