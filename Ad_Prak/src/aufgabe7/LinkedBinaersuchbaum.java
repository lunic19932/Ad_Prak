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

	@Override
	public void knotenEinf�gen(T wert) {
		if (anfangsKnoten == null) {
			anfangsKnoten = new Element<T>(wert);
		} else if (wert.compareTo(anfangsKnoten.getWert()) < 0) {
			if (anfangsKnoten.getLinkenKindKnoten() == null) {
				anfangsKnoten.setLinkenKindKnoten(new Element<T>(wert));
			} else
				knotenEinf�gen(wert, anfangsKnoten.getLinkenKindKnoten());
		} else {
			if (anfangsKnoten.getRechtenKindKnoten() == null) {
				anfangsKnoten.setRechtenKindKnoten(new Element<T>(wert));
			} else
				knotenEinf�gen(wert, anfangsKnoten.getRechtenKindKnoten());
		}
	}

	/**
	 * Rukursive Hilfsmethode zum einsortieren Eines Wertes.
	 * 
	 * @param wert
	 * @param knoten
	 */
	private void knotenEinf�gen(T wert, Element<T> knoten) {
		if (wert.compareTo(knoten.getWert()) < 0) {
			if (knoten.getLinkenKindKnoten() == null) {
				knoten.setLinkenKindKnoten(new Element<T>(wert));
			} else
				knotenEinf�gen(wert, knoten.getLinkenKindKnoten());
		} else {
			if (knoten.getRechtenKindKnoten() == null) {
				knoten.setRechtenKindKnoten(new Element<T>(wert));
			} else
				knotenEinf�gen(wert, knoten.getRechtenKindKnoten());
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
		lbs.knotenEinf�gen(10);
		lbs.knotenEinf�gen(9);
		lbs.knotenEinf�gen(8);
		lbs.knotenEinf�gen(12);
		lbs.knotenEinf�gen(15);
		lbs.knotenEinf�gen(1);
		lbs.ausgabe(AusgabeAuswahl.HAUPT);
		lbs.summe(10, 12);
	}

	@Override
	public int summe(int l, int r) {
		Element<T> wurzel = anfangsKnoten;

		// Finde einen Teilbaum, dessen Wurzelknoten zwischen l und r liegt
		while (!(l <= (int) wurzel.getWert() && r >= (int) wurzel.getWert())) {
			if (l > (int) wurzel.getWert()) {
				wurzel = wurzel.getRechtenKindKnoten();
				continue;
			}

			if (r < (int) wurzel.getWert()) {
				wurzel = wurzel.getLinkenKindKnoten();
				continue;
			}

		}

		// F�ge gesamte Kindersumme dem Ergebnis hinzu
		int ergebnis = getSummeAllerKinder(wurzel);

		Element<T> linkerSohn = wurzel;
		while (linkerSohn != null) {
			// Finde linke Knoten, die kleiner sind als die linke Grenze
			// (deswegen geh�ren sie nicht in das Ergebnis)
			if ((int) linkerSohn.getWert() >= l) {
				linkerSohn = linkerSohn.getLinkenKindKnoten();
			} else {
				// Subtrahiere diese potenziell ung�ltigen Werte vom Ergebnis
				ergebnis = ergebnis - getSummeAllerKinder(linkerSohn);
				linkerSohn = linkerSohn.getRechtenKindKnoten();
				if (linkerSohn == null) {
					break;
				}
				// Addiere pauschal den rechten Sohn wieder auf. Erst
				// beim n�chsten Schleifendurchlauf wird gepr�ft ob dieser
				// Vorgang notwendig war
				ergebnis = ergebnis + getSummeAllerKinder(linkerSohn);
			}
		}

		Element<T> rechterSohn = wurzel;
		while (rechterSohn != null) {
			// Finde rechte Knoten, die gr��er sind als die rechte Grenze
			if ((int) rechterSohn.getWert() <= r) {
				rechterSohn = rechterSohn.getRechtenKindKnoten();
			} else {
				// Subtrahiere diese potenziell ung�ltigen Werte vom Ergebnis
				ergebnis = ergebnis - getSummeAllerKinder(rechterSohn);
				rechterSohn = rechterSohn.getLinkenKindKnoten();
				if (rechterSohn == null) {
					break;
				}
				// Addiere pauschal den rechten Sohn wieder auf. Erst
				// beim n�chsten Schleifendurchlauf wird gepr�ft ob dieser
				// Vorgang notwendig war
				ergebnis = ergebnis + getSummeAllerKinder(rechterSohn);
			}
		}
		return ergebnis;
	}
	
	private int getSummeAllerKinder(Element<T> knoten) {
		int summe = 0;
		if (knoten.getLinkenKindKnoten() != null) {
			summe += getSummeAllerKinder(knoten.getLinkenKindKnoten());
		}
		if (knoten.getRechtenKindKnoten() != null) {
			summe += getSummeAllerKinder(knoten.getRechtenKindKnoten());
		}
		return summe + (int) knoten.getWert();
	}

}
