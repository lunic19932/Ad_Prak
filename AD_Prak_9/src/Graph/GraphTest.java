package Graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	
	AGraph graph;
	Node addedNode1;
	Node addedNode2;
	Node reality;

	
	

	@Before
	public void init() {
		
		
		graph = new GraphMatrixImpl();
		
		addedNode1=new Node();
		addedNode2=new Node();
		reality=new Node();
	
	}
	

	@Test
	public void testBasicFunction() {
		
		graph.addNode(addedNode1);
		assertEquals(graph.getWeight(addedNode1,addedNode1), 0);
		
		graph.addNode(addedNode2);
		graph.setWeight(addedNode1, addedNode2, 2);
		assertEquals(graph.getWeight(addedNode2, addedNode1),2);
		
		reality=graph.getNeighbors(addedNode1).getFirst();
		assertEquals(reality,addedNode1);
		reality=graph.getNeighbors(addedNode1).getLast();
		assertEquals(reality,addedNode2);
		
		graph.removeNode(addedNode2);
		reality=graph.getNeighbors(addedNode1).getFirst();
		assertEquals(reality,addedNode1);
		reality=graph.getNeighbors(addedNode1).getLast();
		assertEquals(reality,addedNode1);
		
		
		
		
		
		
		
		
		
	}
	@Test
	public void testDykstra(){
		Node a=new Node();
		Node b=new Node();
		Node c=new Node();
		Node d=new Node();
		Node e=new Node();
		
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		graph.setWeight(a, c, 3);
		graph.setWeight(a, e, 1);
		graph.setWeight(a, b, 5);
		graph.setWeight(b, e, 10);
		graph.setWeight(c, d, 1);
		graph.setWeight(b, d, 4);
		
		
		graph.getPaths(b);
		assertEquals(5,a.getDistance());
		assertEquals(0,b.getDistance());
		assertEquals(5,c.getDistance());
		assertEquals(4,d.getDistance());
		assertEquals(6,e.getDistance());
		
		assertEquals(b,a.getNextKnoten());
		assertEquals(b,b.getNextKnoten());
		assertEquals(d,c.getNextKnoten());
		assertEquals(b,d.getNextKnoten());
		assertEquals(a,e.getNextKnoten());
	}
	
	@Test
	public void testComplexity() {
		int size;
		int anzNachbarn;
		int k=4;
		int[][] weightMatrix;

		for(int i=1;i<=k;i++){
			size=(int)Math.pow(10, i);
			graph=new GraphListeImpl(size);
			anzNachbarn=size/100;
			fillGraph(size, anzNachbarn);
			Zaehler.reset();
			graph.getPaths(graph.getIndexOf((int)(Math.random()*size)));
			System.out.println("Liste  n="+size+" Aufwand:"+Zaehler.getOpCount());
			weightMatrix=((GraphListeImpl)graph).toArray();
			graph=new GraphMatrixImpl(weightMatrix,size);
			Zaehler.reset();
			graph.getPaths(graph.getIndexOf((int)(Math.random()*size)));
			System.out.println("Matrix  n="+size+" Aufwand:"+Zaehler.getOpCount());
		}
		
	}
	
	public void fillGraph(int size,int anzNachbarn) {
		
		Node tmpNode=null;
		Node tmpNode2=null;
		int weight;
		for(int i=0;i<size;i++){
			Node newNode=new Node();
			graph.addNode(newNode);
			if(i>0){
			weight=(int)(Math.random()*100);
			graph.setWeight(newNode, tmpNode, weight);
	
			}
			tmpNode=newNode;
		}
		for(int j=0;j<anzNachbarn;j++){
			for(int i=0;i<size;i++){
				tmpNode=graph.getIndexOf(i);
				do{
					weight=(int)(Math.random()*size);
					tmpNode2=graph.getIndexOf(weight);
				}while(graph.getNeighbors(tmpNode).contains(tmpNode2));
				weight=(int)Math.random()*100;
				graph.setWeight(tmpNode2, tmpNode, weight);	
			}
		}
		

		

	}

}
