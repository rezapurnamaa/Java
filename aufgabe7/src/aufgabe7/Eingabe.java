package aufgabe7;
import java.util.Scanner;
import java.util.regex.Pattern;
//import java.util.StringTokenizer;

public class Eingabe {
	//Attribute
	private Bruch a = new Bruch();
	private Bruch b = new Bruch();
	private String mathOperator = "";
	//Constructor
	public Eingabe(){

	}

	//Methods
	public Bruch getBruchA() {
		return a;
	}

	public void setBruchA(Bruch a) {
		this.a = a;
	}

	public Bruch getBruchB() {
		return b;
	}

	public void setBruchB(Bruch b) {
		this.b = b;
	}

	//wait for input
	public void benutzerEingabe(){
		Scanner scan = new Scanner(System.in);
		String eingabe = "";
		String leerzeichen = " ";
		int[] bruchA = new int[2];
		int[] bruchB = new int[2];
		String[] getrennteEingabe, strBruchA, strBruchB;
		String op;		
		System.out.print("Bruch : ");
		eingabe = scan.nextLine();
		scan.close();
		System.out.println("eingabe: "+eingabe);
//		String k = "-8";
//		int iK = Integer.parseInt(k);
//		iK += 8;
//		System.out.println("iK:"+iK);
		//split the input into 2 different variables
		op = getOperator(eingabe);
		System.out.println("op: "+ op);
		
		getrennteEingabe = eingabe.trim().split("[+-/]");
//		getrennteEingabe = eingabe.trim().split(" ");

		for(int i =0; i < getrennteEingabe.length ; i++)
			System.out.println(i+".getrennte Eingabe: "+getrennteEingabe[i]);
//		System.out.println(getrennteEingabe[0]);
//		System.out.println(getrennteEingabe[1]);
		
		strBruchA = getrennteEingabe[0].trim().split(leerzeichen);
		strBruchB = getrennteEingabe[1].trim().split(leerzeichen);

//		if(getrennteEingabe[1]!=0)
		for(int i = 0; i< strBruchA.length;i++){
				System.out.println(i+".bruchA: "+strBruchA[i]);
		}
			
		for(int i = 0; i< strBruchB.length;i++){
			System.out.println(i+".bruchB: "+strBruchB[i]);
		}
		System.out.println("strBruchA:"+strBruchA[0]+strBruchA[1]);
		System.out.println("strBruchB:"+strBruchB[0]+strBruchB[1]);			
		//check if string length is 2, 
		if(strBruchA.length>1){
			bruchA[0] = Integer.parseInt(strBruchA[0]);
			bruchA[1] = Integer.parseInt(strBruchA[1]);
			
		}
		else{
			bruchA[0] = Integer.parseInt(strBruchA[0]);
			bruchA[1] = 1;
		}
		
		if(strBruchB.length>1){
			bruchB[0] = Integer.parseInt(strBruchB[0]);
			bruchB[1] = Integer.parseInt(strBruchB[1]);
		}
		else{
			bruchB[0] = Integer.parseInt(strBruchB[0]);
			bruchB[1] = 1;
		}
		a.setZaehler(bruchA[0]);
		a.setNenner(bruchA[1]);
		b.setZaehler(bruchB[0]);
		b.setNenner(bruchB[1]);
	}
	
	public void convertToInt(){
		
	}
	
	public String getOperator(String input){
		String[] operator = {"+","-","*","/"};
//		Pattern operator = Pattern.compile("\\[.+?\\]+?,?\\s*");
		String op = "";
//		String temp;
		for(int i = 0; i<operator.length; i++){
//			temp = operator[i];
//			System.out.println("temp: " +temp);
			if(input.contains(operator[i])){
				op = operator[i];
			}	
		}
		return op;
	}
	
	
	
	//test if string contains number
//	public static boolean isNumeric(String str)  
//	{  
//	  try  
//	  {  
//	    int x =Integer.parseInt(str);  
//	  }  
//	  catch(NumberFormatException nfe)  
//	  {  
//	    return false;  
//	  }  
//	  return true;  
//	}

	 //convert string to int
//	public void inputToInt(){
//		String op = "";
//		for(int i =0; i < strTemp.length ; i++){
//			if(isNumeric(strTemp[i])){
//				intTemp[i] = Integer.parseInt(strTemp[i]);
//			}
//			else{
//				intTemp[i] = 1;
//				op = strTemp[i];
//			}
//			System.out.println("int : " + intTemp[i]);
//			System.out.println("op : " + op);
//		}
//	}
	
	
}

