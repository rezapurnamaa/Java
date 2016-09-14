/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsuebung2;

/**
 *
 * @author RezaPurnama
 */
public class Vsuebung2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(5);
        for (int i = 0; i < 10; i++)
        {
            Auto auto = new Auto(parkhaus);
            Thread thread = new Thread(auto);
            thread.start();
        }
    }
    
}
