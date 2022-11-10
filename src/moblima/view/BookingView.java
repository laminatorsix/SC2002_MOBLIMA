package moblima.view;

/**
 * View class for Booking.
 */
public class BookingView {
	/**
	 * Default constructor for BookingView.
	 */
	public BookingView() {};
	/**
	 * Prints booking.
	 * @param tid
	 * @param price
	 * @param movie
	 * @param time
	 * @param bookingTime
	 */
	public void printBooking(String tid, double price, String movie, String time, String bookingTime) {
		System.out.println("Booking Details: ");
		System.out.println("TID: " + tid);
		System.out.println("Price: " + price);
		System.out.println("Movie: " + movie);
		System.out.println("Showtime: " + time);
		System.out.println("Time of Booking: " + bookingTime);
	}
}
