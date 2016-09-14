package schnittstellen;
import java.rmi.*;

/**
 * Schnittstellen des Chatclients
 * @author Laura Woelbeling und David Rossbach
 * @version 13.06.2016
 */
public interface ChatClientInterface extends Remote{	
	
	/**
	 * gibt eine Nachricht vom Server aus
	 * @param text Nachricht
	 * @throws RemoteException wenn Verbindung nicht m�glich
	 */
	public void tell (String text) throws RemoteException ;
	
	/**
	 * gibt den Namen des Client zur�ck
	 * @return Name des Client im String-Format
	 * @throws RemoteException wenn Verbindung nicht m�glich
	 */
	public String getName() throws RemoteException ;
}
