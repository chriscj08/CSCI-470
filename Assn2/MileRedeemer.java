/*
 * Programmer: Chris Jurrens
 * Zid: 1823592
 * CSCI-470-Assignment2
 * 
 * Class: MileRedeemer
 * 
 * Use: This class takes an input file and builds an
 * ArrayList of Destination objects. It has a few methods
 * that find which cities are the furthest away, whether
 * or not they use frequent flyer miles, or determine if
 * you can upgrade a flight to first class.
 * 
 */

import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections;

public class MileRedeemer
{
  private ArrayList<Destination> flights; 
  private int remainingMiles; //Represents the remaining miles after a destination has been added to flights
  
  //Default contructor
  public MileRedeemer()
  {
    this.flights = new ArrayList<Destination>();
    this.remainingMiles = 0;
  }
  
  //Getter. Returns number of remaining miles
  public int getRemainingMiles()
  {
    return remainingMiles;
  }
  
  //Setter. Changes the value of remaining miles
  public void setRemainingMiles(int remainingMiles)
  {
    this.remainingMiles = remainingMiles;
  }
 
  /*
   * Method: readDestinations
   * returns: nothing
   * args: 
   *      1. fileScanner: Scanner object that read the text file we get from the user.
   * 
   * Use: This method builds the ArrayList flights. 
   * 
   */
  public void readDestinations(Scanner fileScanner)
  {   
    String inputLine = "";
    
    //End after end of file
    while (fileScanner.hasNextLine())
    {
      Destination tempDest = new Destination(); //Temporary destination object
      inputLine = fileScanner.nextLine();
       
      String[] splitLine = inputLine.split(";"); //Split the line up based on semicolons
      
      //Set each variable appropriately 
      tempDest.setDestination(splitLine[0]);
      tempDest.setNormalMiles(Integer.parseInt(splitLine[1]));
      tempDest.setFrequentMiles(Integer.parseInt(splitLine[2]));
      tempDest.setFirstClassMiles(Integer.parseInt(splitLine[3]));
      
      String[] monthSplit = splitLine[4].split("-"); //Split the last entry into two values. Delimited by '-'
      
      tempDest.setStartMonth(Integer.parseInt(monthSplit[0]));
      tempDest.setEndMonth(Integer.parseInt(monthSplit[1]));
      
     
      flights.add(tempDest);
  
    }

      Collections.sort(flights); 
      
  }  
  
  /*
   * Method: getCityNames
   * returns: ArrayList<String>
   * args: none
   * 
   * Use: This method returns all the city names in
   * the flights ArrayList.
   * 
   */
  public ArrayList<String> getCityNames()
  {
    int i = 0;
    ArrayList<String> cityNames = new ArrayList<String>();
    
    while (i < flights.size())
    {
      cityNames.add(flights.get(i).getDestination()); //Add flights destination variable to the ArrayList to be returned
      i++;
    }
    
    Collections.sort(cityNames);
    
    return cityNames;
    
  }
  
  /*
   * Method: redeemMiles
   * returns: ArrayList<String>
   * args: 
   *      1. miles: Integer value representing the remaining miles
   *      2. month: represents the month the user is flying
   * 
   * Use: This method find sthe farthest away cities someone can 
   * visit using a given amount of frequent flyer miles. It takes into account
   * discount periods and whether or not there is enough left over to upgrade
   * to first class. It does some of this by calling other methods.
   * 
   */
  public ArrayList<String> redeemMiles(int miles, int month)
  {
    this.setRemainingMiles(miles); //Sets our remaining miles
    ArrayList<String> cities = new ArrayList<String>(); //This will hold all cities found in a descending order
    while(cities.size() < 9) cities.add(""); //Initialize the size of the cities array to 10
    String theCity = findFurthestCity(miles, cities, month); //This will hold city farthest away.

    int i = 0;
       
    while (theCity != "" && i < cities.size())
    {
      cities.set(i,theCity);
      
      compRemainingMiles(theCity, month);

      theCity = findFurthestCity(this.getRemainingMiles(), cities, month);  
      
      i++;
    }
    
    cities = compClass(cities, this.getRemainingMiles());
    
    return cities;
  }
  
  /*
   * Method: findFurthestCity
   * returns: String
   * args: 
   *      1. miles: Integer value representing the remaining miles
   *      2. cities: Represents the cities that have already been found
   *      3. month: represents the month the user is flying
   * 
   * Use: This method finds the furthest city. It checks if it's already in
   * the list. If it is, it trys the next city until it finds one that isn't
   * or it runs out of cities to compare.
   * 
   */
  public String findFurthestCity(int miles, ArrayList<String> cities, int month)
  { 
    for (int i = 0; i < flights.size(); i++)
    {
      //This condition is checking if the month is in the range of the starting and ending month of the city its checking
      if (flights.get(i).getStartMonth() <= month && flights.get(i).getEndMonth() >= month)
      {
        if (flights.get(i).getFrequentMiles() <= miles) //If it is, check if we have enough miles left over to add it
        {
          if (!cities.contains(flights.get(i).getDestination())) //Last check. See if we already have this city
            return flights.get(i).getDestination();
         
        }
      }
      
      //We use this if the month does not fall in the range of city's starting and ending discount months
      else if (flights.get(i).getNormalMiles() <= miles)  
      {
        if (!cities.contains(flights.get(i).getDestination()))    
          return flights.get(i).getDestination();
      } 
    }
    
    return ""; //If we find nothing, return an empty string.
  }
  
  /*
   * Method: compRemainingMiles
   * returns: nothing
   * args: 
   *      1. cityName: Obviously represents the name of the city.
   *      2. month: represents the month the user is flying
   * 
   * Use: This method subtracts the appropriate amount of miles
   * from the remainingMiles data member. It checks whether or not
   * to subtract normal miles or frequent flyer miles.
   * 
   */
  public void compRemainingMiles(String cityName, int month)
  {
    for (int i = 0; i < flights.size(); i++)
    {
      if (flights.get(i).getDestination().equals(cityName)) //When we find the cityName in flights
      {
        if (flights.get(i).getStartMonth() <= month && flights.get(i).getEndMonth() >= month) //Check for discount
        {
          this.remainingMiles  -= flights.get(i).getFrequentMiles();
        }
        else //Otherwise apply normal rate
        {
          this.remainingMiles -= flights.get(i).getNormalMiles();
        }
      }
    }
  }
  
  /*
   * Method: compClass
   * returns: ArrayList<String>
   * args: 
   *      1. cities: The final collection of cities to be returned
   *      2. miles: Represents the remaining miles after all other calcs
   * 
   * Use: This method finalizes any changes we need to make to our cities
   * array. It check if the farthest city away is eligible for a first class
   * upgrade. If it isn't, we check the next furthest and so on. 
   * 
   */
  public ArrayList<String> compClass(ArrayList<String> cities, int miles)
  {
    for (int i = 0; i < flights.size(); i++)
    {
      for(int j = 0; j < cities.size(); j++)
      {
        //Once we have found the city in flights, check if we have enough frequent flyer miles to spend on first class
        if (flights.get(i).getDestination().equals(cities.get(j)) && miles >= flights.get(i).getFirstClassMiles())
        {
          cities.set(j,"* A trip to " + cities.get(j) + " in first class ");
          miles -= flights.get(i).getFrequentMiles();
        }
        //If not, economy class it is.
        else if (flights.get(i).getDestination().equals(cities.get(j)))
          cities.set(j,"* A trip to " + cities.get(j) + " in economy class ");
      }
    }
    return cities;
  }
}