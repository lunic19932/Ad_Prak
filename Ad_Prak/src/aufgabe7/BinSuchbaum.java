/**
*AD Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe7;

public interface BinSuchbaum <T extends Comparable<T>>{
	
	 /**
	 * Fügt ein Element vom Typ Comparable in den Binaeren Suchbaum ein.
	 * @param ele
	 */
	void knotenEinfügen(T ele);
	/**
	 * Gibt den gesammten Binaeren Suchbaum aus.
	 * @param auswahl: in welcher Reihenfolge der Suchbaum ausgegeben wird(AusgabeAuswahl.SYMMETRISCH,AusgabeAuswahl.HAUPT,AusgabeAuswahl.NEBEN)
	 */
	void ausgabe(AusgabeAuswahl auswahl);
	/**
	 * Gibt die Summe aller Werte der Knoten in den Grenzen aus.
	 * @param l untere Grenze
	 * @param r obere Grenze
	 * @return summe
	 */
	int summe(int l, int r);
}
