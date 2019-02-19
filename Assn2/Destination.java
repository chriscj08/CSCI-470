public class Destination implements Comparable<Destination>
{
  private String destination;
  private int normalMiles;
  private int frequentMiles;
  private int firstClassMiles;
  private int startMonth;
  private int endMonth;
  
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
  
  public int compareTo(Destination anotherDest)
  {
    return this.normalMiles > anotherDest.normalMiles ? -1 : (this.normalMiles < anotherDest.normalMiles ? 1 : 0);
  }
  
}
