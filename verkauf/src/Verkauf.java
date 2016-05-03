
public class Verkauf {

	//Attribute
	//Constructor
	//Method
	
	public void run(){
		Ware[] warenkorb ={new Ware(781503, "LCD-Fernseher", 1789.23),
				new Ware(100212, "Ananas", 2.99) };
				
		schreibe(warenkorb);
	}
	
	public int ermitteleFeldbreite(Ware[] warenkorb)
	{
		int feldbreite = warenkorb[0].liefereAttributTextLaenge();
		for (Ware ware : warenkorb)
			if (ware.liefereAttributTextLaenge() > feldbreite)
				feldbreite = ware.liefereAttributTextLaenge();
		return feldbreite;
	}
	
	public void schreibe(Ware[] warenkorb)
	{
		int feldbreite = ermitteleFeldbreite(warenkorb) + 2;
		for (Ware ware : warenkorb)
			System.out.println(ware.liefereWarenInfo(feldbreite));
	}
}
