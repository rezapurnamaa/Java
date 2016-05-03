package Flaeche;
public class Schablone extends Flaeche {
	private Kreis kreis;
	private Rechteck rechteck;
	Schablone(Kreis kk, Rechteck rr){
		super (kk.getfarbe());
		kreis = kk;
		rechteck = rr;
	}	
	double umfang() {
            return(kreis.umfang()+rechteck.umfang());
        }
	double flaeche() {
            return(kreis.flaeche()-rechteck.flaeche());
        }
	public String toString() {
            return ("Schablone  " + kreis.getfarbe() + "\n        "
				+ kreis + " " +rechteck );
	}
}
/*
Rechteck 3.0 * 5.0 rot
Kreis 10.0 gruen
Kreis 10.0 blau
Ring  gruen
        Kreis 10.0 gruen und Kreis 10.0 blau
Schablone  gruen
        Kreis 10.0 gruen Rechteck 3.0 * 5.0 rot
*/