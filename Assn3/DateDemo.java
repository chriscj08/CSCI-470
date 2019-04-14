/* Name: Chris Jurrens
 * Zid: Z1823592
 * Class: CSCI 470
 * Due Date: 03/06/2019
 * 
 * Assignment 3 - Part 2
 * 
 * Purpose: This assignment simply gets a date and calculates
 * how many days since January 1st have passed. Our Main program
 * here acts as a driver program for the Date class.
 * 
 */ 
import java.io.File; 
import java.util.Scanner;

public class DateDemo
{
  public static void main(String[] args)
  {
    Scanner getInput = new Scanner(System.in);
    
    //Get the day, month, and year from the user
    System.out.println("Enter the day: ");
    int day = getInput.nextInt();
    
    System.out.println("Enter the month: ");
    int month = getInput.nextInt();
    
    System.out.println("Enter the year: ");
    int year = getInput.nextInt();
    
    //Create a new Date object with the user input
    Date theDate = new Date(day, month, year);
    
    theDate.DaysSinceJan1();
  }
}