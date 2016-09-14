/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhouse;

/**
 *
 * @author RezaPurnama
 */
public class Parkhaus {
    private int maxAuto = 10;
    private int freeSpace = 0;
    
    public Parkhaus(){
        freeSpace = maxAuto;
    }
    
    public void einfahrenAuto(){
        if(freeSpace > 0){
            freeSpace--;
        }
        else
            throw new IllegalStateException();
    }
    
    public void rausfahrenAuto(){
        if(freeSpace >= 0){
            freeSpace++;
        }
        else
            throw new IllegalStateException();
    }
    
    public int freieParkplaetze(){
        return freeSpace;
    }
}
