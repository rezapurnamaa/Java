

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Zinsen2 extends JFrame{
//	private static final long serialVersionUID = 1L;
	JTextField t1, t2, t3, t4;
	JLabel l1,l2,l3,l4;
	JButton b1;
	float betrag, zins, endwert;
	int laufzeit;

	Zinsen2(){
		Container c = getContentPane();
//		Angaben zum Fenster		
		setTitle("Zinsberechnung");  
		setLocation(200,150);
		setSize(300,250);
		c.setBackground(new Color(250,250,180));
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
// 		Textfeld erzeugen
		add(t1 = new JTextField(""));
		t1.setBounds (140,30, 60, 20);
		add(t2 = new JTextField(""));
		t2.setBounds (140,60, 60, 20);
		add(t3 = new JTextField(""));
		t3.setBounds (140,90, 60, 20);
		add(t4 = new JTextField(""));
		t4.setBounds (140,170, 60, 20);

// 		Label erzeugen
		add(l1 = new JLabel ("Betrag ")); 
		l1.setBounds (70,30, 70, 20);
		add(l2 = new JLabel ("Zinssatz "));
		l2.setBounds (70,60, 70, 20);
		add(l3 = new JLabel ("Laufzeit "));
		l3.setBounds (70,90, 70, 20);
		add(l3 = new JLabel ("Endwert "));
		l3.setBounds (70,170, 70, 20);

// 		Button erzeugen
		add (b1 = new JButton ("berechne"));
		b1.setBounds (150,130, 90,20);
// 		Button mit Listener versorgen
		b1.addActionListener (new Buttonclick () );
	}

//		innere Klasse zur Behandlung der Button-Ereignisse 
	class Buttonclick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String s;
				s = t1.getText(); 
				betrag = Float.parseFloat(s);
				s = t2.getText(); 
				zins = Float.parseFloat(s);
				s = t3.getText(); 
				laufzeit = Integer.parseInt(s);

				endwert = (float)(betrag * Math.pow(1+zins/100,laufzeit));
				endwert = (int)(endwert*100+0.5f)/100.0f;
				t4.setText(endwert+"");	
		}
	}

	public static void main (String args[]) {
		new Zinsen2();
	}
}
