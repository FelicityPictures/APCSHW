import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class CtoF extends JFrame implements ActionListener{
  private Container pane;
  private JButton convert, clear;
  private JLabel c,f;
  private JTextField numberC, numberF;
  private Container buttons;
  private Container text;
  
  public CtoF(){
    this.setTitle("Convert from Celcius to Fahrenheit");
    this.setSize(300,200);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new GridLayout(2,1));
    
    c = new JLabel("degrees Celsius is equal to ", null, JLabel.CENTER);
    f = new JLabel(" degrees Fahrenheit.", null, JLabel.CENTER);
    convert = new JButton("Convert");
    clear = new JButton("Clear");
    numberC = new JTextField(10);
    numberF = new JTextField(10);

    convert.setActionCommand("convert");
    convert.addActionListener(this);
    clear.setActionCommand("clear");
    clear.addActionListener(this);
    
    buttons = new Container();
    buttons.setLayout(new FlowLayout());
    buttons.add(convert);
    buttons.add(clear);

    text = new Container();
    text.setLayout(new FlowLayout());
    text.add(numberC);
    text.add(c);
    text.add(numberF);
    text.add(f);

    pane.add(text);
    pane.add(buttons);
  }

  public static boolean isValid(String s) {
    try { 
      Double.parseDouble(s); 
    } catch(NumberFormatException e) { 
      return false; 
    }
    return true;
  }

  public void actionPerformed(ActionEvent e){
    String action = e.getActionCommand();
    
    if(action.equals("clear")){
      numberC.setText("");
      numberF.setText("");
    }

    if(action.equals("convert")){
      String degrees = numberC.getText();
      if(isValid(degrees)){
        double d = Double.parseDouble(degrees);
        d = d * 9 / 5 + 32;
        String p = "" + d;
        numberF.setText(p);
      }else{
        numberC.setText("You have caused");
        numberF.setText("an error.");
      }
    }
  }

  public static void main(String[] args){
    CtoF n = new CtoF();
    n.setVisible(true);
  }
}
