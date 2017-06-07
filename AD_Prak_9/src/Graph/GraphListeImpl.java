package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class GraphListeImpl extends AGraph {
	

	public GraphListeImpl(int size) {
		nodes=new ArrayList<Node>(size);
		
	}
	public GraphListeImpl() {
		this(10);
		
	}
	@Override
	public void addNode(Node newNode) {
		Zaehler.count();

		if (nodes.contains(null))
		{
			nodes.set(nodes.indexOf(null), newNode);
		}
		else
		{
			nodes.add(newNode);
		}
		
	}

	@Override
	public void removeNode(Node newNode) {
		Zaehler.count();
		LinkedList<Node> nachbarn=(newNode).getNeighbors();
		Iterator<Node> it=nachbarn.iterator();
		while(it.hasNext()){
			it.next().deleteNachbarKnoten(newNode);
		}
		nodes.remove(newNode);
		
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
		Zaehler.count();
		return start.getWeight(end);
	}

	@Override
	public Node getIndexOf(int index){
		Zaehler.count();
		return nodes.get(index);
	}
	@Override
	public boolean areNeighbors(Node nodeA, Node nodeB) {
		Zaehler.count();
		if(getWeight(nodeA, nodeB)==-1){
			return false;
		}
		return true;
	}
	
	public int[][] toArray(){
		int[][] weightMatrix = new int[nodes.size()][nodes.size()];
			for(int i=0;i<nodes.size();i++){
				for(int j=0;j<nodes.size();j++){
					weightMatrix[i][j]=getWeight(nodes.get(i), nodes.get(j));
					
				}
			}
		return weightMatrix;
	}



}
