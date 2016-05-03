package aufgabe9;
import java.util.ArrayList;
/**
 * Diese Klasse optimiert die Ausgabe
 * @author RezaPurnama
 *
 */
public class Ausgabe {
	
	//Attribute
	/**
	 * Liste von Ausgabe in Satzform
	 */
	private ArrayList<String> strList = new ArrayList<String>();
	/**
	 * Index, bei der Liste die genannten Elemente eingesetzt werden.
	 */
	private int indexOutput;
	/**
	 * Ausgabe in Satzform
	 */
	private String outputString;
	
	//Constructor
	/**
	 * Initialisiere Index von List auf 0
	 */
	public Ausgabe(){
		indexOutput = 0;
	}
	
	//Method
	
	/**
	 * Setze die Ausgabe in der Liste
	 * @param outputString der Satz, der ausgegeben werden muss
	 */
	public void setOutputString(String outputString) {
		this.outputString = outputString;
		strList.add(indexOutput, outputString);
		indexOutput++;
	}

	/**
	 * liefere die geratene Zahl
	 * @return die geratene Zahl
	 */
	public String getOutputString() {
		return outputString;
	}
	/**
	 * Formatiere die Eingabe, damit nur Zahlen empfangen werden
	 * @param str Menge von Zahl
	 */
	public void formatiereString(String str) {
		str = str.toString().replace(",","" )
				.replace("[", "")
				.replace(" ", "")
				.replace("]", "");
		this.outputString = str;
	}
	/**
	 * gibt die Saetze in der Liste aus.
	 */
	public void generiereOutput() {
		
		for (int i = 0; i < indexOutput; i++) {
			System.out.println((i+1) + ".\t" + strList.get(i));
		}
	}

	/**
	 * gibt 25 newLine aus, damit die Ausgaben uebersichtlicher sind.
	 */
	public void clearScreen()  {
		for (int i = 0; i < 25; i++)
			 System.out.println();
	}
}
