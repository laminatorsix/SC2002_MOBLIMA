package moblima.main;

import java.util.Scanner;
import moblima.controller.*;

public class User {
	private static Scanner s = new Scanner(System.in);
	private static boolean contWhole = true;
	private static MovieController movieController;
	private static ListingController listingController;
	private static MovieReviewController movieReviewController;
	private static MoviegoerController moviegoerController;
	private static BookingController bookingController;
	private static CineplexController cineplexController;
	
	
	public static void showUserMenu() {
		System.out.println("-----------------------------");
		System.out.println("1. Search Movies\n" //print movie details
	                     + "2. View Movies\n" //view all movies
						 + "3. Buy Ticket\n" //purchase ticket
						 + "4. View Booking History\n" //print booking history of customer
						 + "5. Exit\n");
		System.out.println("-----------------------------");
	}
	
	public static void userModule() {
		
		contWhole = true;
		showUserMenu();
		System.out.println();
		System.out.println("Enter your choice: ");
		int choice = Integer.parseInt(s.nextLine());
		switch(choice) {
			case(1):
				showMovieDetails();
				break;
			case(2):
				showAllMovies();
				break;
			case(3):
				User.bookTicket();
				break;
			case(4):
				User.checkBookingHistory();
				break;
			default:
				contWhole = false;
				break;
			
		}
		
		
	}
	
	public static void showMovieDetails() {
		String name, input;
		System.out.println("Current Movies: ");
		movieController.printShowingMovieNames();
		System.out.println();
		System.out.println("Enter Movie Name: ");
		name = s.nextLine();
		while(!movieController.getNewMovie(name) || !movieController.checkMovieShowing()) {
			System.out.println("Movie does not exist/is no longer showing. Enter another movie: ");
			name = s.nextLine();
		}
		
		System.out.println();
		movieController.printMovie();
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("Reviews: ");
		System.out.println("-----------------------------------");
		movieReviewController.printAll(movieController.getCurrentMovie());
		
		System.out.println("Leave a review? (Y/N)");
		input = s.nextLine();
		while(!input.equals("Y") && !input.equals("N")) {
			System.out.println("Please enter 'Y' or 'N'.");
			input = s.nextLine();
		}
		
		if(input.equals("Y")) {
			System.out.println();
			leaveReview();
			
		}
	}
	
	public static void leaveReview() {
		String name, review;
		int rating;
		
		System.out.println("Enter your review: ");
		review = s.nextLine();
		System.out.println("Enter your rating (/5): ");
		rating = Integer.parseInt(s.nextLine());
		
		movieReviewController.setMovieReview(movieController.getCurrentMovie(), review, rating);
		movieReviewController.addReviewToDatabase();
		System.out.println("Success!");
		System.out.println();
	}
	
	public static void showAllMovies() {
		int filter = movieController.getFilter(), choice, filterChoice = filter;
		boolean cont = true;
		
		while(cont) {
			System.out.println("-----------------------------");
			System.out.println("What would you like to do?\n"
					+ "1. Show Top 5 Movies\n"
					+ "2. Show All Movies\n"
					+ "3. Exit\n");
			System.out.println("-----------------------------");
			choice = Integer.parseInt(s.nextLine());
			System.out.println();
			
			if(filter == 3) {
				System.out.println("-----------------------------");
				System.out.println("How would you like to sort the movies?\n"
						+ "1. By Overall Rating\n"
						+ "2. By Ticket Sales\n");
				System.out.println("-----------------------------");
				filterChoice = Integer.parseInt(s.next());
			}
			
			if(filterChoice == 1)
				movieController.sortByOverallRating();
			else
				movieController.sortByTotalSales();
			
			switch(choice) {
				case 1:
					movieController.printTopFiveShowingMovies();
					break;
				case 2:
					movieController.printShowingMovies();
					break;
				case 3: 
					cont = false;
					break;
					
			}
		}
		System.out.println();
		
		
		
	}
	
