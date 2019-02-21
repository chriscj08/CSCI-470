/*
 * Programmer: Chris Jurrens
 * Zid: 1823592
 * CSCI-470-Assignment2
 * 
 * Class: MileRedeemerApp
 * 
 * Use: This is the driver program for the rest of the
 * classes. It gets a series of inputs from the user
 * and shows them available options based on criteria
 * entered.
 * 
 */

import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections;

public class MileRedemptionApp
{
  public static void main(String[] args)
  {
    MileRedeemer test = new MileRedeemer(); //Calls most of the functions
    String textFile; //Put name of text file in here
    Scanner getInput = new Scanner(System.in); //Get user input from here
    ArrayList<String> cities = new ArrayList<String>(); //store our cities in here
    int i = 0; //Counter for iterating
    String answer = "Y"; //While loop condition
    boolean check = false; //
    
    do
    {
      try
      {
        System.out.print("Enter the name of the text file: \n");
        textFile = getInput.nextLine(); //Get file name from user
    
        File scanFile = new File(textFile);
    
        Scanner readText = new Scanner(scanFile);  
        
        test.readDestinations(readText); //After getting file, call readDestinations method
        
        
        check = true;
        
      }
      catch (Exception ex)  
      {
        System.out.print("File not found. \n"); //If user provides a nonexistent file, catch the error. Prompt again.
      }
    }while(!check);
    
    
      System.out.print("**********WELCOME TO THE FREQUENT FLYER REDEMPTION APP********** \n\n");
      System.out.print("Here are the cities you can travel to: \n\n");
                     
      cities = test.getCityNames(); //Show all the cities               
      for (i = 0; i < cities.size(); i++)
        System.out.print(cities.get(i) + " \n");
      
     while(true)
    {
      System.out.print("\nEnter the amount of miles: \n");
      int miles = getInput.nextInt(); //Get miles from user
    
      System.out.print("Enter the month you are visiting: \n");
      int month = getInput.nextInt(); //Get month from user
    
      cities = test.redeemMiles(miles, month);
    
      for (i = 0; i < cities.size(); i++)
      {
        if (cities.get(i).equals("") || cities.get(i) == null)
          cities.remove(i);
      }
      cities.trimToSize(); //Trim any empty spaces in the cities array
    
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
      
      if (!"n".equals(answer) || !"N".equals(answer))
      {
        System.out.println("Thank you for using this app.");
        break;
      }
    }
    
    
  }
    
}