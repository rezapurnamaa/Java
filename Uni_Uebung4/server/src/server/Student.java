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
import javax.xml.*;
import org.xml.sax.*;

public class Student {

   //Attribute
    private String vorname;
   private String name;
   private String[] wohnort = new String[4];
   private int matrikelnummer;
   private String studienrichtung;
   private int fachsemester;
   
   //Konstruktor
   public Student(){
       
   }
   
   public Student( String dieVorname, String dieName,String Strasse, String Hausnr, String plz, String stadt, int matrikelnr, String richtung,int semester) {
       setVorname(dieVorname);
       setName(dieName);
       populateStringArray(Strasse, Hausnr, plz, stadt);
       setMatrikelnummer(matrikelnr);
       setStudienrichtung(richtung);
       setFachsemester(semester);
   }
   
   //Methoden
   

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

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String getStudienrichtung() {
        return studienrichtung;
    }

    public void setStudienrichtung(String studienrichtung) {
        this.studienrichtung = studienrichtung;
    }

    public int getFachsemester() {
        return fachsemester;
    }

    public void setFachsemester(int fachsemester) {
        this.fachsemester = fachsemester;
    }
   
   public void populateStringArray(String Strasse, String Hausnr, String plz, String stadt){
       this.wohnort[0] = Strasse;
       this.wohnort[1] = Hausnr;
       this.wohnort[2] = plz;
       this.wohnort[3] = stadt;
   }
   
    /**
    * Erzeugt einen String mit XML tags
    * @return XMLstring
    */
   public String getXMLstr(){
           StringBuilder str=new StringBuilder();
           str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                           + "<Student"
                           + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"student.xsd\">"
                           + "<Name>"+vorname+"</Vorame>"
                           + "<Nachname>"+name+"</Nachname>"
                           + "<Matrikelnummer>"+matrikelnummer+"</Matrikelnummer>"
                           + "<Semester>"+fachsemester+"</Semester>"
                           + "<Studienrichtung>"+studienrichtung+"</Studienrichtung>"
                           + "<Wohnort> "
				+ "<Strasse> "+wohnort[0]+" </Strasse>"
				+ "<Hausnummer> "+wohnort[1]+" </Hausnummer>"
				+ "<PLZ> "+wohnort[2]+" </PLZ>"
				+ "<Stadt> "+wohnort[3]+" </Stadt>"
				+ "</Wohnort>"
                           + "</Student>");

           return str.toString();

   }
}
