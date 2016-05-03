package Vektor2;

public class Vektor2 {

	private int n; 
	private double[] vek;
	
	public Vektor2(int pn)	{
		n = pn;
		vek = new double[n];
	}
	
	public void zufall(double og) {
		for (int i=0; i<n;i++)
			vek[i]= Math.random()*og+1;
	}

	void ausgabe() {
		System.out.print(" Vektor =  ( " );
		for (int i=0; i<n;i++)
			System.out.printf("%4.2f  ", vek[i]);
		System.out.println(" )" );
	}

	void add(Vektor2 v1, Vektor2 v2) {
		for (int i=0; i<n;i++)
			vek[i] = v1.vek[i] + v2.vek[i];
	}

	float smul(Vektor2 v1, Vektor2 v2) {
		return 0;
	}

	float betrag() {
		return 0;
	}
}
