package aufgabe7;

/**
 * 
 * 
 * Dieses Programm simuliert die Berechnung von Brueche.
 * Man kann nicht nur mathematiche Operatoren (+-x:) ausfuehren,
 * sondern auch Brueche generieren aus zwei Brueche
 */

/**
 * Diese Klasse ist die Hauptklasse,
 * die zum Ausfuehren des gesamten Programms
 * @author Reza Purnama Arief
 * 
 */
public class BruchRechnungMain {
	//Attribute
	/**
	 * Erster Bruch
	 * @see Bruch
	 */
	private Bruch a = new Bruch();
	
	/**
	 * zweiter bruch
	 * @see Bruch
	 */
	private Bruch b = new Bruch();
	
	/**
	 * mathematische Operatoren [+-x:]
	 */
	private String operator;
	
	/**
	 * Sortiere die zufaellige Brueche mit "+" oder "-"
	 */
	private String sortiere;
	
	/**
	 * Anzahl zufaellige Brueche aus dem Bereich ersten und zwieten Bruch
	 */
	private int anzahl;
	
	//Constructor
	/**
	 * Konstruktor gibt Werte dem zuerstellenden Objekt
	 */
	public BruchRechnungMain(){
		operator = "";
		anzahl = 0;
	}
	//Methods
	/**
	 * Ausfuehren des Programms
	 */
	private void run(){
		Bruch ergebnis = new Bruch();
		switch (operator) {
		case "+":
			ergebnis = a.addiere(b);
			System.out.println("Addition: " +a.output() +" + " +b.output() + " = " + ergebnis.output());

			break;
		case "-":
			ergebnis = a.substrahiere(b);			
//			System.out.println(+a.getZaehler()+"/"+a.getNenner()+" - "+b.getZaehler() +"/"+b.getNenner());
			System.out.println("Substraktion: " +a.output() +" - " +b.output() + " = " + ergebnis.output());
			break;

		case "x":
			ergebnis = a.multipliziere(b);
			System.out.println("Multiplikation: " +a.output() +" * " +b.output() + " = " + ergebnis.output());

			break;
		
		case ":":
			ergebnis = a.dividiere(b);
			System.out.println("Division: " +a.output() +" : " +b.output() + " = " + ergebnis.output());

			break;
		
		case "-v":
			if(a.istGleich(b))
				System.out.println(a.output() +" = " +b.output());
			if(a.istGroesser(b))
				System.out.println(a.output() +" > " +b.output());
			if(a.istKleiner(b))
				System.out.println(a.output() +" < " +b.output());
			break;
			
		case "generiere":
			ergebnis.generiereBruch(a, b, anzahl, sortiere);
			break;
		default:
			break; 
		}
		
	}
	
//	public void setzeOperator(String input){
//		String[] operator = {"+","-","*","/"};
////		Pattern operator = Pattern.compile("\\[.+?\\]+?,?\\s*");
//		this.setOp("");
////		String temp;
//		for(int i = 0; i<operator.length; i++){
////			temp = operator[i];
////			System.out.println("temp: " +temp);
//			if(input.contains(operator[i])){
//				this.setOp(operator[i]);
//			}	
//		}
////		return op;
//	}
	
	
	/**
	 * Ueberpruefen, ob es Nummer gibt.
	 * @param str Zeichenkette der Eingabe
	 * @return <code>true</code> wenn Nummer vorhanden ist.
	 */
	public boolean istNummer(String str)  
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
	
	/**
	 * Liefere die Werte, die von Benutzer eingegen sind.
	 * @param argument Eingabe von Benutzer
	 */
	public void liefereWert(String[] argument){
//	
		if(argument.length<3){
			System.out.println("Erlaubte Eingabeformat : \n\n"
					+ "BruchRechnungMain a b op c d\n"
					+ "BruchRechnungMain a b op c\n"
					+ "BruchRechnungMain a op c d\n"
					+ "BruchRechnungMain n [ a b c d ] +\n"
					+ "BruchRechnungMain n [ a b c d ] -\n"
					+ "Moegliche Operatoren sind [+ - x :]");
		}
		else{
			if(!istNummer(argument[1])){ //pruefe ob String an der Stelle [1] nicht Nummer ist
				if(argument.length==3){ //pruefe ob der Form : a op b
					if(istNummer(argument[0])){
						a.setZaehler(Integer.parseInt(argument[0]));
						a.setNenner(1);
						operator = (argument[1]); 
						b.setZaehler(Integer.parseInt(argument[2])); //input b.zaehler
						b.setNenner(1);
					}
					else{
						System.out.println("falsche Eingabe.");
					}
				}
				else if(argument.length==4){ 
					if(istNummer(argument[0])){ //pruefe ob der Form : a op b c
						a.setZaehler(Integer.parseInt(argument[0]));
						a.setNenner(1);
						operator = (argument[1]);
						b.setZaehler(Integer.parseInt(argument[2])); //input b.zaehler
						b.setNenner(Integer.parseInt(argument[3]));
					}
					else{
						System.out.println("falsche Eingabe.");
					}
				}
				else if(argument.length==8){ //pruefe ob der Form : n [ a b c d ] op
					anzahl = Integer.parseInt(argument[0]);
					a.setZaehler(Integer.parseInt(argument[2]));
					a.setNenner(Integer.parseInt(argument[3]));
					b.setZaehler(Integer.parseInt(argument[4])); //input b.zaehler
					b.setNenner(Integer.parseInt(argument[5]));
					operator = "generiere";
					sortiere = argument[7];
				}
				else{
					System.out.println(argument.length);
					System.out.println("falsche Eingabe.");
				}
			}
			else if(!istNummer(argument[2])){ //pruefe ob String an der Stelle [2] nicht Nummer ist
				if(argument.length==4){ //pruefe Form: a b op c
					a.setZaehler(Integer.parseInt(argument[0]));
					a.setNenner(Integer.parseInt(argument[1]));
					operator = (argument[2]); 
					b.setZaehler(Integer.parseInt(argument[3])); //input b.zaehler
					b.setNenner(1);
				}
				else if(argument.length==5){
					a.setZaehler(Integer.parseInt(argument[0]));
					a.setNenner(Integer.parseInt(argument[1]));
					operator = (argument[2]);
					b.setZaehler(Integer.parseInt(argument[3])); //input b.zaehler
					b.setNenner(Integer.parseInt(argument[4]));
				}
				else{
					System.out.println("falsche Eingabe.");
				}
				
			}
			else{
				System.out.println("falsche Formateingabe.");
			}
		}
		
	}
	
	/**
	 * Ueberpruefen, ob null vorhanden ist
	 * @param argument Eingabe von Benutzer
	 * @return <code>true</code> wenn null vorhanden ist
	 */
	public boolean istZero(String[] argument){
		boolean zero = false;
		for(int i = 0; i < argument.length; i ++){
			if(argument[i].equals("0")){
				zero = true;
			}
		}
		if(zero)
			System.out.println("0 ist nicht erlaubt.");
		return zero;
	}
	
	/**
	 * Main Methode
	 * @param args wird als Eingabe von Benutzer benutzt.
	 */
	public static void main(String[] args){
		BruchRechnungMain main = new BruchRechnungMain();
		main.liefereWert(args);
		if(!main.istZero(args))
			main.run();

	}
	
}