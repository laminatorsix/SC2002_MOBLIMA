package moblima.model;

import java.io.Serializable;

/**
 * Represents a Movie Review.
 */
public class MovieReview implements Serializable{
	private static final long serialVersionUID = -333975565085120365L;
	private Movie movie;
	private DateTime dt;
	private String time;
	private String content;
	private Rating rating;

	/**
	 * Default constructor for MovieReview.
	 */
	public MovieReview() {}
	/**
	 * Constructor for MovieReview.
	 * @param movie
	 * @param content
	 * @param rating
	 */
	public MovieReview(Movie movie, String content, int rating) {
		this.movie = movie;
		this.content = content;
		this.rating = Rating.values()[rating-1];
		this.dt = new DateTime();
		this.time = dt.getDate();
	}
	
	/**
	 * Gets the movie this review is for.
	 * @return movie.
	 */
	public Movie getMovie() {
		return movie;
	}
	
	/**
	 * Gets the content of this review.
	 * @return content.
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Gets the rating left by this reviewer.
	 * @return rating.
	 */
	public int getRating() {
		switch(rating) {
			case ONE:
				return 1;
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			default:
				return 0;
		}
	}
	
	/**
	 * Gets the time this review was published.
	 * @return time of publication.
	 */
	public String getTime() {
		return time;
	}
	
}
