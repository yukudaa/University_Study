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
			// ���� ��������
			FileReader file_reader = new FileReader(file);
			// ���� �Է� ��Ʈ�� ����
			BufferedReader bufReader = new BufferedReader(file_reader);
			// �����͸� �Ͻ������� �����ϱ� ���� ���� ����
			String line = null;
			int i = 0;
			Movie[] hitMovies = new Movie[19];
			String[] movie = new String[2];

			while ((line = bufReader.readLine()) != null) { // ���پ� �о����
				movie = line.split("\t"); 					// ��Ű�� ����
				hitMovies[i] = new Movie(movie[0], Integer.parseInt(movie[1]));
				//��Ű�� �����ؼ� �տ����� �ڿ����� �迭�� ����
				// System.out.println(hitMovies[i].name + "\t" + hitMovies[i].year);
				i++;
			}
			Quick.sort(hitMovies, new Movie.YearNameOrder());
			for (Movie m : hitMovies) {
				System.out.println(m);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("������ �� �� ����");

		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}

}
