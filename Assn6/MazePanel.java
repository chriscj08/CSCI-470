import java.io.File; 
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.lang.Exception;

import javax.swing.JPanel;

public class MazePanel extends JPanel
{
  private Maze ourMaze;
  private boolean solutionAttempted;
  private boolean solutionFound;
  
  public void readMaze(File fileName) throws NumberFormatException, NoSuchElementException,
                                             FileNotFoundException
  {
    this.solutionAttempted = false;
    this.solutionFound = false;
   
    ourMaze = new Maze();
    
    ourMaze.readMaze(fileName);
    
    repaint();
  }
  
  public void clearMazePath()
  {
    this.solutionAttempted = false;
    this.solutionFound = false;
    
    ourMaze.clearMazePath();
    
    repaint();
  }
  
  @Override
  protected void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    
    Dimension size = getSize();
    
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, size.width, size.height);
    
    if (ourMaze != null)
    {
      ourMaze.drawMaze(g, 200, 200);
    }
    
    if (solutionAttempted && solutionFound)
    {
      g.drawString("Maze solved!", 300, 300);
    }
    else if (solutionAttempted)
    {
      g.drawString("No solution exists.", 300, 300);      
    }
  }
  
}