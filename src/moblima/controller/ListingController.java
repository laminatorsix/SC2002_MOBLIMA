package moblima.controller;

import moblima.model.Listing;

import moblima.dao.ListingsDao;
import moblima.view.ListingView;
import moblima.model.Movie;
import moblima.model.Cinema;
import moblima.model.DateTime;
import moblima.model.Cineplex;
import moblima.model.Seat;
/**
 * Represents controller for Listing.
 */
public class ListingController {
	private Listing model;
	private ListingsDao dao;
	private ListingView view;
	
	/**
	 * Default constructor for ListingController.
	 */
	public ListingController() {
		dao = new ListingsDao();
		view = new ListingView();
	}
	/**
	 * Constructor for ListingController.
	 * Retrieves Listing from database.
	 * @param time
	 * @param date
	 * @param movie
	 * @param cineplex
	 */
	public ListingController(String time, String date, String movie, String cineplex) {
		dao = new ListingsDao();
		view = new ListingView();
		model = dao.getListing(time, date, movie, cineplex);
	}
	
	/**
	 * Constructor for ListingController.
	 * Creates new Listing.
	 * @param year
	 * @param day
	 * @param month
	 * @param hours
	 * @param minutes
	 * @param movie
	 * @param cinema
	 * @param is3D
	 */
	public ListingController(int year, int day, int month, int hours, int minutes, Movie movie, Cinema cinema, boolean is3D) {
		dao = new ListingsDao();
		view = new ListingView();
		model = new Listing(year, day, month, hours, minutes, movie, cinema, is3D);
	}
	
	/**
	 * Gets date of Listing.
	 * @return date of Listing.
	 */
	public String getListingDate() {
		return model.getDate();
	}
	
	/**
	 * Gets time of Listing.
	 * @return time of Listing.
	 */
	public String getListingTime() {
		return model.getTime();
	}
	
	public Seat getListingSeat(int row, int col) {
		return model.getSeat(row, col);
	}
	
	/**
	 * Retrieves Listing from database.
	 * @param time
	 * @param date
	 * @param movie
	 * @param cineplex
	 * @return Listing
	 */
	public Listing retrieveListingFromDatabase(String time, String date, String movie, String cineplex) {
		return dao.getListing(time, date, movie, cineplex);
	}
	
	/**
	 * Updates Listing date and time.
	 * @param year
	 * @param day
	 * @param month
	 * @param hours
	 * @param minutes
	 */
	public boolean setListingDateTime(String date, String time) {
		//yyyy/MM/dd
		//HH:MM:ss
		int year, day, month, hours, minutes;
		String[] dateArr, timeArr;
		if(date.length() != 10 || time.length()!=5)
			return false;
		
		dateArr = date.split("/");
		year = Integer.parseInt(dateArr[0]);
		month = Integer.parseInt(dateArr[1]);
		day = Integer.parseInt(dateArr[2]);
		
		timeArr = time.split(":");
		hours = Integer.parseInt(timeArr[0]);
		minutes = Integer.parseInt(timeArr[1]);
		
		
		DateTime dt = new DateTime(year, day, month, hours, minutes);
		model.setTime(dt);
		return true;
	}
	
	/**
	 * Creates a new Listing.
	 * @param year
	 * @param day
	 * @param month
	 * @param hours
	 * @param minutes
	 * @param movie
	 * @param cinema
	 * @param is3D
	 */
	public boolean setNewListing(String date, String time, Movie movie, Cinema cinema, boolean is3D) {
		int year, day, month, hours, minutes;
		String[] dateArr, timeArr;
		if(date.length() != 10 || time.length()!=5)
			return false;
		
		dateArr = date.split("/");
		year = Integer.parseInt(dateArr[0]);
		month = Integer.parseInt(dateArr[1]);
		day = Integer.parseInt(dateArr[2]);
		
		timeArr = time.split(":");
		hours = Integer.parseInt(timeArr[0]);
		minutes = Integer.parseInt(timeArr[1]);
		model = new Listing(year, day, month, hours, minutes, movie, cinema, is3D);
		return true;
	}
	/**
	 * Checks if seat is available.
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean checkSeatAvailable(int row, int col) {
		return (!model.getSeat(row, col).getBooked());
	}
	/**
	 * Adds new Listing to database.
	 */
	public void addListingToDatabase() {
		dao.add(model);
	}
	/**
	 * Checks if Listing already exists.
	 * @param listing
	 * @return
	 */
	public boolean checkIfListingExists() {
		return dao.checkListing(model);
	}
	/**
	 * Deletes Listing from database.
	 */
	public void deleteListingFromDatabase() {
		dao.delete(model);
	}
	
	/**
	 * Print individual Listing
	 */
	public void printListing() {
		view.printListing(model.getDate(), model.getTime(), model.is3D(), model.getCinema().isPlatinum());
	}
	
	
	/**
	 * Print all Listings for a certain Movie at a certain Cineplex.
	 * @param cineplex
	 * @param movie
	 */
	public boolean printAllListings(Cineplex cineplex, Movie movie) {
		return dao.printMovieAtCineplex(cineplex, movie);
	}
	/**
	 * Prints basic details for all Listings for a certain Movie at a certain Cineplex.
	 * @param cineplex
	 * @param movie
	 */
	public boolean printAllListingsBasic(Cineplex cineplex, Movie movie) {
		return dao.printMovieAtCineplexBasic(cineplex, movie);
	}
	/**
	 * Prints basic details for all Listings for a certain Movie.
	 * @param movie
	 * @return success
	 */
	public boolean printAllListingsForMovie(Movie movie) {
		return dao.printMovie(movie);
	}
	/**
	 * Prints all seats for a listing.
	 */
	public void printListingSeats() {
		view.printListingSeats(model.getSeats(), model.getRow(), model.getCol());
	}
	/**
	 * Retrieves new Listing from database.
	 * @param time
	 * @param date
	 * @param movie
	 * @param cineplex
	 * @return true if success.
	 */
	public boolean getNewListing(String time, String date, String movie, String cineplex) {
		model = dao.getListing(time, date, movie, cineplex);
		if(model == null)
			return false;
		return true;
	}
	/**
	 * Returns current Listing.
	 * @return current Listing.
	 */
	public Listing getCurrentListing() {
		return model;
	}
	/**
	 * Deletes all Listings for a certain Movie.
	 * @param name
	 */
	public void deleteMovieFromDatabase(String name) {
		dao.deleteMovie(name);
	}
	/**
	 * Close Listing database.
	 */
	public void close() {
		dao.end();
	}
	
}
