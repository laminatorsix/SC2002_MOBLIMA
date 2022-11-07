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
	 * @param d Movie description.
	 * @param di Movie director.
	 * @param c Movie cast.
	 * @param r Movie rating.
	 */
	public void setNewMovie(String n, MovieStatus s, String d, String di, String[] c, MovieRating r) {
		this.model = new Movie(n, s, d, di, c, r);
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
	
	public Movie getMovie() {
		return model;
	}
	//SETTERS
	/**
	 * Updates name of Movie.
	 * @param name
	 */
	public void setMovieName(String name) {
		dao.updateNameDescDir(model, 0, name);
	}
	
	/**
	 * Updates Movie status.
	 * @param status
	 */
	public void setMovieStatus(String status) {
		dao.updateStatus(model, status);
	}
	
	/**
	 * Updates description of Movie.
	 * @param desc
	 */
	public void setMovieDesc(String desc) {
		dao.updateNameDescDir(model, 1, desc);
	}
	
	/**
	 * Updates cast of Movie.
	 * @param cast
	 */
	public void setMovieCast(String[] cast) {
		dao.updateCast(model, cast);
	}
	
	/**
	 * Updates director of movie.
	 * @param director
	 */
	public void setMovieDirector(String director) {
		dao.updateNameDescDir(model, 2, director);
	}
	
	/**
	 * Updates rating of Movie.
	 * @param rating
	 */
	public void setMovieRating(String rating) {
		dao.updateMovieRating(model, rating);
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
	 * Adds movie to database.
	 */
	public void addMovieToDatabase(Movie movie) {
		dao.add(movie);
	}
	
	/**
	 * Removes movie from database.
	 */
	public void deleteMovieFromDatabase(Movie movie) {
		dao.delete(movie);
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
