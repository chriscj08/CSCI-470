import javax.swing.JFrame;
import java.awt.EventQueue;
public class MazeApp
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(() -> 
        {
             new MazeAppFrame();
        });
  }
}