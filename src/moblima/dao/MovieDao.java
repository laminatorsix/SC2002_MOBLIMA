package moblima.dao;
import moblima.model.Movie;
import moblima.model.Array;
import moblima.model.Listing;
import moblima.model.MovieStatus;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * DAO Interface for Movie
 * Reads and writes to movie.dat
 */
public class MovieDao implements Dao<Movie>{
	@SuppressWarnings("unchecked")
	List<Movie> movies;
	ListingsDao l = new ListingsDao();
	
	public MovieDao() {
		movies = (ArrayList)SerializeDB.readSerializedObject("data/movie.dat");
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
			if(name.toLowerCase() == m.getName().toLowerCase()) {
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
		}
	}
	
	public void printTopFive() {
		for(int i = 0; i < 5; i++) {
			Movie m = (Movie)movies.get(i);
			System.out.println("Name: " + m.getName());
			System.out.println("Description: " + m.getDesc());
			System.out.println("Status: " + m.getStatus());
			System.out.print("Cast: ");
			
			Array.printArray(m.getCast());
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
	public void updateNameDesc(Movie movie, int i, String n) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		switch(i) {
			case 0:
				m.setName(n);
				break;
			case 1:
				m.setDesc(n);
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
	 * @param s New status for this Movie
	 */
	public void updateStatus(Movie movie, String movieStatus) {
		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
		movie.setStatus(movieStatus);
		if(movieStatus == "ENDOFSHOWING") //remove if end of showing
			movies.remove(m);
		
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
	 * Writes updated data to movie.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/movie.dat", movies);
	}
	
	
	
}
