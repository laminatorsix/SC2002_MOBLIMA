package moblima.controller;
import moblima.model.BookingPrice;
import moblima.model.Booking;

/**
 * Controller class for BookingPrice.
 */
public class BookingPriceController {
	private BookingPrice model;
	
	/**
	 * Constructor for BookingPriceController.
	 */
	public BookingPriceController() {
		model = new BookingPrice();
	}
	
	/**
	 * Gets total price of Booking.
	 * @return price of Booking.
	 */
	public double getBookingPrice() {
		return model.getTotalPrice();
	}
	
	/**
	 * Gets current meal price.
	 * @return current meal price.
	 */
	public double getBookingMealPrice() {
		return model.getMealPrice();
	}
	
	/**
	 * Gets current discount.
	 * @return current discount.
	 */
	public double getBookingDiscount() {
		return model.getDiscount();
	}
	
	/**
	 * Updates current meal price.
	 * @param mealPrice New meal price.
	 */
	public void setBookingMealPrice(double mealPrice) {
		model.setMealPrice(mealPrice);
	}
	
	/**
	 * Updates current discount (in percentages).
	 * @param discount New discount.
	 */
	public void setBookingDiscount(double discount) {
		model.setDiscount(discount);
	}
	
	
	
}
