package Vektor1;

public class Vektor1test {

	public static void main(String[] args) {
		Vektor1 w1, w2, w3;
		w1 = new Vektor1(3, 4);
		w2 = new Vektor1(-1, 1);
		w3 = new Vektor1(0, 0);

		w1.ausgabe();
		w2.ausgabe();
		System.out.println(" Addition ");
		w3.add(w1, w2);
		w3.ausgabe();
		System.out.println(" Skalarprodukt = " + w1.smul(w1, w2));
		System.out.println(" Betrag von w1 = " + w1.betrag());
	}
}