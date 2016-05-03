package Flaeche;
class Rechteck extends Flaeche {
    private double a;
    private double b;   
    Rechteck (double s1, double s2, String f){
    	super (f);
    	a = s1; b = s2;
    }
    double umfang() {
        return(2*a + 2*b);
    }
    double flaeche() {
        return(a *b);
    }
    public String toString() {
	return ("Rechteck " + a + " * " + b + " "+ getfarbe());
    }
}
