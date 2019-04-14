import java.io.File; 
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.lang.Exception;
import java.awt.Graphics;

public class Maze
{
  public static final int MAX_ROW = 30;
  public static final int MAX_COLUMN = 30;
  
  //Data members
  private int startRow;
  private int startColumn;
  private int endRow;
  private int endColumn;
  private int numOfRows;
  private int numOfColumns;
  private MazeSquare[][] theMaze;
  
  //Default Constructor
  public Maze()
  {
    this.startRow = 0;
    this.startColumn = 0;
    this.endRow = 0;
    this.endColumn = 0;
    this.numOfRows = 0;
    this.numOfColumns = 0;
    
  }
  
  //Get method for numOfRows
  public int getNumOfRows()
  {
    return this.numOfRows;
  }
  
  //Set method for numOfRows
  public void setNumOfRows(int numOfRows)
  {
    this.numOfRows = numOfRows;
  }
  
  //Get method for numOfColumns
  public int getNumOfColumns()
  {
    return this.numOfColumns;
  }
  
  //Set method for numOfColumns
  public void setNumOfColumns(int numOfColumns)
  {
    this.numOfColumns = numOfColumns;
  }
  
  //Set method for startRow
  public void setStartRow(int startRow)
  {
    this.startRow = startRow;
  }
  
  //Get method for startRow
  public int getStartRow()
  {
    return this.startRow;
  }
  
  //Set method for startColumn
  public void setStartColumn(int startColumn)
  {
    this.startColumn = startColumn;
  }
  
  //Get method for startColumn
  public int getStartColumn()
  {
    return this.startColumn;
  }
  
  //Set method for endRow
  public void setEndRow(int endRow)
  {
    this.endRow = endRow;
  }
  
  //Get method for endRow
  public int getEndRow()
  {
    return this.endRow;
  }
  
  //Set method for endColumn
  public void setEndColumn(int endColumn)
  {
    this.endColumn = endColumn;
  }
  
  //Get method for endColumn
  public int getEndColumn()
  {
    return this.endColumn;
  }
  
  public void readMaze(File fileName) throws NumberFormatException, NoSuchElementException,
                                             FileNotFoundException
  {
    Scanner inFile = new Scanner(fileName);
    String inputLine = "";
    
    inputLine = inFile.nextLine();
    setNumOfRows(Integer.parseInt(inputLine));
    System.out.println(getNumOfRows());
    
    inputLine = inFile.nextLine();
    System.out.println(inputLine);
    setNumOfColumns(Integer.parseInt(inputLine));
      
    theMaze = new MazeSquare[getNumOfRows()][getNumOfColumns()];
    
    while (inFile.hasNextLine())
    {
      inputLine = inFile.nextLine();
      System.out.println(inputLine);
      //i here represents which row we are on
      for (int i = 0; i < getNumOfRows(); i++)
      {
        //j here represents which column we are on
        for (int j = 0; j < getNumOfColumns(); j++)
        {
          //System.out.println(inputLine.charAt(j));
          //If pound sign, create a wall square
          if (inputLine.charAt(j) == '#')
          {
            MazeSquare tempSquare = new MazeSquare(i, j, MazeSquare.SquareType.WALL);
            theMaze[i][j] = tempSquare;           
          }
          //Only other possibility is space square
          else
          {
            //If we find the starting space
            if (inputLine.charAt(j) == 's')
            {
              setStartRow(i);
              setStartColumn(j);
            }
            //If we find the ending space
            if (inputLine.charAt(j) == 'e')
            {
              setEndRow(i);
              setEndColumn(j);
            }
            
            MazeSquare tempSquare = new MazeSquare(i, j, MazeSquare.SquareType.SPACE);
            theMaze[i][j] = tempSquare;
          }    
        }    
        
        
       }
    }
  }//End of readMaze()
  
  public void clearMazePath()
  {
    for (int i = 0; i < getNumOfRows(); i++)
    {
      for(int j = 0; j < getNumOfColumns(); j++)
      {
        theMaze[i][j].clearPath();
      }
    }
  }
 
  public void drawMaze(Graphics g, int startX, int startY)
  {
    for (int i = 0; i < getNumOfRows(); i++)
    {
      for(int j = 0; j < getNumOfColumns(); j++)
      {
        theMaze[i][j].drawSquare(g, startX, startY);
      }
    }  
  }
  
  
}//End of Maze class