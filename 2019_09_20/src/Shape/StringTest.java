package Shape;

import java.util.Scanner;

public class StringTest {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner scanner = new Scanner(System.in);
      String input;
      System.out.println("���ڿ��� �Է��ϼ���...");  
      input = scanner.nextLine();
      
      for(int i =0; i<input.length(); i++) {
         String last = input.substring(0,1);
         String first = input.substring(1);
         input = first.concat(last);
         System.out.println(input);
      }
   }

}
//ppt 3�� 42~