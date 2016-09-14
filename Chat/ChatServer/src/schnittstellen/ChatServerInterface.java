package schnittstellen;

import java.rmi.*;
import java.util.*;

/**
 * Interface, das den ChatServer definiert
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 11.07.2016
 *
 */
public interface ChatServerInterface extends Remote {	
	
	/**
	 * Macht einen Client dem Server bekannt
	 * @param clientInterface neuer Client
	 * @throws RemoteException wenn Verbindung nicht m�glich
	 */
	public void login (ChatClientInterface clientInterface) throws RemoteException ;
	
	/**
	 * schickt eine Nachricht an alle verbundenen Chatclients
	 * @param message Text der Nachricht
	 * @throws RemoteException wenn Verbindung nicht m�glich
	 */
	public void publish (String message) throws RemoteException ;
	
	/**
	 * gibt die Liste der verbundenen Clients zurueck
	 * @return Liste aller mit dem Server verbundenen Clients
	 * @throws RemoteException wenn Verbindung nicht moeglich
	 */
	public Vector<ChatClientInterface> getClientliste() throws RemoteException ;
}