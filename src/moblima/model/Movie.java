package moblima.model;
import java.io.Serializable;
import java.util.*;


/**
 * Represents a movie
 */
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1985877739336240749L;
	private String name;
	private MovieStatus status;
	private String desc;
	private String director;
	private String[] cast;
	private double totalSales;
	private double overallRating;
	private double totalReviews;
	private MovieRating movieRating;
	
	/**
	 * Default constructor for Movie.
	 */
	public Movie() {}
	
	/**
	 * Constructor for Movie.
	 * @param n Movie name.
	 * @param s Movie status.
	 * @param d Movie description.
	 * @param di Movie director.
	 * @param c Movie cast.
	 * @param r Movie rating.
	 */
	public Movie(String n, MovieStatus s, String d, String di, String[] c, MovieRating r) {
		name = n;
		status = s;
		desc = d;
		director = di;
		cast = c;
		totalSales = 0;
		overallRating = 0;
		totalReviews = 0;
		movieRating = r;
	}
	
	//Getters
	/**
	 * Gets the movie's name
	 * @return this Movie's name
	 */
	public String getName() { return name; }
	/**
	 * Gets the movie's synopsis
	 * @return this Movie's description
	 */
	public String getDesc() { return desc; }
	/**
	 * Gets the movie's cast
	 * @return this Movie's cast
	 */
	public String[] getCast() { return cast; }
	/**
	 * Gets the movie's status
	 * @return this Movie's status
	 */
	public String getStatus() { 
		if(status == MovieStatus.COMINGSOON) {
			return "Coming Soon";
		}
		else if(status == MovieStatus.NOWSHOWING) {
			return "Now Showing";
		}
		else if(status == MovieStatus.ENDOFSHOWING) {
			return "End of Showing";
		}
		
		return "No Status";
	}
	
	public String getMovieRating() { 
		return movieRating.name();
	}
	/**
	 * Gets the movie's director
	 * @return this Movie's director
	 */
	public String getDirector() {return director;}
	/**
	 * Gets the movie's total sales
	 * @return this Movie's total sales
	 */
	public double getTotalSales() {return totalSales;}
	/**
	 * Gets the movie's overall rating
	 * @return this Movie's overall rating
	 */
	public double getOverallRating() {
		if(totalReviews <= 1) {
			return 0;
		}
		else
			return overallRating;
	}
	
	
	/**
	 * Gets the movie's total reviews
	 * @return this Movie's total reviews
	 */
	public double getTotalReviews() {return totalReviews;}
	//Setters
	/**
	 * Changes the name of this Movie.
	 * @param n This Movie's name
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * Changes the description of this Movie.
	 * @param d This Movie's description
	 */
	public void setDesc(String d) {
		desc = d;
	}
	/**
	 * Changes the cast of this Movie.
	 * @param c This Movie's cast
	 */
	public void setCast(String[] c) {
		cast = c;
	}
	/**
	 * Changes the status of this Movie.
	 * @param s This Movie's status
	 */
	public void setStatus(String movieStatus) {
		try {
			status = MovieStatus.valueOf(movieStatus);
		}
		catch(IllegalArgumentException e){
			status = MovieStatus.NA;
		}
	}
	/**
	 * Changes the rating of this Movie.
	 * @param rating This Movie's rating.
	 */
	public void setRating(String rating) {
		try {
			movieRating = MovieRating.valueOf(rating);
		}
		catch(IllegalArgumentException e){
			movieRating = MovieRating.NA;
		}
	}
	/**
	 * Changes the director of this Movie.
	 * @param di This Movie's director
	 */
	public void setDirector(String di) {
		director = di;
	}
	/**
	 * Updates the total sales of this Movie.
	 * @param sales This Movie's total sales
	 */
	public void setTotalSales(double sales) {
		totalSales = sales;
	}
	/**
	 * Updates the overall rating of this Movie.
	 * @param rating This Movie's overall rating
	 */
	public void setOverallRating(double rating) {
		overallRating = rating;
		
	}
	/**
	 * Updates total reviews for this Movie.
	 * @param t This Movie's total reviews
	 */
	public void setTotalReviews(double t) {
		totalReviews = t;
	}
	/**
	 * Increments total sales for this Movie.
	 */
	public void incrementTotalSales() {
		totalSales+=1;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Movie) {
			Movie m = (Movie)o;
			return (getName().equals(m.getName()));
		}
		return false;
	}
	

	
}
