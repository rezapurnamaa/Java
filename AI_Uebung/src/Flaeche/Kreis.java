package Flaeche;
public class Kreis extends Flaeche {
	private double r;
        Kreis (double rr, String f){
	    	super (f);
	    	r = rr;
	}
	double umfang() {
	     return(2*3.141596 * r);
	}
	double flaeche() {
	     return(3.141596*r*r);
	}
	public String toString() {
             return ("Kreis " + r + " "+ getfarbe());
        }
}
