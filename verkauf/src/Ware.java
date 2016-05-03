
public class Ware {
	//Attribute
	private int wareNummer;
	private String warenName;
	private Preis preis;
	
	//Constructor
	public Ware(int dieWareNummer, String derWareName, Preis derPreis){
		boolean inputOk = (0 <= dieWareNummer && dieWareNummer <= Integer.MAX_VALUE && 
				(derWareName != null) && (derPreis != null));
		
		if(inputOk){
			wareNummer = dieWareNummer;
			warenName = derWareName;
			preis = derPreis;
		}
	}
	
	public Ware(int dieWareNummer, String derWareName, double derPreis){
		this(dieWareNummer, derWareName, new Preis(derPreis));
	}
	
	public Ware(Ware eineWare){
		wareNummer = eineWare.wareNummer;
		warenName = eineWare.warenName;
		preis = new Preis(eineWare.getPreis());
	}
	
	//Method
	public int getWareNummmer(){
		return wareNummer;
	}
	
	public String getWareName(){
		return warenName;
	}
	
	public double getPreis(){
		return preis.getBruttoPreis();
	}
	

	public double getNettoPreis(){
		return preis.getNettoPreis();
	}
	
	public double getMehrwertSteuerAnteil(){
		return preis.getMehrwertSteuerAnteil();
	}
	
	public void aenderePreis(double derNeuePreis)
	{
		if (derNeuePreis >= 0.0)
			preis = new Preis(derNeuePreis);
	}
	
	public String liefereWarenInfo(int feldbreite)
	{
		String info = String.format("%-10s%2s%" + feldbreite + "s\n",
		"Name", ":", warenName);
		info += String.format("%-10s%2s%" + feldbreite + "d\n",
		"Nummer", ":", wareNummer);
		info += String.format("%-10s%2s%" + feldbreite + ".2f\n",
		"Preis", ":", getPreis());
		return info;
	}
	
	public int liefereAttributTextLaenge()
	{
	int laenge = Math.max(("" + wareNummer).length(),
	warenName.length());
	return Math.max(laenge, ("" + getPreis()).length());
	}
}
