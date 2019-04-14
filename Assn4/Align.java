/* Class: Align
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

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;


public class Align extends JFrame
{
  //These are all the buttons, text fields, and checkboxes
  private JTextField xCoord;
  private JTextField yCoord;
  private JButton okBtn;
  private JButton cancelBtn;
  private JButton helpBtn;
  private JCheckBox snapCheck;
  private JCheckBox showCheck;
  
  //Default constructor
  public Align()
  {
    //Window tital
    super("Align");
    
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    GridBagConstraints constraints = new GridBagConstraints();
    
    //These constraints will help us make our panel look nice
    constraints.gridx = 4;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.weightx = 50;
    constraints.weighty = 50;
    constraints.insets = new Insets(5,5,5,5);
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.BOTH;
    
    
    //Create and place the OK button
    okBtn = new JButton("OK");
    panel.add(okBtn, constraints);
    
    //Change grid location and add the cancel button
    constraints.gridy = 4;
    cancelBtn = new JButton("Cancel");
    panel.add(cancelBtn, constraints);
    
    //Change grid location and add the help button
    constraints.gridy = 7;
    helpBtn = new JButton("Help");
    panel.add(helpBtn, constraints);
    
    //Change grid location and add the snap to grid checkbox
    snapCheck = new JCheckBox("Snap to Grid");
    constraints.gridx = 1;
    constraints.gridy = 3;
    panel.add(snapCheck,constraints);
    
    //Change grid location and add the show grid checkbox
    showCheck = new JCheckBox("Show Grid");
    constraints.gridy = 5;
    panel.add(showCheck, constraints);
    
    //Change grid location and add X: text field
    xCoord = new JTextField();
    constraints.gridx = 3;
    constraints.gridy = 2;
    panel.add(xCoord, constraints);
    
    //Change grid location and add Y: text field
    yCoord = new JTextField();
    constraints.gridy = 6;    
    panel.add(yCoord, constraints);
    
    //X: label
    JLabel xLabel = new JLabel("X: ");
    constraints.gridx = 2;
    constraints.gridy = 2;
    panel.add(xLabel, constraints);
    
    //Y: label
    JLabel yLabel = new JLabel("Y: ");
    constraints.gridx = 2;
    constraints.gridy = 6;
    panel.add(yLabel, constraints);
         
    add(panel);
    
    thehandler handler = new thehandler();
    
    //Create action listeners
    okBtn.addActionListener(handler);
    cancelBtn.addActionListener(handler);
    helpBtn.addActionListener(handler);
    xCoord.addActionListener(handler);
    yCoord.addActionListener(handler);
    snapCheck.addActionListener(handler);
    showCheck.addActionListener(handler);
    
    setSize(600, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  //This class will handle all the events
  private class thehandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String string = "";
      
      //For each if statement, we are checking which thing you interacted with
      //and creating a dialog box that tells you what you clicked on
      if (event.getSource() == okBtn)
      {
        JOptionPane.showMessageDialog(null, "OK");      
      }
      else if (event.getSource() == cancelBtn)
      {
        JOptionPane.showMessageDialog(null, "Cancel");
      }
      else if (event.getSource() == helpBtn)
      {
        JOptionPane.showMessageDialog(null, "Help");
      }
      else if (event.getSource() == xCoord)
      {
        JOptionPane.showMessageDialog(null, xCoord.getText());
      }
      else if (event.getSource() == yCoord)
      {
        JOptionPane.showMessageDialog(null, yCoord.getText());
      }
      else if (event.getSource() == snapCheck)
      {
        //Flops back and forth between check and unchecked
        if (snapCheck.isSelected())
          JOptionPane.showMessageDialog(null, "Snap to Grid was Checked");
        else
          JOptionPane.showMessageDialog(null, "Snap to Grid was Unchecked");
      }
      else if (event.getSource() == showCheck)
      {
        //Flops back and forth between check and unchecked
        if (showCheck.isSelected())
         JOptionPane.showMessageDialog(null, "Show Grid was Checked");
        else
         JOptionPane.showMessageDialog(null, "Show was Unchecked");
      }
  }
  }  
}
    