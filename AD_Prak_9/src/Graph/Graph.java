package Graph;

public interface Graph {

	int addNode(int[] edges, int[] weights);
	
	void removeNode(int node);
	
	int[] getNeighbors(int node);
	
	int getWeight(int start, int end);
	
	DykstraData[] getPaths(int node);
	
}
