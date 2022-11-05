package moblima.model;

/**
 * Represents a ticket booked by a moviegoer.
 */
public class Ticket {
	Seat seat;
	Moviegoer customer;
	TicketPrice ticketPrice;
	
	/**
	 * Constructor for Ticket.
	 * @param seat
	 * @param customer
	 */
	public Ticket(Seat seat, Moviegoer customer) {
		this.seat = seat;
		this.customer = customer;
		this.ticketPrice = new TicketPrice(this);
	}
	
	/**
	 * Gets Seat corresponding to this Ticket.
	 * @return this Ticket's seat.
	 */
	public Seat getSeat() {return seat;}
	/**
	 * Gets Customer who booked this Ticket.
	 * @return this Ticket's customer.
	 */
	public Moviegoer getCustomer() {return customer;}
	/**
	 * Gets TicketPrice for this Ticket.
	 * @return this Ticket's price.
	 */
	public TicketPrice getTicketPrice() {return ticketPrice;}
	/**
	 * Sets Seat corresponding to this Ticket.
	 * @param seat this Ticket's seat.
	 */
	public void setSeat(Seat seat) {this.seat = seat;}
	/**
	 * Sets Customer who booked this Ticket.
	 * @param customer This Ticket's Customer.
	 */
	public void setCustomer(Moviegoer customer) {this.customer = customer;}
	
	
}
