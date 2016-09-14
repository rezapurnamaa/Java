import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import schnittstellen.ChatClientInterface;
import schnittstellen.ChatServerInterface;

/**
 * Implementation eines Chatservers, der Nachrichten an alle verbundenen Clients verteilt
 * @author Laura Woelbeling und David Rossbach
 * @version 12.06.2016
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface{

	private static final long serialVersionUID = 6752328;
	
	/**
	 * Liste aller mit dem Server verbundenen Clients
	 */
	private Vector<ChatClientInterface> v = new Vector<ChatClientInterface>();
	
	/**
	 * leerer Konstruktor
	 * @throws RemoteException wenn Verbindung nicht möglich
	 */
	public ChatServer() throws RemoteException{}

	/**
	 * Neuen Client am Chatsystem anmelden (zur Liste hinzufügen)
	 */
	public void login(ChatClientInterface a) throws RemoteException{	
		String n = a.getName();
		//System.out.println(a.getName() + "  got connected....");	
		a.tell("[System] You have Connected successfully as " + n + ".");
		publish("[System] " + n + " has just connected.");
		v.add(a);
		//return true;		
	}

	/**
	 * Broadcast: alle verbundenen Clients aus der Liste durchgehen und Info geben. 
	 * Falls ein Server nicht mehr erreichbar ist, entferne ihn aus der Liste.
	 */
	public void publish(String s) throws RemoteException{
		Vector<ChatClientInterface> reduziert = v;
		System.out.println(s);
		for(int i=0; i<v.size(); i++){
			try {
				ChatClientInterface tmp = (ChatClientInterface) v.get(i);
				tmp.tell(s);
			} catch (Exception e) {
				//problem with the client not connected.
				//Better to remove it
				reduziert.remove(i);
				publish("[System] Info: 1 client has disconnected.");
			}
		}
		v = reduziert;
	}

	/**
	 * liefert eine Liste aller momentan angemeldeten Clients
	 */
	public Vector<ChatClientInterface> getClientliste() throws RemoteException{
		return v;
	}
}