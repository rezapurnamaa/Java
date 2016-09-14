import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;

import schnittstellen.*;
import libextern.IPValidator;

/**
 * Hauptprogramm für den Chatclient
 * @author Laura Woelbeling und David Rossbach
 * @version 13.06.2016
 *
 */
public class Chat{
	private ChatClientInterface client;
	private ChatServerInterface server;

	/**
	 * Hauptmethode
	 * Das Programm bricht ab, wenn keine korrekten Parameter übergeben wurden.
	 * @param args Parameter: 1. Serveradresse; 2. Chat-Alias
	 */
	public static void main(String [] args){
		String name, ip;
		Scanner s;
		Chat c;

		// check parameter count
		if (args.length != 2) {
			System.out.println("Notwendige Kommandozeilenparameter: <Serveradresse> <Chatname>");
			return;

			/*double zahl = Math.random() * 1024;
			int z = (int) zahl;
			name = "User " + z;
			ip = "169.254.207.211";*/
		} else {
			name = args[1];
			ip = args[0];
		}
		
		// check if IP is valid
		if (IPValidator.isValidIP(ip) == false) {
			System.out.println(ip + " ist keine gültige Rechneradresse.");
			return;
		}

		// try to connect and login (fail if chatname is not unique)
		try {
			c = new Chat(ip, name);
			c.loginClient();
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR, this chatname is already connected. Choose a different one.");
			return;
		} catch (Exception e) {
			System.out.println("ERROR, we wouldn't connect....");
			e.printStackTrace();
			return;
		}

		// verbunden und eingeloggt: chatte!
		s = new Scanner(System.in);
		while (true) {
			c.sendText(s);
		}
	}

	/**
	 * erzeugt eine neue Chat-Instanz
	 * @param ip	IP des Servers
	 * @param name	Chat-Alias
	 * @throws MalformedURLException bei fehlerhafter Serveradresse
	 * @throws RemoteException wenn Verbindung nicht möglich
	 * @throws NotBoundException wenn Verbindung nicht möglich
	 */
	public Chat (String ip, String name) throws MalformedURLException, RemoteException, NotBoundException {
		this.client = new ChatClient(name);
		this.server = (ChatServerInterface) Naming.lookup("rmi://" + ip + "/plauschecke");
	}

	/**
	 * prüfe ob Name des neuen Clients schon vorhanden und wenn alles passt, melde ihn an
	 * @throws RemoteException wenn Login fehlschlägt
	 * @throws IllegalArgumentException wenn Chatname bereits vergeben
	 */
	public void loginClient() throws RemoteException, IllegalArgumentException {
		Vector<ChatClientInterface> liste = server.getClientliste();
		for (ChatClientInterface c: liste) {
			if (c.getName().equals(this.client.getName())) {
				throw new IllegalArgumentException();
			}	
		}
		this.server.login(client);
	}

	/**
	 * liest eingegebenen Text ein und verteilt ihn über den Server
	 * @param s Scanner-Objekt mit offenem Eingabestream
	 */
	private void sendText(Scanner s){

		String st = s.nextLine().trim();

		try {
			st = "[" + client.getName() + "] " + st;
			server.publish(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}