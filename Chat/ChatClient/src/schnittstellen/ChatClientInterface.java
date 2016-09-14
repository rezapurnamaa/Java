package schnittstellen;
import java.rmi.*;

/**
 * Schnittstellen des Chatclients
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 11.07.2016
 *
 */
public interface ChatClientInterface extends Remote{	
	
	/**
	 * gibt eine Nachricht vom Server aus
	 * @param text Nachricht
	 * @throws RemoteException wenn Verbindung nicht moeglich
	 */
	public void tell (String text) throws RemoteException ;
	
	/**
	 * gibt den Namen des Client zurueck
	 * @return Name des Client im String-Format
	 * @throws RemoteException wenn Verbindung nicht moeglich
	 */
	public String getName() throws RemoteException ;
}
