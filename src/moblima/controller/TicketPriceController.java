package moblima.controller;
import moblima.model.TicketPrice;

public class TicketPriceController {
	private TicketPrice model;
	
	/**
	 * Constructor for TicketPriceController.
	 * Mainly to get and set Ticket discounts and surcharges.
	 */
	public TicketPriceController() {
		model = new TicketPrice();
	}
	
	
	/**
	 * Gets current base price.
	 * @return base price.
	 */
	public double getTicketBasePrice() {
		return model.getBasePrice();
	}
	/**
	 * Gets current holiday surcharge.
	 * @return holiday surcharge.
	 */
	public double getTicketHol() {
		return model.getSurchargeHol();
	}
	/**
	 * Gets current 3D surcharge.
	 * @return 3D surcharge.
	 */
	public double getTicket3D() {
		return model.getSurcharge3D();
	}
	
	/**
	 * Gets current Platinum surcharge.
	 * @return Platinum surcharge.
	 */
	public double getTicketPlat() {
		return model.getSurchargePlat();
	}
	
	/**
	 * Gets current Preview surcharge.
	 * @return Preview surcharge.
	 */
	public double getTicketPreview() {
		return model.getSurchargePreview();
	}
	
	/**
	 * Gets current Senior Citizen discount.
	 * @return Senior citizen discount.
	 */
	public double getTicketSeniorCitizen() {
		return model.getSeniorDiscount();
	}
	
	/**
	 * Updates current base price.
	 * @param basePrice
	 */
	public void setTicketBasePrice(double basePrice) {
		model.setBasePrice(basePrice);
	}
	/**
	 * Updates current Holiday surcharge.
	 * @param surchargeHol
	 */
	public void setTicketHol(double surchargeHol) {
		model.setSurchargeHol(surchargeHol);
	}
	/**
	 * Updates current 3D surcharge.
	 * @param surcharge3D
	 */
	public void setTicket3D(double surcharge3D) {
		model.setSurcharge3D(surcharge3D);
	}
	/**
	 * Updates current Platinum surcharge.
	 * @param surchargePlat
	 */
	public void setTicketPlat(double surchargePlat) {
		model.setSurchargePlat(surchargePlat);
	}
	/**
	 * Updates current Preview surcharge.
	 * @param surchargePreview
	 */
	public void setTicketPreview(double surchargePreview) {
		model.setSurchargePreview(surchargePreview);
	}
	/**
	 * Updates current senior citizen discount.
	 * @param seniorCitizenDiscount
	 */
	public void setTicketSeniorCitizen(double seniorCitizenDiscount) {
		model.setDiscountSeniorCitizen(seniorCitizenDiscount);
	}
}
