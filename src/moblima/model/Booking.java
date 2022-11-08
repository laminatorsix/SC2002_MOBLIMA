package moblima.model;
import java.io.Serializable;
import java.util.*;




/**
 * Represents a booking made for a ticket.
 * Linked to a Ticket booked by a particular Moviegoer.
 */
public class Booking implements Serializable{
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 8386971035862977044L;
	private static String discountCode = "ILOVEMOVIES123";
	private Ticket ticket;
	private BookingPrice bookingPrice;
	private String tid = "";
	private boolean hasMeal;
	private boolean hasDiscount;
	private DateTime dateTime;
	private String dt;
	
	
	
	/**
	 * Default constructor for Booking.
	 */
	public Booking() {
		dateTime = new DateTime();
		dt = dateTime.getDateTime();
	}
	/**
	 * Constructor for Booking.
	 * @param ticket
	 * @param hasMeal
	 * @param hasDiscount
	 */
	public Booking(Seat seat, Moviegoer customer, boolean hasMeal, boolean hasDiscount) {
		this.hasMeal = hasMeal;
		this.hasDiscount = hasDiscount;
		this.ticket = new Ticket(seat, customer);
		tid = generateTID();
		bookingPrice = new BookingPrice(this);
		dateTime = new DateTime();
		dt = dateTime.getDateTime();
		ticket.getSeat().getListing().getMovie().incrementTotalSales(); //increment movie sales
		
	}
	
	//GETTERS
	/**
	 * Gets Ticket for this Booking.
	 * @return Ticket.
	 */
	public Ticket getTicket() {return ticket;}
	/**
	 * Gets whether this Booking has a meal.
	 * @return if a meal was bought.
	 */
	public boolean hasMeal() {return hasMeal;}
	/**
	 * Gets whether this Booking is discounted.
	 * @return if it has a discount.
	 */
	public boolean hasDiscount() {return hasDiscount;}
	/**
	 * Gets TID of this Booking.
	 * @return TID.
	 */ 
	public String getTID() {return tid;}
	/**
	 * Gets price of this Booking.
	 * @return price.
	 */
	public BookingPrice getBookingPrice() {return bookingPrice;}
	/**
	 * Gets date and time of this Booking.
	 * @return date and time.
	 */
	public String getDateTime() {return dt;}
	/**
	 * Gets date and time object of this Booking.
	 * @return date and time object.
	 */
	public DateTime getDTObj() {return dateTime;}
	/**
	 * Gets DiscountCode of Booking.
	 * @return discount code.
	 */
	public String getDiscountCode() {return discountCode;}
	
	//SETTERS
	/**
	 * Updates Ticket linked to this booking.
	 * @param ticket
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Updates if this Booking has a meal.
	 * @param hasMeal
	 */
	public void hasMeal(boolean hasMeal) {this.hasMeal = hasMeal;}
	/**
	 * Updates if this Booking has a discount.
	 * @param hasDiscount
	 */
	public void hasDiscount(boolean hasDiscount) {this.hasDiscount = hasDiscount;}
	/**
	 * Generates TID of Booking.
	 * @return TID.
	 */
	public String generateTID() {
		String dateTime = ticket.getSeat().getListing().getDateTime();
		tid = ticket.getSeat().getListing().getCinema().getCode() + dateTime;
		for(int i = 0; i < dateTime.length(); i++) {
			if(dateTime.charAt(i) != ' ' || dateTime.charAt(i) != '/'|| dateTime.charAt(i) != ':') {
				tid += dateTime.charAt(i);
			}
		}
		return tid;
	}
	

}
