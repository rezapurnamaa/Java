/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;

/**
 *
 * @author RezaPurnama
 */
import java.net.*;
import java.io.*;
public class UDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Erzeuge DatagramSocket mit Portnummer 6789
            DatagramSocket aSocket = new DatagramSocket(6789);
            //initialisiere Eingangspuffer mit 1000 Byte
            byte[] buffer = new byte[1000];
            
            while (true) {                
                //DatagramPacket aus dem Eingangspuffer
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                //Empfangen eines potenzielles DatagramPackets request am aSocket
                aSocket.receive(request);
                
                //initialisiere DatagramPacket als Antwort
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
                //Versand des DatagramPacket ueber aSocket
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket Server: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Server: " + e.getMessage());
        }
        // TODO code application logic here
    }
    
}
