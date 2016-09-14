/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsuebung2;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author RezaPurnama
 */
public class Auto implements Runnable{
    private String wagennummer = "";
    private int startzeitInMilliSekunden = 0;
    private int parkdauerInMilliSekunden = 0;
    private Parkhaus parkhaus = null;
    private static int counter = 0; 

    public Auto(Parkhaus haus)
    {
        parkhaus = haus;
        startzeitInMilliSekunden = this.gibZufallszahl(20,50);
        parkdauerInMilliSekunden = this.gibZufallszahl(20,50);
        counter++;
        //wagennummer = "" + this.gibZufallszahl(1000,9999);
        wagennummer = "" + counter;
        
        System.out.println("Auto erstellt. " + wagennummer );
    }
    /*
     * Wenn der Thread gestartet wird, wartet das Auto eine bestimmte Startzeit und versucht dann,
     * in das Parkhaus zu fahren. Wenn das Parkhaus frei ist, wird geparkt und eine bestimmte Zeit gewartet,
     * bis hinausgefahren wird.
     */
    public void run() {
        try {
            Thread.sleep(startzeitInMilliSekunden);
        } catch (InterruptedException ex) {
            System.out.println("Fehler: Thread Sleep abgebrochen");
        }

        synchronized(parkhaus){
            if( parkhaus.freieParkplaetze() == 0)
            System.out.println(this.getCurrentTimestamp() + " Auto " + wagennummer + " wartet.");
            parkhaus.einfahrenAuto();
            System.out.println(this.getCurrentTimestamp() + " Auto " + wagennummer + " faehrt ein.");
        }

        try {
            Thread.sleep(parkdauerInMilliSekunden);
        } catch (InterruptedException ex) {
            System.out.println("Fehler: Thread Sleep abgebrochen");
        }
        
        System.out.println(this.getCurrentTimestamp() + " Auto " + wagennummer + " faehrt aus.");
        parkhaus.ausfahrenAuto();
        
    }
    
    
    public int getStartzeit()
    {
        return startzeitInMilliSekunden;
    }
    
    private int gibZufallszahl(int minimum, int Maximum) {
        return  (int) ((Math.random() * Maximum) + 1 + minimum);
    }

    private Timestamp getCurrentTimestamp()
    {
         Date date= new java.util.Date();
     return new Timestamp(date.getTime());
    }
}
