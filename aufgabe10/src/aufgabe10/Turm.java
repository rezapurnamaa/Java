package aufgabe10;
/**
 * Diese Klasse vereerbt und implementiert die Superklasse Spielfigur
 * und erzeugt die Spielfigur Turm.
 * @author RezaPurnama
 *
 */
public class Turm extends Spielfigur {

	//Attribute
	
	//Constructor
	/**
	 * Erzeuge Spielfigur Turm
	 * @param name Name der Spielfigur
	 * @param xPosition Position in X-Achse
	 * @param yPosition Position in X-Achse
	 */
	public Turm(String name, int xPosition, int yPosition){
		super(name, xPosition, yPosition);
		xPosition = 0;
		yPosition = 0;
		inputPositon = 0;
		
	}
	
	//Method
	/**
	 * liefere die Name der Spielfigur
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
	 * @return Position des Spielifgur im y-Achse
	 */
	public int getyPosition(){
		return yPosition;
	}
	
	
	@Override
	/**
	 * ueberschreibe die Methode ziehe in der Superklasse
	 */
	public void ziehe(Eingabe input){
		// TODO Auto-generated method stub
		System.out.println("Wie wollen Sie ziehen");
		System.out.print("(-, |)");
		String str = input.benutzerEingabe();
		System.out.print("(eingabe < 0) nach links unten, (eingabe > 0) nach rechts oben: ");
		inputPositon = input.intEingabe();
		switch(str){
		case "-":
			horizontal();
			break;
		case "|":
			vertical();
			break;
		}	
	}

}
