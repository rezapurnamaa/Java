
import java.awt.*;
import javax.swing.*;

public class swing1 extends JFrame {

	JTextField t1;
	JLabel l1;
	int p;
	
	swing1(){
		
		setTitle("Potenz von 2");
		setSize(250,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(l1 = new JLabel("2 hoch 10 = "));
		
		add(t1 = new JTextField(""));
		
		p=(int)Math.pow(2, 10);
		t1.setText(p+"");
		setVisible(true);
	}
	
	public static void main(String args[]){
	
		new swing1();
	}
}
