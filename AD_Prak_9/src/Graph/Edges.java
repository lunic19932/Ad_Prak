package Graph;

public class Edges {

	private NodeListe nachbarKnoten;
	private int weight;
	
	public Edges(NodeListe nachbarKnoten,int weight){
		this.nachbarKnoten=nachbarKnoten;
		this.weight=weight;
	}
	
	public NodeListe getNachbarKnoten(){
		return nachbarKnoten;
	}
	
	public int getWeight(){
		return weight;
	}
}
