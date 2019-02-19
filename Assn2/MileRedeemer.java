import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections;

public class MileRedeemer
{
  private ArrayList<Destination> flights;
  private int remainingMiles;
  
  public MileRedeemer()
  {
    this.flights = new ArrayList<Destination>();
    this.remainingMiles = 0;
  }
  
  
  public ArrayList<Destination> getFlights ()
  {
    return flights;
  }
  
  public void setFlights(ArrayList<Destination> flights)
  {
    this.flights = flights; 
  }
  
  public int getRemainingMiles()
  {
    return remainingMiles;
  }
  
  public void setRemainingMiles(int remainingMiles)
  {
    this.remainingMiles = remainingMiles;
  }
 
  
  public void readDestinations(Scanner fileScanner)
  {   
    String inputLine = "";
    
    while (fileScanner.hasNextLine())
    {
      Destination tempDest = new Destination();
      inputLine = fileScanner.nextLine();
       
      String[] splitLine = inputLine.split(";");
      
      tempDest.setDestination(splitLine[0]);
      tempDest.setNormalMiles(Integer.parseInt(splitLine[1]));
      tempDest.setFrequentMiles(Integer.parseInt(splitLine[2]));
      tempDest.setFirstClassMiles(Integer.parseInt(splitLine[3]));
      
      String[] monthSplit = splitLine[4].split("-");
      
      tempDest.setStartMonth(Integer.parseInt(monthSplit[0]));
      tempDest.setEndMonth(Integer.parseInt(monthSplit[1]));
      
     
      flights.add(tempDest);
  
    }

      Collections.sort(flights);
  }  
  
  public ArrayList<String> getCityNames()
  {
    int i = 0;
    ArrayList<String> cityNames = new ArrayList<String>();
    
    while (i < flights.size())
    {
      cityNames.add(flights.get(i).getDestination());
      System.out.print(flights.get(i).getDestination());
      i++;
    }
    
    Collections.sort(cityNames);
    
    return cityNames;
  }
  
  public ArrayList<String> redeemMiles(int miles, int month)
  {
    this.setRemainingMiles(miles); //Sets our remaining miles
    ArrayList<String> cities = new ArrayList<String>(); //This will hold all cities found in a descending order
    while(cities.size() < 9) cities.add(""); //Initialize the size of the cities array to 10
    String theCity = findFurthestCity(miles, cities); //This will hold city farthest away.
    int i = 0;
       
    while (theCity != "" && i < flights.size())
    {
      cities.set(i,theCity);
      
      compRemainingMiles(theCity, month);
      
      theCity = findFurthestCity(this.getRemainingMiles(), cities);
      
      i++;
    }
    
    return cities;
  }
  
  public String findFurthestCity(int miles, ArrayList<String> cities)
  { 
    for (int i = 0; i < flights.size(); i++)
    {
      if (flights.get(i).getNormalMiles() <= miles && !flights.get(i).getDestination().equals(cities.get(i)))
        return flights.get(i).getDestination();
    }
    
    return "";
  }
  
  public void compRemainingMiles(String cityName, int month)
  {
    for (int i = 0; i < flights.size(); i++)
    {
      if (flights.get(i).getDestination().equals(cityName))
      {
        if (flights.get(i).getStartMonth() <= month && flights.get(i).getEndMonth() >= month)
        {
          this.remainingMiles  -= flights.get(i).getFrequentMiles();
        }
        else
        {
          this.remainingMiles -= flights.get(i).getNormalMiles();
        }
      }
    }
  }
}