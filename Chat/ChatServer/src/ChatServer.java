import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import schnittstellen.ChatClientInterface;
import schnittstellen.ChatServerInterface;

/**
 * Implementation eines Chatservers, der Nachrichten an alle verbundenen Clients verteilt
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 11.07.2016
 *
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface{

	
	
	/**
	 * Liste aller mit dem Server verbundenen Clients
	 */
	private Vector<ChatClientInterface> chatClientVector = new Vector<ChatClientInterface>();
	
	/**
	 * leerer Konstruktor
	 * @throws RemoteException wenn Verbindung nicht moeglich
	 */
	public ChatServer() throws RemoteException{}

	/**
	 * Neuen Client am Chatsystem anmelden (zur Liste hinzufuegen)
	 */
	public void login(ChatClientInterface chatClient) throws RemoteException{	
		String n = chatClient.getName();
		//System.out.println(chatClient.getName() + "  got connected....");	
		chatClient.tell("[System] You have Connected successfully as " + n + ".");
		publish("[System] " + n + " has just connected.");
		chatClientVector.add(chatClient);
		//return true;		
	}

	/**
	 * Broadcast: alle verbundenen Clients aus der Liste durchgehen und Info geben. 
	 * Falls ein Server nicht mehr erreichbar ist, entferne ihn aus der Liste.
	 */
	public void publish(String broadcastInfo) throws RemoteException{
		Vector<ChatClientInterface> reduziert = chatClientVector;
		System.out.println(broadcastInfo);
		for(int i=0; i<chatClientVector.size(); i++){
			try {
				ChatClientInterface tmp = (ChatClientInterface) chatClientVector.get(i);
				tmp.tell(broadcastInfo);
			} catch (Exception e) {
				//problem with the client not connected.
				//Better to remove it
				reduziert.remove(i);
				publish("[System] Info: 1 client has disconnected.");
			}
		}
		chatClientVector = reduziert;
	}

	/**
	 * liefert eine Liste aller momentan angemeldeten Clients
	 */
	public Vector<ChatClientInterface> getClientliste() throws RemoteException{
		return chatClientVector;
	}
}