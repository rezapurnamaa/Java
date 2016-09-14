/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RezaPurnama
 */
import java.net.*;
import java.io.*;
import org.xml.sax.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {
        
        Student student = new Student("Max", "Mustermann", "Musterstrasse", "00", "10367", "Berlin", 0512345, "AI", 6);
        Professor professor = new Professor("John", "Doe", "01.01.1980", "Leipzigerstrasse", "36A", "06366", "Koethen", 123132, "Informatik");
        try {
            //erzeuge Socket mit Hostname und Port 7896
            int severPort = 7896;
            String host = "localhost";
            Socket s = new Socket(host, severPort);
            
            //erzeuge Eingabe- Ausgabestream
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
//            ObjectOutputStream clientOutputStream = new ObjectOutputStream(s.getOutputStream());
//            ObjectInputStream clientInputStream = new ObjectInputStream(s.getInputStream());
            
//            clientOutputStream.writeObject(student);
//Ausgabe Zeichenkette mit KOdierung UTF
            //Schreibe Nachricht in DataOutputStream out
            out.writeUTF(student.getXMLstr());
//            out.writeUTF(professor.getXMLstr());
            //wartet auf Antwort
            String data = in.readUTF();
            System.out.println("Recieved: " + data);
//            String data;
//            try {
//                data = (String) clientInputStream.readObject();
//                System.out.println("Recieved: " + data);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            clientOutputStream.close();
//            clientInputStream.close();
            
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
