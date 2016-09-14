package Person;

import java.io.File;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

/**
 * erzeuge Dozenteninformation
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 24.07.2016
 */
@XmlRootElement(name="Professor")
@XmlType(propOrder = {"vorname", "nachname", "wohnort", "geburtsdatum", "fachbereich", "personalnummer"})
public class Professor {

	protected String vorname;
	protected String nachname;
	protected Wohnort wohnort;
	private Date geburtsdatum;
	private String fachbereich;
	private String personalnummer;
	
	public Professor(String vorname, String nachname, Wohnort wohnort,
			Date geburtsdatum, String fachbereich, String personalnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.wohnort = wohnort;
		this.geburtsdatum = geburtsdatum;
		this.fachbereich = fachbereich;
		
		if (validierePersnr(personalnummer)) {
			this.personalnummer = personalnummer;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	
	
	public Professor() {
		super();
		this.geburtsdatum = new Date();
		this.fachbereich = "weiss nicht";
		this.personalnummer = "543210";
		this.vorname = "Max";
		this.nachname = "Mustermann";
		this.wohnort = new Wohnort();
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
	
	@XmlJavaTypeAdapter(DateFormatterAdapter.class)
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}



	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}



	public String getFachbereich() {
		return fachbereich;
	}



	public void setFachbereich(String fachbereich) {
		this.fachbereich = fachbereich;
	}



	public String getPersonalnummer() {
		return personalnummer;
	}



	public void setPersonalnummer(String personalnummer) {
		if (validierePersnr(personalnummer)) {
			this.personalnummer = personalnummer;
		} else {
			throw new IllegalArgumentException();
		}
	}



	private boolean validierePersnr(String persnr) {
		Pattern p = Pattern.compile("^[1-9]{1}[0-9]{5}$");
		Matcher m = p.matcher(persnr);
		return m.matches();
	}
	
	private Marshaller getMarshaller() throws JAXBException {
	    JAXBContext jc = JAXBContext.newInstance(Professor.class);
	    Marshaller m = jc.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "professor.xsd");
	    return m;
	}
	
	public Professor readFromFile(File file) throws JAXBException {
	    return JAXB.unmarshal(file, Professor.class);
	  }
	
	public void writeToFile(File file) throws JAXBException {
	    Marshaller m = getMarshaller();
	    m.marshal(this, file);
	}
	
	public String toXML() throws JAXBException {
		Marshaller m = getMarshaller();
	    StringWriter sw = new StringWriter();
	    m.marshal(this, sw);
	    String xmlString = sw.toString();
	    return xmlString;
	  }
	
	/**
	 * this class is needed to format the birthday date for with JAXB
	 * http://stackoverflow.com/questions/6378227/how-to-change-programmatically-the-default-jaxb-date-serialization
	 */
	private static class DateFormatterAdapter extends XmlAdapter<String, Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date unmarshal(final String v) throws Exception {
            return dateFormat.parse(v);
        }

        @Override
        public String marshal(final Date v) throws Exception {
            return dateFormat.format(v);
        }
    }
	
}
