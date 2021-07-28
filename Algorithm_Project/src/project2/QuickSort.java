package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import project.Insertion;
import project.Movie;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File file = new File("C:\\Users\\leeyo\\eclipse-workspace\\Algorithm_Project\\src\\Movie1.txt");
			// 파일 가져오기
			FileReader file_reader = new FileReader(file);
			// 파일 입력 스트림 생성
			BufferedReader bufReader = new BufferedReader(file_reader);
			// 데이터를 일시적으로 저장하기 위한 버퍼 생성
			String line = null;
			int i = 0;
			Movie[] hitMovies = new Movie[19];
			String[] movie = new String[2];

			while ((line = bufReader.readLine()) != null) { // 한줄씩 읽어오기
				movie = line.split("\t"); 					// 탭키로 구분
				hitMovies[i] = new Movie(movie[0], Integer.parseInt(movie[1]));
				//탭키로 구분해서 앞에꺼와 뒤에꺼를 배열에 저장
				// System.out.println(hitMovies[i].name + "\t" + hitMovies[i].year);
				i++;
			}
			Quick.sort(hitMovies, new Movie.YearNameOrder());
			for (Movie m : hitMovies) {
				System.out.println(m);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열 수 없음");

		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}

}
