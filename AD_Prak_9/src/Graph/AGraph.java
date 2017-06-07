package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class AGraph implements Graph {
	
	
	protected ArrayList<Node> nodes;
	
	public void getPaths(Node node) {
	
		LinkedList<Node> notFinished=new LinkedList<>();
		LinkedList<Node> neighbors=new LinkedList<>();
		Node altNode=node;
		Node tmpNode=new Node();
		Node minNode=null;
		altNode.setFinished(true);
		altNode.setDistance(0);
		altNode.setNextKnoten(altNode);
		Iterator<Node> it;
		do{
		neighbors=getNeighbors(altNode);
		it=neighbors.iterator();
		while(it.hasNext()){
			Zaehler.count();
			tmpNode=it.next();
			if(!tmpNode.isFinished() && !notFinished.contains(tmpNode)){
				notFinished.add(tmpNode);
			}
		}
		
		it=notFinished.iterator();
		while(it.hasNext()){
			tmpNode=it.next();
			Zaehler.count();
			if(areNeighbors(altNode, tmpNode)&&smallerDistance(altNode,tmpNode)){
				tmpNode.setDistance(altNode.getDistance()+getWeight(altNode, tmpNode));
				tmpNode.setNextKnoten(altNode);
			}	
			if(minNode==null ||minNode.getDistance()>tmpNode.getDistance() ){
				minNode=tmpNode;
			}
		}
		
		altNode.setFinished(true);
		notFinished.remove(altNode);
		altNode=minNode;
		minNode=null;
		}while(!notFinished.isEmpty());
		
	}
	private boolean smallerDistance(Node altNode,Node tmpNode){
		return (altNode.getDistance()+getWeight(altNode, tmpNode)<tmpNode.getDistance()||tmpNode.getDistance()==-1);
	}

}