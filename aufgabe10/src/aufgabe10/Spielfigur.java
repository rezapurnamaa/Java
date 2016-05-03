package aufgabe10;
/**
 * Diese Klasse ist eine abstrakte Klasse Spielfigur, die in der Subklasse implementiert wird.
 * Der Spielfigur hat Name und Position (x,y) auf dem Feld.
 * @author RezaPurnama
 *
 */
public abstract class Spielfigur {

	//Attribute
	/**
	 * Position in X-Achse
	 */
	public int xPosition;
	
	/**
	 * Position in Y-Achse
	 */
	public int yPosition;
	
	/**
	 * Name der Spielfigur
	 */
	public String name;
	
	/**
	 * Die neue Position durch ziehen
	 */
	int inputPositon;
	
	//Constructor
	
	/**
	 * Erstelle Objekt, der spaeter auf Subklasse instanziiert
	 */
	public Spielfigur(){	
		name = "";
		xPosition = 0;
		yPosition = 0;
	}
	
	/**
	 * Erzeuge Objekt, der bestimmte Name und Position hat
	 * @param name Name der Spielfigur
	 * @param xPosition Position in X-Achse
	 * @param yPosition Position in Y-Achse
	 */
	public Spielfigur(String name, int xPosition, int yPosition){
		this.name = name;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	//Method
	/**
	 * Ziehen der Spielfigur
	 * @param input neue Position
	 */
	abstract public void ziehe(Eingabe input);
	
	/**
	 * Korriegiere die Position von Spielfigur
	 * @param position aktuelle Position
	 * @return neue Position
	 */
	private int korrigiere(int position){
		while(position < 1 || position > 8){
			if (position > 8) {
				position = position - 8;
			}
			else if (position < 1) {
				position = position + 8;
			}
		}
		
		return position;
	}
	
	/**
	 * Ziehe den Spielfigur nach oben oder nach unten
	 */
	public void horizontal(){
		xPosition = xPosition + inputPositon;
		xPosition = korrigiere(xPosition);
	}
	
	/**
	 * Ziehe den Spielfigur nach rechts oder nach links
	 */
	public void vertical(){
		yPosition = yPosition + inputPositon;
		yPosition = korrigiere(yPosition);
	}
	
	/**
	 * Ziehe den Spielfigur nach oben-rechts  oder nach unten-links (diagonal)
	 */
	public void obenRechts(){
		horizontal();
		vertical();

	}

	/**
	 * Ziehe den Spielfigur nach oben-links  oder nach unten-rechts (diagonal)
	 */
	public void obenLinks(){
		xPosition = xPosition - inputPositon;
		xPosition = korrigiere(xPosition);
		vertical();
	}
	
}
