/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhouse;

import java.util.ArrayList;

/**
 *
 * @author RezaPurnama
 */
public class Parkhouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus();
        ArrayList<Parkhaus> parkhausListe = new ArrayList<Parkhaus>();
        int parkhauser = 2;
        for( int i = 0; i < parkhauser; i++){
            parkhausListe.add(new Parkhaus());
        }
        for (int i = 0; i < 10; i++){
            Auto auto = new Auto(parkhaus);
            Thread thread = new Thread(auto);
            thread.start();
        }
    }
    
}
