/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

/**
 *
 * @author RezaPurnama
 */
import java.net.*;
import java.io.*;

public class UDPClient {

    /**
     * args give message content and server hostname
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            //ermoeglicht dem Client, den Port fuer die Verbindung frei zu waehlen
            DatagramSocket aSocket = new DatagramSocket();
            byte[] m;
            InetAddress aHost;
            // check parameter count
		if (args.length != 2) {
			System.out.println("Bitte Argument eingeben: <Serveradresse> <InternetAdresse>");
                        System.out.println("Bei Netbeans: UDPClient recht klicken -> Properties -> Run -> Argument -> <Serveradresse> <InternetAdresse> ");
			return;

		} else {
                        
			//Umwandlung erste Parameter in ein Byte-Array
                        m = args[0].getBytes();

                        //Umwandlung zweite Parameter in eine Internetadresse
                        aHost = InetAddress.getByName(args[1]);
		}
            
            
            //Deklaration des Server-Port
            int serverPort = 6789;
            
            //Datagrampacket request enthält:
            //Nachricht m (als Byte-Array)
            //lange der Nachricht
            //die Internetadresse des Servers aHost
            //Port des Servers (ServerPort 6789)
            DatagramPacket request = new DatagramPacket(m, args[0].length(),aHost,serverPort);
            
            //Versand des DatagramPacket
            aSocket.send(request);
            //initialisiere Eingangspuffers als Byte-Array der Groeße 1000
            byte[] buffer = new byte[1000];
            
            //Datagrampacket reply enthält:
            //Eingangspuffer in Byte
            //lange des Eingangspuffers
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            
            //Empfang des DatagramPacket
            aSocket.receive(reply);
            
            //Ausgabe der Antwort auf der Konsole
            System.out.println("Reply: " + new String(reply.getData()));
            
            //Socket schliessen
            aSocket.close();
            
        } catch (SocketException e) {
            System.out.println("Socket Client: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Client: " + e.getMessage());
        }
    }
    
}
