import java.util.ArrayList;
import java.util.HashSet;

public class GridGraph {
	
	ArrayList<GridNode> allNodes = new ArrayList<GridNode>();
	int N = 0;
	
	void addGridNode(final int x, final int y, final int nodeVal) {
		GridNode gn = new GridNode(x, y, nodeVal);
		allNodes.add(gn);
		N++;
	}
	
	void addUndirectedEdge(final GridNode first, final GridNode second) {
		if (first.paths.contains(second) || !isNeighbor(first,second))
			return;
		
		first.paths.add(second);
		second.paths.add(first);	
	}
	
	void removeUndirectedEdge(final GridNode first, final GridNode second) {
		first.paths.remove(second);
		second.paths.remove(first);
	}
	
	HashSet<GridNode> getAllNodes() {
		HashSet<GridNode> hashset = new HashSet<GridNode>();
		for (int i = 0; i < N; i++) 
			hashset.add(allNodes.get(i));
		return hashset;
	}
	
	boolean isNeighbor(GridNode first, GridNode second) {
		if (first.x == second.x) {
			if (first.y == second.y + 1 || first.y == second.y - 1) {
				return true;
			}
		}
		else if (first.y == second.y) {
			if (first.x == second.x + 1 || first.x == second.x - 1) {
				return true;	
			}
			
		}
		return false;
	}
	
	ArrayList<GridNode> getNeighbors(GridNode node, int n) {
		ArrayList<GridNode> neighbors = new ArrayList<GridNode>();
		int pos = node.val;
		
		if (pos - n >= 0) 
			neighbors.add(allNodes.get(pos - n));
		if (pos + n  < n*n)
			neighbors.add(allNodes.get(pos + n));
		if ((pos + 1) % n != 0) 
			neighbors.add(allNodes.get(pos + 1));
		if (pos % n != 0)
			neighbors.add(allNodes.get(pos - 1));
		
		return neighbors;
	}
	
	void printAllNodes() {
		HashSet<GridNode> hset = this.getAllNodes();
		for (GridNode n : hset) {
			System.out.print("(" + n.x + "," + n.y + ")  :  ");
			if(!n.paths.isEmpty()) {
				int i = 0;
				do {
					GridNode e = n.paths.get(i);
					System.out.print("(" + e.x + "," + e.y + ") ");
					i++;
				} while (i < n.paths.size());
			}
			System.out.println("");
		}
	}

}
