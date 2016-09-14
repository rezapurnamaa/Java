import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import schnittstellen.ChatClientInterface;

/**
 * Implementation eines Chatclients, welcher Nachrichten vom Server ausgibt.
 * @author Laura Woelbeling und David Rossbach
 * @version 12.06.2016
 */
public class ChatClient  extends UnicastRemoteObject implements ChatClientInterface{

	private static final long serialVersionUID = 87643;
	/**
	 * Name des Clients
	 */
	private String name;

	/**
	 * Konstruktor: erzeugt neuen Client und setzt Name
	 * @param n Name des neuen Clients
	 * @throws RemoteException wenn Verbindung nicht möglich
	 */
	public ChatClient (String n) throws RemoteException {
		name = n;
	}

	/**
	 * gibt eine Nachricht aus
	 */
	public void tell (String st) throws RemoteException{
		System.out.println(st);
	}
	
	/**
	 * gibt den Namen des Client zurück
	 */
	public String getName() throws RemoteException{
		return name;
	}
}