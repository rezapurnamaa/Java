package aufgabe7;

import java.util.Arrays;
/**
 * Bruch besteht aus Zaehler und Nenner.
 * @author RezaPurnama
 *
 */
public class Bruch {
	//Attribute
	/**
	 * Zaehler von Bruch
	 */
	private int zaehler;
	/**
	 * Nenner von Bruch
	 */
	private int nenner;
	
	//Konstruktoren
	/**
	 * Konstruktor ohne Parameter
	 */
	public Bruch(){
	}
	/**
	 * Konstruktor gibt die Werte dem zuerstellenden Objekt
	 * @param derZaehler 
	 * @param derNenner
	 */
	public Bruch(int derZaehler, int derNenner){
		zaehler = derZaehler;
		nenner = derNenner;
	}
		
	//Methoden
	/**
	 * liefere den Wert Zaehler zurueck
	 * @return zaehler Wert des Zaehlers
	 */
	public int getZaehler() {
		return zaehler;
	}
	
	/**
	 * Setze einen neuen Zaehler
	 * @param zaehler der neue Wert von Zaehler
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}
	
	/**
	 * liefere den Wert Nenner zurueck
	 * @return nenner Wert des Nenners
	 */
	public int getNenner() {
		return nenner;
	}
	
	/**
	 * Setze einen neuen Nenner
	 * @param nenner der neue Wert von Nenner
	 */
	public void setNenner(int nenner) {
		this.nenner = nenner;
	}
	/**
	 * gcd ist die Abkurzung fuer "Great common divisor"
	 * oder "Groesster Gemeinsamer Teiler".
	 * Er ist die größte natürliche Zahl,
	 * durch die sich zwei ganze Zahlen ohne Rest teilen lassen.
	 * @param K ist die Zahl von Zaehler
	 * @param M ist die Zahl von Nenner
	 * @return k der gcd
	 */
	private int gcd(int K, int M) {
	      int k = Math.abs(K);   // In order to state a simple, elegant loop invariant,
	      int m = Math.abs(M);   // we keep the formal arguments constant and use 
	                   // local variables to do the calculations.
	      // loop invariant: GCD(K,M) = GCD(k,m)
	      while (k != m) {
	         if (k > m) 
	            { k = k-m; }
	         else 
	            { m = m-k; }
	      }
	      // Ab jetzt, GCD(K,M) = GCD(k,m) = GCD(k,k) = k
	      return k;
	   }
	/**
	 * Die Elemente einer Addition werden Summanden und das Ergebnis Summe genannt.			
	 * @param b Summand ist zweite Bruch
	 * @return e Summe von ersten Bruch und zweiten Bruch
	 */
	public Bruch addiere(Bruch b){
		Bruch e = new Bruch(0, 0);
		if(b.nenner == nenner){
			e.zaehler = zaehler + b.zaehler;
			e.nenner = nenner;
		}	
		else{
			int gesNenner = nenner * b.nenner;
			e.nenner = gesNenner;
			e.zaehler =  (gesNenner/nenner)*zaehler + (gesNenner/b.nenner)*b.zaehler;	
		}
//		System.out.println(e.gcd(e.zaehler, e.nenner));
//		System.out.println("Addition: "+e.zaehler+"/"+e.nenner);
//		System.out.println("Addition: "+ zaehler +"/"+ nenner +" + "+ output(b) + " = " + output(e));
		return e;
	}
	/**
	 * Unter der Subtraktion versteht man das Abziehen einer Zahl von einer anderen. 
	 * @param b minuend ist zweite Bruch
	 * @return e Differenz von ersten Bruch und zweiten Bruch
	 */
	public Bruch substrahiere(Bruch b){
		Bruch e = new Bruch(0, 0);
		if(b.nenner == nenner) {
			e.zaehler = zaehler - b.zaehler;
			e.nenner = nenner;
		}	
		else{
			int gesNenner = nenner * b.nenner;
			e.nenner = gesNenner;
			e.zaehler =(gesNenner/nenner)*zaehler - (gesNenner/b.nenner)*b.zaehler;	
		}
//		System.out.println(e.gcd(e.zaehler, e.nenner));
//		System.out.println("Sub: "+e.zaehler+"/"+e.nenner);
//		System.out.println("Addition: "+ zaehler +"/"+ nenner +" + "+ output(b) + " = " + output(e));
		return e;
	}
	
