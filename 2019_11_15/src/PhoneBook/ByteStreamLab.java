package PhoneBook;

import java.io.*;
import java.util.*;

public class ByteStreamLab {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� ���ϸ���?");
		String source_file = scan.next();
		System.out.print("���纻 ���ϸ��� ?");
		String copy_file = scan.next();
		try {
			FileInputStream in_stream = new FileInputStream(source_file);
			FileOutputStream out_stream = new FileOutputStream(copy_file);
			int data;
			while ((data = in_stream.read()) != -1)
				out_stream.write(data);

			in_stream.close();
			out_stream.close();
		} catch (IOException ex) {
			System.out.println("���� ����");
		}
	}

}
