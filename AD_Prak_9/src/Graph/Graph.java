package Graph;

import java.util.LinkedList;

public interface Graph {

	int addNode(NodeListe node);
	
	void removeNode(NodeListe node);
	
	LinkedList getNeighbors(NodeListe node);
	
	int getWeight(NodeListe start, NodeListe end);
	
	DykstraData[] getPaths(NodeListe node);
	
}
