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
    Destination tempDest = new Destination();
    
    while (fileScanner.hasNext())
    {
      fileScanner.useDelimiter(";");
      
      tempDest.setDestination(fileScanner.next());
      tempDest.setNormalMiles(Integer.parseInt(fileScanner.next()));
      tempDest.setFrequentMiles(Integer.parseInt(fileScanner.next()));
      tempDest.setFirstClassMiles(Integer.parseInt(fileScanner.next()));
      
      fileScanner.useDelimiter("-");
      
      tempDest.setStartMonth(Integer.parseInt(fileScanner.next()));
      tempDest.setEndMonth(Integer.parseInt(fileScanner.next()));
      
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
      i++;
    }
    
    Collections.sort(cityNames);
    
    return cityNames;
  }
  
  public ArrayList<String> redeemMiles(int miles, int month)
  {
    this.setRemainingMiles(miles); //Sets our remaining miles
    ArrayList<String> cities = new ArrayList<String>(); //This will hold all cities found in a descending order
    while(cities.size() < 10) cities.add(""); //Initialize the size of the cities array to 10
    String theCity = findFurthestCity(miles, cities); //This will hold city farthest away.
    int i = 0;
       
    while (theCity != "" && i < flights.size())
    {
      cities.add(theCity);
      
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