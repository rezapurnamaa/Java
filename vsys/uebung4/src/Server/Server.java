package Server;

import java.io.*;
import java.net.*;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.parsers.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import javax.xml.validation.Validator;	// explicitly!

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import Person.Professor;
import Person.Student;

/**
 * Im Server werden XML-Dateien erzeugt
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 24.07.2016
 */
class Server {
	public static void main(String args[]) {

	   try {
		   int serverPort = 1234;
		   Server a = new Server();
		   @SuppressWarnings("resource")
		ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket skt = listenSocket.accept();
				System.out.print("Client has connected!\n");
				a.new Connection(skt);
			}
      } catch(Exception e) {
         System.out.println("Nicht geklappt." + e.getMessage());
      }
	}
	
	
private int counter = 0;	
	
	/**
	 * Validiert das XML gegen ein Schema
	 * @param in InputStream
	 * @return true/false 
	 */
	private String validieren(String xmlStr){	
		String xsdPath;
		String typ;
		
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlStr));
			Document doc = db.parse(is);
			typ = doc.getFirstChild().getNodeName();
			xsdPath = "resources/" + typ + ".xsd";
			
	         SchemaFactory factory =
	            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(xsdPath));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new ByteArrayInputStream(xmlStr.getBytes("UTF-8"))));
	      } catch (Exception e) {
	    	  System.out.println("Exception: "+e.getMessage());
		      return null;
	      }
			
	      return typ;
	}
	
	private Object instanziieren(String xml) {
		String typ;
		Object result = null;
		
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			Document doc = db.parse(is);
			typ = doc.getFirstChild().getNodeName();
			Class<?> cls = Class.forName("Person." + typ);
			result = JAXB.unmarshal(new StringReader(xml), cls);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * Innere Klasse
	 */
	class Connection extends Thread{
		
		DataInputStream in;
		DataOutputStream out;
		Socket clientSocket;
		
		/**
		 * Konstruktor
		 * @param aClientSocket
		 */
		public Connection(Socket aClientSocket){
			try{
				clientSocket = aClientSocket;
				in = new DataInputStream(clientSocket.getInputStream());
				out = new DataOutputStream(clientSocket.getOutputStream());
				this.start();
			}
			catch(IOException e){
				System.out.println("Connection: " + e.getMessage());
			}
		}
		
		
		public void run(){
			try{
				System.out.println(counter++);
				String xmlStr = in.readUTF();
				
				// is XML valid?
				String typ = validieren(xmlStr);
				if (typ == null) {
					out.writeUTF("XML fehlerhaft!");
				} else {
					// serialize
					Object neu = instanziieren(xmlStr);
					if (neu.getClass() == Student.class) {
				
						Student studi = (Student) neu;
						studi.writeToFile(new File("student.xml"));
					} else if (neu.getClass() == Professor.class) {
						Professor prof = (Professor) neu;
						prof.writeToFile(new File("professor.xml"));
					}
					out.writeUTF("XML okay. Objekt gespeichert");
				}
				
				clientSocket.close();
				
			} catch(EOFException e) {
				System.out.println("EOF: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO: " + e.getMessage());
			} catch (JAXBException e) {
				try {
					out.writeUTF("XML fehlerhaft. Speichern fehlgeschlagen.");
				} catch (IOException e1) {
					System.out.println("XML fehlerhaft. Speichern fehlgeschlagen.");
					e1.printStackTrace();
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
	}//class Connection
}