/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhouse;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author RezaPurnama
 */
public class Auto implements Runnable{

    private String kennzeichen = "";
    private int delayStart = 0;
    private int delayPark = 0;
    private Parkhaus parkhaus = null;
    private static int schild = 0;
    
    public Auto(Parkhaus parkhaus){
        this.parkhaus = parkhaus;
        this.delayStart = this.rand(20, 50);
        this.delayPark = this.rand(20, 50);
        schild = schild + 1;
        kennzeichen = "Auto - " + schild;
    }
    
    
    private int rand(int min, int max){
        java.util.Random r = new Random();
        return (r.nextInt(max - min + 1) + min);
    }
    
    private Timestamp getCurrentTimestamp(){
        Date date = new java.util.Date();
        return new Timestamp(date.getTime());
    }
    
    @Override
    public void run() {
        System.out.println("Auto startet. Nummerschild: " + kennzeichen);
        try {
            Thread.sleep(delayStart);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted");
        }
        
        synchronized(parkhaus){
            try {
                while (parkhaus.freieParkplaetze() == 0) {
                    parkhaus.wait();
                }
            } catch (Exception e) {
                
            }
            parkhaus.einfahrenAuto();
            System.out.println(this.getCurrentTimestamp() + " enter: " + kennzeichen);
        }
        
        try {
            Thread.sleep(delayPark);
        } catch (Exception e) {
            System.out.println("Thread sleep interrupted");
        }
        
        synchronized(parkhaus){
            parkhaus.rausfahrenAuto();
            System.out.println(this.getCurrentTimestamp()+" leave: " + kennzeichen);
        }
        parkhaus.notifyAll();
    }
    
}
