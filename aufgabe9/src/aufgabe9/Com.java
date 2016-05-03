package aufgabe9;

import java.util.ArrayList;

/**
 * Computer kann die Geheimzahl raten
 * @author RezaPurnama
 *
 */
public class Com {

	//Attribute
	/**
	 * Anzahl der Geheimzahl, die von Spieler festgelegt wird.
	 */
	private int anzahl; 
	/**
	 * Zahlen, die von Com geraten werden
	 */
	private int[] geratenVonCom;
	/**
	 * Stelle der von computer geratener Zahl 
	 */
	private int index;
	/**
	 * einzel Zahl, die von computer geraten werden
	 */
//	private int element;
	/**
	 * Liste von Zahlen, die dem Computer hilft, um Zahlen zu erinnern
	 */
	private ArrayList<Integer> zahlList = new ArrayList<Integer>(10);
	
	/**
	 * Array von Zahlen, die dem Computer hilft, um Zahlen zu erinnern
	 */
	private int[] reserve;
	//Constructor
	/**
	 * Erstelle einen Objekt, der bestimmte Eigenschaften hat
	 */
	public Com(){
		anzahl = 4;
		setGeratenVonCom(new int[anzahl]);
		setReserve(new int[anzahl]);
		index = 0;
	}
	/**
	 * Erstelle einen Objekt mit der Anzahl der Geheimzahl, die von Spieler eingegeben ist
	 * @param anzahl Anzahl der Geheimzahl
	 */
	public Com(int anzahl){
		this.anzahl = anzahl;
		setGeratenVonCom(new int [anzahl]);
		setReserve(new int[anzahl]);
		index = 0;
	}

	/**
	 * liefere die geratene Zahlen zurueck
	 * @return die geratene Zahlen
	 */
	public int[] getGeratenVonCom() {
		return geratenVonCom;
	}

	/**
	 * setze die geratene Zahlen
	 * @param geratenVonCom die Zahlen, die von computer geraten sind
	 */
	public void setGeratenVonCom(int[] geratenVonCom) {
		this.geratenVonCom = geratenVonCom;
	}

	/**
	 * Liefere die Anzahl der Geheimzahl zurueck
	 * @return die Anzahl der Geheimzahl
	 */
	public int getAnzahl() {
		return anzahl;
	}

	
//	public void setAnzahl(int anzahl) {
//		this.anzahl = anzahl;
//	}
	
	/**
	 * Setze einzelne Zahl, die von computer generiert ist
	 * @param element die geratene Zahl
	 */
	public void setElement(int element) {
		
		if (index < anzahl) {
			geratenVonCom[index] = element;
			index++ ;
		}
		else {
			index = 0;
			geratenVonCom[index] = element;
			index++ ;
		}		
	}

	/**
	 * Setze einzelne Zahl, die von computer generiert ist
	 * @param element die geratene Zahl
	 * @param index Stelle der geratenen Zahl
	 */
	public void setElement(int element, int index) {	
		if (index < anzahl) {
			geratenVonCom[index] = element;
		}
	}
	
	/**
	 * Setze geratene Zahl in der Liste
	 * @param element die geratene Zahl
	 */ 
	public void setZahlList(int element) {
		zahlList.add(element);
	}

	/**
	 * Setze geratene Zahl in der Liste
	 * @param index Stelle der geratenen Zahl
	 * @param element die geratene Zahl
	 */
	public void setZahlList(int index,int element) {
		zahlList.set(index,element);
	}
	
	/**
	 * liefere die Zahl in der Liste zurueck
	 * @return die Liste
	 */ 
	public ArrayList<Integer> getZahlList() {
		return zahlList;
	}
	
	/**
	 * liefere die reservierte Zahl
	 * @return reservierte Zahl
	 */
	public int[] getReserve() {
		return reserve;
	}
	
	/**
	 * reserviere neue Array Zahl
	 * @param reserve
	 */
	public void setReserve(int[] reserve) {
		this.reserve = reserve;
	}

	/**
	 * Setze einzelne Zahl, die reserviert werden muss
	 * @param index Stelle der geratenen Zahl
	 * @param element reservierte Zahl
	 */
	public void setReserve(int index, int element){
		this.reserve[index] = element;
	}
}
