import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Graph g1 = new Graph();
		
		g1.addNode(0);
		g1.addNode(1);
		g1.addNode(2);
		g1.addNode(3);
		g1.addNode(4);
		g1.addNode(5);
		g1.addNode(6);
		
		g1.addUndirectedEdge(g1.allNodes.get(0), g1.allNodes.get(2));
		g1.addUndirectedEdge(g1.allNodes.get(0), g1.allNodes.get(6));
		g1.addUndirectedEdge(g1.allNodes.get(0), g1.allNodes.get(5));
		g1.addUndirectedEdge(g1.allNodes.get(1), g1.allNodes.get(3));
		g1.addUndirectedEdge(g1.allNodes.get(1), g1.allNodes.get(4));		
		g1.addUndirectedEdge(g1.allNodes.get(2), g1.allNodes.get(3));
		g1.addUndirectedEdge(g1.allNodes.get(2), g1.allNodes.get(6));
		
		g1.printAllNodes();

		
		GraphSearch search = new GraphSearch();
		ArrayList<Node> dfsR = search.DFSRec(g1.allNodes.get(0), g1.allNodes.get(6));
		ArrayList<Node> dfsI = search.DFSIter(g1.allNodes.get(0), g1.allNodes.get(6));
		ArrayList<Node> bftI = search.BFTIter(g1);
		ArrayList<Node> bftR = search.BFTRec(g1);
		
		search.printGraphSearch(dfsR);
		search.printGraphSearch(dfsI);
		search.printGraphSearch(bftI);
		search.printGraphSearch(bftR);
		
		Graph g = createLinkedList(10000);
//		BFTRecLinkedList(g); !! crashes bc runs out of stack space !!
		BFTIterLinkedList(g);
	}
	
	static Graph createRandomUnweightedGraphIter(int n) {
		Graph g = new Graph();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) 
			g.addNode(new Node(i).val);
		
		for (int i = 0; i < n; i++) {
			if (random.nextInt(2) == 0) {
				int r = random.nextInt(n);
				g.addUndirectedEdge(g.allNodes.get(i), g.allNodes.get(r));
			}
		}	
		return g;
	}
	
	static Graph createLinkedList(int n) {
		Graph g = new Graph();
		
		for (int i = 0; i < n; i++) {
			g.addNode(i);
			if (i == 0)
				continue;
			g.addUndirectedEdge(g.allNodes.get(i), g.allNodes.get(i-1));	
		}		
		return g;
	}
	
	static ArrayList<Node> BFTRecLinkedList(final Graph graph) {
		GraphSearch search = new GraphSearch();
		return search.BFTRec(graph);
	}
	
	static ArrayList<Node> BFTIterLinkedList(final Graph graph) {
		GraphSearch search = new GraphSearch();
		return search.BFTIter(graph);
	}

}
