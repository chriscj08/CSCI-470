/* Class: TipCalcFrame
 * 
 * Use: This class contains information for a swing app.
 * It also has all the event handlers here.
 * 
 */

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;


public class TipCalcFrame extends JFrame
{
  //Data members go here  
  private JTextField billAmt;
  private JSlider tipPercent;
  private JSpinner partySize;
  private JButton calcBtn;
  private JButton clearBtn;  
  private JLabel totalBill;
  private JLabel share;
  
  private TipCalculator tipObject;
  
  //Default Constructor
  public TipCalcFrame()
  {
    super("Tip Calculator");
    
    tipObject = new TipCalculator();
    //Window title
    
    
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
       
    GridBagConstraints constraints = new GridBagConstraints();
    
    //GridBag constraints
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.weightx = 50;
    constraints.weighty = 50;
    constraints.insets = new Insets(5,5,5,5);
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.BOTH;
    
     JLabel billAmtLabel = new JLabel("Bill Amount: ");
     panel.add(billAmtLabel, constraints);
     
     //Add bill amount text field
     billAmt = new JTextField();
     constraints.gridx = 2;
     panel.add(billAmt, constraints);
     
     JLabel tipPercentLabel = new JLabel("Tip Percentage: ");
     constraints.gridx = 1;
     constraints.gridy = 2;
     panel.add(tipPercentLabel, constraints);
     
     //Add tip percent slider
     tipPercent = new JSlider(JSlider.HORIZONTAL, 0, 50, 20);
     tipPercent.setMajorTickSpacing(5);
     tipPercent.setPaintTicks(true);
     tipPercent.setPaintLabels(true);
     constraints.gridx = 2;
     panel.add(tipPercent, constraints);
     
     JLabel partySizeLabel = new JLabel("Party Size: ");
     constraints.gridx = 1;
     constraints.gridy = 3;
     panel.add(partySizeLabel, constraints);
     
     //Add number in party spinner
     SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
     partySize = new JSpinner(model);
     constraints.gridx = 2;
     panel.add(partySize, constraints);
     
     //Add Calc button
     calcBtn = new JButton("Calculate");
     constraints.gridx = 1;
     constraints.gridy = 4;
     panel.add(calcBtn, constraints);
     
     //Add clear button
     clearBtn = new JButton("Clear");
     constraints.gridx = 2;
     panel.add(clearBtn, constraints);
     
     JLabel totalBillLabel = new JLabel("Total Bill (With Tip): ");
     constraints.gridx = 1;
     constraints.gridy = 5;
     panel.add(totalBillLabel, constraints);
     
     //JLabel with changing text
     totalBill = new JLabel("$0.00");
     constraints.gridx = 2;
     panel.add(totalBill, constraints);
     
     
     JLabel individualShareLabel = new JLabel("Individual Share: ");
     constraints.gridx = 1;
     constraints.gridy = 6;
     panel.add(individualShareLabel, constraints);
     
     //JLabel with changing text
     share = new JLabel("$0.00" ); 
     constraints.gridx = 2;
     panel.add(share, constraints);
     
     add(panel);
     
     changed e = new changed();
     tipPercent.addChangeListener(e);
     partySize.addChangeListener(e); 
                                  
     thehandler handler = new thehandler();
      
     calcBtn.addActionListener(handler);   
     clearBtn.addActionListener(handler);   
                                  
     setSize(600, 500);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);                            
  }

/* Class: changed
 * 
 * Use: Implements ChangeListener. Wait for you to change
 * the value of the spinner and slider and automatically
 * updates the TipObject value.
 * 
 */
public class changed implements ChangeListener 
{
  public void stateChanged (ChangeEvent e)
  {
    tipObject.setTipPercentage(tipPercent.getValue());
    
    tipObject.setPartySize((Integer)partySize.getValue());
  }
}

/* Class: thehandler
 * 
 * Use: Implements ActionListener. This class handles
 * all of the button click and what they should do
 * when pressed.
 * 
 */
public class thehandler implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
    String string = "";
    
    if (e.getSource() == calcBtn)
    {
      try
      {
        //Make Sure user gives us a number and no non-numeric characters
        tipObject.setBill(Double.parseDouble(billAmt.getText())); 
      }
      catch(Exception ex)
      {
        //If they do, display a message telling them they gave us a non-number
        JOptionPane.showMessageDialog(null, "Please enter a number. ");
        return;
      }
      
      //If they bill is less than zero, tell them that's wrong
      if (tipObject.getBill() < 0)
      {
        JOptionPane.showMessageDialog(null, "Please enter a number greater than zero. ");
        return;
      }
      
      //We should be good to go now. Perform calculations, format output, and print it
      String output = String.format("$%.2f", tipObject.getTotalBill());
      
      totalBill.setText(output);
      
      output = String.format("$%.2f", tipObject.getIndividualShare());
      share.setText(output);
    }
      
    if (e.getSource() == clearBtn)
    {
      //Restore default values
      billAmt.setText("");
      tipPercent.setValue(20);
      partySize.setValue(1);
      totalBill.setText("$0.00");
      share.setText("$0.00");
    }
 }
}

/* Class: TipCalculator
 * 
 * Use: The objects of this class represent
 * information required for a tip app program.
 * It contains various set methods and a couple
 * methods that will calculate the total bill with
 * tip and the individual share.
 * 
 */
public class TipCalculator
{
  private double bill;
  private int tipPercentage;
  private int partySize;
  
  //Default constructor. 
  public TipCalculator()
  {
    this.bill = 0;
    this.tipPercentage = 20;
    this.partySize = 1;
  }
  
  //Get method for bill.
  public double getBill()
  {
    return bill;
  }
  
  //Set method for bill.
  public void setBill( double bill)
  {
    this.bill = bill;
  }
  
  //Set method for tipPercentage.
  public void setTipPercentage( int tipPercentage)
  {
    this.tipPercentage = tipPercentage;
  }
  
  //Get method for tipPercentage
  public int getTipPercentage()
  {
    return tipPercentage;
  }
  
  //Get method for partySize
  public int getPartySize()
  {
    return partySize;
  }
  
  //Set method for partySize.
  public void setPartySize( int partySize)
  {
    this.partySize = partySize;
  }
  
  //getTotalBill() returns the total including tip.
  public double getTotalBill()
  {
    //Java automatically typecasts ints to doubles when multiplying them together.
    return (getBill() + ((getBill() * getTipPercentage())/100));  
  }
  
  //getIndividualShare() returns the amount each person should equally contribute.
  public double getIndividualShare()
  {
    return ((getTotalBill())/(getPartySize()));
  }
}

}
    
    
    