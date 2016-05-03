package aufgabe10;
/**
 * Diese Klasse vereerbt und implementiert die Superklasse Spielfigur
 * und erzeugt die Spielfigur Dame.
 * @author RezaPurnama
 *
 */
public class Dame extends Spielfigur {

	//Attribute
	
	
	//Constructor
	/**
	 * Erzeuge Spielfigur Dame
	 * @param name Name der Spielfigur
	 * @param xPosition Position in X-Achse
	 * @param yPosition Position in X-Achse
	 */
	public Dame(String name, int xPosition, int yPosition){
		super(name, xPosition, yPosition);
		xPosition = 0;
		yPosition = 0;
		inputPositon = 0;
		
	}
	//Method
	/**
	 * liefere Name der Spielfigur
	 * @return Name
	 */
	public String getName(){
		return name;
	}
	
//	public void setxPosition(int input){
//		xPosition = input;
//	}
	
	/**
	 * liefere die x-Achse
	 * @return Position des Spielfigur im x-Achse
	 */
	public int getxPosition(){
		return xPosition;
	}
	
//	public void setyPosition(int input){
//		yPosition = input;
//	}
	/**
	 * liefere die y-Achse
	 * @return Position des Spielfigur im y-Achse
	 */
	public int getyPosition(){
		return yPosition;
	}
	
	@Override
	public void ziehe(Eingabe input){
		System.out.println("Wie wollen Sie ziehen");
		System.out.print("(-, |, /, \\) : ");	
		String str = input.benutzerEingabe();
//		System.out.println(str);
		System.out.print("(eingabe < 0) nach links unten, (eingabe > 0) nach rechts oben: ");
		inputPositon = input.intEingabe();
		switch(str){
		case "-":
			horizontal();
			break;
		case "|":
			vertical();
			break;
		case "/":
			obenRechts();
			break;
		case "\\":
			obenLinks();
			break;
			default:
				System.out.println("Falsche Eingabe.");
		}
	}
	
	
	
}
