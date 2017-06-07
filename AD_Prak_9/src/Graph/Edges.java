package Graph;

public class Edges {

	private Node nachbarKnoten;
	private int weight;
	
	public Edges(Node nachbarKnoten,int weight){
		this.nachbarKnoten=nachbarKnoten;
		this.weight=weight;
	}
	
	public Node getNachbarKnoten(){
		return nachbarKnoten;
	}
	
	public int getWeight(){
		return weight;
	}
}
