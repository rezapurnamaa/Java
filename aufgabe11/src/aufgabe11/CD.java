package aufgabe11;

public class CD extends MedienObjekte{

	//Attribute
	private int interpreter;
	int genre;
	
	//Constructor
	public CD(MedienObjekte einArtikel, int derInterpreter, int dasGenre) {
		super(einArtikel);
		// TODO Auto-generated constructor stub
		setInterpreter(derInterpreter);
		setGenre(dasGenre);
	}
	
	public CD(String derTyp, int derTitel, double derPreis, int derInterpreter, int dasGenre ){
		super(derTyp, derTitel,derPreis);
		// TODO Auto-generated constructor stub
		setInterpreter(derInterpreter);
		setGenre(dasGenre);
	}
	//Method

	/**
	 * @return the interpreter
	 */
	public int getInterpreter() {
		return interpreter;
	}

	/**
	 * @param interpreter the interpreter to set
	 */
	public void setInterpreter(int interpreter) {
		this.interpreter = interpreter;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}
	
	public String hatGenre(){
		String dasGenre = "";
		if( genre == 1){
			dasGenre = "Rock";
		}else if( genre == 2){
			dasGenre = "Pop";
		}else if( genre == 3){
			dasGenre = "Klassik";
		}else if( genre == 4){
			dasGenre = "HipHop";
		}else if( genre == 5){
			dasGenre = "Metal";
		}else if( genre == 6){
			dasGenre = "Techno";
		}else if( genre == 7){
			dasGenre = "Jazz";
		}
		return dasGenre;
	}

	@Override
	public int liefereAttributTextLaenge() {
		// TODO Auto-generated method stub
		int laenge = Math.max(super.liefereAttributTextLaenge(), ("" + interpreter).length());
		return Math.max(laenge, hatGenre().length());
	}
	@Override
	public String liefereWarenInfo(int feldbreite){
		String info = getTyp()+" 'Titel "+ getTitel() +"' von 'Interpret "+ interpreter +"' "+ hatGenre();
		info = String.format("%-70s%2s%" + feldbreite + ".2f EUR * %d = %.2f €",info,":", getPreis(),getAnzahl(),getGesamtPreis());
		return info;
	}
	
	
}
