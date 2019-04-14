/* Class: CalculatorFrame
 * 
 * Use: This class contains information for a swing app.
 * It also has all the event handlers here.
 * 
 */

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;


public class CalculatorFrame extends JFrame
{
  private JTextField textField1;
  
  //All of our buttons
  private JButton oneBtn;
  private JButton twoBtn;
  private JButton threeBtn;
  private JButton fourBtn;
  private JButton fiveBtn;
  private JButton sixBtn;
  private JButton sevenBtn;
  private JButton eightBtn;
  private JButton nineBtn;
  private JButton zeroBtn;
  private JButton equalBtn;
  private JButton plusBtn;
  private JButton minusBtn;
  private JButton multiplyBtn;
  private JButton divisionBtn;
  private JButton decimalBtn;
  
  //Default Constructor
  public CalculatorFrame()
  {
    //Window title
    super("Calculator");
    
    //Using the border layout. Put the text field in the north panel. The buttons in the center.
    setLayout(new BorderLayout());
    
    textField1 = new JTextField();
    add(textField1, BorderLayout.NORTH);
    
    //Using the grid bag layout for the number and operation buttons
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridBagLayout());
    
    GridBagConstraints constraints = new GridBagConstraints();
    
    //GridBag constraints
    constraints.gridx = 1;
    constraints.gridy = 3;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.weightx = 50;
    constraints.weighty = 50;
    constraints.insets = new Insets(5,5,5,5);
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.BOTH;
    
    //Create all of our buttons
    oneBtn = new JButton("1");
    southPanel.add(oneBtn, constraints); //Add to the panel south of the text field
    
    constraints.gridx = 2;
    twoBtn = new JButton("2");
    southPanel.add(twoBtn, constraints);
    
    constraints.gridx = 3;
    threeBtn = new JButton("3");
    southPanel.add(threeBtn, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 2;
    fourBtn = new JButton("4");
    southPanel.add(fourBtn, constraints);
    
    constraints.gridx = 2;
    fiveBtn = new JButton("5");
    southPanel.add(fiveBtn, constraints);
    
    constraints.gridx = 3;
    sixBtn = new JButton("6");
    southPanel.add(sixBtn, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 1;
    sevenBtn = new JButton("7");
    southPanel.add(sevenBtn, constraints);
    
    constraints.gridx = 2;
    eightBtn = new JButton("8");
    southPanel.add(eightBtn, constraints);
    
    constraints.gridx = 3;
    nineBtn = new JButton("9");
    southPanel.add(nineBtn, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 4;
    zeroBtn = new JButton("0");
    southPanel.add(zeroBtn, constraints);
    
    constraints.gridx = 3;
    equalBtn = new JButton("=");
    southPanel.add(equalBtn, constraints);
    
    constraints.gridx = 4;
    plusBtn = new JButton("+");
    southPanel.add(plusBtn, constraints);
    
    constraints.gridx = 4;
    constraints.gridy = 3;
    minusBtn = new JButton("-");
    southPanel.add(minusBtn, constraints);
    
    constraints.gridx = 4;
    constraints.gridy = 2;
    multiplyBtn = new JButton("*");
    southPanel.add(multiplyBtn, constraints);
    
    constraints.gridx = 4;
    constraints.gridy = 1;
    divisionBtn = new JButton("/");
    southPanel.add(divisionBtn, constraints);
    
    constraints.gridx = 2;
    constraints.gridy = 4;
    decimalBtn = new JButton(".");
    southPanel.add(decimalBtn, constraints);
    
    add(southPanel, BorderLayout.CENTER); //Finally add the panel to the JFrame
    
    thehandler handler = new thehandler();
    
    //Create all our action listeners
    oneBtn.addActionListener(handler);
    twoBtn.addActionListener(handler);
    threeBtn.addActionListener(handler);
    fourBtn.addActionListener(handler);
    fiveBtn.addActionListener(handler);
    sixBtn.addActionListener(handler);
    sevenBtn.addActionListener(handler);
    eightBtn.addActionListener(handler);
    nineBtn.addActionListener(handler);
    zeroBtn.addActionListener(handler);
    equalBtn.addActionListener(handler);
    plusBtn.addActionListener(handler);
    minusBtn.addActionListener(handler);
    multiplyBtn.addActionListener(handler);
    divisionBtn.addActionListener(handler);
    decimalBtn.addActionListener(handler);
    textField1.addActionListener(handler);
    
    
    setSize(300, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  //Here we'll handle our button and text field events
  private class thehandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String string = "";
      
      if (event.getSource() == oneBtn)
      {
        JOptionPane.showMessageDialog(null, "1");
      }
      else if (event.getSource() == twoBtn)
      {
        JOptionPane.showMessageDialog(null, "2");
      }
      else if (event.getSource() == threeBtn)
      {
        JOptionPane.showMessageDialog(null, "3");
      }
      else if (event.getSource() == fourBtn)
      {
        JOptionPane.showMessageDialog(null, "4");
      }
      else if (event.getSource() == fiveBtn)
      {
        JOptionPane.showMessageDialog(null, "5");
      }
      else if (event.getSource() == sixBtn)
      {
        JOptionPane.showMessageDialog(null, "6");
      }
      else if (event.getSource() == sevenBtn)
      {
        JOptionPane.showMessageDialog(null, "7");
      }
      else if (event.getSource() == eightBtn)
      {
        JOptionPane.showMessageDialog(null, "8");
      }
      else if (event.getSource() == nineBtn)
      {
        JOptionPane.showMessageDialog(null, "9");
      }
      else if (event.getSource() == zeroBtn)
      {
        JOptionPane.showMessageDialog(null, "0");
      }
      else if (event.getSource() == equalBtn)
      {
        JOptionPane.showMessageDialog(null, "=");
      }
      else if (event.getSource() == plusBtn)
      {
        JOptionPane.showMessageDialog(null, "+");
      }
      else if (event.getSource() == minusBtn)
      {
        JOptionPane.showMessageDialog(null, "-");
      }
      else if (event.getSource() == multiplyBtn)
      {
        JOptionPane.showMessageDialog(null, "*");
      }
      else if (event.getSource() == divisionBtn)
      {
        JOptionPane.showMessageDialog(null, "/");
      }
      else if (event.getSource() == decimalBtn)
      {
        JOptionPane.showMessageDialog(null, ".");
      }
      else if (event.getSource() == textField1)
      {
        JOptionPane.showMessageDialog(null, textField1.getText());
      }
    }
    }
}
    
    
    