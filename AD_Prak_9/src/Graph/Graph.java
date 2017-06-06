package Graph;

import java.util.LinkedList;

public interface Graph {

	int addNode(Node node);
	
	void removeNode(Node node);
	
	LinkedList getNeighbors(Node node);
	
	int getWeight(Node start, Node end);
	
	DykstraData[] getPaths(Node node);

	void setWeight(Node addedNode1, Node addedNode2, int i);
	
}
