package PhoneBook;
import java.io.*;
import java.util.*;

public class PhoneLab {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		for(int i = 0 ; i < 3; i++) {
		try {
			FileWriter fout = new FileWriter("phone.txt");
			System.out.println("��ȭ��ȣ �Է�......");
			System.out.print("�̸� ��ȭ��ȣ : \n");
			str = scan.nextLine();
			fout.write(str);
			fout.close();
			FileReader fin = new FileReader("phone.txt");
			int c;
			while((c=fin.read())!=-1)
				System.out.print((char)c);
			fin.close();
		}catch(IOException ex) {
			System.out.println("���� ����.....");
		}
	}
	
	}
}
