package moblima.dao;
import moblima.model.Movie;
import moblima.model.Array;
import moblima.model.Listing;
import moblima.model.MovieStatus;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import moblima.model.MovieRating;
/**
 * DAO Interface for Movie
 * Reads and writes to movie.dat
 */
public class MovieDao implements Dao<Movie>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1354341169941313208L;
	@SuppressWarnings("unchecked")
	List<Movie> movies;
	ListingsDao l;
	
	public MovieDao() {
		l = new ListingsDao();
		movies = (ArrayList<Movie>)SerializeDB.readSerializedObject("data/movie.dat");
		if(movies == null) {
			List<Movie> a = new ArrayList<>();
			movies = a;
		}
	}
	
	/**
	 * Retrieves movie from movie.dat based on id
	 * @param id Index of this Movie in list
	 */
	@Override
	public Optional<Movie> get(long id){
		return Optional.ofNullable(movies.get((int) id));
	}
	
	/**
	 * Retrieves all movies from movie.dat
	 */
	@Override
	public List<Movie> getAll(){
		return movies;
	}
	
	/**
	 * Retrieves Movie from movie.dat based on name.
	 * @param name Name of Movie.
	 * @return movie.
	 */
	public Movie getMovie(String name){
		for(int i = 0; i < movies.size(); i++) {
			Movie m = (Movie)movies.get(i);
			if(name.toLowerCase().equals(m.getName().toLowerCase())) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 * Prints all movies from movie.dat
	 */
	public void printAll(){
		for(int i = 0; i < movies.size(); i++) {
			Movie m = (Movie)movies.get(i);
			System.out.println("Name: " + m.getName());
			System.out.println("Description: " + m.getDesc());
			System.out.println("Status: " + m.getStatus());
			System.out.print("Cast: ");
			
			Array.printArray(m.getCast());
			System.out.println("Rating: " + m.getMovieRating());
			
			System.out.println(m.getOverallRating() + "/5");
			System.out.println();
		}
	}
	/**
	 * Only print movies that are in Preview or Showing.
	 */
	public void printAllShowing() {
		for(int i = 0; i < movies.size(); i++) {
			Movie m = (Movie)movies.get(i);
			if(m.getStatus().equals("End of Showing")) {
				continue;
			}
			System.out.println("Name: " + m.getName());
			System.out.println("Description: " + m.getDesc());
			System.out.println("Status: " + m.getStatus());
			System.out.print("Cast: ");
			
			Array.printArray(m.getCast());
			System.out.println("Rating: " + m.getMovieRating());
			
			System.out.println(m.getOverallRating() + "/5");
			System.out.println();
		}
	}
	/**
	 * Print all movie names only
	 */
	public void printAllNames() {
		for(int i = 0; i < movies.size(); i++) {
			Movie m = (Movie)movies.get(i);
			System.out.println(m.getName());
		}
	}
	/**
	 * Only print names of movies showing/preview.
	 */
	public void printAllNamesShowing() {
		for(int i = 0; i < movies.size(); i++) {
			Movie m = (Movie)movies.get(i);
			if(m.getStatus().equals("End of Showing")) {
				continue;
			}
			System.out.println(m.getName());
		}
	}
	/**
	 * Prints top 5 movies.
	 */
	public void printTopFive() {
		for(int i = 0; i < movies.size(); i++) {
			if(i == 5)
				break;
			Movie m = (Movie)movies.get(i);
			System.out.println("Name: " + m.getName());
			System.out.println("Description: " + m.getDesc());
			System.out.println("Status: " + m.getStatus());
			System.out.println("Cast: ");
			Array.printArray(m.getCast());
			System.out.println();
			System.out.println(m.getOverallRating() + "/5");
			System.out.println();
		}
	}
	/**
	 * Prints top 5 movies that are in preview/now showing.
	 */
	public void printTopFiveShowing() {
		for(int i = 0; i < movies.size(); i++) {
			if(i == 5)
				break;
			
			Movie m = (Movie)movies.get(i);
			if(m.getStatus().equals("End of Showing"))
				continue;
			System.out.println("Name: " + m.getName());
			System.out.println("Description: " + m.getDesc());
			System.out.println("Status: " + m.getStatus());
			System.out.println("Cast: ");
			Array.printArray(m.getCast());
			System.out.println();
			System.out.println(m.getOverallRating() + "/5");
			System.out.println();
		}
	}
	/**
	 * Adds a Movie to movie.dat
	 * @param movie New Movie to be added
	 */
	@Override
	public void add(Movie movie) {
		if(movies != null && movies.contains(movie)) {
			movies.remove(movie);
		}
		movies.add(movie);
	}
	
	/**
	 * Deletes a Movie from movie.dat
	 * @param movie Movie to be deleted
	 */
	@Override
	public void delete(Movie movie) {
		if(movies.contains(movie)) {
			movies.remove(movie);
			l.deleteMovie(movie.getName());
		}
	}
	
	
	//UPDATES
	/**
	 * Update this Movie's name and description
	 * @param movie
	 * @param i
	 * @param n
	 */
	public void updateNameDescDir(Movie movie, int i, String n) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		switch(i) {
			case 0:
				m.setName(n);
				break;
			case 1:
				m.setDesc(n);
				break;
			case 2:
				m.setDirector(n);
				break;
		}
	}
	
	
	/**
	 * Update this Movie's cast
	 * @param movie This Movie
	 * @param c New cast for this Movie
	 */
	public void updateCast(Movie movie, String[] c) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		movie.setCast(c);
	}
	
	/**
	 * Updates this Movie's status
	 * @param movie This Movie
	 * @param movieStatus New status for this Movie
	 */
	public void updateStatus(Movie movie, String movieStatus) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		movie.setStatus(movieStatus);
		if(movieStatus == "ENDOFSHOWING") //remove if end of showing
			movies.remove(m);
		
	}
	/**
	 * Updates movie rating.
	 * @param movie
	 * @param r Rating.
	 */
	public void updateMovieRating(Movie movie, String r) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		movie.setRating(r);
	}
	/**
	 * Updates this Movie's overall rating and total reviews
	 * @param movie This Movie
	 * @param r New individual rating for this Movie
	 * @param i Boolean indicating if review was added or deleted
	 */
	public void updateRating(Movie movie, int r, boolean i) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		double overallRating = movie.getOverallRating();
		double totalReviews = movie.getTotalReviews();
		double totalRating = overallRating * totalReviews;
		System.out.println("Current overall rating: " + movie.getOverallRating());
		System.out.println("Current total reviews: " + movie.getTotalReviews());
		if(i == true) {
			totalRating += r; 
			totalReviews += 1;
		}
		else {
			totalRating -= r;
			totalReviews -= 1;
		}
		
		overallRating = totalRating / totalReviews;
		m.setOverallRating(overallRating);
		m.setTotalReviews(totalReviews);
		
		
	}
	
	/**
	 * Sorts Movies by Total Sales in descending order.
	 */
	public void sortMoviesByTotalSales() {
		Collections.sort(movies, Collections.reverseOrder(Comparator.comparing(Movie::getTotalSales)));
	}
	
	/**
	 * Sorts Movies by Overall Rating in descending order.
	 */
	public void sortMoviesByOverallRating() {
		Collections.sort(movies, Collections.reverseOrder(Comparator.comparing(Movie::getOverallRating)));
	}
	/**
	 * Clears all movies.
	 */
	public void clear() {
		movies.clear();
	}
	/**
	 * Writes updated data to movie.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/movie.dat", movies);
	}
	
	
	
}
