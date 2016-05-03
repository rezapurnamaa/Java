package aufgabe10;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.StringTokenizer;
/**
 * Nimmt die Eingabe von Nutzer/in
 * @author Reza Purnama
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
	 * Zahl mit Nachkommazahl einlesen 
	 * @return eingelesene Zahl, die von Nutzer eingegeben ist.
	 */
	public double doubleEingabe(){
		
		double betrag = 0;
		try {
			betrag = scan.nextDouble();
		} 
		catch (InputMismatchException e) {
		    System.out.println(e.getMessage()); //try to find out specific reason.
		}
//		scan.close();
		return betrag;
		}
	/**
	 * Zahl  einlesen 
	 * @return eingelesene Zahl, die von Nutzer eingegeben ist.
	 */
	public int intEingabe() {
		int num = 0;
		try {
			num = scan.nextInt();
		} 
		catch (InputMismatchException e) {
		    System.out.println(e.getMessage()); //try to find out specific reason.
		}
		
		return num;
		}
	/**
	 * Buchstaben einlesen
	 * @return eingelesene Buchstaben, die von Nutzer eingegeben ist.
	 */
	public char charEingabe() {
		char eingabe = scan.next().charAt(0);
//		scan.close();
		return eingabe;
		}
	}

