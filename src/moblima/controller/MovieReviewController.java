package moblima.controller;
import moblima.model.Movie;
import moblima.model.MovieReview;
import moblima.model.Rating;
import moblima.dao.MovieReviewDao;
import moblima.view.MovieReviewView;

/**
 * Controller for MovieReview.
 */
public class MovieReviewController {
	private MovieReview model = null;
	private MovieReviewDao dao;
	private MovieReviewView view;
	
	/**
	 * Constructor for MovieReviewController.
	 */
	public MovieReviewController() {
		dao = new MovieReviewDao();
		view = new MovieReviewView();
	}
	
	/**
	 * Create new MovieReview.
	 * @param movie
	 * @param content
	 * @param rating
	 */
	public void setMovieReview(Movie movie, String content, Rating rating) {
		model = new MovieReview(movie, content, rating);
		dao.add(model);
	}
	
	/**
	 * Print all reviews for a certain movie.
	 * @param movie
	 */
	public void printAll(Movie movie) {
		dao.printAll(movie);
	}
	
	/**
	 * Saves MovieReview data.
	 */
	public void close() {
		dao.end();
	}
}
