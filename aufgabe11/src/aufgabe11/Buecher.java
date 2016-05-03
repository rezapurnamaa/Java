package aufgabe11;

public class Buecher extends MedienObjekte {

	
	//Attribute
	private int author;
	private int hardcover;
	
	//Constructor
	public Buecher(MedienObjekte einArtikel, int derAuthor, int dasCover) {
		super(einArtikel);
		// TODO Auto-generated constructor stub
		setAuthor(derAuthor);
		setHardcover(dasCover);
	}
	
	public Buecher(String derTyp,int derTitel, double derPreis, int derAuthor, int derCover ){
		super(derTyp, derTitel, derPreis);
		// TODO Auto-generated constructor stub
		setAuthor(derAuthor);
		setHardcover(derCover);
	}

	//Method
	/**
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}

	/**
	 * @return the hardcover
	 */
	public int getHardcover() {
		return hardcover;
	}

	public String isHardcover(){
		String cover = "[HARDCOVER]";
		if((getHardcover() % 2) != 0){
			cover = "";
		}
		return cover;
	}
	
	/**
	 * @param hardcover the hardcover to set
	 */
	public void setHardcover(int hardcover) {
		this.hardcover = hardcover;
	}

//	@Override
//	public String liefereWarenInfo(int feldbreite) {
//		// TODO Auto-generated method stub
//		String info = super.liefereWarenInfo(feldbreite) +
//				String.format("%-10s%2s%" + feldbreite + "d",
//				"Author", ":", author);
//		info += String.format("%-10s%2s%" + feldbreite + "s",
//				"", "", isHardcover());
//		return info;
//	}

	@Override
	public int liefereAttributTextLaenge() {
		// TODO Auto-generated method stub
		int laenge = Math.max(super.liefereAttributTextLaenge(), ("" + author).length());
		return Math.max(laenge, isHardcover().length());
	}
	
	@Override
	public String liefereWarenInfo(int feldbreite){
		String info = "Buch 'Titel "+ getTitel() +"' von 'Author "+ author +"' "+ isHardcover();
		info = String.format("%-70s%2s%" + feldbreite + ".2f EUR * %d = %.2f €",info,":", getPreis(),getAnzahl(),getGesamtPreis());
		return info;
	}
	
	
	

}