	/**
	 * Die Multiplikation natürlicher Zahlen entsteht durch 
	 * das wiederholte Addieren (Zusammenzaehlen) des gleichen Summanden
	 * @param b Multiplikand ist zweite Bruch
	 * @return e Produkt aus ersten Bruch und zweiten Bruch
	 */
	public Bruch multipliziere(Bruch b){
		Bruch e = new Bruch(0, 0);
		e.zaehler = zaehler * b.zaehler;
		e.nenner  = nenner * b.nenner;
		return e;
	}
	
	/**
	 * Die Division wird umgangssprachlich auch als Teilen bezeichnet.
	 * @param b Divisor ist der zweite Bruch
	 * @return e Quotient aus ersten Bruch und zweiten Bruch
	 */
	public Bruch dividiere(Bruch b){
		Bruch e = new Bruch(0, 0);
		int tempZaehler = b.nenner;
		int tempNenner = b.zaehler;
		e.zaehler = zaehler * tempZaehler;
		e.nenner  = nenner * tempNenner;
		return e;
	}
	/**
	 * wenn man Zaehler und Nenner des Bruches durch
	 * einen gemeinsamen Teiler von Zaehler und Nenner teilt
	 * @return a Bruch kuerzt
	 */
	private Bruch kuerzt(){
		int teiler;
		if(nenner < 0){
			nenner = Math.abs(nenner);
			zaehler *= -1;
		}
		teiler = gcd(zaehler, nenner);
		zaehler /= teiler;
		nenner /= teiler;
		Bruch a = new Bruch(zaehler, nenner);
		return a;
	}
	
	/**
	 * Formatiert die Ausgabe, wenn der Nenner 1 ist,
	 * dann gebe nur den Zaehler aus
	 * @return ausgabe formatierte Ausgabe
	 */
	public String output(){
		String ausgabe = "";
		if(kuerzt().zaehler==kuerzt().nenner) {
			ausgabe = Integer.toString(kuerzt().zaehler);
		}
		else if(kuerzt().nenner == 1) {
			ausgabe = Integer.toString(kuerzt().zaehler);
		}
		else {
			ausgabe = kuerzt().zaehler+ "/" +kuerzt().nenner;
		}
			
		return ausgabe;
	}
	
	/**
	 * Vergleiche ob ersten Bruch groesser als zweiten Bruch ist.
	 * @param b zweiter Bruch
	 * @return groesser <code>true</code> erster Bruch ist groesser
	 * 					<code>false</code> erster Bruch ist nicht groesser
	 */
	public boolean istGroesser(Bruch b){
		boolean groesser = false;
		
		double decimalA = (double)kuerzt().zaehler / kuerzt().nenner;
		double decimalB = (double)b.kuerzt().zaehler / b.kuerzt().nenner;
		
		if(decimalA > decimalB)
			groesser = true;
		else
			groesser = false;
		
		return groesser;
	}
	
	/**
	 * Vergleiche ob ersten Bruch kleiner als zweiten Bruch ist.
	 * @param b zweiter Bruch
	 * @return kleiner <code>true</code> erster Bruch ist groesser.
	 * 					<code>false</code> erster Bruch ist nicht groesser.
	 */
	public boolean istKleiner(Bruch b){
		boolean kleiner = false;
		
		double decimalA = (double)kuerzt().zaehler / kuerzt().nenner;
		double decimalB = (double)b.kuerzt().zaehler / b.kuerzt().nenner;
		
		if(decimalA < decimalB)
			kleiner = true;
		else
			kleiner = false;
		
		return kleiner;
	}
	
