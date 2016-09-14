
import java.net.Inet4Address;
import java.rmi.*;
import schnittstellen.ChatServerInterface;
     
/**
 * Hauptprogramm des Servers
 * @author Laura Woelbeling und David Rossbach
 * @version 13.06.2016
 *
 */
public class StartServer {
	
	/**
	 * erzeugt ein neues Server-Objekt und bindet es an die lokale IP-Adresse/plauschecke
	 * RMI horcht auf Port 1099.
	 * @param args nicht benutzt
	 */
	public static void main(String[] args) {
		String serveradresse;
		try {
			//System.setSecurityManager(new RMISecurityManager());
			java.rmi.registry.LocateRegistry.createRegistry(1099);		// Port festlegen
			serveradresse = Inet4Address.getLocalHost().getHostAddress();
			//serveradresse = "localhost";
			
			ChatServerInterface b = new ChatServer();	
			Naming.rebind("rmi://" + serveradresse + "/plauschecke", b);		// aktuelle Adresse 

			System.out.println("[System] Chat Server (" + serveradresse +") is ready.");
		} catch (Exception e) {
			System.out.println("[System] Chat Server failed: " + e);
		}
	}
}