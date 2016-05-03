package aufgabe10;
/**
 * Dieses Programm realisiert das Beute-Jaeger-Spiel.
 * Auf einem unsichtbaren Schachbrett wird die Beute per Zufall
 * auf eines der Felder positioniert. der Spieler oder die Spielerin wird aufgefordert,
 * den (oder die) Jäger (Dame, Turm oder zwei Läufer) auf dem unsichtbaren Schachbrett
 * zu positionieren. Anschließend stehen n Versuche zur Verfügung, durch Ziehen der Figur(en) des Jägers, die
 * Beute zu treffen. Dabei kann die Beute "übersprungen" werden.
 * @author RezaPurnama
 *
 */
public class BeuteJaeger {

	//Attribute
	/**
	 * Spielfigur, die von Spieler/in ausgewaehlt wird
	 */
	private Spielfigur figur1;
	/**
	 * Diese Spielfigur wird benutzt, wenn Spieler/in
	 * Laeufer gewaehlt hat, weil der Laeufer nur entweder im swchwarzen- oder
	 * im weissen Feld sich befindet. 
	 */
	private Spielfigur figur2;
	
	/**
	 * Empfange die Eingabe von Spieler/in
	 */
	private Eingabe input = new Eingabe();
	/**
	 * Nimmt die von Spieler/in eingegebene Spalte
	 */
	private char ch;
	/**
	 * nimmt die von Spieler/in eingegebene Felder
	 */
	private int intInput;
	/**
	 * Positioniere Spielfigur auf x-Achse
	 */
	private int xInput;
	/**
	 * Positioniere Spielfigur auf y-Achse
	 */
	private int yInput;
	//Constructor
	/**
	 * Initialisiere das Spiel
	 */
	public BeuteJaeger(){
		ch = ' ';
		intInput = 0;
		xInput = 0;
		yInput = 0;
	}
	
	//Method
	/**
	 * Starte das Spiel
	 */
	public void run(){
		int count = 0;
		int versuch = 0;
		System.out.println("--Beute-Jaeger-Speiel--\n");
		Beute beute = new Beute();
		System.out.println("Beute ist vorhanden.\n");
		
//		System.out.println("Beute befindet sich im Feld : " +  intToChar(beute.getxPosition()) + beute.getyPosition());
		
		
		while (!istAuswahlOk(intInput)){
			System.out.println("1 - Dame\n"
					+ "2 - Turm\n"
					+ "3 - Laeufer\n");
			System.out.print("Waehlen Sie ihre Spielfigur: ");
			intInput = input.intEingabe();
		}
		
		System.out.println("Setzen Sie den Jaeger");
		
		//if(strInput.equals("3")){
		int[] position = positionieren();
		xInput = position[0];
		yInput = position[1];
				
		
		switch (intInput){
		case 1:
			figur1 = new Dame("Dame",xInput,yInput);
			figur2 = null;
			
			break;
			
		case 2:
			figur1 = new Turm("Turm",xInput,yInput);
			figur2 = null;

			break;
			
		case 3:
			
			figur1 = new Laufer("Laeufer1",xInput,yInput);
//			System.out.println("Bitte setzen Sie den naehste Jaeger ein");
//			position = position();
				xInput += 1;
			figur2 = new Laufer("Laeufer2",xInput,yInput);

			break;
		}
//		if(figur2 != null){
//			System.out.println("Ihre " + figur1.name + " befindet sich im Feld: " +  intToChar(figur1.xPosition) + figur1.yPosition);
//			System.out.println("Ihre " + figur2.name + " befindet sich im Feld: " +  intToChar(figur2.xPosition) + figur2.yPosition);
//		}
//		else{
//			System.out.println("Ihre " + figur1.name + " befindet sich im Feld: " +  intToChar(figur1.xPosition) + figur1.yPosition);
//		}
		System.out.print("Wie viele Versuche wollen Sie spielen: ");
		versuch = input.intEingabe();
		while ((!vergleichBeute(figur1, beute)) && (!vergleichBeute(figur2, beute) && versuch != 0)){
			count++;		
//			if(versuch != 0){
			
				if (figur2 == null){
					figur1.ziehe(input);
					
				}
				else{
					figur1.ziehe(input);
					
					figur2.ziehe(input);
					
				}
				
				System.out.println("Ihre "+ count +" Versuch.");
//			}
//			else{
			versuch--;
			if (versuch == 0){
				System.out.println("Sie haben verloren.");
			}
			
		}
//		System.out.println("Gewinnen!");
	}
	
