package aufgabe8;
/**
 * Die Fahrkarten besitzen bestimmte Name und Preis
 * @author RezaPurnama
 *
 */
public class Fahrkarten {
	//Attribut
	/**
	 * Preis der Fahrkarten
	 */
	private double preis;
	
	/**
	 * Name der Fahrkarten
	 */
	private String name;
	
	
	//Konstruktor
	/**
	 * Parameterloser Konstruktor
	 */
	public Fahrkarten(){
		
	}
	
	/**
	 * erzeuge Fahrkarten mit Preis und Name
	 * @param fahrkartenPreis der Preis
	 * @param fahrkartenName die Name
	 */
	public Fahrkarten(double fahrkartenPreis, String fahrkartenName){
		setPreis(fahrkartenPreis);
		setName(fahrkartenName);
	}
	//Method
		
	/**
	 * liefere den Wert Preis der Fahrkarte
	 * @return Der Preis
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * Setze Preis der Fahrkarte
	 * @param preis neuer Preis
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * liefere die Name der Fahrkarte
	 * @return name die Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setze Name der Fahrkarten
	 * @param name neue Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
