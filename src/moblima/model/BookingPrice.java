package moblima.model;

/**
 * Represents price of a particular Booking.
 *
 */
public class BookingPrice {
	private static double mealPrice = 5;
	private static double discount = 0.1;
	private double totalPrice;
	//private Booking booking;
	
	/**
	 * Constructor for BookingPrice.
	 * @param booking
	 */
	public BookingPrice(Booking booking) {
		totalPrice = ((booking.getTicket()).getTicketPrice()).getTotalPrice();
		
		if(booking.hasDiscount()) {
			totalPrice = totalPrice * (1 - discount);
		}
		
		if(booking.hasMeal()) {
			totalPrice = totalPrice + mealPrice;
		}
	}
	
	//GETTERS
	/**
	 * Gets total booking price.
	 * @return this Booking's total price.
	 */
	public double getTotalPrice() {return totalPrice;}
	/**
	 * Gets booking discount.
	 * @return set booking discount.
	 */
	public double getDiscount() {return discount;}
	/**
	 * Gets meal price.
	 * @return set meal price.
	 */
	public double getMealPrice() {return mealPrice;}
	
	//SETTERS
	/**
	 * Updates total price of booking.
	 * @param booking The booking that is linked to this price.
	 */
	public void setTotalPrice(Booking booking) {
		totalPrice = ((booking.getTicket()).getTicketPrice()).getTotalPrice();
				
		if(booking.hasDiscount()) {
			totalPrice = totalPrice * (1 - discount);
		}
		
		if(booking.hasMeal()) {
			totalPrice = totalPrice + mealPrice;
		}
	}
	/**
	 * Updates discount value.
	 * @param discount New discount value.
	 */
	public void setDiscount(double discount) {BookingPrice.discount = discount;}
	/**
	 * Updates meal price.
	 * @param mealPrice New meal price.
	 */
	public void setMealPrice(double mealPrice) {BookingPrice.mealPrice = mealPrice;}
}
