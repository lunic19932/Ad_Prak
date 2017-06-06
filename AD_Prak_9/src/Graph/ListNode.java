package Graph;

import java.util.Iterator;
import java.util.LinkedList;


public class ListNode implements Node{

	private LinkedList<Edges> nachbarKnoten;
	
	
	
	public ListNode(){
		nachbarKnoten=new LinkedList<Edges>();
		addNachbarKnoten(this, 0);
	}
	public ListNode(LinkedList<Edges> nachbarKnoten){
		this.nachbarKnoten=nachbarKnoten;
		addNachbarKnoten(this, 0);
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
			if(it.equals(zielknoten)) {
				break;
			}	
		}
		
		return edge.getWeight();
	}
	
	public void addNachbarKnoten(Node newNachbar,int weight){
		nachbarKnoten.add(new Edges((ListNode)newNachbar,weight));
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
	

	
}
