package Flaeche;
public class Ring extends Flaeche {
	private Kreis kreisa, kreisi;
	Ring (Kreis a, Kreis b){
		super (a.getfarbe());
		kreisa = a; 
		kreisi = b;
	}
	double umfang() {
            return(kreisa.umfang()+kreisi.umfang());
        }
	double flaeche() {
            return(kreisa.flaeche()-kreisi.flaeche());
        }
	public String toString() {
            return ("Ring  " +  kreisa.getfarbe() + "\n        "
			     + kreisa + " und " + kreisi );
	}
}