	public static void bookTicket() {
		String movie, cineplex, date, time, input, name, email, mobile, code;
		boolean senior = false, setMeal = false, discount = false;
		//Movie
		System.out.println("Movies: ");
		movieController.printShowingMovieNames();
		System.out.println();
		System.out.println("Enter a Movie (0 to Exit): ");
		movie = s.nextLine();
		if(movie.equals("0"))
			return;
		while(true) {
			if(!movieController.getNewMovie(movie) || !movieController.checkMovieShowing()) {
				System.out.println("This movie does not exist/ is no longer showing. Enter another movie: ");
				movie = s.nextLine();
			}
			else if(!listingController.printAllListingsForMovie(movieController.getCurrentMovie())){
				System.out.println("There are no listings for this movie. Choose another movie: ");
				movie = s.nextLine();
			}
			else
				break;
		}
		
		System.out.println();
		
		//Cineplex
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Enter a Cineplex: ");
		
		cineplex = s.nextLine();
		while(true) {
			if(!cineplexController.getNewCineplex(cineplex)) {
				System.out.println("This cineplex does not exist. Enter another cineplex: ");
				cineplex = s.nextLine();
			}
			else if(!listingController.printAllListingsBasic(cineplexController.getCurrentCineplex(), movieController.getCurrentMovie())){
				System.out.println("There are no listings for this cineplex. Choose another Cineplex: ");
				cineplex = s.nextLine();
			}
			else
				break;
		}
		
		//DateTime
		System.out.println("Choose a Date (YYYY-MM-DD): ");
		date = s.nextLine();
		
		System.out.println("Choose a Time (HH:MM): ");
		time = s.nextLine();
		
		while(!listingController.getNewListing(time, date, movie, cineplex)) {
			System.out.println("There is no showtime on this date/format is wrong. Please re-enter.");
			System.out.println();
			
			System.out.println("Choose a Date (YYYY-MM-DD): ");
			date = s.nextLine();
			
			System.out.println("Choose a Time (HH:MM): ");
			time = s.nextLine();
		}
		
		//Seat
		listingController.printListingSeats();
		
		System.out.println("Choose a row: ");
		int row = Integer.parseInt(s.nextLine())-1;
		System.out.println("Choose a column: ");
		int col = Integer.parseInt(s.nextLine())-1;
		
		while(!listingController.checkSeatAvailable(row, col) || row > listingController.getRows() || col > listingController.getCols()) {
			System.out.println("That seat is not available. Please choose another.");
			System.out.println();
			System.out.println("Choose a row: ");
			row = Integer.parseInt(s.nextLine()) - 1;
			System.out.println("Choose a column: ");
			col = Integer.parseInt(s.nextLine()) - 1;
		}
		
		listingController.updateSeat(row, col);
		System.out.println("Would you like to purchase a set meal? (Y/N): ");
		input = s.nextLine();
		while(!input.equals("Y") && !input.equals("N")) {
			System.out.println("Please enter 'Y' or 'N'.");
			input = s.nextLine();
		}
		if(input.equals("Y")) {
			setMeal = true;
		}
		else if(input.equals("N")) {
			setMeal = false;
		}

		//Moviegoer Details
		System.out.println("Enter your name: ");
		name = s.nextLine();
		System.out.println("Enter your email address: ");
		email = s.nextLine();
		System.out.println("Enter your mobile number: ");
		mobile = s.nextLine();
		System.out.println("Are you over 60 years old? (Y/N): ");
		input = s.nextLine();
		while(!input.equals("Y") && !input.equals("N")) {
			System.out.println("Please enter 'Y' or 'N'.");
			input = s.nextLine();
		}
		if(input.equals("Y")) {
			senior = true;
		}
		else if(input.equals("N")) {
			senior = false;
		}
		
		//If moviegoer doesn't exist
		if(!moviegoerController.getMoviegoer(email, mobile)) {
			moviegoerController.setMoviegoer(name, email, mobile, senior);
			moviegoerController.addMoviegoerToDatabase();
		}
		
		bookingController.setBooking(listingController.getListingSeat(row, col), moviegoerController.getCurrentMoviegoer(), setMeal, false);
		System.out.println("Current Booking Price: " + bookingController.getBookingPrice());
		//discount code
		System.out.println("Do you have a discount code? (Y/N) ");
		input = s.nextLine();
		while(!input.equals("Y") && !input.equals("N")) {
			System.out.println("Please enter 'Y' or 'N'.");
			input = s.nextLine();
		}
		
		if(input.equals("Y")) {
			System.out.println("Please enter the code: ");
			code = s.nextLine();
			while(!bookingController.checkBookingDiscountCode(code)) {
				System.out.println("Incorrect. Enter another code? (Y/N)");
				input = s.nextLine();
				if(input.equals("N"))
					break;
			}
			if(input.equals("Y"))
				bookingController.setBookingDiscount(true);
		}
		
		
		bookingController.addBookingToDatabase();
		
		System.out.println("Booking has been made. ");
		System.out.println("-----------------------------");
		bookingController.printBooking();
		System.out.println();
		//print booking details
	}
	
	public static void checkBookingHistory() {
		System.out.println("Enter your email address or mobile number: ");
		String emailMobile = s.nextLine();
		while(!moviegoerController.getMoviegoer(emailMobile, emailMobile)){
			System.out.println("This user does not exist. Please enter another email/mobile: ");
			emailMobile = s.nextLine();
		}
		
		bookingController.printBookingHistory(moviegoerController.getCurrentMoviegoer());
		System.out.println();
	}
	
	/**
	 * Finalises database.
	 */
	public static void end() {
		movieController.close();
		listingController.close();
		moviegoerController.close();
		bookingController.close();
		movieReviewController.close();
	}
	/**
	 * Returns contwhole.
	 * @return contwhole.
	 */ 
	public static boolean returnCont() {
		return contWhole;
	}
	/**
	 * Sets whether the program should continue running.
	 * @return cont.
	 */
	public static void setCont() {
		contWhole = true;
	}
	/**
	 * Initialises all controllers.
	 * Refreshes data.
	 */
	public static void initialise() {
		movieController = new MovieController();
		listingController = new ListingController();
		movieReviewController = new MovieReviewController();
		moviegoerController = new MoviegoerController();
		bookingController = new BookingController();
		cineplexController = new CineplexController();
	}
	/**
	 * Resets everything.
	 */
	public static void reset() {
		bookingController.reset();
		moviegoerController.reset();
		movieReviewController.reset();
		movieController.reset();
		listingController.reset();
	}
}
