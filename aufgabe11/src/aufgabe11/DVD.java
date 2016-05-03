package aufgabe11;

public class DVD extends MedienObjekte{

	
	//Attribute
	private int regisseur;
	private int altersfreigabe;
	
	//Constructor
	public DVD(MedienObjekte einArtikel, int derRegisseur, int dieAltersfreigabe) {
		super(einArtikel);
		// TODO Auto-generated constructor stub
		setRegisseur(derRegisseur);
		setAltersfreigabe(dieAltersfreigabe);
	}
	
	public DVD(String derTyp,int derTitel, double derPreis , int derRegisseur, int dieAltersfreigabe) {
		super(derTyp,derTitel, derPreis);
		// TODO Auto-generated constructor stub
		setRegisseur(derRegisseur);
		setAltersfreigabe(dieAltersfreigabe);
	}
	
	//Method
	/**
	 * @return the regisseur
	 */
	public int getRegisseur() {
		return regisseur;
	}
	/**
	 * @param regisseur the regisseur to set
	 */
	public void setRegisseur(int regisseur) {
		this.regisseur = regisseur;
	}
	/**
	 * @return the altersfreigabe
	 */
	public int getAltersfreigabe() {
		return altersfreigabe;
	}
	/**
	 * @param altersfreigabe the altersfreigabe to set
	 */
	public void setAltersfreigabe(int altersfreigabe) {
		this.altersfreigabe = altersfreigabe;
	}
	
	public String freigabeAb(){
		String freigabe = "";
		switch(altersfreigabe){
		case 1:
			freigabe = "(Freigabe ab 0)";
			break;
		case 2:
			freigabe = "(Freigabe ab 6)";
			break;
		case 3:
			freigabe = "(Freigabe ab 12)";
			break;
		case 4:
			freigabe = "(Freigabe ab 16)";
			break;
		case 5:
			freigabe = "(Freigabe ab 18)";
			break;
			
		}
		return freigabe;
	}
	
	@Override
	public int liefereAttributTextLaenge() {
		// TODO Auto-generated method stub
		int laenge = Math.max(super.liefereAttributTextLaenge(), ("" + regisseur).length());
		return Math.max(laenge, freigabeAb().length());
	}
	
	@Override
	public String liefereWarenInfo(int feldbreite){
		String info = "DVD 'Titel "+ getTitel() +"' von 'Regisseur "+ regisseur +"' "+ freigabeAb();
		info = String.format("%-70s%2s%" + feldbreite + ".2f EUR * %d = %.2f €",info,":", getPreis(),getAnzahl(),getGesamtPreis());
		return info;
	}

}
