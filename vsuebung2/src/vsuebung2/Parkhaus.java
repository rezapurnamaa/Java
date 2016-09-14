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
public class Parkhaus {
    private int freiePlaetze;
    private int nummerWarten;
    private int nummerEinfahren;

    public Parkhaus(int plaetze)
    {    
        freiePlaetze = plaetze;
        nummerWarten = 0;
        nummerEinfahren = 0;
    }

    public synchronized void einfahrenAuto()
    {
        int nummer  = nummerWarten++;
        while (nummer != nummerEinfahren || freiePlaetze == 0)
        {
            try 
            {
                wait(); 
            }
            catch(InterruptedException e)
            { 
            }
        }
        freiePlaetze--;
        nummerEinfahren++;
        notifyAll();
    }
    
    
    public synchronized void ausfahrenAuto()
    {
        freiePlaetze++;
        notifyAll();
    }

    public int freieParkplaetze()
    {
        return freiePlaetze;
    }
}
