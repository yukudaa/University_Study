package project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class redBlackTest {

	public static void main(String[] args) {


		try {
			File file = new File("C:\\Users\\leeyo\\eclipse-workspace\\Algorithm_Project\\src\\stationB.txt");
			// ���� ��������
			FileReader file_reader = new FileReader(file);
			// ���� �Է� ��Ʈ�� ����
			BufferedReader in = new BufferedReader(file_reader);
			// �����͸� �Ͻ������� �����ϱ� ���� ���� ����
			
			String line = null;
			
			
			redBlack<String, String> bst = new redBlack<String, String>();
			
			
			try {
				in = new BufferedReader(new FileReader(file));
				while((line = in.readLine()) != null) {
					String[] vs = new String[2];
					vs = line.split(",");
					bst.insert(vs[0],vs[1]);
				}
				in.close();
			} catch(IOException e) {
				System.err.println("File Error");
			}
			

			bst.inorder();

			System.out.println("height : " + bst.height());
			System.out.println("root key : " + bst.getRootKey());
			
			Scanner scanner = new Scanner(System.in);
			String search_key;
			for(int j = 0 ; j < 2; j++) {
				System.out.print("Enter your search key : ");
				search_key = scanner.nextLine();
				if(bst.search(search_key) == null) {
					System.out.println("=> no such key!");
				}
				else {
					System.out.println("=> "+bst.getValue(bst.search(search_key)));
				}
			}
			
			
			
	
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �� �� ����");

		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}
	/*
	 * redBlack<String, String> bst = new redBlack<String, String>(); // �������� for
	 * (int i = 0; i < keys.length; i++) { bst.insert(keys[i], values[i]); } // BST
	 * Ȯ�� bst.inorder(); System.out.println("height = " + bst.height());
	 * System.out.println("root key = " + bst.getRootKey());
	 */

	// �˻�
	/*
	 * if (bst.search("B") == null) { System.out.println("No such key"); } else {
	 * System.out.println(bst.getValue(bst.search("B"))); }
	 */
}
