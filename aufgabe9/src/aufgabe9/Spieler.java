package aufgabe9;
/**
 * Spieler raet die Geheimzahl und kann die Anzahl der Geheimzahl festlegen
 * @author RezaPurnama
 *
 */
public class Spieler {

	//Attribute
	/**
	 * Anzahl der Geheimzahl, die von Spieler festgelgt werden kann
	 */
	private int anzahl; //sie kann von Benutzer eingegeben werden
	/**
	 * Zahlen, die von Spieler geraten werden
	 */
	private int[] geratenVonSpieler;
	/**
	 * Stelle der von Spieler geratener Zahl 
	 */
	private int index;
	/**
	 * einzel Zahl, die von Spieler geraten werden
	 */
//	private int element;
	

	//Constructor
	/**
	 * Erstelle einen Objekt, der bestimmte Eigenschaften hat
	 */
	public Spieler(){
		anzahl = 4;
		geratenVonSpieler = new int[anzahl];
		index = 0;
	}
	/**
	 * Erstelle einen Objekt mit der Anzahl der Geheimzahl, die von Spieler eingegeben ist
	 * @param anzahl Anzahl der Geheimzahl
	 */
	public Spieler(int anzahl){
		this.anzahl = anzahl;
		geratenVonSpieler = new int [anzahl];
		index = 0;
	}
	
	//Method
	/**
	 * liefere die Anzahl der Geheimzahl
	 * @return anzahl der Geheimzahl
	 */
	public int getAnzahl() {
		return anzahl;
	}
	
//	public void setAnzahl(int anzahl) {
//		this.anzahl = anzahl;
//	}
	/**
	 * liefere die Zahlen, die von Spieler geraten sind
	 * @return geratene Zahlen
	 */
	public int[] getGeratenVonSpieler() {
		return geratenVonSpieler;
	}

//	public void setGeratenVonSpieler(int[] geratenVonSpieler) {
//		this.geratenVonSpieler = geratenVonSpieler;
//	}
	/**
	 * Setze einzelne Zahl, die von Spieler eingegeben ist
	 * @param element die geratene Zahl
	 */
	public void setElement(int element) {
		
		if (index < anzahl) {
			geratenVonSpieler[index] = element;
			index++ ;
		}
		else {
			index = 0;
			geratenVonSpieler[index] = element;
			index++ ;
		}
			
		
	}
}
