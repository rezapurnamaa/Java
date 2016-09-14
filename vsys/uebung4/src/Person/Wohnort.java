package Person;

import java.io.StringWriter;
import java.util.regex.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
/**
 * Wohnort enthält die Information von Strasse, Hausnr,PLZ, Stadt
 * @author Reza Purnama Arief (s0533453), Eric Yepmo (s0541816)
 * @version 24.07.2016
 */
@XmlRootElement(name="Wohnort")
@XmlType(propOrder = {"strasse", "hausnr", "plz", "stadt"})
public class Wohnort {

	private String strasse;
	private String hausnr;
	private String plz;
	private String stadt;
	
	public Wohnort(String strasse, String hausnr, String plz, String stadt) {
		super();
		this.strasse = strasse;
		this.stadt = stadt;
		if (!validierePLZ(plz) || !validiereHausnr(hausnr)) 
			throw new IllegalArgumentException();
		this.hausnr = hausnr;
		this.plz = plz;
		
	}
	
	public Wohnort() {
		super();
		this.strasse = "Musterstrasse";
		this.hausnr = "1";
		this.plz = "12345";
		this.stadt = "Musterstadt";
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnr() {
		return hausnr;
	}

	public void setHausnr(String hausnr) {
		if (validiereHausnr(hausnr)) {
			this.hausnr = hausnr;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		if (validierePLZ(plz)) {
			this.plz = plz;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	
	private boolean validierePLZ(String plz) {
		// regex from http://www.fadoe.de/blog/archives/262-Regulaerer-Ausdruck-fuer-Deutsche-Postleitzahlen.html
		Pattern p = Pattern.compile("^([0]{1}[1-9]{1}|[1-9]{1}[0-9]{1})[0-9]{3}$");
		Matcher m = p.matcher(plz);
		boolean b = m.matches();
		return b;
	}
	
	private boolean validiereHausnr(String hnr) {
			Pattern p = Pattern.compile("^[1-9]{1}[0-9]*[A-Za-z]?$");
			Matcher m = p.matcher(hnr);
			boolean b = m.matches();
			return b;
	}

	public String toXML() throws JAXBException {
		Marshaller m = getMarshaller();
	    StringWriter sw = new StringWriter();
	    m.marshal(this, sw);
	    String xmlString = sw.toString();
	    return xmlString;
	  }
	
	private Marshaller getMarshaller() throws JAXBException {
	    JAXBContext jc = JAXBContext.newInstance(Wohnort.class);
	    Marshaller m = jc.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    return m;
	}

}
