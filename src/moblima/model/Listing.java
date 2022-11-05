package moblima.model;

/**
 * Represents a listing for a particular movie screening at a cinema.
 */
public class Listing {
	static int ROWS = 10;
	static int COLS = 8;
	Movie movie;
	Cinema cinema;
	Seat[][] seats = new Seat[ROWS][COLS];
	boolean is3D;
	DateTime time;
	
	/**
	 * Constructor for Listing.
	 * @param year
	 * @param day
	 * @param month
	 * @param hours
	 * @param minutes
	 * @param movie
	 * @param cinema
	 * @param is3D
	 */
	public Listing(int year, int day, int month, int hours, int minutes, Movie movie, Cinema cinema, boolean is3D) {
		time = new DateTime(year, day, month, hours, minutes);
		this.movie = movie;
		this.cinema = cinema;
		this.is3D = is3D;
	}
	
	//GETTERS
	/**
	 * Gets the DateTime of this Listing.
	 * @return this Listing's DateTime.
	 */
	public DateTime getDTObj() {return time;}
	/**
	 * Gets the time of this Listing.
	 * @return this Listing's time.
	 */
	public String getTime() {return time.getTime();}
	/**
	 * Gets the date of this Listing.
	 * @return this Listing's date.
	 */
	public String getDate() {return time.getDate();}
	/**
	 * Gets the date and time of this Listing.
	 * @return this Listing's date and time.
	 */
	public String getDateTime() {return time.getDateTime();}
	/**
	 * Gets the day of the week of this Listing.
	 * @return this Listing's day of the week.
	 */
	public int getDayOfWeek() {return time.getDay();} 
	/**
	 * Gets the Movie that this Listing is for.
	 * @return this Listing's movie.
	 */
	public Movie getMovie() {return movie;}
	/**
	 * Gets the Cinema that this Listing is for.
	 * @return this Listing's cinema.
	 */
	public Cinema getCinema() {return cinema;}
	/**
	 * Gets whether this Listing is for a 3D screening. 
	 * True if 3D, false if not.
	 * @return whether this Listing is 3D or not.
	 */
	public boolean is3D() {return is3D;}
	/**
	 * Gets a specific Seat.
	 * @param row
	 * @param col
	 * @return
	 */
	public Seat getSeat(int row, int col) {return seats[row][col];}
	
	//SETTERS
	/**
	 * Updates the time for this Listing.
	 * @param dateTime The new time for this Listing.
	 */
	public void setTime(DateTime dateTime) {this.time = dateTime;}
	/**
	 * Updates the Movie that this Listing is for.
	 * @param movie The new Movie for this Listing.
	 */
	public void setMovie(Movie movie) {this.movie = movie;}
	/**
	 * Updates the Cinema that this Listing is for.
	 * @param cinema The new Cinema for this Listing.
	 */
	public void setCinema(Cinema cinema) {this.cinema = cinema;}
	/**
	 * Updates whether this Listing is for a 3D screening.
	 * @param is3D Whether this Listing is 3D or not.
	 */
	public void is3D(boolean is3D) {this.is3D = is3D;}
}
