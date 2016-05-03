package Vektor2;

public class Vektor2test {

	public static void main(String[] args) {
		Vektor2 w1, w2, w3;
		w1 = new Vektor2(4);
		w2 = new Vektor2(4);
		w3 = new Vektor2(4);

		w1.zufall(33);
		w2.zufall(15);
		w1.ausgabe();
		w2.ausgabe();
		System.out.println(" Addition ");
		w3.add(w1, w2);
		w3.ausgabe();
		System.out.println(" Skalarprodukt = " + w1.smul(w1, w2));
		System.out.println(" Betrag von w1 = " + w1.betrag());
	}
}