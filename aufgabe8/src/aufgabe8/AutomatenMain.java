package aufgabe8;
/**
 * Die Klasse AutomatenMain simuliert einen Fahrkartenautomaten.
 * diese Klasse prüfen, ob sinnvolle Geldbeträge
 * eingeworfen werden, und drucken ein Ticket nur dann, wenn
 * ausreichend Geld eingeworfen wurde.
 * @author RezaPurnama
 *
 */
public class AutomatenMain {
	//Attribute
	/**
	 * bisher gezahltes Geld
	 */
	private double bisherGezahlt;
	/**
	 * Ticket oder Fahrkarten, die von Automat ausgedrueckt werden kann
	 * @see Fahrkarten
	 */
	private Fahrkarten ticket = new Fahrkarten();
	/**
	 * Eingabe von Nutzer/in ueber Tastatur
	 * @see Eingabe
	 */
	private Eingabe tastatur = new Eingabe();
	
	//Konstruktoren
	/**
     * Erzeuge einen Automaten, der Tickets zum angegebenen Preis
     * (in EUR) ausgibt.
     */
	public AutomatenMain() {
		
		bisherGezahlt = 0;
	}
	
	//Methoden
		
	/**
     * Nimm den angegebenen Betrag (in EUR) als Anzahlung für das 
     * naechste Ticket. Pruefe, ob der Betrag sinnvoll ist.
     * @param betrag Der Betrag des Gelds, der vom Nutzer eingegeben ist.
     */
    private void geldEinwerfen(double betrag) {
       
    	double[] geld = {50, 20, 10, 5, 2, 1, 0.50, 0.10, 0};
    	boolean istGueltig = false;
    	for(int i = 0; i < geld.length; i++) {
    		if (betrag == geld[i] ) {
    			istGueltig = true;
    		}
    	}
    	if(istGueltig){
    		bisherGezahlt = bisherGezahlt + betrag;
    	}
        else {
            System.out.println("Bitte nur 50 EUR, 20 EUR, 10 EUR, 5 EUR, 2 EUR, 1 EUR, 0.50 EUR, oder 0.10 EUR einwerfen."
            		+ "\nEingeworfen: " + betrag);
        }
    }
	
    /**
     * Druecke Fahrkarten aus.
     */
    private void ticketDrucken() {
    	
    	// Den Ausdruck eines Tickets simulieren.
        System.out.println("------------------------------");
        System.out.println("  Fahrkarten	   ");
        System.out.println("  " + ticket.getName());
        System.out.format("  %.2f EUR\n", ticket.getPreis());
        System.out.println("------------------------------");
        System.out.println();
        
    }
    
    /**
     * Diese Klasse simuliert den Vorgang der Transaktion
     */
    private void transaktion(){
    	
    	double betrag = 0, restBetrag = 0;
    	while(bisherGezahlt < ticket.getPreis()) {
			System.out.println();
			System.out.print("Druecken Sie '0' um die Transaktion abzubrechen.\nBitte bezahlen Sie den angezeigten Betrag : ");
			betrag = tastatur.doubleEingabe();
			geldEinwerfen(betrag);
			if(betrag == 0) {
				System.out.println("Vorgang abgebrochen.");
				System.out.format("Ihr Rueckgeld: %.2f EUR\n", bisherGezahlt);
				bisherGezahlt = 100;
			}
			else if (bisherGezahlt >= ticket.getPreis()) {
				
	            ticketDrucken();
	            double RueckGeld = bisherGezahlt - ticket.getPreis();
	            System.out.format("Gezahltes Geld: %.2f EUR\n", bisherGezahlt);
	            System.out.format("Ihr Rueckgeld: %.2f EUR\n\n", RueckGeld);
			}
	        else {
	        	
	        	restBetrag = ticket.getPreis() - bisherGezahlt;
	        	System.out.format("\nBisher gezahlt: %.2f\n", bisherGezahlt);
	            System.out.format("Sie müssen noch mindestens %.2f EUR einwerfen.", restBetrag);
	           
	        }
		}
    	bisherGezahlt = 0; //setze bisherGezahlt wieder auf null, wenn das Ticket gedrueckt ist.
    }
    /**
     * Fuehre das gesammte Programm aus.
     */
   	private void run() {
		
		boolean run = true;
		while(run) {
			
			
			System.out.println("Herzlich Willkommen "
					+ "\nbitte waehlen Sie Ihre gewuenschte Fahrkarte aus.\n"
					+ "(a) Einzelfahrausweis\n"
					+ "(b) Einzelfahrausweis Ermaessigungstarif\n"
					+ "(c) TagesKarte\n"
					+ "(d) Tageskarte Ermaessigungstarif\n"
					+ "(e) Tageskarte Kleingruppe\n"
					+ "(f) 4-Fahrten-Karte\n"
					+ "(g) 4-Fahrten-Karte Ermaessigung\n"
					+ "(h) Einzelfahrausweis Fahrrad\n"
					+ "(i) Tageskarte Fahrrad\n"
					+ "(j) Monatskarte\n"
					+ "(-1) Beenden");
			System.out.print("Ihre wahl: ");
			String wahl = tastatur.benutzerEingabe();
			
			switch(wahl) {
			case "a":
				ticket.setName("Einzelfahrausweis");
				ticket.setPreis(2.30);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "b":
				ticket.setName("Einzelfahrausweis Ermaessigungstarif");
				ticket.setPreis(1.60);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
			
			case "c":
				ticket.setName("Tageskarte");
				ticket.setPreis(6.70);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "d":
				ticket.setName("Tageskarte Ermaessigungstarif");
				ticket.setPreis(4.70);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "e":
				ticket.setName("Tageskarte Kleingruppe");
				ticket.setPreis(16.20);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "f":
				ticket.setName("4-Fahrten-Karte");
				ticket.setPreis(8.80);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
				
			case "g":
				ticket.setName("4-Fahrten-Karte Ermaessigung");
				ticket.setPreis(5.60);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "h":
				ticket.setName("Einzelfahrausweis Fahrrad");
				ticket.setPreis(1.70);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "i":
				ticket.setName("Tageskarte Fahrrad");
				ticket.setPreis(4.70);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				
			case "j":
				ticket.setName("Monatskarte");
				ticket.setPreis(76.00);
				System.out.format("%s \nEs kostet: %.2f EUR\n"
						,ticket.getName(), ticket.getPreis());
				transaktion();
				break;
				

			case "-1":
				System.out.println("Programm Beendet.");
				run = false;
				break;
				
				default:
					
			}
		}
		
		
	}
	/**
	 * Main-Methode
	 * @param args ist nicht verwendet
	 */
	public static void main(String[] args) {
		
		AutomatenMain main = new AutomatenMain();
		main.run();
	}
}
