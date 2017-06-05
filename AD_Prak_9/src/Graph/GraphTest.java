package Graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	
	Graph graph;

	@Before
	public void init() {
		graph = new GraphMatrixImpl(2);
	}
	
	@Test
	public void testBasicFunctions() {
		int[] edges;
		int[] weights;
		
		graph.addNode(new int[0], new int[0]);
		assertEquals(graph.getWeight(0, 0), 0);
		
		edges = new int[1]; edges[0] = 0;
		weights = new int[1]; weights[0] = 2;
		graph.addNode(edges, weights);
		assertEquals(graph.getNeighbors(1)[0], 0);
		assertEquals(graph.getWeight(0, 1), 2);
		assertEquals(graph.getWeight(1, 0), 2);
		
		edges = new int[2]; edges[0] = 0; edges[1] = 1;
		weights = new int[2]; weights[0] = 5; weights[1] = 2;
		graph.addNode(edges, weights);
		assertEquals(graph.getNeighbors(2)[0], 0);
		assertEquals(graph.getNeighbors(2)[1], 1);
		assertEquals(graph.getWeight(0, 2), 5);
		assertEquals(graph.getWeight(2, 1), 2);
		
		graph.removeNode(1);
		assertEquals(graph.getNeighbors(2).length, 1);
		assertEquals(graph.getNeighbors(2)[0], 0);
		assertEquals(graph.getWeight(0, 2), 5);
		assertEquals(graph.getWeight(2, 1), -1);
		assertEquals(graph.getWeight(1, 2), -1);
	}
	
	@Test
	public void testComplexity() {
		
	}
	
	private void fillGraph(int size) {
		graph = new GraphMatrixImpl(size);
		int[] edges;
		int[] weights;
		
		graph.addNode(new int[0], new int[0]);
		edges = new int[1]; edges[0] = 0;
		weights = new int[1]; weights[0] = 2;
		graph.addNode(edges, weights);
		edges = new int[2]; edges[0] = 0; edges[1] = 1;
		weights = new int[2]; weights[0] = 5; weights[1] = 2;
		graph.addNode(edges, weights);
		
		int alternateSize = 30;
		if (size < 30) {
			alternateSize = size;
		}
		for (int i = 3; i < alternateSize; i++) {
			graph.addNode(edges, weights);
		}
		
		for (int i = 30; i < size; i++) {
			
		}
	}

}
