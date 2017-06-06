package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public interface Node {

	public LinkedList<Node> getNeighbors();
	public int getWeight(Node zielknoten);
	public void addNachbarKnoten(Node newNachbar,int weight);
	public void deleteNachbarKnoten(Node knoten);

}
