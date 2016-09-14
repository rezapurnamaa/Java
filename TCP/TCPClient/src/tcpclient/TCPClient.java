/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

/**
 *
 * @author RezaPurnama
 */
import java.net.*;
import java.io.*;

public class TCPClient {

    /**
     * args give message content and server hostname
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //erzeuge Socket mit Hostname agrs 1 und Port 7896
            int severPort = 7896;
            Socket s = new Socket(args[1], severPort);
            //erzeuge Eingabe- Ausgabestream
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            //Ausgabe Zeichenkette mit KOdierung UTF
            //Schreibe Nachricht in DataOutputStream out
            out.writeUTF(args[0]);
            //wartet auf Antwort
            String data = in.readUTF();
            System.out.println("Recieved: " + data);
            //schliesse Socket
            s.close();
            
        } catch (UnknownHostException e) {
            System.out.println("Sock: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
    
}
