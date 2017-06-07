package Graph;

import java.util.LinkedList;

public interface Graph {

	void addNode(Node node);
	
	void removeNode(Node node);
	
	LinkedList<Node> getNeighbors(Node node);
	
	int getWeight(Node start, Node end);
	
	boolean areNeighbors(Node nodeA,Node nodeB);

	void setWeight(Node nodeA, Node nodeB, int weight);
	public Node getIndexOf(int index);
}
