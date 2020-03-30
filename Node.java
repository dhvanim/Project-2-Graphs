import java.util.Vector;

public class Node {
	
		public Node(int val) {
			this.val = val;
			this.neighbors = new Vector<Node>();
		}
		
		int val;
		Vector<Node> neighbors;	
}
