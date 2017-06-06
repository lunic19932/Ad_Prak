package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphListeImpl extends AGraph {
	
	List<NodeListe> knoten;
	public GraphListeImpl() {
		knoten=new LinkedList<NodeListe>();
		
	
	}
	

	public int addNode(NodeListe newNode) {
		knoten.add(newNode);
		return 0;
	}

	
	public void removeNode(NodeListe newNode) {
		LinkedList<NodeListe> nachbarn=newNode.getNeighbors();
		Iterator<NodeListe> it=nachbarn.iterator();
		while(it.hasNext()){
			it.next().deleteNachbarKnoten(newNode);
		}
		knoten.remove(newNode);
		
	}

	
	public LinkedList<NodeListe> getNeighbors(NodeListe node) {
	
		return node.getNeighbors();
	}
	public void setWeight(NodeListe start, NodeListe end, int weight){
		start.addNachbarKnoten(end, weight);
		end.addNachbarKnoten(start, weight);
		
	}

	public int getWeight(NodeListe start, NodeListe end) {
		
		return start.getWeight(end);
	}



}
