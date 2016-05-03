package aufgabe11;


import java.util.ArrayList;
import java.util.Collections;

public class Zahlgenerator {

	//Attribute
		/**
		 * Liste von Zahlen
		 */
		private ArrayList<Integer> zahl = new ArrayList<Integer>();
		
		//Constructor
		/**
		 * Erstelle die Zahl 0 bis 9
		 */
		public Zahlgenerator() {
			for(int i = 0; i < 10; i++){
				zahl.add(i);
			}
		}
		//Methods
		/**
		 * generiere n Ziffern, die die Zahlen zwischen 0-9 sind
		 * @param anzahl Anzahl der Ziffern
		 * @return n Ziffern
		 */
		public int[] generate(int anzahl) {
			
			int[] ziffer = new int[anzahl];
			Collections.shuffle(zahl);
			for (int i = 0; i < anzahl; i++) {
				ziffer[i] = zahl.get(i);
			}
			return ziffer;
		}
		
		public int ArrToInt(int anzahl){
			
			StringBuilder strNum = new StringBuilder();
			int nums[] = generate(anzahl);
			for (int num : nums) 
			{
			     strNum.append(num);
			}
			return Integer.parseInt(strNum.toString());
		}
		
		public double generateDouble(int min, int max){
			
			return min + (Math.random() * ((max - min) + 1));
			
		}
		
		public int generateInt(int min, int max){
			
			return  min + (int)(Math.random() * ((max - min) + 1));
			
		}
}
