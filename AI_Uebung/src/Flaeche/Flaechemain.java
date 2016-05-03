package Flaeche;
public class Flaechemain {
    public static void main (String [] args) {
//	Erzeugen von Objekten
    	Rechteck r1 = new Rechteck(15,12,"rot");
    	Rechteck r = new Rechteck(3,5,"rot");
        Kreis k1 = new Kreis (10,"gruen");
        Kreis k2 = new Kreis (3,"blau");
        Ring ri = new Ring (k1,k2);
        Quadrat q = new Quadrat(4,"gelb");
        Schablone s = new Schablone (k1,q);
        Muster2 m = new Muster2 (r1,k2,q);
        
        System.out.println(r1);
        System.out.println(r);
        System.out.println(q);

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(ri);
        System.out.println(s);
        System.out.println(m);
//  Flaeche vom Ring
        System.out.println("Ringflaeche =  " + ri.flaeche());
        System.out.printf( "Ringflaeche = %7.2f\n",ri.flaeche());
//  Umfang der Schablone
        System.out.println("Schablonenumfang = " + s.umfang());
//  Flaeche vom Muster
        System.out.println("Musterflaeche =  " + m.flaeche());
      }
}
