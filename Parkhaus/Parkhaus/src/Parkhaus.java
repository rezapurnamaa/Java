
import java.util.LinkedList;
import java.util.Queue;
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
public final class Parkhaus {
    /**
     * Maximum Anzahl von Parkpaltz
     */
    private int gesamtPlatz;
    /**
     * Anzahl verfügare Plätze
     */
    private int freiPlatz;
    /**
     * Name des Parkhauses
     */
    private String name;
    
    /**
     * Warteschlange
     */
    private static Queue queue;

    /**
     * erzeuge Parkhaus mit anzahl Platz und Name
     * @param derFreiPlatz zeigt an, wieviel Plaetze zur Verfuegung sind
     * @param dieName Name des Parkhauses
     */
    public Parkhaus(int derFreiPlatz, String dieName){
        setGesamtPlatz(derFreiPlatz);
        setFreiPlatz(derFreiPlatz);
        setName(dieName);
        queue = new LinkedList();
    }
    /**
     * liefere den Azahl von freien Plaetze
     * @return freiPlatz
     */
    public int getFreiPlatz() {
        return freiPlatz;
    }
    /**
     * 
     * @param freiPlatz setze Anzahl von Parkplatz
     */
    public void setFreiPlatz(int freiPlatz) {
        this.freiPlatz = freiPlatz;
    }
    /**
     * liefere die Name des Parkhaus zurück
     * @return Name
     */
    public String getName() {
        return name;
    }
    /**
     * setze Name ds Parkhauses
     * @param name die Name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Wenn ein Auto einfährt, ist ein Pakrplatz belegt.
     * Die Anzahl von freien Plätze sinkt um eins
     * @param auto 
     */
    public void einfahrtAuto(Auto auto){
        if (freiPlatz > 0) {
            freiPlatz--;
            System.out.println(auto.getNummerschild() + " fährt ein.");
            System.out.println("freiplatz : "+freiPlatz);
        }
        else {
            throw new IllegalStateException();
        }
    }
    
    /**
     * Wenn ein Auto ausfährt, erhöht sich die Anzahl von freien Plätze um eins
     * @param auto 
     */
    public void ausfahrtAuto(Auto auto){
        if (freiPlatz < gesamtPlatz && freiPlatz >= 0) {
            freiPlatz++;
            System.out.println(auto.getNummerschild() + " fährt aus.");
            System.out.println("verfügbar : "+freiPlatz);
        } else {
            throw new IllegalStateException();
        }
        
    }

    /**
     * @return the gesamtPlatz
     */
    public int getGesamtPlatz() {
        return gesamtPlatz;
    }

    /**
     * @param gesamtPlatz the gesamtPlatz to set
     */
    public void setGesamtPlatz(int gesamtPlatz) {
        this.gesamtPlatz = gesamtPlatz;
    }
    
    /**
     * Auto In die Warteschlange hinzufügen
     * @param auto Auto
     */
    public void addToQueue(Auto auto){
        try {
            queue.add(auto);
            System.out.println(auto.getNummerschild() + " wartet auf die Schlange");
            try {
                wait();
                //System.out.println(queue);
            } catch (InterruptedException ex) {
                Logger.getLogger(Parkhaus.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        
    }
    /**
     * Auto von der Schlange ziehen
     */
    public void removeFromQueue(){
        if(!queue.isEmpty()){
            Object peek = queue.peek();
            System.out.println("queue : "+queue);
            peek = queue.poll();
            //System.out.println("top of queue : "+peek);
        }
        
    }
    
    public void peekQueue(){
        queue.peek();
    }
}
