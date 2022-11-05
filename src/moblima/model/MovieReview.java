package moblima.model;

public class MovieReview {
	private Movie movie;
	private DateTime dt;
	private String time;
	private String content;
	private Rating rating;

	public MovieReview(Movie movie, String content, Rating rating) {
		this.movie = movie;
		this.content = content;
		this.rating = rating;
		this.time = dt.getDate();
	}
	
	//GETTERS because don't let them update
	public Movie getMovie() {
		return movie;
	}
	
	public String getContent() {
		return content;
	}
	
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
	
	public String getTime() {
		return time;
	}
	
}
