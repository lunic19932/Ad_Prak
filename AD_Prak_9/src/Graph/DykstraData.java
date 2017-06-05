package Graph;

public class DykstraData {
	
	private int nextNode;
	private int distance;
	
	public DykstraData(int nextNode, int distance) {
		this.nextNode = nextNode;
		this.distance = distance;
	}
	
	public int getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(int nextNode) {
		this.nextNode = nextNode;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

}
