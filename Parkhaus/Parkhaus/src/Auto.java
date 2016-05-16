
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RezaPurnama
 */
public final class Auto extends Thread{
    /**
     * Initialisiere thread
     */
    private Thread thread;
    
    /**
     * Nummerschild des Auo
     */
    private String nummerschild;
    
    /**
     * Abfahrtszeit des Autos
     */
    private int abfahren;
    
    /**
     * Dauer von Parken eines Autos
     */
    private int parken;
    
    /**
     * Initialisiere Parkhaus
     */
    private Parkhaus parkhaus;
    
    /**
     * counter als Hilfe um die Auto zu zählen
     */
    private static int counter = 1;
    
    /**
     * Erstelle ein Auto
     * @param parkhaus wo das Auto einparken kann.
     */
    public Auto(Parkhaus parkhaus){
        setParkhaus(parkhaus);
        setAbfahren(0);
        setParken(2000);
        setNummerschild(getRandom(1000, 9999));
        getInfoAuto();
        counter++;
    }
    
    /**
     * liefere nummerschild
     * @return the nummerschild
     */
    public String getNummerschild() {
        return nummerschild;
    }

    /**
     * @param autoNummerschild the autoNummerschild to set
     */
    public final void setNummerschild(int autoNummerschild) {
        this.nummerschild ="B-"+ Integer.toString(autoNummerschild) + " " + counter;

    }
    
    /**
     * setze Die Abfahrtszeit
     * @param autoAbfahren 
     */
    public void setAbfahren(int autoAbfahren){
        this.abfahren = autoAbfahren;
    }
    
    /**
     * setze Parkzeit
     * @param autoParken Parkzeit in ms
     */
    public void setParken(int autoParken){
        this.parken = autoParken;
    }
    
    /**
     * setze Parkhaus
     * @param dasParkhaus Parkhaus
     */
    public void setParkhaus(Parkhaus dasParkhaus){
        this.parkhaus = dasParkhaus;
    }
    
    /**
     * generiere eine Zufallszahl, die als Nummerschild verwendet wird
     * @param minimum Untergrenze
     * @param Maximum Öbergrenze
     * @return Zufallszahl
     */
    private int getRandom(int minimum, int Maximum) {
        return  (int) ((Math.random() * Maximum) + 1 + minimum);
    }
    
    /**
     * liefere Info über neues erstelltes Auto
     */
    private void getInfoAuto(){
        System.out.println("Neues Auto. Nummerschild: " + nummerschild );
        
    }
    
    /**
     * ein Auto fährt ein. Wenn Parkhaus voll ist, wartet Auto auf das abdere,
     * bis ein anderes ausfährt
     * @return boolean
     */
    public boolean eingefahrenParkhaus(){
        boolean eingefahren = false;
    
        synchronized(parkhaus){
            while(parkhaus.getFreiPlatz() == 0){
                System.out.println("Parkhaus ist voll. " + nummerschild + " wartet.");
                try {            
                    parkhaus.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            parkhaus.einfahrtAuto(this);
            //System.out.println("Eingefahren: " + nummerschild);
            eingefahren = true;
        }
        return eingefahren;
    }
    
    /**
     * Auto fährt aus und informiert das andere.
     */
    public void rausfahrenParkhaus(){
        synchronized(parkhaus){
            parkhaus.ausfahrtAuto(this);
            System.out.println("Ausgefahren: " + nummerschild);
            parkhaus.notifyAll();
        }
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(abfahren);
        } catch (InterruptedException e) {
            System.out.println("Fehler: Thread sleep interrupted.");
        }
        
        if (eingefahrenParkhaus()) {
            try {
                System.out.println(nummerschild + " parkt für " + parken + " ms.");
                Thread.sleep(parken);
            } catch (InterruptedException e) {
                System.out.println("Fehler: Thread sleep interrupted.");
            }
            rausfahrenParkhaus();
        }
               
    }
    
    @Override
    public void start(){
        System.out.println(nummerschild + " fährt los.");
        if (thread == null) {
            thread = new Thread (this, nummerschild);
            thread.start();
        }
    }

    
}
