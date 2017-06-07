package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Node {
	private LinkedList<Edges> nachbarKnoten;
	private boolean isFinished;
	private Node nextKnoten;
	private int distance;

	public Node(){
		nachbarKnoten=new LinkedList<Edges>();
		addNachbarKnoten(this, 0);
		setFinished(false);
		distance=-1;
	}
	
	public LinkedList<Node> getNeighbors() {
		Iterator<Edges> it=nachbarKnoten.iterator();
		LinkedList<Node> nachbarn=new LinkedList<Node>();
		
		while(it.hasNext()){
			nachbarn.add( it.next().getNachbarKnoten());
		}
		
		return nachbarn;
	}
	
	
	public int getWeight(Node zielknoten){
		Iterator<Edges> it=nachbarKnoten.iterator();
		Edges edge=null;
		while(it.hasNext()){
			edge=it.next();
			if(edge.getNachbarKnoten()==zielknoten) {
				return edge.getWeight();
			}	
		}
		
		return -1;
	}
	
	public void addNachbarKnoten(Node newNachbar,int weight){
		Zaehler.count();
		nachbarKnoten.add(new Edges(newNachbar,weight));
	}
	
	public void deleteNachbarKnoten(Node knoten){
		Iterator<Edges> it=nachbarKnoten.iterator();
		Edges edge=null;
		while(it.hasNext()){
			edge=it.next();
			if(edge.getNachbarKnoten()==knoten){
				break;
			}
		}
		nachbarKnoten.remove(edge);
		
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Node getNextKnoten() {
		return nextKnoten;
	}

	public void setNextKnoten(Node nextKnoten) {
		this.nextKnoten = nextKnoten;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	


}
