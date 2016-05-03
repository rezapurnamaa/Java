package aufgabe9;
import java.util.Collections;
import java.util.ArrayList;
/**
 * In dieser Klasse wird die Zahl (Geheimzahl oder Zahl fuer AI) generiert
 * @author RezaPurnama
 *
 */
public class Zahl {
	//Attribute
	/**
	 * Liste von Zahlen
	 */
	private ArrayList<Integer> zahl = new ArrayList<Integer>();
	
	//Constructor
	/**
	 * Erstelle die Zahl 0 bis 9
	 */
	public Zahl() {
		for(int i = 0; i < 10; i++){
			zahl.add(i);
		}
	}
	//Methods
	/**
	 * generiere n Ziffern, die die Zahlen zwischen 0-9 sind
	 * @param anzahl Anzahl der Ziffern
	 * @return n Ziffern
	 */
	public int[] generate(int anzahl) {
		
		int[] ziffer = new int[anzahl];
		Collections.shuffle(zahl);
		for (int i = 0; i < anzahl; i++) {
			ziffer[i] = zahl.get(i);
		}
		return ziffer;
	}
	
	/**
	 * Standardeinstellung der Geheimzahl
	 * @param anzahl Anzahl der Geheimzahl
	 * @return liefere die Geheimzahl
	 */
	public int[] defaultGeheimZahl(int anzahl) {
		int[] ziffer = new int[anzahl];
		for (int i = 0; i < anzahl; i++) {
			ziffer[i] = zahl.get(i+1);
		}
		return ziffer;
	}
	
}
