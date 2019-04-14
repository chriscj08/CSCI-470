import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class MazeAppFrame extends JFrame
{
  private File file;
  int returnVal;
  String currentLine;
  
  
  //Data members go HERE
  private JButton openMazeBtn;
  private JButton solveMazeBtn;
  private JButton clearSolutionBtn;
  private MazePanel ourMazePanel; 
  private JFileChooser fc;
  
  public MazeAppFrame()
  {
    super("A-Maze-ing Mazes");
   
    
    setLayout(new BorderLayout());
    
    JPanel southPanel = new JPanel(); 
    southPanel.setLayout(new FlowLayout());
    
    fc = new JFileChooser();
    fc.setCurrentDirectory(new File ("."));
    
    ourMazePanel = new MazePanel();
    
    openMazeBtn = new JButton("Open Maze");
    southPanel.add(openMazeBtn);
    
    solveMazeBtn = new JButton("Solve Maze");
    solveMazeBtn.setEnabled(false);
    southPanel.add(solveMazeBtn);
    
    clearSolutionBtn = new JButton("Clear Solution");
    clearSolutionBtn.setEnabled(false);
    southPanel.add(clearSolutionBtn);
    
    add(ourMazePanel, BorderLayout.CENTER);
    add(southPanel, BorderLayout.SOUTH);
    
    theHandler handler = new theHandler();
    
    openMazeBtn.addActionListener(handler);
    solveMazeBtn.addActionListener(handler);
    clearSolutionBtn.addActionListener(handler);
    
    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);   
  }
  
  public class theHandler implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
    String string = "";
    
    if (e.getSource() == openMazeBtn)
    {
      returnVal = fc.showOpenDialog(null);
      
      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
        file = fc.getSelectedFile();
        try
        {
        ourMazePanel.readMaze(file);
        }
        catch(FileNotFoundException ex)
        {
           
        }
      }
      solveMazeBtn.setEnabled(true);
    }
    else if (e.getSource() == solveMazeBtn)
    {
      ourMazePanel.solveMaze();
      clearSolutionBtn.setEnabled(true);
      solveMazeBtn.setEnabled(false);
    }
    else if (e.getSource() == clearSolutionBtn)
    {
      ourMazePanel.clearMazePath();
      solveMazeBtn.setEnabled(true);
      clearSolutionBtn.setEnabled(false);
    }
    
    
  }
  }
}