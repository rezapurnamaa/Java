/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/**
 *
 * @author RezaPurnama
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer {

    /**
     * @param args the command line arguments
     */
    
    public void run (String args[]) throws Exception {
        try {
           /*oeffnung eines ServerSockets
            *wartet auf connect-Anforderung des Clients
            */
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {          
                //nach Ausfuehren Methode accept() ermögicht es den Zugriff 
                //auf Streams fuer Kommunikation mit Client
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen: " + e.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        try {
            server.run(args);
        } catch (Exception ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class Connection extends Thread{    
        DataInputStream in;
        DataOutputStream out;
        Socket clientSocket;
        
        //Konstruktor
        public Connection(Socket aClientSocket){
            try {
                clientSocket = aClientSocket;
                in = new DataInputStream((clientSocket.getInputStream()));
                out = new DataOutputStream(clientSocket.getOutputStream());
           //     this.start();

            } catch (IOException e) {
                System.out.println("Connection: " + e.getMessage());
            }
           // public void run(){
                try{ // Echo-Server
                    String data = in.readUTF();
                    out.writeUTF(data);
                    clientSocket.close();
                } catch (EOFException e) {
                    System.out.println("EOF: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IO: " + e.getMessage());
                }
           // }
        }
    }
    
    
}
