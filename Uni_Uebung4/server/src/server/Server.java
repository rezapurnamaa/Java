/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author RezaPurnama
 */
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.*;
import org.xml.sax.*;

public class Server {

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
        Server server = new Server();
        try {
            server.run(args);
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * erzeuge ProfessorXML
     * @param doc
     * @return ProfessorObject
     */
    private Professor profXML(Document doc) {
        Professor professor = new Professor();
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Professor");
        Element element = (Element)nList.item(0);
        professor.setFachbereich(element.getElementsByTagName("Fachbereich").item(0).getTextContent());
        professor.setVorname(element.getElementsByTagName("Vorname").item(0).getTextContent());
        professor.setName(element.getElementsByTagName("Name").item(0).getTextContent());
        professor.setPersonalNummer(Integer.valueOf(element.getElementsByTagName("Personalnummer").item(0).getTextContent().trim()));
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
                professor.setGeburtsdatum(element.getElementsByTagName("Geburtsdatum").item(0).getTextContent());
        } catch (Exception e) {
        } 
        element = (Element)nList.item(0).getLastChild();
        String strasse = element.getElementsByTagName("Strasse").item(0).getTextContent();
        String hausnr = element.getElementsByTagName("Hausnummer").item(0).getTextContent();
        String plz = element.getElementsByTagName("PLZ").item(0).getTextContent();
        String stadt = element.getElementsByTagName("Stadt").item(0).getTextContent();
        professor.populateStringArray(strasse, hausnr, plz, stadt);
        
        return professor;
    }
    
    /**
     * schreibe Professor auf Festplatte
     * @param professor
     * @param path 
     */
    private void writeToDiskProf(Professor professor, String path) {
        try (Writer write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "prof_" + System.currentTimeMillis() + ".xml"), StandardCharsets.UTF_8))) {
            
            write.write(professor.getXMLstr());
        } catch (Exception e) {
        }
        
    }

    /**
     * erzeuge StudentXML
     * @param doc
     * @return StudentObject
     */
    private Student studXML(Document doc) {
        Student student = new Student();
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Student");
        Element element = (Element)nList.item(0);
        student.setVorname(element.getElementsByTagName("Vorname").item(0).getTextContent());
        student.setName(element.getElementsByTagName("Name").item(0).getTextContent());
        student.setMatrikelnummer(Integer.valueOf(element.getElementsByTagName("Matrikelnummer").item(0).getTextContent()));
        student.setFachsemester(Integer.valueOf(element.getElementsByTagName("Semester").item(0).getTextContent()));
        student.setStudienrichtung(element.getElementsByTagName("Studienrichtung").item(0).getTextContent());
        
        element = (Element)nList.item(0).getLastChild();
        String strasse = element.getElementsByTagName("Strasse").item(0).getTextContent();
        String hausnr = element.getElementsByTagName("Hausnummer").item(0).getTextContent();
        String plz = element.getElementsByTagName("PLZ").item(0).getTextContent();
        String stadt = element.getElementsByTagName("Stadt").item(0).getTextContent();
        student.populateStringArray(strasse, hausnr, plz, stadt);
        
        return student;
    }
    
    /**
     * schreibe Student auf Festplatte
     * @param student
     * @param path 
     */
    private void writeToDiskStudent(Student student, String path) {
        try (Writer write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "stud_" + System.currentTimeMillis() + ".xml"), StandardCharsets.UTF_8))){
            write.write(student.getXMLstr());
        } catch (Exception e) {
        }
    }
    
    //Erzeuge Verbindung von Client-Server
    class Connection extends Thread{    
        DataInputStream in;
        DataOutputStream out;
        Socket clientSocket;
        
        //Konstruktor
        public Connection(Socket aClientSocket) throws SAXException{
            try {
                clientSocket = aClientSocket;
                in = new DataInputStream((clientSocket.getInputStream()));
                out = new DataOutputStream(clientSocket.getOutputStream());
                this.start();

            } catch (IOException e) {
                System.out.println("Connection: " + e.getMessage());
            }
            
            try{ // Echo-Server
                DocumentBuilder document;
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource inputSource = new InputSource();
                String data = in.readUTF();
                inputSource.setCharacterStream(new StringReader(data));
                Document doc = document.parse(inputSource);
                
                String typ = doc.getFirstChild().getNodeName();
                System.out.println("typ : "+typ);
                System.out.println("data : "+data);
                boolean isValid = validieren(typ, data);
//                boolean isSerialisiert = isValid ? serialisieren(typ, doc) : false;
                boolean isSerialisiert =serialisieren(typ, doc);
                out.writeUTF(data);
//                out.writeUTF(isValid&&isSerialisiert ? ("gut") : ("schlecht"));
                clientSocket.close();
                
            } catch (EOFException e) {
                System.out.println("EOF: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO: " + e.getMessage());
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * validiere XMLdatei zu einem Schema
     * @param typ
     * @param xmlStr
     * @return Boolean
     */
    private boolean validieren(String typ, String xmlStr){
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File(System.getProperty("user.home")+((System.getProperty("os.name").toLowerCase().contains("windows"))?"\\":"/")+(typ.equals("Student")?"professor":"student")+".xsd");
        
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
            validator.validate(source);
            System.out.println("validated");
        } catch (Exception e) {
            System.out.println("cannot validate");
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @param typ
     * @param doc
     * @return 
     */
    private boolean serialisieren(String typ, Document doc){
        try {
            if(typ.equals("Professor")){
                Professor professor = profXML(doc);
                writeToDiskProf(professor, System.getProperty("user.home")+((System.getProperty("os.name").toLowerCase().contains("windows"))?"\\":"/"));
                System.out.println("Professor");
            }
            else {
                Student student = studXML(doc);
                writeToDiskStudent(student, System.getProperty("user.home")+((System.getProperty("os.name").toLowerCase().contains("windows"))?"\\":"/"));
                System.out.println("Student");
            }
        } catch (Exception e) {
                    System.out.println("serialize failed");

            return false;
        }
        System.out.println("serialize checked");
        return true;
    }
    
}
