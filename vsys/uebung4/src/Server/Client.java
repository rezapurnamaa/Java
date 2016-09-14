package Server;
import java.io.*;
import java.net.*;

/**
 * 
 * Client, welcher XML-Datei verschickt.
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 24.07.2016
 *
 *
 */
class Client {
	

	DataInputStream in;
	DataOutputStream out;
	Socket sk;
	
	
   
   public Client(Socket skt) {
	   try {
		   this.sk = skt;
		   this.in = new DataInputStream(skt.getInputStream());
		   this.out = new DataOutputStream(skt.getOutputStream());

	   } catch(Exception e) {
	         System.out.print("Nicht verbunden!\n");
	   }
	}


	public void sendRequest(String xml) {
		try {
	
		 	System.out.println(xml);
		 	
			out.writeUTF(xml);
			System.out.println(in.readUTF());
			this.sk.close();
		  }
		  catch(Exception e) {
		     System.out.print("Nicht geklappt!\n");
		  }
		   
	}

}
