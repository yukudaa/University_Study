package project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class dun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File file = new File("C:\\Users\\leeyo\\eclipse-workspace\\Algorithm_Project\\src\\100random.txt");
			// ���� ��������
			FileReader file_reader = new FileReader(file);
			// ���� �Է� ��Ʈ�� ����
			BufferedReader in = new BufferedReader(file_reader);
			// �����͸� �Ͻ������� �����ϱ� ���� ���� ����
			
			String line = null;
			try {
				in = new BufferedReader(new FileReader(file));
				while((line = in.readLine()) != null) {
					
					String a[] = line.split("\n");
					String b = sort.a[]
					
				}
				in.close();
			} catch(IOException e) {
				System.err.println("File Error");
			}
		}catch (FileNotFoundException e) {
			System.out.println("������ �� �� ����");

		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}
	}

}
