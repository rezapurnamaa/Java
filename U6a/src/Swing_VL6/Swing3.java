package Swing_VL6;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Swing3 extends JFrame{
	JTextField t1, t2,t3,t4;
	JLabel l1, l2,l3,l4;
	JButton b1;

	Swing3(){
//		Angaben zum Fenster		
		setTitle("Potenzen einer Zahl");  
		setSize(300,300);
		setLocation(200,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
// 		Label erzeugen
		add(l1 = new JLabel ("Betrag "));
		l1.setBounds (30,30, 70, 20);
		add(l2 = new JLabel ("Zinssatz "));
		l2.setBounds (30,70, 70, 20);
		add(l3 = new JLabel ("Laufzeit"));
		l3.setBounds (30,110, 70, 20);
		add(l4 = new JLabel ("Endwert "));
		l4.setBounds (30,180, 70, 20);
// 		Textfeld erzeugen
		add(t1 = new JTextField(""));
		t1.setBounds (100,30, 90, 20);
		add(t2 = new JTextField(""));
		t2.setBounds (100,70, 90, 20);
		add(t3 = new JTextField("")); //Textfeld für Laufzeit
		t3.setBounds (100,110, 90, 20);
		add(t4 = new JTextField(""));
		t4.setBounds (100,180, 90, 20);
// 		Button erzeugen
		add (b1 = new JButton ("berechne"));
		b1.setBounds (100,145,90,20);
// 		Button mit Listener versorgen
		b1.addActionListener (new Action ());
		setVisible(true); 
	}
//	innere Klasse zur Behandlung der Button-Ereignisse 
	class Action implements ActionListener {

// Bitte nach float umwandeln, mit variablen betrag,zinssatz,laufzeit, und endwert		
		
//	Behandlungsmethode fuer Aktionen
	  public void actionPerformed(ActionEvent e){
		  String s;
		  float betrag, zins, summe;
		  int laufzeit = 0;
		  s = t1.getText(); 
		  betrag = Integer.parseInt(s);
		  s = t2.getText(); 
		  zins = Integer.parseInt(s);
		  zins = zins/100;
		  s = t3.getText();
		  laufzeit = Integer.parseInt(s);
		  
		  for(int i = 0; i<laufzeit; i++){
			  summe = betrag*zins;
			  betrag = betrag + summe;
			  
		  }
		  String formatOutput = String.format("%.2f", betrag);
//		  System.out.printf("%.2f",betrag);
		  t4.setText(formatOutput + "");
//		  betrag=(int)Math.pow(betrag,zins);
//		  t3.setText(betrag +"");	
	 }
}

	public static void main (String args[]) {
		new Swing3();
	}
}
