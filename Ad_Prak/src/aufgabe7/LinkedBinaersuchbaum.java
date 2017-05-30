/**
 *AD Paktikum
 *@autor Daniel Nisch
 *@autor Luis Nickel
 */
package aufgabe7;

public class LinkedBinaersuchbaum<T extends Comparable<T>> implements
		BinSuchbaum<T> {
	/**
	 * Beginn des binaeren Suchbaumes
	 */
	Element<T> anfangsKnoten;
	private int counter;

	@Override
	public void knotenEinfügen(T wert) {
		if (anfangsKnoten == null) {
			anfangsKnoten = new Element<T>(wert);
		} else if (wert.compareTo(anfangsKnoten.getWert()) < 0) {
			if (anfangsKnoten.getLinkenKindKnoten() == null) {
				anfangsKnoten.setLinkenKindKnoten(new Element<T>(wert));
			} else
				knotenEinfügen(wert, anfangsKnoten.getLinkenKindKnoten());
		} else {
			if (anfangsKnoten.getRechtenKindKnoten() == null) {
				anfangsKnoten.setRechtenKindKnoten(new Element<T>(wert));
			} else
				knotenEinfügen(wert, anfangsKnoten.getRechtenKindKnoten());
		}
	}

	/**
	 * Rukursive Hilfsmethode zum einsortieren Eines Wertes.
	 * 
	 * @param wert
	 * @param knoten
	 */
	private void knotenEinfügen(T wert, Element<T> knoten) {
		if (wert.compareTo(knoten.getWert()) < 0) {
			if (knoten.getLinkenKindKnoten() == null) {
				knoten.setLinkenKindKnoten(new Element<T>(wert));
			} else
				knotenEinfügen(wert, knoten.getLinkenKindKnoten());
		} else {
			if (knoten.getRechtenKindKnoten() == null) {
				knoten.setRechtenKindKnoten(new Element<T>(wert));
			} else
				knotenEinfügen(wert, knoten.getRechtenKindKnoten());
		}
	}

	@Override
	public void ausgabe(AusgabeAuswahl auswahl) {
		if (auswahl == AusgabeAuswahl.SYMMETRISCH) {
			inorder(anfangsKnoten);
		} else if (auswahl == AusgabeAuswahl.HAUPT) {
			preorder(anfangsKnoten);
		} else {
			postorder(anfangsKnoten);
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Symmetrischenreihenfolge.
	 * 
	 * @param k
	 */
	public void inorder(Element<T> k) {
		if (k.getLinkenKindKnoten() != null) {
			inorder(k.getLinkenKindKnoten());
		}
		System.out.print(k.getWert() + " ");

		if (k.getRechtenKindKnoten() != null) {
			inorder(k.getRechtenKindKnoten());
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Hauptreihenfolge.
	 * 
	 * @param k
	 */
	public void preorder(Element<T> k) {
		System.out.print(k.getWert() + " ");
		if (k.getLinkenKindKnoten() != null) {
			preorder(k.getLinkenKindKnoten());
		}
		if (k.getRechtenKindKnoten() != null) {
			preorder(k.getRechtenKindKnoten());
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Nebenreihenfolge.
	 * 
	 * @param k
	 */
	public void postorder(Element<T> k) {

		if (k.getLinkenKindKnoten() != null) {
			postorder(k.getLinkenKindKnoten());
		}
		if (k.getRechtenKindKnoten() != null) {
			postorder(k.getRechtenKindKnoten());
		}
		System.out.print(k.getWert() + " ");

	}

	public static void main(String[] args) {
		System.out.println("kdfsk");
		System.out.println("asda");
		LinkedBinaersuchbaum<Integer> lbs = new LinkedBinaersuchbaum<Integer>();
		lbs.knotenEinfügen(10);
		lbs.knotenEinfügen(9);
		lbs.knotenEinfügen(8);
		lbs.knotenEinfügen(12);
		lbs.knotenEinfügen(15);
		lbs.knotenEinfügen(1);
		lbs.ausgabe(AusgabeAuswahl.HAUPT);
		lbs.summe(10, 12);
	}

	@Override
	public int summe(int l, int r) {
		Element<T> wurzel = anfangsKnoten;
		counter = 0;

		// Finde einen Teilbaum, dessen Wurzelknoten zwischen l und r liegt
		while (!(l <= (int) wurzel.getWert() && r >= (int) wurzel.getWert())) {
			counter++;
			if (l > (int) wurzel.getWert()) {
				wurzel = wurzel.getRechtenKindKnoten();
				if (wurzel == null) return -1; 
				continue;
			}

			if (r < (int) wurzel.getWert()) {
				wurzel = wurzel.getLinkenKindKnoten();
				if (wurzel == null) return -1; 
				continue;
			}

		}

		// Füge Kindersumme dem Ergebnis hinzu abzüglich der Knoten ausserhalb des Bereichs.
		int ergebnis = getSummeAllerKinder(wurzel, l, r);

		System.out.println("heap counter: " + counter);
		return ergebnis;
	}
	
	private int getSummeAllerKinder(Element<T> knoten, int l, int r) {
		counter++;
		int summe = 0;
		int wert = (int) knoten.getWert();
		if (knoten.getLinkenKindKnoten() != null && wert >= l) {
			summe += getSummeAllerKinder(knoten.getLinkenKindKnoten(), l, r);
		}
		if (knoten.getRechtenKindKnoten() != null && wert <= r) {
			summe += getSummeAllerKinder(knoten.getRechtenKindKnoten(), l, r);
		}
		if (wert > r || wert < l) {
			wert = 0;
		}
		return summe + wert;
	}

}
