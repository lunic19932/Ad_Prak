package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphMatrixImpl extends AGraph {
	
	private final int NO_EDGE = -1;
	
	private int[][] weightMatrix;
	private Queue<Integer> freeIndices;
	
	public GraphMatrixImpl(int size) {
		weightMatrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				weightMatrix[i][j] = NO_EDGE;
			}
		}
		freeIndices = new LinkedBlockingQueue<Integer>();
	}
	
	public GraphMatrixImpl() {
		this(10);
	}

	@Override
	public int addNode(int[] edges, int[] weights) {
		if (edges.length != weights.length || edges.length > size) {
			throw new IllegalArgumentException("Invalid Array Lengths");
		}
		if (weights.length == size) {
			resizeMatrix((int) (weights.length + weights.length * 0.1 + 1));
		}
		int index = size;
		if (!freeIndices.isEmpty()) {
			index = freeIndices.poll();
		} 
		weightMatrix[index][index] = 0;
		for (int i = 0; i < edges.length; i++) {
			if (i != index) {
				weightMatrix[index][i] = weights[i];
				weightMatrix[i][index] = weights[i];
			}
		}
		size++;
		return index;
	}

	@Override
	public void removeNode(int node) {
		if (weightMatrix.length + weightMatrix.length * 0.1 + 1 < size) {
			resizeMatrix((int) (weightMatrix.length - weightMatrix.length * 0.1 - 1));
		}
		for (int i = 0; i < weightMatrix.length; i++) {
			weightMatrix[node][i] = NO_EDGE;
			weightMatrix[i][node] = NO_EDGE;
		}
		if (node < size -1) {
			freeIndices.add(node);
		}
		size--;
	}

	@Override
	public int[] getNeighbors(int node) {
		List<Integer> neighbors = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if (weightMatrix[node][i] != NO_EDGE && i != node) {
				neighbors.add(i);
			}
		}
		return neighbors.stream().mapToInt(i->i).toArray();
	}

	@Override
	public int getWeight(int start, int end) {
		if (start >= weightMatrix.length || end >= weightMatrix.length) {
			throw new IllegalArgumentException("Index out of Bounds");
		}
		return weightMatrix[start][end];
	}
	
	private void resizeMatrix(int size) {
		int[][] resizedMatrix = new int[size][];
		for (int i = 0; i < size; i++) {
			if (i < weightMatrix.length) {
				resizedMatrix[i] = Arrays.copyOf(weightMatrix[i], size);
			} else {
				resizedMatrix[i] = new int[size];
				Arrays.fill(resizedMatrix[i], NO_EDGE);
			}
		}
		weightMatrix = resizedMatrix;
	}

}
