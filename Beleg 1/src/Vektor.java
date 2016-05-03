
//import java.util.Scanner;
import java.text.DecimalFormat;
import Prog1Tools.IOTools;

/**
 *
 * @author s0533453
 */

/** ein Vektor, die ein n-Dimension hat, und in einem Array geschpeichert wird.
 * <br /> es kann einfache Operationen von Vektorrechnung wie Addition, Substraktion, Berechnung eines einheitsvektor und einer Skalarprodukt ausfuehren. */

public class Vektor{
	//Attribut
     /** ein Array, in dem die werte eines vektor geschpeichert wird. */
    private double[] v;
    
    /** die Dimension eines Vektor */
    private int dim;
    /**
     * die Bedingung, so dass die methode zur Berechnung der Vektorprodukt ausgefuehrt werden kann.
     */
    final int kreuzprodukt_dim = 3;
    //Constructor

    /**erzeugt ein Vektor mit i-Dimension 
     *@param i  Dimension des Vektors
     */
    Vektor(int i){
        dim =i;
        v = new double[i];
        
    
    
    }
    
    //Method
    /** speichere die eingegebene Zahl von Benutzern als der wert des Vektors
     * 
     */
    public void UserEingabe(){
   //     int[] a = new int[dim];
        for(int j = 0; j<dim; j++){
            double x = IOTools.readDouble("Geben Sie die "+(j+1)+".Zahl ein : ");
            v[j] = x;
            }
    }
    
    /**
     * gibt das Vektor auf dem Bildschirm aus
     * @param s man kann ein String vor dem Vektor hinzufuegen
     */
    
     public void ausgabe(String s){
        DecimalFormat f = new DecimalFormat("#0.00");
    	System.out.print(s+" =[");
        for(int j = 0;j<dim;j++){
            System.out.print(f.format(v[j]));
            if(j == dim-1){
                System.out.println("]");
            }
            else{
                System.out.print(" , ");
            }
            
        }
    }
    /**
     * berechnet die Lange bzw. den Betrag eines Vektors.
     * @return Lange bzw. Betrag in Doublewert
     */
    
    public double LangeBerechnen(){
        double i= 0;
        for(int j = 0; j<dim; j++){    
             i += Math.pow(v[j], 2);
       }
        double j = Math.sqrt(i);
        return j;
    }
    
    /**
     * untersucht das Einheitsvektor eines Vektor, und speichert das Ergebnis als eigenes Vektor.
     * @param a das Vektor, dessen Einheitsvektor zu berechnen ist.
     */
    
    public void EinheitsvektorBerechnen(Vektor a){
        for(int j = 0; j<dim; j++){
            v[j] = a.v[j]/a.LangeBerechnen();
        }
    }
    
    /**
     * addiert vektor b zu Vektor a und speichert den Ergebnis in eigenes Vektor.
     * @param a das erste Vektor
     * @param b das zweite Vektor
     */
    
    public void Summe(Vektor a, Vektor b){
        for(int j = 0;j<dim;j++){
            v[j]= a.v[j] + b.v[j];
        }  
    }
    
    /**
     * Substrahiere Vektor a und Vektor b und speichert den Ergebnis in eigenes Vektor.
     * @param a das erste Vektor
     * @param b das zweite Vektor
     */
    
    public void Differenz(Vektor a, Vektor b){
        for(int j=0; j<dim; j++){
            v[j]= a.v[j] - b.v[j];
        }  
    }
    
    /**
     * berechnet das Skalarprodukt von 2 Vektoren
     * @param v1 ein Vektor
     * @return das Skalarprodukt
     */
    
    public double SkalarproduktBerechnen(Vektor v1){
        double S=0;
        for(int j = 0; j<dim; j++){
            S += v[j]*v1.v[j];
        }
        return S;
    }
    
    /**
     * erzeugt das Vektorprodukt von 2 Vektoren, mit Bedingung dimension = 3
     * @param a das erste Vektor
     * @param b das zweite Vektor
     */
    
    public void VektorproduktBerechnen(Vektor a,Vektor b){
        if(dim != kreuzprodukt_dim){
            System.out.println("\nEs kann nur die Kreuzprodukt fuer 3-dimensionales vektor berechnet werden!");
        }else{
            v[0]=(a.v[1]*b.v[2])-(a.v[2]*b.v[1]);
            v[1]=(a.v[2]*b.v[0])-(a.v[0]*b.v[2]);
            v[2]=(a.v[0]*b.v[1])-(a.v[1]*b.v[0]);
        }
    }
    
    /**
     * Einlesen von 3.Vektor / Vektor C
     */
    double[] w = new double[3];
    public void Vektor3(){
        
        for(int j = 0; j<3; j++){
//                        System.out.print("Geben Sie die "+(j+1)+".Zahl ein : ");
//                        Scanner sc = new Scanner(System.in);
//                        w[j] = sc.nextDouble();
        	w[j] = IOTools.readDouble("Geben Sie die "+(j+1)+".Zahl ein : ");
                        } 
    }
    /**
     * berechnet das Spatprodukt von 3 Vektoren
     * @return das Spatprodukt
     */
    public double SpatproduktBerechnen(Vektor x){
        double sp = 0;
        Vektor3();
        for(int j = 0; j<3; j++){
            sp += v[j]*w[j];
        }
        return sp;
        }
        
}