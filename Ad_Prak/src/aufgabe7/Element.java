/**
*AD Paktikum
*@autor Daniel Nisch
*@autor Luis Nickel
*/
package aufgabe7;

public class Element<T extends Comparable<T>>{
	private Element<T> linkerKindKnoten;
	private Element<T> rechterKindKnoten;
	private T wert;
	
	public Element(T wert){
		this.wert=wert;
	}
	
	public T getWert(){
		return wert;
	}
	public Element<T> getLinkenKindKnoten(){
		return linkerKindKnoten;
	}
	
	public Element<T> getRechtenKindKnoten(){
		return rechterKindKnoten;
	}
	public void setLinkenKindKnoten(Element<T> linkerKindKnoten){
		this.linkerKindKnoten=linkerKindKnoten;
	}
	
	public void setRechtenKindKnoten(Element<T> rechterKindKnoten){
		this.rechterKindKnoten=rechterKindKnoten;
	}
}
