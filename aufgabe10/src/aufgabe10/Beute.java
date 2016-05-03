package aufgabe10;
/**
 * Dies ist die Beute, die gesucht ist.
 * @author RezaPurnama
 *
 */
public class Beute {

	//Attribute
	/**
	 * Position der Beute im x-Achse
	 */
	private int xPosition;
	/**
	 * Position der Beute im y-Achse
	 */
	private int yPosition;
	
	//Constructor
	/**
	 * Beim erzeugen das Objekt Beute, wird die Position per Zufall generiert.
	 */
	public Beute(){
		erstelle();
		//test Koordinate
//		xPosition = 5;
//		yPosition = 5;
	}
	
	
	//Method
	/**
	 * liefere die Position im x-Achse
	 * @return Position im x-Achse
	 */
	public int getxPosition(){
		return xPosition;
	}
	/**
	 * liefere die Position im y-Achse
	 * @return Position im y-Achse
	 */
	public int getyPosition(){
		return yPosition;
	}
	/**
	 * Erzeuge die Position von Beute
	 */
	public void erstelle(){
		xPosition = 1 + (int)(Math.random() * ((8 - 1) + 1));
		yPosition = 1 + (int)(Math.random() * ((8 - 1) + 1));
	}
}