	/**
	 * Buchstaben wird auf Zahl umgesetzt
	 * @param ch Buchstaben
	 * @return Zahl
	 */
	public int charToInt(char ch){
		int position = (int) ch;
		if (ch < 97){
			position = position + 32;
		}
		return position - 96;
	}

	/**
	 * Pruefe, ob die eingegebene Buchstabe fuer x-Achse richtig ist
	 * @param ch Buchstabe
	 * @return <code>true</code> Die Eingabe ist zugelassen
	 */
	public boolean istEingabeOk(char ch){
		boolean eingabeOk = false;
		int convert = (int) ch;
		if (convert < 97){
			convert = convert + 32;
		}
		for (int i = 97; i <= 104; i++) {
			if(convert == i){
				eingabeOk = true;
			}
		}
	
		return eingabeOk;
	}
	
	/**
	 * Vergleiche Position der Spielfigur mit Beute
	 * @param figur Spielfigur
	 * @param beute Beute
	 * @return <code>true</code> Beute ist gefunden.
	 * <code>false</code> Beute ist nicht gefunden.
	 */
	public boolean vergleichBeute(Spielfigur figur, Beute beute){
		boolean gefunden = false;
		if (figur != null){
			if (figur.xPosition == beute.getxPosition() && figur.yPosition == beute.getyPosition()){
				gefunden = true;
				System.out.println("Gewinnen! Ihr " + figur.name + " hat Beute im Feld " +  intToChar(figur.xPosition) + figur.yPosition + " gefunden.");
			}
			else{
				System.out.println("Ihr " + figur.name + " befindet sich im Feld " +  intToChar(figur.xPosition) + figur.yPosition);
				
				new Suchen(figur,beute).check();
			}
		}
		
		return gefunden;

		
	
	}
	
	/**
	 * Pruefe, ob die eingegebene Zahl fuer y-Achse richtig ist
	 * @param input Zahl
	 * @return <code>true</code> Die Eingabe ist zugelassen
	 */
	public boolean istEingabeOk(int input){
		boolean eingabeOk = false;
		if(input >= 1 && input <= 8)
			eingabeOk = true;
		return eingabeOk;
	}
	/**
	 * Pruefe, ob die eingegebene Zahl fuer Auswahl richtig ist
	 * @param input Zahl
	 * @return <code>true</code> Die Eingabe ist zugelassen
	 */
	public boolean istAuswahlOk(int input){
		boolean eingabeOk = false;
		if (input >= 1 && input <= 3)
			eingabeOk = true;
		return eingabeOk;
	}

	/**
	 * Setze die Spielfigur auf dem Schachbrett
	 * @return Position auf dem Schachbrett
	 */
	public int[] positionieren(){
		int xPos = 0;
		int yPos = 0;
		while (!istEingabeOk(ch)){
			
			System.out.print("Spalte (A-H) : ");
			ch = input.charEingabe();
//			System.out.println(ch);
		}
		xPos = charToInt(ch);
		
		while (!istEingabeOk(yPos))
		{
			System.out.print("Zeile (1-8) : ");
			yPos = input.intEingabe();
//			System.out.println(yPos);
		}
		
		return new int[]{xPos,yPos};
	}
	/**
	 * Die Zahl wird nach Buchstaben umgesetzt
	 * @param input die Zahl
	 * @return Buchstaben
	 */
	public char intToChar(int input){
		char ch = (char) (input + 64);
		
		return ch;
	}
}
