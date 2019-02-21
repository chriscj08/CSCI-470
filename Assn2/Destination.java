/*
 * Programmer: Chris Jurrens
 * Zid: 1823592
 * CSCI-470-Assignment2
 * 
 * Class: Destination
 * 
 * Use: This class lays down the foundation for the whole program.
 * Each destination object represents information about a city
 * and how it interacts with frequent flyer miles.
 * 
 */

public class Destination implements Comparable<Destination>
{
  private String destination; //The city
  private int normalMiles;    //Normal miles you have to spend frequent flyer miles on
  private int frequentMiles;  //Represents the the discounted amount you have to spend frequent flyers miles on
  private int firstClassMiles; //Represents the amount of frequent flyers miles needed to upgrade to first class
  private int startMonth;     //Represents the starting month you can spend the discounted amount
  private int endMonth;       //Represents the last month  you can spend the discounted amount
  
  //Default constructor. 
  public Destination ()
  {
    this.destination = "";
    this.normalMiles = 0;
    this.frequentMiles = 0;
    this.firstClassMiles = 0;
    this.startMonth = 0;
    this.endMonth = 0;
  }
  
  //Overloaded constructor.
  public Destination (String destination, int normalMiles, int frequentMiles, int firstClassMiles, int startMonth, int endMonth)
  {
    this.destination = destination;
    this.normalMiles = normalMiles;
    this.frequentMiles = frequentMiles;
    this.firstClassMiles = firstClassMiles;
    this.startMonth = startMonth;
    this.endMonth = endMonth;
  }
  
 /*
  * The following methods (except the last one), are all all accessor
  * methods. For the sake of convenience, I will document them all
  * here. Each data member has a setter and a getter method defined
  * below. They all function as on would expect. Setter takes an input
  * and returns nothing. Getter return the value.
  */
  public String getDestination()
  {
    return destination;
  }
  
  
  public void setDestination(String destination)
  {
    this.destination = destination;
  }

  public int getNormalMiles()
  {
    return normalMiles;
  }
  
  public void setNormalMiles(int normalMiles)
  {
    this.normalMiles = normalMiles;
  }
  
  public int getFrequentMiles()
  {
    return frequentMiles;
  }
  
  public void setFrequentMiles(int frequentMiles)
  {
    this.frequentMiles = frequentMiles;
  }
   
  public int getFirstClassMiles()
  {
    return firstClassMiles;
  }
  
  public void setFirstClassMiles(int firstClassMiles)
  {
    this.firstClassMiles = firstClassMiles;
  }
  
  public int getStartMonth()
  {
    return startMonth;
  }
  
  public void setStartMonth(int startMonth)
  {
    this.startMonth = startMonth;
  }
  
  
  public int getEndMonth()
  {
    return endMonth;
  }
  
  public void setEndMonth(int endMonth)
  {
    this.endMonth = endMonth;
  }
  
  //This method allows us to sort collections containing Destination objects
  public int compareTo(Destination anotherDest)
  {
    return this.normalMiles > anotherDest.normalMiles ? -1 : (this.normalMiles < anotherDest.normalMiles ? 1 : 0);
  }
  
}
