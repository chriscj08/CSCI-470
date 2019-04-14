/* USMoney
 * 
 * USMoney is a class. The objects of this class
 * represent US currency. The class contains
 * methods for adding two USMoney objects together.
 * It has getter methods to help with that. 
 */

public class USMoney
{
  private int dollars;
  private int cents;
  
  //Default constructor
  public USMoney()
  {
    this.dollars = 0;
    this.cents = 0;
  }
  
  /* Name: USMoney
   * Args: 1.dollars: An integer value representing a dollar amount 
   *       2.cents: An integer value representing a cents amount
   * 
   * 
   * Use: This is UsMoney's constructor when you pass arguments in
   * the object declaration. It sets the dollar amount and the cents
   * amount. If cents is greater than 99 it adds dollars to the dollar
   * data member until cents is less than or equal to 99.
   */ 
  public USMoney( int dollars, int cents)
  {
    this.dollars = dollars;
    
    while (cents > 99)
    {
      this.dollars += 1;
      cents -= 100;
    }
    
    if (cents < 0)
      this.cents = 0;
    
    else
      this.cents = cents;
  }
  
  //getDollars(): returns the dollar amount for the object calling this method
  public int getDollars()
  {
    return this.dollars;
  }
  
  //getCents(): return the cents amount for the object calling this method
  public int getCents()
  {
    return this.cents;
  }
  
  /* Name: plus()
   * args: 1. moneyObject: Represents a USMoney object whose values we are going to
   *          add to the object who called the method.
   * 
   * return: Returns a money object representing the addition.
   * 
   * Use: Adds the dollars and cents amount of two USMoney objects. 
   * 
   */
  public USMoney plus(USMoney moneyObject)
  {
    int newDollarAmt = this.getDollars() + moneyObject.getDollars();
    int newCentsAmt = this.getCents() + moneyObject.getCents();
    
    USMoney newMoneyObject = new USMoney(newDollarAmt, newCentsAmt);
    
    return newMoneyObject;
  }
  
  }
      