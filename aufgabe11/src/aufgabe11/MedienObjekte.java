package aufgabe11;

import java.io.Serializable;

public abstract class MedienObjekte implements Serializable {
	//Attribute
	private String typ;
	private int titel;
	private double preis;
	private int anzahl;
	
	//Constructor
	public MedienObjekte(String derTyp, int derTitel, double derPreis){
		boolean inputOk = (derTyp != null );
		
		if(inputOk){
			typ = derTyp;
			titel = derTitel;
			preis = derPreis;
			anzahl = 1;
			
		}
	}
	
	
	public MedienObjekte(MedienObjekte einArtikel){
		typ = einArtikel.typ;
		titel = einArtikel.titel;
		preis = einArtikel.titel;
		anzahl = 1;
		
	}
	
	//Method
	public String getTyp(){
		return typ;
	}
	
	public double getPreis(){
		return preis;
	}

	public int getTitel() {
		return titel;
	}
	
	public int getAnzahl(){
		return anzahl;
	}
	
	public double getGesamtPreis(){
		double total = Math.round(getPreis()*100);
		return (total/100)*getAnzahl();
	}
	
	public void setAnzahl(int dieAnzahl){
		anzahl = dieAnzahl;
	}
//	public String liefereWarenInfo(int feldbreite)
//	{
//		String info = String.format("%-10s%2s%" + feldbreite + "d\n",
//		"Titel", ":", titel);
////		info += String.format("%-10s%2s%" + feldbreite + "d\n",
////		"Nummer", ":", wareNummer);
//		info += String.format("%-10s%2s%" + feldbreite + ".2f\n",
//		"Preis", ":", getPreis());
//		return info;
//	}
	
	public int liefereAttributTextLaenge()
	{
//		int laenge = Math.max((""+titel).length());
		int laenge = ((""+titel).length());
		return Math.max(laenge, ("" + getPreis()).length());
	}

	
	public String liefereWarenInfo(int feldbreite){
		String info = getTyp()+" 'Titel "+ getTitel();
		info = String.format("%-70s%2s%" + feldbreite + ".2f EUR * %d = %.2f €",info,":", getPreis(),getAnzahl(),getGesamtPreis());
		return info;
	}
	
}
