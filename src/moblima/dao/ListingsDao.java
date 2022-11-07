package moblima.dao;
import java.util.*;
import moblima.model.*;
import moblima.view.ListingView;

public class ListingsDao implements Dao<Listing>{
	List<Listing> listings;
	ListingView listingview = new ListingView();
	/**
	 * Constructor for ListingDAO.
	 */
	@SuppressWarnings("unchecked")
	public ListingsDao() {
		listings = (ArrayList<Listing>)SerializeDB.readSerializedObject("data/listings.dat");
		if(listings == null) {
			List<Listing> a = new ArrayList<>();
			listings = a;
		}
	}
	
	/**
	 * Retrieves Listing from listings.dat based on index.
	 * @param id Index of this Listing in list.
	 */
	@Override
	public Optional<Listing> get(long id){
		return Optional.ofNullable(listings.get((int) id));
	}
	
	/**
	 * Retrieves all Listings from listing.dat
	 * @return list of Listings.
	 */
	@Override
    public List<Listing> getAll(){
		return listings;
	}
    /**
     * Retrieves Listing by Time, Cineplex, and Movie
     * @return
     */
	public Listing getListing(String time, String date, String movie, String cineplex) {
		for(int i = 0; i < listings.size(); i++) {
			Listing l = (Listing)listings.get(i);
			if(time.equals(l.getTime()) && date.equals(l.getDate()) && movie.equals(l.getMovie().getName()) && cineplex.equals(l.getCinema().getCineplex().getName()))
				return l;
		}
		return null;
	}
	/**
	 * Prints all Listings for a certain Cineplex
	 * @param cineplex The Cineplex containing the Listings.
	 */
	public boolean printAllAtCineplex(Cineplex cineplex) {
		boolean have = false;
		System.out.println("Cineplex: " + cineplex.getName());
		for(int i = 0; i < listings.size(); i++) {
			Listing l = (Listing)listings.get(i);
			if(l.getCinema().getCineplex() == cineplex) {
				have = true;
				System.out.println("Movie: " + l.getMovie().getName());
				listingview.printListing(l.getCinema().getCode().substring(l.getCinema().getCode().length()-1), l.getTime(), l.is3D(), l.getCinema().isPlatinum());
			}
			
		}
		return have;
	}
	
	
	
	/**
	 * Prints all Listings for a certain Movie at a certain Cineplex.
	 * @param cineplex The Cineplex that the Listing is for.
	 * @param movie The Movie that the Listing is for.
	 */
	public boolean printMovieAtCineplex(Cineplex cineplex, Movie movie) {
	    boolean have = false;
	    String date = "";
		System.out.println("Movie: " + movie.getName());
		System.out.println("Cineplex: " + cineplex.getName());
		
		for(int i = 0; i < listings.size(); i++) {
			Listing l = (Listing)listings.get(i);
			if(date == "" || date != l.getDate()) {
				date = l.getDate();
				System.out.println("Date: " + date);
			}
			
			if(l.getCinema().getCineplex() == cineplex && l.getMovie() == movie) {
				have = true;
				listingview.printListing(l.getCinema().getCode().substring(l.getCinema().getCode().length()-1), l.getTime(), l.is3D(), l.getCinema().isPlatinum());
			}
			
		}
		return have;
	}
	

	/**
	 * Sorts Listings by date and time.
	 */
	public void sortListings() {
		Collections.sort(listings, Comparator.comparing(Listing::getDate).thenComparing(Listing::getTime));
	}
	
	/**
	 * Adds a Listing to listings.dat.
	 * @param listing The Listing to be added.
	 */
	@Override
    public void add(Listing listing) {
		if(listings != null && listings.contains(listing)) {
			listings.remove(listing);
		}
		listings.add(listing);
		sortListings();
	}
    
	/**
	 * Deletes a Listing from listings.dat
	 * @param listing The Listing to be deleted.
	 * 
	 */
	@Override
    public void delete(Listing listing) {
		if(listings != null && listings.contains(listing)) {
			listings.remove(listing);
		}
		if(listings!= null)
			sortListings();
	};
	
	/**
	 * Deletes all Listings for a particular Movie.
	 * @param name Name of Movie.
	 */
	public void deleteMovie(String name) {
		
		for(int i = 0; i < listings.size(); i++) {
			Listing l = listings.get(i);
			if(l.getMovie().getName().equals(name)) {
				delete(l);
			}
		}
	}
	/**
	 * Writes updated data to listings.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/listings.dat", listings);
	}

	
	
}