	/**
	 * Vergleiche ob ersten Bruch gleich als zweiten Bruch ist.
	 * @param b zweiter Bruch
	 * @return ok <code>true</code> erster Bruch und zweiter Bruch sind gleich gross
	 * 					<code>false</code> Beide sind nicht gleich gross
	 */
	public boolean istGleich(Bruch b){
		boolean ok = false;
		
		double decimalA = (double)kuerzt().zaehler / kuerzt().nenner;
		double decimalB = (double)b.kuerzt().zaehler / b.kuerzt().nenner;
		
		if(decimalA == decimalB)
			ok = true;
		else
			ok = false;
		
		return ok;
	}
	/**
	 * generiere zufaellige Brueche aus dem Bereich Bruch a, und Bruch b.
	 * @param a Bruch a
	 * @param b Bruch b
	 * @param anzahl Anzahl der generierten Bruche
	 */
	public void generiereBruch(Bruch a, Bruch b, int anzahl,String sortieren){ 
		double dezimalA = (double)a.zaehler/a.nenner;
		double dezimalB = (double)b.zaehler/b.nenner;
		double[] generierteDezi = new double[anzahl];
		
		System.out.println("unsortiert: ");
		for(int i=0; i<anzahl;i++){
			generierteDezi[i] =dezimalA + (Math.random()*(dezimalB-dezimalA));
//			System.out.printf("Dezimal: %.7f\n", generierteDezi[i]);
			System.out.println(i+1+". "+dezimalToBruch(generierteDezi[i]).output());
		}
		System.out.println();
		if(sortieren.equals("-")){
			System.out.println("absteigend sortiert: ");
			double tempDecimal = 0.0;
			boolean loop = true;
			while(loop){
				loop = false;
				for(int i = 0; i < anzahl-1; i++){
					if(generierteDezi[i] < generierteDezi[i+1]){
						tempDecimal = generierteDezi[i+1];
						generierteDezi[i+1] = generierteDezi[i];
						generierteDezi[i] = tempDecimal;
						loop = true;
					}
				}
			}
			for(int i = 0; i < anzahl; i++){
				System.out.println(i+1+". "+dezimalToBruch(generierteDezi[i]).output());
			}
		}
		else if(sortieren.equals("+")){
			System.out.println("aufsteigend sortiert: ");
			double tempDecimal = 0.0;
			boolean loops = true;
			while(loops){
				loops = false;
				for(int i = 0; i < anzahl-1; i++){
					if(generierteDezi[i] > generierteDezi[i+1]){
						tempDecimal = generierteDezi[i+1];
						generierteDezi[i+1] = generierteDezi[i];
						generierteDezi[i] = tempDecimal;
						loops = true;
					}
				}
			}
			for(int i = 0; i < anzahl; i++){
				System.out.println(i+1+". "+dezimalToBruch(generierteDezi[i]).output());
			}
		}
		else
			System.out.println("es kann nicht soritert werden.");
	}
	/**
	 * Umwandlung von Dezimalzahl nach Bruch
	 * @param decimal Dezimalzahl
	 * @return e Bruch Ergebnis nach Umwandlung
	 */
	private Bruch dezimalToBruch(double decimal){
        int LIMIT = 12;
        int denominators[] = new int[LIMIT + 1];
        int numerator = 0, denominator = 0, temp = 0;
        // Berechne alle moegliche Nenner
        int i = 0;
        while (i < LIMIT + 1) {
            denominators[i] = (int)decimal;
//            System.out.print(denominators[i] + "  ");
            decimal = 1.0 / (decimal - denominators[i]);
            i = i + 1;
        }
        // Berechne die i-ten approximation
        int last = 0;
        
        while (last < LIMIT) {
       
        	// Initialisiere die Variablen neu
            numerator = 1;
            denominator = 1;
            temp = 0;
           
            // Fuehre die Berechnung aus
            int current = last;
            while (current >= 0) {
                denominator = numerator;
                numerator = (numerator * denominators[current]) + temp;
                temp = denominator;
                current = current - 1;
            }
            last = last + 1;
        } 
//     System.out.println("fraction = " + (int)numerator + "/" + (int)denominator);
       Bruch e = new Bruch(numerator,denominator);
       return e;
    }
	
}
