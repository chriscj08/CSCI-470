import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections;

public class MileRedemptionApp
{
  public static void main(String[] args)
  {
    MileRedeemer test = new MileRedeemer();
    String textFile;
    Scanner getInput = new Scanner(System.in);
    ArrayList<String> cities = new ArrayList<String>();
      
    System.out.print("Enter the name of the text file: \n");
    textFile = getInput.nextLine();
    
    File scanFile = new File(textFile);
    
    Scanner readText = new Scanner(scanFile);
    
    test.readDestinations(readText);
    
    System.out.print("Enter: \n");
    
    
    System.out.print("Enter the name of the text file: \n");
    
    cities = test.redeemMiles(
    
    for (int i = 0; i < cities.size(); i++)
      System.out.print(cities.get(i) + " \n");
  }
    
}