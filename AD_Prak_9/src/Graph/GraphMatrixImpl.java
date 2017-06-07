package Graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class GraphMatrixImpl extends AGraph {
	
	private final int NO_EDGE = -1;
	
	private int[][] weightMatrix;
	
	
	public GraphMatrixImpl(int size) {
		nodes=new ArrayList<Node>(size);
		
		weightMatrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				weightMatrix[i][j] = NO_EDGE;
			}
		}

	}
	
	public GraphMatrixImpl() {
		this(10);
	}
	public GraphMatrixImpl(int[][] weightMatrix, int size){
		nodes=new ArrayList<Node>(size);
		this.weightMatrix=weightMatrix;
		for(int i=0;i<size;i++){
			nodes.add(new Node());
		}
	}

	@Override
	public void addNode(Node node) {
		Zaehler.count();
		if (nodes.size() >= weightMatrix.length && !nodes.contains(null))
		{
			System.out.println("Graph ist voll");
			// throw new Exception("Graph ist voll");
			return;
		}

		if (nodes.contains(null))
		{
			nodes.set(nodes.indexOf(null), node);
		}
		else
		{
			nodes.add(node);
		}
		weightMatrix[nodes.indexOf(node)][nodes.indexOf(node)]=0;
	}

	@Override
	public void removeNode(Node node) {
		int index=nodes.indexOf(node);
		if (weightMatrix.length + weightMatrix.length * 0.1 + 1 < nodes.size()) {
			resizeMatrix((int) (weightMatrix.length - weightMatrix.length * 0.1 - 1));
		}
		for (int i = 0; i < weightMatrix.length; i++) {
			Zaehler.count();
			weightMatrix[index][i] = NO_EDGE;
			weightMatrix[i][index] = NO_EDGE;
		}

		nodes.set(nodes.indexOf(node), null);

	}

	@Override
	public LinkedList<Node> getNeighbors(Node node) {
		int index=nodes.indexOf(node);
		LinkedList<Node> neighbors = new LinkedList<Node>();
		neighbors.add(node);
		for (int i = 0; i < nodes.size(); i++) {
			Zaehler.count();
			if (weightMatrix[index][i] != NO_EDGE && i != index) {
				neighbors.add(nodes.get(i));
			}
		}
		return neighbors;//.stream().mapToInt(i->i).toArray();
	}

	@Override
	public int getWeight(Node nodeA, Node nodeB) {
		Zaehler.count();
		int start=nodes.indexOf(nodeA);
		int end=nodes.indexOf(nodeB);
		if (start >= weightMatrix.length || end >= weightMatrix.length) {
			throw new IllegalArgumentException("Index out of Bounds");
		}
		return weightMatrix[start][end];
	}
	
	private void resizeMatrix(int size) {
		int[][] resizedMatrix = new int[size][];
		for (int i = 0; i < size; i++) {
			Zaehler.count();
			if (i < weightMatrix.length) {
				
				resizedMatrix[i] = Arrays.copyOf(weightMatrix[i], size);
			} else {
				resizedMatrix[i] = new int[size];
				Arrays.fill(resizedMatrix[i], NO_EDGE);
			}
		}
		weightMatrix = resizedMatrix;
	}
	@Override
	public Node getIndexOf(int index){
		Zaehler.count();
		return nodes.get(index);
	}
	@Override
	public void setWeight(Node nodeA, Node nodeB, int weight) {
		Zaehler.count();
		int indexA=nodes.indexOf(nodeA);
		int indexB=nodes.indexOf(nodeB);
		
		weightMatrix[indexA][indexB] = weight;
		weightMatrix[indexB][indexA] = weight;
		
	}

	@Override
	public boolean areNeighbors(Node nodeA, Node nodeB) {
		Zaehler.count();
		if(getWeight(nodeA, nodeB)==-1){
			return false;
		}
		return true;
	}

}
