package Graph;

import java.util.LinkedList;

public class MatrixNode implements Node {
	private int[] edges;
	private int[] weights;
	private int index;
	
	public MatrixNode(){
		edges=new int[1];
		edges[0]=0;
		weights=new int[1];
		weights[0]=0;
		index=0;
	}
	public MatrixNode(int[] edges,int[] weights){
		this.edges=edges;
		this.weights=weights;
		index=0;
	}
	public MatrixNode(int index){
		this.index=index;
	}
	
	public int[] getEdges(){
		return edges;
	}
	
	public int[] getWeights(){
		return weights;
	}
	public int getIndex(){
		return index;
	}
	
	public void setIndex(int index){
		this.index=index;
	}
	
	@Override
	public LinkedList<Node> getNeighbors() {
	
		return null;
	}

	@Override
	public int getWeight(Node zielknoten) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addNachbarKnoten(Node newNachbar, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNachbarKnoten(Node knoten) {
		// TODO Auto-generated method stub
		
	}

}
