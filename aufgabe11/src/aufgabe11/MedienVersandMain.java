package aufgabe11;

public class MedienVersandMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args!=null){
			MedienVersand verkauf = new MedienVersand();
		verkauf.run(args);
		}
		else
			System.out.println("bitte schreiben Sie 'generiere n'\n"
					+ "oder 'zeige t'");
	}

}
