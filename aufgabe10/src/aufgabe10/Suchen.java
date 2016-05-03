package aufgabe10;
/**
 * Diese Klasse sucht die moegliche Position der Beute. 
 * Sie hilft dem Spieler, die Beute zu finden.
 * @author RezaPurnama
 *
 */
public class Suchen {

	//Attribute
	/**
	 * Spielfigur
	 * @see Spielfigur
	 */
	private Spielfigur figur;
	/**
	 * Beute
	 * @see Beute
	 */
	private Beute beute;
	/**
	 * <code>true</code> es ist moeglich, die Beute in den naechsten Zug zu finden.
	 */
	private boolean moeglich;
	
	
	//Constructor
	/**
	 * Benutze vorhandene Spielfigur, die Beute zu suchen
	 * @param figur Spielfigur
	 * @param beute Beute
	 */
	public Suchen(Spielfigur figur,Beute beute ){
		this.figur = figur;
		this.beute = beute;
		moeglich = false;
	}
	
	//Method
	/**
	 * pruefe, ob die Beute in den naechsten Zug gefunden werden kann
	 */
	public void check(){
		if (figur.name.equals("Dame")){
			findeObenRechts();
			findeObenLinks();
			findeHorizontal();
			findeVertical();
		}
		else if (figur.name.equals("Turm")){
			findeHorizontal();
			findeVertical();
		}
		else {
			findeObenRechts();
			findeObenLinks();
		}
		if (moeglich){
			System.out.println("Beute kann in den naechsten Zug gefunden werden.\n");
		}
		else{
			System.out.println("Beute ist woanders.\n");
		}
	}
	/**
	 * suche die Beute nach oben rechts und unten links (diagonal)
	 */
	public void findeObenRechts(){
		int xDiff = Math.abs(beute.getxPosition() - figur.xPosition);
		int yDiff = Math.abs(beute.getyPosition() - figur.yPosition);
		if (xDiff == yDiff){
			moeglich = true;
		}
//		if((((beute.getxPosition()+beute.getyPosition())%2) == 0) && (((figur.xPosition+figur.yPosition)%2) == 0)){
////			int summeBeute = beute.getxPosition() + beute.getyPosition();
////			int summePos = (figur.xPosition+figur.yPosition);
////			if((summeBeute - summePos) == beute.getyPosition())
//				moeglich = true;
//			
//			
//		}
//		else if((((beute.getxPosition()+beute.getyPosition())%2) != 0) && (((figur.xPosition+figur.yPosition)%2) != 0)){
//			moeglich = true;
//		}
	}
	
	/**
	 * suche die Beute nach oben links und unten rechts (diagonal)
	 */
	public void findeObenLinks(){
		
		if ((beute.getxPosition() + beute.getyPosition()) == (figur.xPosition + figur.yPosition)){
			moeglich = true;
		}
	}
	
	/**
	 * suche die Beute nach rechts und links (horizontal)
	 */
	public void findeHorizontal(){
		
		if (beute.getxPosition() == figur.xPosition){
			moeglich = true;
		}
	}
	
	/**
	 * suche die Beute nach  oben und unten (vertical)
	 */
	public void findeVertical(){
		if (beute.getyPosition() == figur.yPosition){
			moeglich = true;
		}
	}
}
