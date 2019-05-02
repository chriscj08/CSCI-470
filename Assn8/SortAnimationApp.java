/* Programmer: Chris Jurrens
 * Zid: 1823592
 * 
 * Date: 5/02/2019
 * 
 * Purpose: This program is GUI application that lets
 * the user pick a sort alogrithm (3 choices), a sorting speed,
 * and then runs a visual demonstration of the sorting algorithm
 * at work
 * 
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.Random;
import java.lang.Exception;

public class SortAnimationApp extends JFrame
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() 
            { new SortAnimationApp(); }});
  }
  
  //Data members
  private String[] speed;
  private SortPanel leftPanel;
  private SortPanel rightPanel;
  private JButton populateBtn;
  private JButton pauseBtn;
  private JComboBox<String> sortSpeed;
  
  public SortAnimationApp()
  {
    super("Sorting Animation");
    
    setLayout(new BorderLayout());
    
    //Panel that will hold our animations
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridBagLayout());
    
    //Create the bottom panel. Will hold the buttons
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout());
    
    theHandler handler = new theHandler();
    
    //Create our buttons and combo box
    populateBtn = new JButton("Populate");
    populateBtn.addActionListener(handler);
    
    speed = new String[]{"Slow", "Medium", "Fast"};
    sortSpeed = new JComboBox<String>(speed);
    
    pauseBtn = new JButton("Sort");
    pauseBtn.addActionListener(handler);
     
    //GridBag constraints
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.insets = new Insets(5,5,5,5);
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.BOTH;
    
    bottomPanel.add(populateBtn);
    bottomPanel.add(sortSpeed);
    pauseBtn.setEnabled(false);
    bottomPanel.add(pauseBtn);
    //bottom panel finished
    
    //These next two panels will be placed on the center panel. They will
    //Hold the SortPanels
    leftPanel = new SortPanel();
    leftPanel.setBackground(Color.LIGHT_GRAY);
    
    rightPanel = new SortPanel();
    rightPanel.setBackground(Color.DARK_GRAY);
    
    centerPanel.add(leftPanel, constraints);
    constraints.gridx = 2;
    centerPanel.add(rightPanel, constraints);  
    
    add(centerPanel, BorderLayout.CENTER);
    add(bottomPanel, BorderLayout.SOUTH);   
    
    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  //Handle all button events here
  public class theHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String string = "";
    
      if(e.getSource() == populateBtn)
      {
        populateBtn.setEnabled(false);
        pauseBtn.setEnabled(true);
        pauseBtn.setText("Sort");
        
        Dimension size = new Dimension();
        size = leftPanel.getAnimation().getSize();
    
        //Create the arrays here since both panels
        //need the same data
        int[] numbers1 = new int[size.width];
        int[] numbers2 = new int[size.width];
        Random rand = new Random();
        
        for (int i = 0; i < size.width; i++)
        {
         numbers1[i] = rand.nextInt(size.height);
         numbers2[i] = numbers1[i]; //Copy data into second array       
        }
        
        leftPanel.setNumbers(numbers1);
        rightPanel.setNumbers(numbers2);
        
        //Draw the lines
        leftPanel.populate();        
        rightPanel.populate();     

      }
      else if (e.getActionCommand().equals("Sort"))
      {
        pauseBtn.setText("Pause");
        
        leftPanel.setSpeed((String) sortSpeed.getSelectedItem());
        rightPanel.setSpeed((String) sortSpeed.getSelectedItem());
        leftPanel.sort(populateBtn);
        rightPanel.sort(populateBtn);
        
      }
      else if (e.getActionCommand().equals("Pause"))
      {
        pauseBtn.setText("Resume");
        
        leftPanel.pauseSort();
        rightPanel.pauseSort();
      }
      else if (e.getActionCommand().equals("Resume"))
      {
        pauseBtn.setText("Pause");
        
        leftPanel.resumeSort();
        rightPanel.resumeSort();
      }                                
    }//End of actionPerformed
  }//End of theHandler class
}//End of SortAnimationApp class