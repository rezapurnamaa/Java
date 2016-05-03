package aufgabe9;

//import java.util.ArrayList;
import java.util.Arrays;
/**
 * Dieses Programm realisiert die Spielvariante Mastermind.
 * Per Zufallszahlengenerator wird eine 4-stellige (oder mehr) positive ganze Zahl erzeugt,
 * die man raten muss. Diese Geheimzahl kann von Spieler oder von Computer geloest werden.
 * @author RezaPurnama
 *
 */
public class MasterMind {
	//Attributes
	/**
	 * Die 4-stellige (oder mehr) Geheimzahl
	 */
	private int[] geheimZahl;
	/**
	 * Ziffer, die generiert ist
	 */
	private Zahl ziffer = new Zahl();
	/**
	 * nimmt die Eingabe von Spieler
	 */
	private Eingabe input = new Eingabe();
	/**
	 * der Spieler
	 */
	private Spieler spieler;
	/**
	 * Kunstlische Intelligenz /artificial Intelligence
	 */
	private Com ai;
	/**
	 * Optimiere die Ausgabe
	 */
	private Ausgabe output = new Ausgabe();
	/**
	 * Die Zahl,die von Spieler geraten , in richtige Stelle
	 */
	private int richtig;
	/**
	 * Die Zahl,die von Spieler geraten , in falsche Stelle
	 */
	private int falsch;
	

	//Constructors
	/**
	 * erzeuge einen Objekt mit Startzustand
	 */
	public MasterMind(){
		richtig = 0;
		falsch = 0;
	}
	
	//Methods
	/**
	 * beginne das Spiel
	 */
	public void run() {
		Integer anzahlGeheim = -1;
		int antwort = -1;
		int rateVersuch = 0;
		int vergleich = 0;
		boolean user = false;
		
		System.out.println("--Mastermind--");
			
		do {
			anzahlGeheim = frageNachAnzahlGeheimzahl();
		}
		while (anzahlGeheim < 0 );
		
		do{
			System.out.println("Wollen Sie die Geheimzahl von Computer geloest werden? ");
			System.out.println("|1 - ja||0 - nein|");
			antwort = input.intEingabe();
			if (antwort == 1) {
				if (anzahlGeheim != 0){
					ai = new Com(anzahlGeheim);
				}
				else {
					ai = new Com();
				}
			}
			else if (antwort == 0) {
				user = true;
				if(anzahlGeheim != 0) {
					spieler = new Spieler(anzahlGeheim);
				}
				else {
					spieler = new Spieler();
				}
			}
			else  {
				System.out.println("Bitte nur 0 oder 1 eingeben.");
				
			}
		}while ( antwort < 0 || antwort > 1);
	
		erzeugeGeheimZahl(anzahlGeheim);
//		geheimZahl = ziffer.defaultGeheimZahl(anzahlGeheim); //generiere 1-n, mit n als Anzahl von Geheimzahl
		if (user){
			do // von Spieler geloest
			{
				rateVersuch++;
				frageNachGeheimzahl();
				vergleich = vergleich(spieler.getGeratenVonSpieler());
				String str = output.getOutputString() + "\tRichtige Stelle : " + richtig + "\tFalsche Stelle : " + (falsch - richtig);
				output.setOutputString(str);
				output.clearScreen();
				output.generiereOutput();
			}while (vergleich != anzahlGeheim);
			
		}
		else {
			do // von ai geloest
			{
				rateVersuch++;
				rateZahlVonCom();

				for (int i = 0; i < ai.getAnzahl(); i++){
					if(ai.getReserve()[i] != 0){
						ai.setElement(ai.getReserve()[i], i);	
					}
//					System.out.println("the num["+ i +"]: " + ai.getGeratenVonCom()[i]);
					
				}
			}
			while (vergleichCom(ai.getGeratenVonCom()) != anzahlGeheim);
			
		}
		
		verrateGeheimZahl(rateVersuch);
	}
	/**
	 * Man kann die Anzahl der Geheimzahl festlegen
	 * @return Anzahl der Geheimzahl
	 */
	public int frageNachAnzahlGeheimzahl(){
		int anzahlGeheim = -1;
		
		System.out.println("\nWollen Sie die Anzahl der Geheimzahl festlegen?");
		System.out.println("|1 - ja||0 - nein|");
		anzahlGeheim = input.intEingabe();
		if (anzahlGeheim == 1) {
			anzahlGeheim = setzeAnzahl();
		}
		else if (anzahlGeheim != 0 ) {
			System.out.println("Bitte nur 0 oder 1 eingeben.");
			anzahlGeheim = -1;
		}
		else{
			anzahlGeheim = 4;
			
		}
		
		return anzahlGeheim;
	}
		
