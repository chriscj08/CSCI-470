/* Class: MazeSquare
 * 
 * Use: This classes objects describe individual
 * squares on our maze panel. The objects contain
 * information about the row and column where the 
 * square are located, the type of square they are,
 * and whether or not they have been visited.
 * 
 * This class also contains methods that allow us
 * to check on values of objects and do things
 * with drawing squares.
 */ 

import java.awt.Graphics;
import java.awt.Color;

public class MazeSquare
{ 
  public enum SquareType { WALL, SPACE, PATH };
  public static final int DIMENSIONS = 15; //Square dimension
  
  //Data members
  private int row;
  private int column;
  private SquareType type;
  private boolean visited; 
  
  //Overloaded constructor 
  public MazeSquare(int row, int column, SquareType type)
  {
    this.row = row;
    this.column = column;
    this.type = type;
    this.visited = false;
  }
  
  public SquareType getType()
  {
    return this.type;
  }
  
  //This method will return the square to its original look
  public void clearPath()
  {
    this.visited = false;
    
    //If PATH, then restore it to a space
    if (this.type == SquareType.PATH)
      this.type = SquareType.SPACE;
  }
  
  //When you visit a square, call this method
  public void markVisited()
  {
    this.visited = true;
  }
  
  //See if a square has been visited
  public boolean getVisited()
  {
    return this.visited;
  }
  
  //Check for a wall
  public boolean isWall()
  {
    return (this.type == SquareType.WALL);
  }
  
  public void setToPath()
  {
    this.type = SquareType.PATH;
  }
  
  public void drawSquare(Graphics g, int startX, int startY)
  {
    if (this.type == SquareType.SPACE)
    {
      g.setColor(Color.WHITE);
    }
    else if (this.type == SquareType.WALL)
    {
      g.setColor(Color.DARK_GRAY);
    }
    else if (this.type  == SquareType.PATH)
    {
      g.setColor(Color.RED);
    }
    
    g.fillRect((startX * (this.row + 1)), (startY * (this.column +1)), (startX + (this.row + 1)) ,
               (startY + (this.column +1) ) );
    
    g.setColor(Color.BLACK);
    
    g.drawRect((startX * (this.row + 1)), (startY * (this.column +1)), (startX + (this.row + 1)) ,
               (startY + (this.column +1) ) );
  }
}

