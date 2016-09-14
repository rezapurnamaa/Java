
import java.net.Inet4Address;
import java.rmi.*;
import schnittstellen.ChatServerInterface;
     
/**
 * Hauptprogramm des Servers
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 11.07.2016
 *
 */
public class StartServer {
	
	/**
	 * erzeugt ein neues Server-Objekt und verbindet es an die lokale IP-Adresse/plauschecke
	 * RMI hoert auf Port 1099.
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