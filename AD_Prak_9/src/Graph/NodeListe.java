package Graph;

import java.util.Iterator;
import java.util.LinkedList;


public class NodeListe{

	private LinkedList<Edges> nachbarKnoten;
	
	
	
	public NodeListe(){
		nachbarKnoten=new LinkedList<Edges>();
		addNachbarKnoten(this, 0);
		
	}
	public NodeListe(LinkedList<Edges> nachbarKnoten){
		this.nachbarKnoten=nachbarKnoten;
		addNachbarKnoten(this, 0);
		
	}
	public LinkedList<NodeListe> getNeighbors() {

		Iterator<Edges> it=nachbarKnoten.iterator();
		LinkedList<NodeListe> nachbarn=new LinkedList<NodeListe>();
		while(it.hasNext()){
			nachbarn.add( it.next().getNachbarKnoten());
			
		}
		
		return nachbarn;
	}
	
	
	public int getWeight(NodeListe zielknoten){
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
	
	public void addNachbarKnoten(NodeListe newNachbar,int weight){
		nachbarKnoten.add(new Edges(newNachbar,weight));
	}
	
	public void deleteNachbarKnoten(NodeListe knoten){
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
