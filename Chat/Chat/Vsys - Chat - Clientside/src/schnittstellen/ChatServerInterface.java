package schnittstellen;

import java.rmi.*;
import java.util.*;

/**
 * Interface, das den ChatServer definiert
 * @author Laura Woelbeling und David Rossbach
 * @version 13.06.2016
 */
public interface ChatServerInterface extends Remote {	
	
	/**
	 * Macht einen Client dem Server bekannt
	 * @param a neuer Client
	 * @throws RemoteException wenn Verbindung nicht möglich
	 */
	public void login (ChatClientInterface a) throws RemoteException ;
	
	/**
	 * schickt eine Nachricht an alle verbundenen Chatclients
	 * @param s	Text der Nachricht
	 * @throws RemoteException wenn Verbindung nicht möglich
	 */
	public void publish (String s) throws RemoteException ;
	
	/**
	 * gibt die Liste der verbundenen Clients zurück
	 * @return Liste aller mit dem Server verbundenen Clients
	 * @throws RemoteException wenn Verbindung nicht möglich
	 */
	public Vector<ChatClientInterface> getClientliste() throws RemoteException ;
}