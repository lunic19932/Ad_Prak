/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe7;

public interface BinSuchbaum <T extends Comparable<T>>{
	
	 /**
	 * F�gt ein Element vom Typ Comparable in den Binaeren Suchbaum ein.
	 * @param ele
	 */
	void knotenEinf�gen(T ele);
	/**
	 * Gibt den gesammten Binaeren Suchbaum aus.
	 * @param auswahl: in welcher Reihenfolge der Suchbaum ausgegeben wird(AusgabeAuswahl.SYMMETRISCH,AusgabeAuswahl.HAUPT,AusgabeAuswahl.NEBEN)
	 */
	void ausgabe(AusgabeAuswahl auswahl);
}