	/**
	 * Computer raet 4-stellige (oder mehr) positive Zahl
	 */
	public void rateZahlVonCom() {
		ai.setGeratenVonCom(ziffer.generate(ai.getAnzahl()));
		
		
	}
	/**
	 * Computer versucht die Geheimzahl zu loesen
	 * @param rateZahl geratene Zahl von Computer
	 * @return Stellen, die richtig geraten sind
	 */
	public int vergleichCom(int[] rateZahl) {
		int richtigStelle = 0;
		for (int i = 0; i < rateZahl.length; i++)
			for (int j = 0; j < rateZahl.length; j++){
				if (geheimZahl[i] == ai.getGeratenVonCom()[j]) {
					if (i == j) {
						richtigStelle++;
						ai.setReserve(i, ai.getGeratenVonCom()[j]);
					}	
					
				}
			}
		return richtigStelle;
	}
	
	/**
	 * Man setzt die Anzahl der Geheimzahl. Man darf nur zwischen 4 und 9 eingeben
	 * @return Anzahl der Geheimzahl
	 */
	private int setzeAnzahl(){
		int anzahl = 0;
		while (anzahl < 4 || anzahl > 9) {
			System.out.print("Legen Sie die Anzahl fest: ");
			anzahl = input.intEingabe();
			if (anzahl < 4) {
				System.out.println("Anzahl niedrigstens 4.");
			}
			else if (anzahl > 9) {
				System.out.println("Anzahl hoechstens 9");
			}
		}
		return anzahl;
			
	}
	/**
	 * erzeuge die Geheimzahl
	 * @param anzahl Anzahl der Geheimzahl, die von Spieler eingegeben ist
	 */
	public void erzeugeGeheimZahl(int anzahl) {
		
		geheimZahl = ziffer.generate(anzahl);

	}
	
	/**
	 * verrate die Geheimzahl
	 * @param rateVersuch Versuche zum Raten der Geheimzahl
	 */
	public void verrateGeheimZahl(int rateVersuch) {
		System.out.println("mit " + rateVersuch + " Versuchen geraten! Herzlichen Glueckwunsch!");
		System.out.print("Geheimzahl: ");
		for (int i = 0; i < geheimZahl.length; i++) {
			System.out.print(geheimZahl[i]);
		}
		System.out.println();
	}
	
	/**
	 * fragt Spieler nach Ratezahl
	 */
	public void frageNachGeheimzahl() {
		String strInput;
		do
		 {
			System.out.print("Ihr Tipp: ");
			strInput = input.benutzerEingabe();
		}
		while ( !istEingabeOk(strInput) );

		for (int i = 0; i < strInput.length(); i++){
			spieler.setElement(Integer.parseInt(String.valueOf(strInput.charAt(i))));
			}
		
			String arrToStr  = Arrays.toString(spieler.getGeratenVonSpieler());
			output.formatiereString(arrToStr);

	}
	/**
	 * vergleiche die Ratezahl mit Geheimzahl
	 * @param rateZahl Zahl die von Spieler geraten
	 * @return die richtige Stelle
	 */
	public int vergleich(int[] rateZahl) {
		int falscheStelle = 0;
		int richtigeStelle = 0;
		for (int i = 0; i < geheimZahl.length; i++)
			for (int j = 0; j < geheimZahl.length; j++) {
				if (geheimZahl[i] == rateZahl[j]) {
					falscheStelle++;
					if(i == j) {
						richtigeStelle++;
					}	
				}
			}
		richtig = richtigeStelle;
		falsch = falscheStelle;
		
		return richtigeStelle;
	}
	
	/**
	 * pruefe, ob die Ratezahl, die von Spieler eingegeben ist, richtig sind
	 * @param eingabe Eingabe von Spieler
	 * @return <code>true</code> die Eingabe ist zugelassen
	 */
	private boolean istEingabeOk(String eingabe) {
		boolean eingabeOk = true;
		if (eingabe.length() > spieler.getAnzahl() || eingabe.length() < spieler.getAnzahl()) {
			System.out.println("Bitte "+ spieler.getAnzahl() + " Ziffern eingeben");
			eingabeOk = false;
		}
		else if ( !istNummer(eingabe) ) {
					System.out.println("Bitte nur Zahl eingeben.");
					eingabeOk = false;
		}
//		else {
//			
//			for(int i = 0; i < eingabe.length(); i++) 
//				for(int j = 0; j < eingabe.length(); j++){
//					if(i != j) {
//						if(eingabe.charAt(i) == eingabe.charAt(j)){
//							System.out.println("Die Zahl an der Stelle ["+(i+1)+"] "
//									+ "und ["+(j+1)+"] ist gleich.");
//							eingabeOk = false;
//						}
//					}
//					
//				}
//		}
				
		return eingabeOk;
	}
	
	/**
	 *pruefe, ob die Eingabe Nummer ist
	 * @param str Eingabe von Spieler
	 * @return <code>true</code> die Eingabe ist zugelassen
	 */
	private boolean istNummer(String str)  
	{  
	  try  
	  {  
	    int x =Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
}
