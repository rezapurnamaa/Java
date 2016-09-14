package libextern;

/**
 * Prüft ob String valide IP enthält
 * Quelle: http://www.java-forum.org/thema/ip-eingabe-ueberpruefen.16688/
 * (angepasst von Laura Woelbeling)
 * @author Zille
 * @version 14.05.2005
 */
public class IPValidator {
   
    public static boolean isValidIP(String ip){
        String[] zahlen = ip.split("\\."); //Splitten in Zahlen
        if (ip.equalsIgnoreCase("localhost")){
            return true; //wenn ip = localhost
        }
        if (zahlen.length <4)
            return false; //wenn es weniger als 4 Zahlen gibt
        else{
            for (int i=0;i<zahlen.length;i++){
                try {
                    //jede Zahl passen auf Integer
                    //falls fehler dann return false
                    int zahl = Integer.parseInt(zahlen[i]);
                    // wenn Zahl nicht zwischen 0 und 255 liegt
                    if ((zahl < 0)||(zahl >255))
                        return false;//dann false
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }
}