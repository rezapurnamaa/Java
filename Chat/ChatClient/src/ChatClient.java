import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import schnittstellen.ChatClientInterface;

/**
 * Implementation eines Chatclients, welcher Nachrichten vom Server ausgibt.
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 11.07.2016
 *
 */
public class ChatClient  extends UnicastRemoteObject implements ChatClientInterface{

	
	/**
	 * Name des Clients
	 */
	private String name;

	/**
	 * Konstruktor: erzeugt neuen Client und setzt Name
	 * @param n Name des neuen Clients
	 * @throws RemoteException wenn Verbindung nicht m�glich
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
	 * gibt den Namen des Client zur�ck
	 */
	public String getName() throws RemoteException{
		return name;
	}
}