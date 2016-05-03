/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;
import Prog1Tools.IOTools;
/**
 * zur Berechnung 2 Vektoren mit einfacher Operationen wie Addition,
 * Substraktion, Berechnung der Skalarprodukt des Einheitsvektor.
 * Falls die Dimension 3 ist, hat der Benutzer Moeglickeit Vektorprodukt.
 * Die 3. Vektor mit Dimension 3 wird eingegeben, wenn der Benutzer die Spatprodukt berechnen moechte.
 * @author Reza Purnama A
 */

/**
 * 
 * @author RezaPurnama A
 * das ist die Mainklasse
 *
 */
public class VektorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean b=false;
        int i=0;
        Vektor v1;
        Vektor v2;
        boolean b1=false;
        DecimalFormat f = new DecimalFormat("#0.00");
        
        /*dimension des Vektor eingeben.
         * <br \> wenn die Zahl kleiner als 1 oder groesser als 7, wird der Benutzer noch einmal gefragt.*/
        while(b1==false){
            i=IOTools.readInteger("Wie viel Dimension sollen ihre Vektoren haben ? (1-7)\n");
            if(i<=1||i>=7){
                System.out.println("falsche eingabe! geben Sie nochmal ein: ");
                b1=false;
            }else
                b1=true;
        }
        v1 = new Vektor(i); //vektor wird initialisiert
        v2 = new Vektor(i); //wie Oben
        
        System.out.println("Geben Sie Vektor A und B ein :");
        
        v1.UserEingabe();
        v2.UserEingabe();
        
        
        v1.ausgabe("Vektor A");
        v2.ausgabe("Vektor B");
        
        Boolean b2=false;
        while(b2==false){
            int j = IOTools.readInteger("\nWaehlen Sie eine der folgenden Menu aus:\n"
                    + "(1) Laenge der beiden vektoren berechnen\n"
                    + "(2) Die Einheitsvektoren berechnen\n"
                    + "(3) Summe berechnen\n"
                    + "(4) Differenz berechnen\n"
                    + "(5) Skalarprodukt berechnen\n"
                    + "(6) Vektorprodukt berechnen\n"
                    + "(7) Spatprodukt berechnen ((AxB)*C)\n"
                    + "(8) Exit\n");
            switch(j){
                case 1 :
                    System.out.println("\nLange von Vektor A = "+ f.format(v1.LangeBerechnen()));
                    System.out.println("\nLange von Vektor B = "+ f.format(v2.LangeBerechnen()));
                    b=false;
                    break;
                case 2 :
                    Vektor v3 = new Vektor(i);
                    v3.EinheitsvektorBerechnen(v1);
                    v3.ausgabe("\nDie Einheitsvektor von Vektor A");
                    Vektor v4 = new Vektor(i);
                    v4.EinheitsvektorBerechnen(v2);
                    v4.ausgabe("\nDie Einheitsvektor von Vektor B");
                    b=false;
                    break;
                case 3 :
                    Vektor v5 = new Vektor(i);
                    v5.Summe(v1, v2);
                    v5.ausgabe("\nDie Summe von Vektor A und Vektor B");
                    b=false;
                    break;
                case 4 :
                    Vektor v6 = new Vektor(i);
                    v6.Differenz(v1, v2);
                    v6.ausgabe("\nDie Differenz zwischen Vektor A und Vektor B");
                    b=false;
                    break;
                case 5 :
                    System.out.println("\nSkalarprodukt von Vektor A und B = "+v1.SkalarproduktBerechnen(v2));
                    b=false;
                    break;
                case 6 :
                    Vektor v7 = new Vektor(i);
                    v7.VektorproduktBerechnen(v1, v2);
                    v7.ausgabe("Vektorprodukt von Vektor A und B = ");
                    b=false;
                    break;
                case 7 :
                    Vektor v8 = new Vektor(i);
                    v8.VektorproduktBerechnen(v1, v2);
                    if(i==3){
                    	System.out.println("\nGeben Sie Vektor C mit 3 Dimension ein :");
	                    System.out.println("\nSpatprodukt : " + v8.SpatproduktBerechnen(v1));
	                    b=false;
                    }
                    
                    break;
                case 8 :
                    b2=true;
                    break;
                default :
                    System.out.println("\nfalsche eingabe! geben Sie nochmal ein: ");
                    b=false;
            }
        }
    }
    
}
          
    