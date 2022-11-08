package moblima.controller;
import moblima.model.Moviegoer;
import moblima.dao.MoviegoerDao;

/**
 * Controller for Moviegoer.
 */
public class MoviegoerController {
	private Moviegoer model;
	private MoviegoerDao dao;
	/**
	 * Default constructor for MoviegoerController.
	 */
	public MoviegoerController() {
		this.dao = new MoviegoerDao();
	}
	/**
	 * Constructor for MoviegoerController.
	 * Creates a new Moviegoer.
	 * @param name
	 * @param email
	 * @param mobile
	 * @param isSeniorCitizen
	 */
	public MoviegoerController(String name, String email, String mobile, boolean isSeniorCitizen) {
		this.model = new Moviegoer(name, email, mobile, isSeniorCitizen);
		this.dao = new MoviegoerDao();
		dao.add(model);
	}
	
	/**
	 * Constructor for MoviegoerController.
	 * Retrieves a Moviegoer from database.
	 * @param email
	 * @param mobile
	 */
	public MoviegoerController(String email, String mobile) {
		this.model = dao.retrieveMoviegoer(email, mobile);
		this.dao = new MoviegoerDao();
	}
	
	/**
	 * Creates a new Moviegoer.
	 * @param name
	 * @param email
	 * @param mobile
	 * @param isSeniorCitizen
	 * @return success.
	 */
	public boolean setMoviegoer(String name, String email, String mobile, boolean isSeniorCitizen) {
		if(checkMoviegoer(email, mobile) == false) {
			this.model = new Moviegoer(name, email, mobile, isSeniorCitizen);
			dao.add(model);
			return true;
		}
		return false;
	}
	
	/**
	 * Retrieves an existing Moviegoer from database.
	 * @param email
	 * @param mobile
	 * @return success.
	 */
	public boolean getMoviegoer(String email, String mobile) {
		Moviegoer m = retrieveMoviegoer(email, mobile);
		if(m != null) {
			this.model = m;
			return true;
		}
		return false;
	}
	
	/**
	 * Get an existing Moviegoer from database.
	 * @param email
	 * @param mobile
	 * @return
	 */
	public Moviegoer retrieveMoviegoer(String email, String mobile) {
		return dao.retrieveMoviegoer(email, mobile);
	}
	
	/**
	 * Checks if a Moviegoer already exists.
	 * @param email
	 * @param mobile
	 * @return
	 */
	public boolean checkMoviegoer(String email, String mobile) {
		return dao.checkMoviegoerExists(email, mobile);
	}
	
	/**
	 * Returns current Moviegoer.
	 * @return moviegoer.
	 */
	public Moviegoer getCurrentMoviegoer() {
		return model;
	}
	
	public void addMoviegoerToDatabase() {
		dao.add(model);
	}
	/**
	 * Updates database.
	 */
	public void close() {
		dao.end();
	}
}
