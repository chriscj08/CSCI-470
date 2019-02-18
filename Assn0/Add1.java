import java.util.Scanner;

public class Add1
{
     public static void main(String[] args)
     {
          String amountStr ;
          double num1, num2;
          
          Scanner sc = new Scanner(System.in);
          
          System.out.println("Enter the first number: ");
          amountStr = sc.next();
          
          try
          {
               num1 = Double.parseDouble(amountStr);
          }
          catch (NumberFormatException nfe)
          {
               System.out.println("1st number invalid.");
               return;
          }
          
          System.out.println("Enter the second number: ");
          amountStr = sc.next();
          
          try
          {
               num2 = Double.parseDouble(amountStr);
           }
          catch (NumberFormatException nfe)
          {
               System.out.println("2nd number invalid.");
               return;
          }
          
          System.out.printf("Sum is: %.2f\n", num1 + num2);
          
     }
}

           