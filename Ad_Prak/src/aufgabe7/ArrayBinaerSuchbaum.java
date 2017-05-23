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

	
	@Override
	public void knotenEinfügen(T wert){
		if(array[0]==null){
			array[0]=wert;
		}
		else if(wert.compareTo((T) array[0])<0){
			knotenEinfügen(wert, 1);
		}else{
			knotenEinfügen(wert, 2);
		}
		
	}
	/**
	 * Rukursive Hilfsmethode zum einsortieren Eines Wertes.
	 * @param wert
	 * @param index
	 */
	private void knotenEinfügen(T wert,int index){
		if(index>=array.length){
			Comparable[] tmpArray=new Comparable[array.length*10];
			System.arraycopy(array, 0, tmpArray, 0, array.length);
			array=tmpArray;
		}
		if(array[index]==null){
			array[index]=wert;
		}else if(wert.compareTo((T) array[index])<0){
			knotenEinfügen(wert, index*2+1);
		}else{
			knotenEinfügen(wert,index*2+2);
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
		a.knotenEinfügen(14);
		a.knotenEinfügen(15);
		a.knotenEinfügen(3);
		a.knotenEinfügen(30);
		a.knotenEinfügen(19);
		a.knotenEinfügen(1);
		a.knotenEinfügen(4);
		a.ausgabe(AusgabeAuswahl.HAUPT);
	}
	@Override
	public int summe(int l, int r) {
		int wurzel = 0;

		// Finde einen Teilbaum, dessen Wurzelknoten zwischen l und r liegt
		while (!(l <= (int) array[wurzel] && r >= (int) array[wurzel])) {
			if (l > (int) array[wurzel]) {
				wurzel = wurzel*2+2;
				continue;
			}

			if (r < (int) array[wurzel]) {
				wurzel = wurzel*2+1;
				continue;
			}

		}

		// Füge gesamte Kindersumme dem Ergebnis hinzu
		int ergebnis = getSummeAllerKinder(wurzel);

		int linkerSohn = wurzel;
		while (linkerSohn < array.length && array[linkerSohn] != null) {
			// Finde linke Knoten, die kleiner sind als die linke Grenze
			// (deswegen gehören sie nicht in das Ergebnis)
			if ((int) array[linkerSohn] >= l) {
				linkerSohn = linkerSohn*2+1;
			} else {
				// Subtrahiere diese potenziell ungültigen Werte vom Ergebnis
				ergebnis = ergebnis - getSummeAllerKinder(linkerSohn);
				linkerSohn = linkerSohn*2+2;
				if (array[linkerSohn] == null) {
					break;
				}
				// Addiere pauschal den rechten Sohn wieder auf. Erst
				// beim nächsten Schleifendurchlauf wird geprüft ob dieser
				// Vorgang notwendig war
				ergebnis = ergebnis + getSummeAllerKinder(linkerSohn);
			}
		}

		int rechterSohn = wurzel;
		while (rechterSohn < array.length && array[rechterSohn] != null) {
			// Finde rechte Knoten, die größer sind als die rechte Grenze
			if ((int) array[rechterSohn] <= r) {
				rechterSohn = rechterSohn*2+2;
			} else {
				// Subtrahiere diese potenziell ungültigen Werte vom Ergebnis
				ergebnis = ergebnis - getSummeAllerKinder(rechterSohn);
				rechterSohn = rechterSohn*2+1;
				if (array[rechterSohn] == null) {
					break;
				}
				// Addiere pauschal den rechten Sohn wieder auf. Erst
				// beim nächsten Schleifendurchlauf wird geprüft ob dieser
				// Vorgang notwendig war
				ergebnis = ergebnis + getSummeAllerKinder(rechterSohn);
			}
		}
		return ergebnis;
	}
	
	private int getSummeAllerKinder(int index) {
		int summe = 0;
		if (array.length > index*2+1 && array[index*2+1] != null) {
			summe += getSummeAllerKinder(index*2+1);
		}
		if (array.length > index*2+2 && array[index*2+2] != null) {
			summe += getSummeAllerKinder(index*2+2);
		}
		return summe + (int) array[index];
	}
	

}
