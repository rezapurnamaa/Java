/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RezaPurnama
 */
public class ParkhausMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parkhaus ringCenter = new Parkhaus(1, "Ring Center");
        System.out.println(ringCenter.getName()+" hat freie Plaetze von : "+ringCenter.getFreiPlatz());
        for(int i = 0; i < 10; i++) {
            Auto car = new Auto(ringCenter);
            car.start();
        }
        
    }
    
}
