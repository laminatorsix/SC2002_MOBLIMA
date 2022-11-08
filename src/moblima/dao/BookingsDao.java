package moblima.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import moblima.view.BookingView;
import moblima.model.*;

public class BookingsDao implements Dao<Booking> {
	List<Booking> bookings;
	BookingView b = new BookingView();
	
	

	public BookingsDao() {
		bookings = (ArrayList)SerializeDB.readSerializedObject("data/bookings.dat");
		if(bookings == null) {
			List<Booking> a = new ArrayList<>();
			bookings = a;
		}
	}
	
	@Override
	public Optional<Booking> get(long id){
		return Optional.ofNullable(bookings.get((int) id));
	}
	
	@Override
    public List<Booking> getAll(){
		return bookings;
	}
    
	
//	public void printAll(){
//		for(int i = 0; i < bookings.size(); i++) {
//			Booking m = (Booking)bookings.get(i);
//			System.out.println("Name: " + m.getName());
//			System.out.println("Description: " + m.getDesc());
//			System.out.println("Status: " + m.getStatus());
//			System.out.print("Cast: ");
//			Array.printArray(m.getCast());
//		}
//	}
	
	//print history for a certain moviegoer via email
	public void printHistory(Moviegoer moviegoer) {
		System.out.println("Customer Name: " + moviegoer.getName());
		System.out.println("Email: " + moviegoer.getEmail());
		for(int i = 0; i < bookings.size(); i++) {
			Booking m = (Booking)bookings.get(i);
			if(moviegoer.getEmail().equals(m.getTicket().getCustomer().getEmail()) && moviegoer.getMobile().equals(m.getTicket().getCustomer().getMobile())) {
				b.printBooking(m.getTID(), m.getBookingPrice().getTotalPrice(), m.getTicket().getSeat().getListing().getMovie().getName(), m.getTicket().getSeat().getListing().getDateTime(), m.getDateTime());
			}
		}
	}
	@Override
    public void add(Booking booking) {
		if(bookings != null && bookings.contains(booking)) {
			bookings.remove(booking);
		}
		bookings.add(booking);
		
	}
    
	@Override
    public void delete(Booking booking) {
		if(bookings != null && bookings.contains(booking)) {
			bookings.remove(booking);
		}
	}
	
	//no updating for bookings
	/**
	 * Writes updated data to bookings.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/booking.dat", bookings);
	}
}
