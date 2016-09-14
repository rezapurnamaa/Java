package Person;

import java.io.File;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 * erzeuge Studenteniformation
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 24.07.2016
 */
@XmlRootElement(name="Student")
@XmlType(propOrder = {"vorname", "nachname", "wohnort", "matrikelnummer", "studiengang", "fachsemester"})
public class Student{

	protected String vorname;
	protected String nachname;
	protected Wohnort wohnort;
	private String matrikelnummer;
	private String studiengang;
	private int fachsemester;
	
	public Student() {
		super();
		this.fachsemester = 1;
		this.studiengang = "weiss nicht";
		this.matrikelnummer = "543210";
		this.vorname = "Max";
		this.nachname = "Mustermann";
		this.wohnort = new Wohnort();
	}
	
	public Student(String vorname, String nachname, Wohnort wohnort,
			String matrikelnummer, String studiengang, int fachsemester) {
		
		if (validiereMatrnr(matrikelnummer)) {
			this.matrikelnummer = matrikelnummer;
		} else {
			throw new IllegalArgumentException();
		}
		
		this.studiengang = studiengang;
		
		if (fachsemester > 0) {
			this.fachsemester = fachsemester;
		} else {
			throw new IllegalArgumentException();
		}
		this.vorname = vorname;
		this.nachname = nachname;
		this.wohnort = wohnort;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Wohnort getWohnort() {
		return wohnort;
	}
	public void setWohnort(Wohnort wohnort) {
		this.wohnort = wohnort;
	}


	public String getMatrikelnummer() {
		return matrikelnummer;
	}


	public void setMatrikelnummer(String matrikelnummer) {
		if (validiereMatrnr(matrikelnummer)) {
			this.matrikelnummer = matrikelnummer;
		} else {
			throw new IllegalArgumentException();
		}
	}


	public String getStudiengang() {
		return studiengang;
	}


	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}


	public int getFachsemester() {
		return fachsemester;
	}


	public void setFachsemester(int fachsemester) {
		if (fachsemester > 0) {
			this.fachsemester = fachsemester;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private boolean validiereMatrnr(String matrnr) {
		Pattern p = Pattern.compile("^[5]{1}[0-9]{5}$");
		Matcher m = p.matcher(matrnr);
		return m.matches();
	}
	
	
	public void writeToFile(File file) throws JAXBException {
	    Marshaller m = getMarshaller();
	    m.marshal(this, file);
		
	  }
	
	private Marshaller getMarshaller() throws JAXBException {
	    JAXBContext jc = JAXBContext.newInstance(Student.class);
	    Marshaller m = jc.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "student.xsd");
	    return m;
	}
	
	public String toXML() throws JAXBException {
		Marshaller m = getMarshaller();
	    StringWriter sw = new StringWriter();
	    m.marshal(this, sw);
	    String xmlString = sw.toString();
	    return xmlString;
	  }
	  
	  public Student readFromFile(File file) throws JAXBException {
	    return JAXB.unmarshal(file, Student.class);
	  }
	
}
