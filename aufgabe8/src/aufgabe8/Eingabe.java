package aufgabe8;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.StringTokenizer;
/**
 * Nimmt die Eingabe von Nutzer/in
 * @author RezaPurnama
 *
 */
public class Eingabe {
	//Attribute
	/**
	 * @see Scanner
	 */
	Scanner scan = new Scanner(System.in);
	
	//Constructor
	/**
	 * Parameterloser Konstruktor
	 */
	public Eingabe(){
	}

	//Methods
	/**
	 * String einlesen 
	 * @see String
	 * @return eingelesene Zeichen, die von Nutzer eingegeben ist.
	 */
	public String benutzerEingabe(){
		
		String eingabe = scan.next();
//		scan.close();
		return eingabe;
		}
		
	/**
	 * Zahl einlesen 
	 * @return eingelesene Zahl, die von Nutzer eingegeben ist.
	 */
	public double doubleEingabe(){
		
		double betrag = 0;
		try {
			betrag = scan.nextDouble();
		} 
		catch (InputMismatchException e) {
		    System.out.println(e.getMessage()); //versucht, spezifische Fehler zu finden.
		}
//		scan.close();
		return betrag;
		}
	}

