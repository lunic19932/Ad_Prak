/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe7;

public class ArrayBinaerSuchbaum<T extends Comparable<T>> implements BinSuchbaum<T> {
	/**
	 * Array zum Speichern des Binaeren Suchbaumes
	 */
	Comparable[] array=new Comparable[10];

	
	@Override
	public void knotenEinf�gen(T wert){
		if(array[0]==null){
			array[0]=wert;
		}
		else if(wert.compareTo((T) array[0])<0){
			knotenEinf�gen(wert, 1);
		}else{
			knotenEinf�gen(wert, 2);
		}
		
	}
	/**
	 * Rukursive Hilfsmethode zum einsortieren Eines Wertes.
	 * @param wert
	 * @param index
	 */
	private void knotenEinf�gen(T wert,int index){
		if(index>=array.length){
			Comparable[] tmpArray=new Comparable[array.length*10];
			System.arraycopy(array, 0, tmpArray, 0, array.length);
			array=tmpArray;
		}
		if(array[index]==null){
			array[index]=wert;
		}else if(wert.compareTo((T) array[index])<0){
			knotenEinf�gen(wert, index*2+1);
		}else{
			knotenEinf�gen(wert,index*2+2);
		}
		
	}

	@Override
	public void ausgabe(AusgabeAuswahl auswahl) {
		if(auswahl==AusgabeAuswahl.SYMMETRISCH){
			inorder(0);
		}else if(auswahl==AusgabeAuswahl.HAUPT){
			preorder(0);
		}else{
			postorder(0);
		}
	
		
	}
	/**
	 * Hilfsmethode zum Ausgeben der Symmetrischenreihenfolge.
	 * @param index: Index im Array
	 */
	private void inorder(int index){
		if(array[index*2+1]!=null){
			inorder(index*2+1);
		}
		System.out.print(array[index]+" ");
		
		if(array[index*2+2]!= null){
			inorder(index*2+2);
		}
		
	}
	/**
	 * Hilfsmethode zum Ausgeben der Hauptreihenfolge.
	 * @param index: Index im Array
	 */
	private void preorder(int index){
		System.out.print(array[index]+" ");
		if(array[index*2+1]!=null){
			preorder(index*2+1);
		}
		
		
		if(array[index*2+2]!= null){
			preorder(index*2+2);
		}
		
	}
	/**
	 * Hilfsmethode zum Ausgeben der Nebenreihenfolge.
	 * @param index: Index im Array
	 */
	private void postorder(int index){
		
		
		if(array[index*2+1]!=null){
			postorder(index*2+1);
		}
		
		
		if(array[index*2+2]!= null){
			postorder(index*2+2);
		}
		System.out.print(array[index]+" ");
		
	}

	public static void main(String[] args) {
		ArrayBinaerSuchbaum<Integer> a=new ArrayBinaerSuchbaum<Integer>();
		a.knotenEinf�gen(14);
		a.knotenEinf�gen(15);
		a.knotenEinf�gen(3);
		a.knotenEinf�gen(30);
		a.knotenEinf�gen(19);
		a.knotenEinf�gen(1);
		a.knotenEinf�gen(4);
		a.ausgabe(AusgabeAuswahl.HAUPT);
	}
	

}
