// Will Howard CSCI 1320A HW6
import java.util.*;
public class HW6{
   public static void main(String [] args){
      int x = 0;
      int y = 0;
      int sum = 1; 
      do{
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Enter a positive number: ");
         x = keyboard.nextInt();
      }while (x <= 0);
      
      while (y < x){
         System.out.print(y+ "+");
         y++;
         sum = sum +y;
         }
      System.out.print(x);
      System.out.print("=" +sum);
   }
}