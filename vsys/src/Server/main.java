package Server;
import java.io.*;
import java.net.Socket;
import java.text.*;
import java.util.Date;
import javax.xml.bind.JAXBException;
import Person.*;


/**
 * Hauptprogramm der XML-Übung
 * @author David Rossbach und Laura Woelbeling
 * @version 16.07.2016
 */
public class main {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Student studi = new Student("Ilse", "Bilse", new Wohnort("Im Wald", "12a", "12345", "Berlin"), "543210", "Angewandtes Computerspielen", 2);
		Date gebDat = new Date();
		try {
			gebDat = format.parse("1972-05-12");
		} catch (ParseException e1) {}
		Professor prof = new Professor("Hans", "Schlauberger", new Wohnort("Elfenbeinturm", "42", "76543", "Wiesbaden"), gebDat , "FB 4", "999999");
		String fehlerhaftesXML = "<Student><Name>Ilse</Name><Nachname>Bilse</Nachname><Matrikelnummer>543210</Matrikelnummer><Semester>2</Semester><Studienrichtung>Angewandtes Computerspielen</Studienrichtung><Wohnort><Strasse>Im Wald</Strasse><Hausnummer>12a</Hausnummer><PLZ>12345</PLZ><Stadt>Berlin</Stadt></Wohnort>";
				
		try {
			//studi.writeToFile(new File("student.xml"));
			//prof.writeToFile(new File("professor.xml"));
			
			// sende Student
			new Client(new Socket("localhost", 1234)).sendRequest(studi.toXML());
			
			// sende Professor
			new Client(new Socket("localhost", 1234)).sendRequest(prof.toXML());
			
			// sende fehlerhaftes XML
			new Client(new Socket("localhost", 1234)).sendRequest(fehlerhaftesXML);
			
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ende");
	}

}
