package server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RezaPurnama
 */

import java.io.*;
import java.util.Date;
import javax.xml.*;
import org.xml.sax.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Professor {
   //Attribute
   private String vorname;
   private String name;
   private Date geburtsdatum;
   private String[] wohnort = new String[4];
   private int personalNummer;
   private String fachbereich;
   
   //Konstruktor
   public Professor(){
       
   }
   
   public Professor(String vorname, String name, String geburtsdatum,String Strasse, String Hausnr, String plz, String stadt, int personalNummer, String fachbereich){
       setVorname(vorname);
       setName(name);
       populateStringArray(Strasse, Hausnr, plz, stadt);
       setGeburtsdatum(geburtsdatum);
       setPersonalNummer(personalNummer);
       setFachbereich(fachbereich);
   }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
       try {
           this.geburtsdatum = formatter.parse(geburtsdatum);
       } catch (ParseException ex) {
           Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public int getPersonalNummer() {
        return personalNummer;
    }

    public void setPersonalNummer(int personalNummer) {
        this.personalNummer = personalNummer;
    }

    public String getFachbereich() {
        return fachbereich;
    }

    public void setFachbereich(String fachbereich) {
        this.fachbereich = fachbereich;
    }
   
    public void populateStringArray(String strasse, String hausnr, String plz, String stadt){
       this.wohnort[0] = strasse;
       this.wohnort[1] = hausnr;
       this.wohnort[2] = plz;
       this.wohnort[3] = stadt;
   }
    
    public String getXMLstr(){
           StringBuilder str = new StringBuilder();
            
		
           str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                           + "<Professor"
                           + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"professor.xml\">"
                           + "<Name>"+this.vorname+"</Vorame>"
                           + "<Nachname>"+this.name+"</Nachname>"
                           + "<Geburtsdatum>"+this.geburtsdatum+"</Geburtsdatum>"
                           + "<Personalnummer>"+this.personalNummer+"</Personalnummer>"
                           + "<Fachbereich>"+this.fachbereich+"</Fachbereich>"
                           + "<Wohnort> "
				+ "<Strasse> "+wohnort[0]+" </Strasse>"
				+ "<Hausnummer> "+wohnort[1]+" </Hausnummer>"
				+ "<PLZ> "+wohnort[2]+" </PLZ>"
				+ "<Stadt> "+wohnort[3]+" </Stadt>"
				+ "</Wohnort>"
                           + "</Professor>");

           return str.toString();

   }
}
