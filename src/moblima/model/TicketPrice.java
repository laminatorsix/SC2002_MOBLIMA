package moblima.model;

import java.io.Serializable;

/**
 * Represents the price of a Ticket.
 */
public class TicketPrice implements Serializable{
	private static final long serialVersionUID = 7101835306099183034L;
	private static double basePrice = 12;
	private static double surcharge3D = 2;
	private static double surchargePlat = 3;
	private static double surchargeHol = 2;
	private static double surchargePreview = 2;
	private static double seniorCitizenDiscount = 0.1;
	
	private double totalPrice;
	
	/**
	 * Default constructor for TicketPrice.
	 */
	public TicketPrice() {}
	
	/** 
	 * Constructor for TicketPrice.
	 * @param ticket The ticket that is linked to this TicketPrice.
	 */
	public TicketPrice(Ticket ticket) {
		
		totalPrice = basePrice;
		//Add surcharges
		if(ticket.getSeat().getListing().is3D()) {
			totalPrice += surcharge3D;
		}
		if(ticket.getSeat().getListing().getCinema().isPlatinum()) {
			totalPrice += surchargePlat;
		}
		if(ticket.getSeat().getListing().getDTObj().isHol()) {
			totalPrice += surchargeHol;
		}
		if(ticket.getSeat().getListing().getMovie().getStatus() == "Preview") {
			totalPrice += surchargePreview;
		}
		if(ticket.getCustomer().isSeniorCitizen()) {
			totalPrice = totalPrice * (1-seniorCitizenDiscount);
		}
		
	}
	
	//GETTERS
	/**
	 * Gets total price of this TicketPrice.
	 * @return total price of this TicketPrice.
	 */
	public double getTotalPrice() {return totalPrice;}
	/**
	 * Gets base price of Ticket.
	 * @return base price of Ticket.
	 */
	public double getBasePrice() {return basePrice;}
	/**
	 * Gets 3D surcharge of Ticket.
	 * @return 3D surcharge.
	 */
	public double getSurcharge3D() {return surcharge3D;}
	/**
	 * Gets Platinum surcharge of Ticket.
	 * @return Platinum surcharge.
	 */
	public double getSurchargePlat() {return surchargePlat;}
	/**
	 * Gets Preview surcharge of Ticket.
	 * @return Preview surcharge.
	 */
	public double getSurchargePreview() {return surchargePreview;}
	/**
	 * Gets Holiday surcharge of Ticket.
	 * @return Holiday surcharge.
	 */
	public double getSurchargeHol() {return surchargeHol;}
	/**
	 * Gets senior discount of Ticket.
	 * @return Senior discount.
	 */
	public double getSeniorDiscount() {return seniorCitizenDiscount;}
	
	
	//SETTERS
	/**
	 * Updates base price of TicketPrice.
	 * @param basePrice Base price of TicketPrice.
	 */
	public void setBasePrice(double basePrice) {TicketPrice.basePrice = basePrice;}
	/**
	 * Updates 3D surcharge of TicketPrice.
	 * @param surcharge3D 3D surcharge of TicketPrice.
	 */
	public void setSurcharge3D(double surcharge3D) {TicketPrice.surcharge3D = surcharge3D;}
	/**
	 * Updates Platinum surcharge of TicketPrice.
	 * @param surchargePlat Platinum surcharge of TicketPrice.
	 */
	public void setSurchargePlat(double surchargePlat) {TicketPrice.surchargePlat = surchargePlat;}
	/**
	 * Updates Holiday/Weekend surcharge of TicketPrice.
	 * @param surchargeHol Holiday/Weekend surcharge of TicketPrice.
	 */
	public void setSurchargeHol(double surchargeHol) {TicketPrice.surchargeHol = surchargeHol;}
	/**
	 * Updates Preview surcharge of TicketPrice.
	 * @param surchargePreview Preview surcharge of TicketPrice.
	 */
	public void setSurchargePreview(double surchargePreview) {TicketPrice.surchargePreview = surchargePreview;}
	/**
	 * Updates Senior Citizen discount of TicketPrice (percentage).
	 * @param seniorCitizenDiscount
	 */
	public void setDiscountSeniorCitizen(double seniorCitizenDiscount) {TicketPrice.seniorCitizenDiscount = seniorCitizenDiscount;}


}
