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
    int i = 0;
    String answer = "Y";
    boolean check = false;
    
    do
    {
      try
      {
        System.out.print("Enter the name of the text file: \n");
        textFile = getInput.nextLine();
    
        File scanFile = new File(textFile);
    
        Scanner readText = new Scanner(scanFile);  
        
        test.readDestinations(readText);
        
        
        check = true;
        
      }
      catch (Exception ex)  
      {
        System.out.print("File not found. \n"); 
      }
    }while(!check);
    
    while(!answer.equals("n") || !answer.equals("N"))
    {
      System.out.print("**********WELCOME TO THE FREQUENT FLYER REDEMPTION APP********** \n\n");
      System.out.print("Here are the cities you can travel to: \n\n");
                     
      cities = test.getCityNames();                 
      for (i = 0; i < cities.size(); i++)
        System.out.print(cities.get(i) + " \n");
    
      System.out.print("\nEnter the amount of miles: \n");
      int miles = getInput.nextInt();
    
      System.out.print("Enter the month you are visiting: \n");
      int month = getInput.nextInt();
    
      cities = test.redeemMiles(miles, month);
    
      for (i = 0; i < cities.size(); i++)
      {
        if (cities.get(i).equals("") || cities.get(i) == null)
          cities.remove(i);
      }
      cities.trimToSize();
    
      if (cities.get(0).equals(""))
        System.out.println("***Not enough miles to redeem any trips*** ");
      else
      {
        System.out.print("You can redeem one of the following trips: \n\n");
        for (i = 0; i < cities.size(); i++)
          System.out.print(cities.get(i) + " \n"); 
      }
    
      System.out.print("\nYour remaining frequent miles: " + test.getRemainingMiles() + "\n");
    
      System.out.print("Would you like to continue? (y/n)\n");
      answer = getInput.next();
      System.out.print(answer);
    }
    
    
  }
    
}