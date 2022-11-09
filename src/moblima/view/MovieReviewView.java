package moblima.view;
import moblima.model.*;

/**
 * Represents the View of a MovieReview class.
 * Allows the user to view a movie review.
 */
public class MovieReviewView {
	/**
	 * Prints a movie review.
	 * @param reviewerName Name of reviewer.
	 * @param rating Rating posted by the reviewer.
	 * @param content Content of the review.
	 * @param time Time of publication.
	 */
	public void printMovieReview(int rating, String content, String time) {
		System.out.println("Rating: " + rating + "/5");
		System.out.println("Review: " + content);
		System.out.println("Published: " + time);
	}
}

