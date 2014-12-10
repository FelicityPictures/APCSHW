import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window2 extends JFrame {
    private Container pane;

    private JButton b;
    private JLabel dc,df;
    private JTextField f,c;
    //private JCheckBox c;
    public Window2() {
	this.setTitle("Conversion between Fahrenheit and Celcius");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);


	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Convert");
	df = new JLabel("Fahrenheit",null,JLabel.CENTER);
	dc = new JLabel("Celcius",null,JLabel.CENTER);
	f = new JTextField(10);
	c = new JTextField(10);
	//c = new JCheckBox("Overclock!!!");
	pane.add(f);
	pane.add(df);
	pane.add(c);
	pane.add(dc);
	pane.add(b);
    }

    public void actionPerformed(ActionEvent e){
	String s;
	if(b.getActionCommand){
	    if(f.getText != null){
		s = f.getText;
	    }
	    if(c.getText != null){
		s = //left off here
	}

    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}