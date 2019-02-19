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
   
    try
    {
    System.out.print("Enter the name of the text file: \n");
    textFile = getInput.nextLine();
    
    File scanFile = new File("Destination Mileage.txt");
    
        Scanner readText = new Scanner(scanFile);  
        
        test.readDestinations(readText);
        cities = test.getCityNames();
        
        int i = 0;
        while (i < cities.size())
        {
          System.out.print(cities.get(i) + "\n");
          i++;
        }
    }
    catch (Exception ex)  
    {
        // insert code to run when exception occurs
    }
    
    System.out.print("Enter the amount of miles: \n");
    int miles = getInput.nextInt();
    
    System.out.print("Enter the month you are visiting: \n");
    int month = getInput.nextInt();
    
    cities = test.redeemMiles(miles, month);
    
    for (int i = 0; i < cities.size(); i++)
      System.out.print(cities.get(i) + " \n");
  }
    
}