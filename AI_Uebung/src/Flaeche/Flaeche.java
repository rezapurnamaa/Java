package Flaeche;
public class Flaeche {
	private String farbe;
	Flaeche (String f) {
		farbe = f;
	}
	public String getfarbe(){
		return farbe;
	}
	public String toString() {
		return "Farbe ist " +  farbe;
	}
}

