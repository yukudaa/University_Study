package project;
import java.util.Comparator;
public class Movie implements Comparable<Movie>{
	private String name;
	private int year;
	
	public Movie(String title, int yr) {
		this.name = title;
		this.year = yr;
	}
	
	public int compareTo(Movie that) {
		return this.name.compareTo(that.name);
	}
	public static class TitleOrder implements Comparator<Movie>{
	      public int compare(Movie m1, Movie m2) {
	         if(m1.name.compareTo(m2.name) < 0) return -1;
	         else if(m1.name.compareTo(m2.name) > 0) return 1;
	         return 0;
	      }
	   }
	public static class YearOrder implements Comparator<Movie>{
		public int compare(Movie m1, Movie m2) {
			if(m1.year < m2.year) return -1;
			if(m1.year > m2.year) return +1;
			return 0;
		}
	}
	
	public static class YearNameOrder implements Comparator<Movie>{
		public int compare(Movie m1, Movie m2) {
			if(m1.year > m2.year) return -1;
			if(m1.year < m2.year) return +1;
			return m1.name.compareTo(m2.name);
		}
	}
	public String toString() {
		return name + "("+ year + ")";
	}
}
