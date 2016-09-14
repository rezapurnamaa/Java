package Server;
import java.io.*;
import java.net.Socket;
import java.text.*;
import java.util.Date;
import javax.xml.bind.JAXBException;
import Person.*;


/**
 * Client-main class
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 24.07.2016
 */
public class main {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Student student = new Student("Max", "Mustermann", new Wohnort("Musterstr", "123a", "12345", "Berlin"), "545344", "AI", 1);
		Date gerburtsDatum = new Date();
		try {
			gerburtsDatum = format.parse("1900-01-01");
		} catch (ParseException e1) {}
		Professor professor = new Professor("Prenzlauer", "Berger", new Wohnort("Prenzlauer Allee", "22", "10247", "Berlin"), gerburtsDatum , "FB 4", "123456");
		String fehlerhaftesXML = "<Student><Name>Max</Name><Nachname>Mustermann</Nachname><Matrikelnummer>545344</Matrikelnummer><Semester>1</Semester><Studienrichtung>AI</Studienrichtung><Wohnort><Strasse>Musterstr</Strasse><Hausnummer>00</Hausnummer><PLZ>12345</PLZ><Stadt>Berlin</Stadt></Wohnort>";
				
		try {
			//studi.writeToFile(new File("student.xml"));
			//prof.writeToFile(new File("professor.xml"));
			
			// sende Student
			new Client(new Socket("localhost", 1234)).sendRequest(student.toXML());
			
			// sende Professor
			new Client(new Socket("localhost", 1234)).sendRequest(professor.toXML());
			
			// sende fehlerhaftes XML
			new Client(new Socket("localhost", 1234)).sendRequest(fehlerhaftesXML);
			
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ende");
	}

}
