import java.util.*;

public class VectorEx {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("���� �Է�...");
      int num;
      int max=0;
      int sum=0;

      Vector<Integer> v = new Vector<Integer>();
    
      while (true) {
         num=input.nextInt();
         v.add(num);
         if (num == -1)
            break;
      }
      for(int i=0; i<v.size(); i++) {
         int n = v.get(i);
         sum+=n;
         if(n>max)
            max=n;
      }      
      
   
      System.out.println("���� ū ������..."+max);
      System.out.println("�հ�..."+sum);
      System.out.println("���..."+sum/(v.size()-1));
   }
}
