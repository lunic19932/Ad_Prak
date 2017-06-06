package Graph;

public class Edges {

	private ListNode nachbarKnoten;
	private int weight;
	
	public Edges(ListNode nachbarKnoten,int weight){
		this.nachbarKnoten=nachbarKnoten;
		this.weight=weight;
	}
	
	public ListNode getNachbarKnoten(){
		return nachbarKnoten;
	}
	
	public int getWeight(){
		return weight;
	}
}
