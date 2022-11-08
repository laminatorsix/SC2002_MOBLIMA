package moblima.controller;
import moblima.model.Movie;
import moblima.model.MovieRating;
import moblima.model.MovieStatus;
import moblima.model.Array;

import moblima.dao.MovieDao;

public class MovieController {
	private Movie model;
	private MovieDao dao;
	private int filter = 0;
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
	 * @return true if movie exists.
	 */
	public boolean getNewMovie(String name) {
		Movie movie = dao.getMovie(name);
		if(movie == null)
			return false;
		this.model = dao.getMovie(name);
		return true;
	}
	/**
	 * Returns a movie from database.
	 * @param name
	 * @return movie.
	 */
	public Movie getMovie(String name) {
		return dao.getMovie(name);
	}
	/**
	 * Returns current movie.
	 * @return model.
	 */
	public Movie getCurrentMovie() {
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
	 * Prints the names of all movies.
	 */
	public void printAllMovieNames() {
		dao.printAllNames();
	}
	
	/**
	 * Sorts movies by overall rating.
	 */
	public void sortByOverallRating() {
		dao.sortMoviesByOverallRating();
	}
	/**
	 * Sorts movies by total sales.
	 */
	public void sortByTotalSales() {
		dao.sortMoviesByTotalSales();
	}
	/**
	 * Sets Filter option.
	 * 1 for OverallRating, 2 for TotalSales, 3 for Both.
	 * @param filter
	 */
	public void setFilter(int filter) {
		this.filter = filter;
	}
	/**
	 * Returns Filter option.
	 * @return filter.
	 */
	public int getFilter() {
		return filter;
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
	public void addMovieToDatabase() {
		dao.add(model);
		
	}
	
	/**
	 * Removes movie from database.
	 */
	public void deleteMovieFromDatabase() {
		dao.delete(model);
	}
	/**
	 * Prints a Movie.
	 * @param movie
	 */
	public void printMovie() {
		System.out.println("Name: " + model.getName());
		System.out.println("Description: " + model.getDesc());
		System.out.println("Status: " + model.getStatus());
		System.out.print("Cast: ");
		
		Array.printArray(model.getCast());
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
