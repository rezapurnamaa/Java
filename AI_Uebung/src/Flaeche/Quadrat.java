package Flaeche;
public class Quadrat extends Rechteck {
    
    double a;
    
    Quadrat (double s1,  String f){
    	super (s1,s1,f);
        a=s1;
    }

//    public String toString() {
//	return ("Quadrat " + a + " "+ getfarbe());
//    }
}
