package Graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	
	Graph graph;
	GraphListeImpl graphListe;

	@Before
	public void init() {
		graph = new GraphMatrixImpl(2);
		graphListe = new GraphListeImpl();
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
	public void testBasicFunctionsListe() {
		ListNode addedNode1=new ListNode();
		ListNode addedNode2=new ListNode();
		ListNode reality;
		graphListe.addNode(addedNode1);
		assertEquals(graphListe.getWeight(addedNode1,addedNode1), 0);
		
		graphListe.addNode(addedNode2);
		graphListe.setWeight(addedNode1, addedNode2, 2);
		assertEquals(graphListe.getWeight(addedNode2, addedNode1),2);
		
		reality=((ListNode)(graphListe.getNeighbors(addedNode1)).getFirst());
		assertEquals(reality,addedNode1);
		reality=((ListNode)(graphListe.getNeighbors(addedNode1)).getLast());
		assertEquals(reality,addedNode2);
		
		graphListe.removeNode(addedNode2);
		reality=((ListNode)(graphListe.getNeighbors(addedNode1)).getFirst());
		assertEquals(reality,addedNode1);
		reality=((ListNode)(graphListe.getNeighbors(addedNode1)).getLast());
		assertEquals(reality,addedNode1);
		
		
		
		
		
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
