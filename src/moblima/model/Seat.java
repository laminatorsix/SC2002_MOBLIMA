package moblima.model;

import java.io.Serializable;

/**
 * Represents a seat in a particular cinema.
 * One cinema contains many seats.
 */
public class Seat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8941806988236290832L;
	int row;
	int col;
	boolean booked;
	Listing listing;
	
	/**
	 * Constructor for seat.
	 * @param row
	 * @param col
	 * @param listing
	 */
	public Seat(int row, int col, Listing listing) {
		this.row = row;
		this.col = col;
		this.booked = false;
		this.listing = listing;
	}
	/**
	 * Constructor for Seat.
	 * @param row This Seat's row.
	 * @param col This Seat's column.
	 * @param booked This Seat's availability (True if booked, False if empty)
	 * @param listing The Listing linked to this Seat.
	 */
	public Seat(int row, int col, boolean booked, Listing listing) {
		this.row = row;
		this.col = col;
		this.booked = booked;
		this.listing = listing;
	}
	
	//GETTERS
	/**
	 * Gets this Seat's row number.
	 * @return this Seat's row.
	 */
	public int getRow() {return row;}
	/**
	 * Gets this Seat's column number.
	 * @return this Seat's column.
	 */
	public int getCol() {return col;}
	/**
	 * Gets this Seat's availability.
	 * @return this Seat's availability.
	 */
	public boolean getBooked() {return booked;}
	/**
	 * Gets the Listing linked to this Seat.
	 * @return the Listing linked to this Seat.
	 */
	public Listing getListing() {return listing;}
	
	//SETTERS
	/**
	 * Updates the Seat's availability.
	 * @param booked This Seat's new availability.
	 */
	public void setBooked(boolean booked) {this.booked = booked;}
	/**
	 * Updates the Listing linked to this Seat.
	 * @param listing The Listing linked to this Seat.
	 */
	public void setListing(Listing listing) {this.listing = listing;}
	
}
