/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe7;

public class LinkedBinaersuchbaum<T extends Comparable<T>> implements BinSuchbaum<T>{
/**
 *Beginn des binaeren Suchbaumes 
 */
	Element<T> anfangsKnoten;

	@Override
	public void knotenEinfügen(T wert) {	
		if(anfangsKnoten==null){
			anfangsKnoten=new Element<T>(wert);
		}
		else if(wert.compareTo(anfangsKnoten.getWert())<0){
			if(anfangsKnoten.getLinkenKindKnoten()==null){
				anfangsKnoten.setLinkenKindKnoten(new Element<T>(wert));
			}else
			knotenEinfügen(wert, anfangsKnoten.getLinkenKindKnoten());
		}else{
			if(anfangsKnoten.getRechtenKindKnoten()==null){
				anfangsKnoten.setRechtenKindKnoten(new Element<T>(wert));
			}else
			knotenEinfügen(wert, anfangsKnoten.getRechtenKindKnoten());
		}
	}
	/**
	 * Rukursive Hilfsmethode zum einsortieren Eines Wertes.
	 * @param wert
	 * @param knoten
	 */
	private void knotenEinfügen(T wert,Element<T> knoten){
		if(wert.compareTo(knoten.getWert())<0){
			if(knoten.getLinkenKindKnoten()==null){
				knoten.setLinkenKindKnoten(new Element<T>(wert));
			}else
			knotenEinfügen(wert, knoten.getLinkenKindKnoten());
		}else{
			if(knoten.getRechtenKindKnoten()==null){
				knoten.setRechtenKindKnoten(new Element<T>(wert));
			}else
			knotenEinfügen(wert, knoten.getRechtenKindKnoten());
		}
	}
	
	@Override
	public void ausgabe(AusgabeAuswahl auswahl) {
		if(auswahl==AusgabeAuswahl.SYMMETRISCH){
		inorder(anfangsKnoten);
		}else if(auswahl==AusgabeAuswahl.HAUPT){
			preorder(anfangsKnoten);
		}else{
			postorder(anfangsKnoten);
		}
	
		
	}
	/**
	 * Hilfsmethode zum Ausgeben der Symmetrischenreihenfolge.
	 * @param k
	 */
	public void inorder(Element<T> k){
		if(k.getLinkenKindKnoten()!=null){
			inorder(k.getLinkenKindKnoten());
		}
		System.out.print(k.getWert()+" ");
		
		if(k.getRechtenKindKnoten()!= null){
			inorder(k.getRechtenKindKnoten());
		}
		
	}
	/**
	 * Hilfsmethode zum Ausgeben der Hauptreihenfolge.
	 * @param k
	 */
	public void preorder(Element<T> k){
		System.out.print(k.getWert()+" ");
		if(k.getLinkenKindKnoten()!=null){
			preorder(k.getLinkenKindKnoten());
		}
		if(k.getRechtenKindKnoten()!= null){
			preorder(k.getRechtenKindKnoten());
		}
		
	}
	/**
	 * Hilfsmethode zum Ausgeben der Nebenreihenfolge.
	 * @param k
	 */
	public void postorder(Element<T> k){
		
		if(k.getLinkenKindKnoten()!=null){
			postorder(k.getLinkenKindKnoten());
		}
		if(k.getRechtenKindKnoten()!= null){
			postorder(k.getRechtenKindKnoten());
		}
		System.out.print(k.getWert()+" ");
		
	}
	public static void main(String[] args) {
	System.out.println("kdfsk");
	System.out.println("asda");
		LinkedBinaersuchbaum<Integer> lbs=new LinkedBinaersuchbaum<Integer>();
		lbs.knotenEinfügen(10);
		lbs.knotenEinfügen(9);
		lbs.knotenEinfügen(8);
		lbs.knotenEinfügen(12);
		lbs.knotenEinfügen(15);
		lbs.knotenEinfügen(1);
		lbs.ausgabe(AusgabeAuswahl.HAUPT);
		
	}












}
