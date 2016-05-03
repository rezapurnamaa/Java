package Vektor1;

public class Vektor1 {

	private float x, y;

	Vektor1(float px, float py) {
		x = px;
		y = py;
	}

	void ausgabe() {
		System.out.println(" Vektor = ( " + x + " , " + y + " )");
	}

	void add(Vektor1 v1, Vektor1 v2) {
		x = v1.x + v2.x;
		y = v1.y + v2.y;
	}

	void sub(Vektor1 v1, Vektor1 v2) {
	}

	float smul(Vektor1 v1, Vektor1 v2) {
		return v1.x * v2.x + v1.y * v2.y;
	}

	float betrag() {
		return ((float) Math.sqrt(x * x + y * y));
	}
}
