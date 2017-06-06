package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphListeImpl extends AGraph {
	
	List<ListNode> knoten;
	public GraphListeImpl() {
		knoten=new LinkedList<ListNode>();
		
	
	}
	
	@Override
	public int addNode(Node newNode) {
		knoten.add((ListNode)newNode);
		return 0;
	}

	@Override
	public void removeNode(Node newNode) {
		LinkedList<Node> nachbarn=((ListNode)newNode).getNeighbors();
		Iterator<Node> it=nachbarn.iterator();
		while(it.hasNext()){
			it.next().deleteNachbarKnoten(newNode);
		}
		knoten.remove(newNode);
		
	}

	@Override
	public LinkedList<Node> getNeighbors(Node node) {
	
		return node.getNeighbors();
	}
	public void setWeight(Node start, Node end, int weight){
		start.addNachbarKnoten(end, weight);
		end.addNachbarKnoten(start, weight);
		
	}
	@Override
	public int getWeight(Node start, Node end) {
		
		return start.getWeight(end);
	}



}
