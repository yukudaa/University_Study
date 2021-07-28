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
			// 파일 가져오기
			FileReader file_reader = new FileReader(file);
			// 파일 입력 스트림 생성
			BufferedReader in = new BufferedReader(file_reader);
			// 데이터를 일시적으로 저장하기 위한 버퍼 생성
			
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
			System.out.println("파일을 열 수 없음");

		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
	}

}
