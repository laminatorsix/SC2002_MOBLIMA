package moblima.controller;
import moblima.model.Booking;
import moblima.dao.BookingsDao;
import moblima.view.BookingView;
import moblima.model.Ticket;
import moblima.model.Moviegoer;
import moblima.model.Seat;

/**
 * Controller for Booking.
 * Mainly to get and set discounts and surcharges.
 */
public class BookingController {
	private Booking model;
	private BookingsDao dao;
	private BookingView view;
	
	/**
	 * Default constructor for BookingController.
	 */
	public BookingController() {
		this.dao = new BookingsDao();
		this.view = new BookingView();
	}
	
	/**
	 * Constructor for BookingController.
	 * @param model 
	 * @param dao
	 * @param view
	 */
	public BookingController(Booking model, BookingsDao dao, BookingView view) {
		this.model = model;
		this.dao = dao;
		this.view = view;
	}
	
	/**
	 * Sets Booking Model.
	 * @param seat Seat linked to this booking.
	 * @param customer Customer who made the booking.
	 * @param hasMeal If there is a meal.
	 * @param hasDiscount If there is a discount.
	 */
	public void setBooking(Seat seat, Moviegoer customer, boolean hasMeal, boolean hasDiscount) {
		model = new Booking(seat, customer, hasMeal, hasDiscount);
	}
	
	
	/**
	 * Sets Booking Ticket.
	 * @param ticket Ticket booked.
	 */
	public void setBookingTicket(Ticket ticket) {
		model.setTicket(ticket);
	}
	
	/**
	 * Sets if there is a meal.
	 * @param hasMeal Whether there is a meal.
	 */
	public void setBookingMeal(boolean hasMeal) {
		model.hasMeal(hasMeal);
	}
	
	/**
	 * Sets if there is a discount.
	 * @param discount Whether there is a discount.
	 */
	public void setBookingDiscount(boolean discount) {
		model.hasDiscount(discount);
	}
	
	/**
	 * Verifies discount code entered by user.
	 * @param discountCode Discount code entered by user.
	 * @return Whether discount code is correct or not.
	 */
	public boolean checkBookingDiscountCode(String discountCode) {
		if(discountCode.equals(model.getDiscountCode())) {
			setBookingDiscount(true);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds booking to database.
	 */
	public void addBookingToDatabase() {
		dao.add(model);
	}
	/**
	 * Gets price of booking.
	 * @return booking price of booking.
	 */
	public double getBookingPrice() {
		return model.getBookingPrice().getTotalPrice();
	}
	/**
	 * Prints booking history for a certain customer.
	 * @param moviegoer Customer.
	 */
	public void printBookingHistory(Moviegoer moviegoer) {
		dao.printHistory(moviegoer);
	}
	/**
	 * Prints current booking.
	 */
	public void printBooking() {
		view.printBooking(model.getTID(), model.getBookingPrice().getTotalPrice(), model.getTicket().getSeat().getListing().getMovie().getName(), model.getTicket().getSeat().getListing().getDateTime(), model.getDateTime());
	}
	/**
	 * Prints all bookings
	 */
	public void printAllBookings() {
		dao.printAll();
	}
	/**
	 * Reset all bookings.
	 */
	public void reset() {
		dao.clear();
	}
	/**
	 * Updates data.
	 */
	public void close() {
		dao.end();
	}
	
}
