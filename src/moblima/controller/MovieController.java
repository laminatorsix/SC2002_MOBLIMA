package moblima.controller;
import moblima.model.Movie;
import moblima.model.MovieRating;
import moblima.model.MovieStatus;
import moblima.model.Array;

import moblima.dao.MovieDao;

public class MovieController {
	private Movie model;
	private MovieDao dao;
	
	/**
	 * Default constructor for MovieController.
	 */
	public MovieController() {
		dao = new MovieDao();
	};
	
	
	/**
	 * Constructor for MovieController.
	 * Retrieves an existing Movie from database.
	 * @param name Retrieves Movie from database.
	 */
	public MovieController(String name) {
		dao = new MovieDao();
		model = dao.getMovie(name);
	}
	
	/**
	 * Constructor for MovieController.
	 * Creates a new Movie.
	 * @param model
	 * @param dao
	 */
	public MovieController(String n, MovieStatus s, String d, String di, String[] c, MovieRating r) {
		this.model = new Movie(n, s, d, di, c, r);
		dao = new MovieDao();
		dao.add(model);
	}
	
	/**
	 * Create a new Movie.
	 * @param n Movie name.
	 * @param s Movie status.
	 * @param d Movie date.
	 * @param di Movie director.
	 * @param c Movie cast.
	 * @param r Movie rating.
	 */
	public void setNewMovie(String n, MovieStatus s, String d, String di, String[] c, MovieRating r) {
		this.model = new Movie(n, s, d, di, c, r);
		dao = new MovieDao();
		dao.add(model);
	}
	
	/**
	 * Retrieves an existing Movie from database.
	 * @param name Name of Movie.
	 */
	public void getNewMovie(String name) {
		this.model = dao.getMovie(name);
	}
	
	/**
	 * Returns an existing Movie from database.
	 * @param name Name of Movie.
	 * @return
	 */
	public Movie retrieveMovieFromDatabase(String name) {
		return dao.getMovie(name);
	}
	
	//SETTERS
	/**
	 * Updates name of Movie.
	 * @param name
	 */
	public void setMovieName(String name) {
		model.setName(name);
	}
	
	/**
	 * Updates Movie status.
	 * @param status
	 */
	public void setMovieStatus(String status) {
		model.setStatus(status);
	}
	
	/**
	 * Updates description of Movie.
	 * @param desc
	 */
	public void setMovieDesc(String desc) {
		model.setDesc(desc);
	}
	
	/**
	 * Updates cast of Movie.
	 * @param cast
	 */
	public void setMovieCast(String[] cast) {
		model.setCast(cast);
	}
	
	/**
	 * Updates director of movie.
	 * @param director
	 */
	public void setMovieDirector(String director) {
		model.setDirector(director);
	}
	
	/**
	 * Updates rating of Movie.
	 * @param rating
	 */
	public void setMovieRating(String rating) {
		model.setRating(rating);
	}
	
	//GETTERS
	/**
	 * Gets the overall rating of a Movie.
	 * @return overall rating.
	 */
	public double getMovieOverallRating() {
		return model.getOverallRating();
	}
	
	/**
	 * Gets the total sales of a Movie.
	 * @return total sales.
	 */
	public double getMovieTotalSales() {
		return model.getTotalSales();
	}
	
	/**
	 * Prints all available movies.
	 */
	public void printAllMovies() {
		dao.printAll();
	}
	
	/**
	 * Prints top five movies.
	 */
	public void printTopFiveMovies() {
		dao.printTopFive();
	}
	
	/**
	 * Prints a Movie.
	 * @param movie
	 */
	public void printMovie(Movie movie) {
		System.out.println("Name: " + movie.getName());
		System.out.println("Description: " + movie.getDesc());
		System.out.println("Status: " + movie.getStatus());
		System.out.print("Cast: ");
		
		Array.printArray(movie.getCast());
	}
	
	/**
	 * Sorts Movies by overall rating.
	 */
	public void sortMoviesByOverallRating() {
		dao.sortMoviesByOverallRating();
	}
	
	/**
	 * Sorts Movies by Total Sales.
	 */
	public void sortMoviesByTotalSales() {
		dao.sortMoviesByTotalSales();
	}
	
	/**
	 * Saves Movie data to database.
	 */
	public void close() {
		dao.end();
	}

	
}
