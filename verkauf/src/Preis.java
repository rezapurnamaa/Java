

public class Preis {

	//Attribute
	private final double MEHRWERT_STEUER_SATZ = 0.19;
	private double bruttoPreis;
	
	//Constructor
	public Preis(double derBruttoPreis){
		if(derBruttoPreis >= 0.0){
			setBruttoPreis(derBruttoPreis);
		}
		else
			throw new IllegalArgumentException();
	}
	
	//Method
	/**
	 * @return the bruttoPreis
	 */
	public double getBruttoPreis() {
		return bruttoPreis;
	}

	/**
	 * @param bruttoPreis the bruttoPreis to set
	 */
	public void setBruttoPreis(double bruttoPreis) {
		this.bruttoPreis = bruttoPreis;
	}
	
	public double getMehrwertSteuerAnteil(){
		return MEHRWERT_STEUER_SATZ * bruttoPreis;
	}
	
	public double getNettoPreis(){
		return bruttoPreis - MEHRWERT_STEUER_SATZ * bruttoPreis;
	}
}
