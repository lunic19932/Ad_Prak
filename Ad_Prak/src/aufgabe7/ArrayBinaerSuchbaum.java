/**
*AD Paktikum
*@autor Daniel Niscjh
*@autor Luis Nickel
*/
package aufgabe7;

public class ArrayBinaerSuchbaum<T extends Comparable<T>> implements BinSuchbaum<T> {
	/**
	 * Array zum Speichern des Binaeren Suchbaumes
	 */
	Comparable[] array=new Comparable[10];
	private int counter;

	
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
	@Override
	public int summe(int l, int r) {
		int wurzel = 0;
		counter = 0;

		// Finde einen Teilbaum, dessen Wurzelknoten zwischen l und r liegt
		while (!(l <= (int) array[wurzel] && r >= (int) array[wurzel])) {
			counter++;
			if (l > (int) array[wurzel]) {
				wurzel = wurzel*2+2;
				if (wurzel >= array.length || array[wurzel] == null) return -1; 
				continue;
			}

			if (r < (int) array[wurzel]) {
				wurzel = wurzel*2+1;
				if (wurzel >= array.length || array[wurzel] == null) return -1; 
				continue;
			}

		}

		// F�ge gesamte Kindersumme dem Ergebnis hinzu
		int ergebnis = getSummeAllerKinder(wurzel, l, r);

		System.out.println("Array counter: " + counter);
		return ergebnis;
	}
	
	private int getSummeAllerKinder(int index, int l, int r) {
		counter++;
		int summe = 0;
		int wert = (int) array[index];
		if (array.length > index*2+1 &&  wert >= l && array[index*2+1] != null) {
			summe += getSummeAllerKinder(index*2+1, l, r);
		}
		if (array.length > index*2+2 && wert <= r && array[index*2+2] != null) {
			summe += getSummeAllerKinder(index*2+2, l, r);
		}
		if (wert > r || wert < l) {
			wert = 0;
		}
		return summe + wert;
	}
	

}
