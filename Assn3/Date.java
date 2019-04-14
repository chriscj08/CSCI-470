/* Date
 * 
 * Date is a class. The objects of this class
 * represents a calendar date. The class contains
 * methods for calculating the days since January 1st
 * along with some getter methods and other methods
 * to help it do that
 */


public class Date
{
  private int day;
  private int month;
  private int year;
  
  //Default Constructor
  public Date()
  {
    this.day = 0;
    this.month = 0;
    this.year = 0;
  }
  
  /* Name: Date()
   * Args: 1. day: Integer value representing the day
   *       2. month: Integer value representing the month
   *       3. year: Integer value representing the year
   * 
   * Use: This is a constructor you can use to initialize a Date
   * object with values.
   */ 
  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  //getDay(): getter method to return the day
  public int getDay()
  {
    return this.day;
  }
  
  //getMonth(): getter method to return the month
  public int getMonth()
  {
    return this.month;
  }
  
  //getYear(): getter method to return the year
  public int getYear()
  {
    return this.year;
  }
  
  /* Name: DaysSinceJan1()
   * Args: none
   * returns nothing.
   * 
   * Use: This method will look at the date the user has
   * entered for the Date object. It will then calculate
   * how many days have passed since January 1st taking into
   * account leap years. 
   */
  public void DaysSinceJan1()
  {
    int numOfDays = 1; //Counting variable
    int addOrSubtract = 1; //Adds one or subtracts one
    
    int daysInMonth = 31;
    
    //Initialize these to one since that is Jan 1st
    int theDay = 1;
    int theMonth = 1;
    
    while (true)
    {  
      if (theDay == daysInMonth)
      {
        theDay = 1;
        theMonth += 1;
        numOfDays += 1;
        //Handle the special case of February
        if (theMonth == 2) 
        {
          if (IsLeapYear(getYear()))
            daysInMonth = 29;
          else
            daysInMonth = 28;
        }
        //Handle the months between February and August 
        else if (theMonth > 2 && theMonth < 8)
        {
          if (theMonth == 3)
            daysInMonth = 30;
          
          daysInMonth += addOrSubtract; //Every month has either 30 or 31 (except February)
          addOrSubtract = addOrSubtract * (-1); //It alternates every month (except August)
        }
         //Handle August ruining the pattern
        else if (theMonth == 8)
        {
          daysInMonth = 31;
        }
        //Handle everything after August
        else
        {
          daysInMonth += addOrSubtract;
          addOrSubtract = addOrSubtract * (-1);
        }
      }
      
      //Once we rech our date, end the while loop
      if (theDay == getDay() && theMonth == getMonth())
      {
        break;
      }
      
      theDay += 1;
      numOfDays += 1;
  }
    System.out.println(" Number of days since January 1st: " + numOfDays);
 }
  
  /* Name: IsLeapYear()
   * Args: 1. year: Represents the calendar year
   * 
   * returns a boolean value.
   * 
   * Use: This method determines if a year is a leap year
   * or not. We use modulous division to find things
   * evenly divisble by 400 or 4 years. If they aren't or
   * are divisible by 100, we return false.
   */ 
  public boolean IsLeapYear(int year)
  {
    if (year % 400 == 0)
      return true;
    else if (year % 100 == 0)
      return false;
    else if (year % 4 == 0)
      return true;
    else
      return false;
  }
}

            
            
            
            
            
            
            
            
            
            
            
            
            