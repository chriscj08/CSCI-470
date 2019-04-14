/* Name: Chris Jurrens
 * Zid: Z1823592
 * Class: CSCI 470
 * Due Date: 03/06/2019
 * 
 * Assignment 3 - Part 1
 * 
 * Purpose: This assignment gets a dollar and cents amount for two
 * USMoney objects. It then adds those together and prints the result.
 * This Main program acts as a driver for the USMoney class.
 * 
 */

import java.io.File; 
import java.util.Scanner;

public class USMoneyDemo
{
  public static void main(String[] args)
  {
    Scanner getInput = new Scanner(System.in);
    
    //Get the dollar amount and cents amount for x
    System.out.print("Enter an integer for the amount of dollars for x. \n");
    int dollars = getInput.nextInt();
    
    System.out.print("Enter an integer for the amount of cents for x. \n");
    int cents = getInput.nextInt();
    
    USMoney x = new USMoney(dollars, cents); //Create USMoney object x
    
    //Get the dollar amount and cents amount for y
    System.out.print("Enter an integer for the amount of dollars for y. \n");
    dollars = getInput.nextInt();
    
    System.out.print("Enter an integer for the amount of cents for y. \n");
    cents = getInput.nextInt();
    
    USMoney y = new USMoney(dollars, cents); //Create USMoney object y
    
    System.out.println("Dollar amount for x: " + x.getDollars());
    System.out.println("Cents amount for x: " + x.getCents());
    
    System.out.println("\nDollar amount for y: " + y.getDollars());
    System.out.println("Cents amount for y: " + y.getCents());
    
    USMoney xPlusY = new USMoney();
    
    //Test the plus method
    xPlusY = x.plus(y);
    
    System.out.println("\nDollar amount for x + y: " + xPlusY.getDollars());
    System.out.println("Cents amount for x + y: " + xPlusY.getCents());
  }
}