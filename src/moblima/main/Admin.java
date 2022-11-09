package moblima.main;
import java.util.Scanner;
import moblima.model.Array;
import moblima.controller.*;
import moblima.model.MovieRating;
import moblima.model.MovieStatus;
public class Admin {
	private static Scanner s = new Scanner(System.in);
	private static AdminLoginController adminLoginController = new AdminLoginController();
	private static MovieController movieController;
	public static ListingController listingController;
	public static CineplexController cineplexController;
	public static CinemaController cinemaController;
	public static TicketPriceController ticketPriceController;
	public static HolidayController holidayController;
	
	
	private static boolean contWhole = true;
	
	public static boolean adminLogin() {
		System.out.println("Please enter the password (Type 0 to exit): ");
		String pw = s.nextLine();
		if(adminLoginController.verifyLogin(pw)) {
			System.out.println("Success!");
			return true;
		}
		
		if(pw.equals("0"))
			return false; //exit
		
		while(!adminLoginController.verifyLogin(pw)) {
			System.out.println("Wrong password! Please enter again (Type 0 to exit): ");
			pw = s.nextLine();
			if(pw.equals("0"))
				return false;
		}
		
		return true;
		
		
	}
	
	public static void showAdminMenu() {
		System.out.println("-----------------------------");
		System.out.println("1. Create/Update/Remove Movie Listing\n" //edit movie
						+ "2. Create/Update/Remove Cinema Showtimes/Available Movies\n" //edit listings
						+ "3. Configure System Settings\n"//edit all the prices etc 
						+ "4. Logout\n"); //logout and return to main page
		System.out.println("-----------------------------");
	}
	
//	1. Login
//	2. Create/Update/Remove movie listing
//	3. Create/Update/Remove cinema showtimes and the movies to be shown
//	4. Configure system settings
	public static void adminModule() {
		
		contWhole = true;
		showAdminMenu();
	
		System.out.println("Enter your choice: ");
		int choice = Integer.parseInt(s.nextLine());
		
		switch(choice) {
			case(1): //Create/Update/Remove movie listing
				updateMovie();
				break;
			case(2): //Create/Update/Remove cinema showtimes and the movies to be shown
				updateShowtimes();
				break;
			case(3): //configure system settings 
				configureSystemSettings();
				break;
			default:
				//logout and exit
				contWhole = false;
				break;
		}
		
	}
	
	
	
	public static void updateMovie() {
		System.out.println("---UPDATE MOVIE---");
		System.out.println();
		String name, desc, dir, cast, statusStr, ratingStr;
		String[] castArr;
		MovieStatus status;
		MovieRating rating;
		boolean cont = true;
		System.out.println("-----------------------------");
		System.out.println("What would you like to do?\n" 
						+ "1. Add new movie\n"
						+ "2. Delete movie\n"
						+ "3. Update movie details\n");
		System.out.println("-----------------------------");
		switch(Integer.parseInt(s.nextLine())) {
			case 1: //Add movie
				System.out.println("---ADD MOVIE---");
				System.out.println("Enter movie name: ");
				name = s.nextLine();
				System.out.println("Enter movie description: ");
				desc = s.nextLine();
				System.out.println("Enter movie director: ");
				dir = s.nextLine();
				System.out.println("Enter movie cast (Separated by commas):");
				cast = s.nextLine();
				castArr = cast.split(",");
				System.out.println("Enter movie status (COMINGSOON, NOWSHOWING, ENDOFSHOWING): ");
				status = MovieStatus.valueOf(s.nextLine());
				System.out.println("Enter movie rating (PG, PG13, NC16, M18, R21): ");
				rating = MovieRating.valueOf(s.nextLine());
				
				movieController.setNewMovie(name, status, desc, dir, castArr, rating);
				break;
			case 2: //delete movie
				System.out.println("---DELETE MOVIE---");
				System.out.println();
				movieController.printAllMovies();
				System.out.println();
				System.out.println("Enter name of movie to be deleted (0 to exit):");
				name = s.nextLine();
				if(name.equals("0"))
					break;
				while(!movieController.getNewMovie(name)) {
					System.out.println("This movie does not exist. Enter another name:");
					name = s.nextLine();
				}
				
				movieController.deleteMovieFromDatabase();
				break;
			case 3: //update movie
				System.out.println("---UPDATE MOVIE---");
				movieController.printAllMovies();
				System.out.println("Enter name of movie to be updated (0 to exit): ");
				name = s.nextLine();
				if(name.equals("0"))
					break;
				while(!movieController.getNewMovie(name)) {
					System.out.println("This movie does not exist. Enter another name:");
					name = s.nextLine();
				}
				
				while(cont) {
					System.out.println("What would you like to update?\n"
							+ "1. Name\n"
							+ "2. Description\n"
							+ "3. Director\n"
							+ "4. Cast\n"
							+ "5. Status\n"
							+ "6. Rating\n"
							+ "7. Exit\n");
					
					switch(Integer.parseInt(s.nextLine())) {
						case 1: 
							System.out.println("Enter new name: ");
							name = s.nextLine();
							movieController.setMovieName(name);
							break;
						case 2:
							System.out.println("Enter new description: ");
							desc = s.nextLine();
							movieController.setMovieDesc(desc);
							break;
						case 3:
							System.out.println("Enter new director: ");
							dir = s.nextLine();
							movieController.setMovieDirector(dir);
							break;
						case 4: 
							System.out.println("Enter new cast (Seperated by commas): ");
							castArr = s.nextLine().split(",");
							movieController.setMovieCast(castArr);
							break;
						case 5:
							System.out.println("Enter new status (PREVIEW, NOWSHOWING, ENDOFSHOWING): ");
							statusStr = s.nextLine();
							movieController.setMovieStatus(statusStr);
							break;
						case 6:
							System.out.println("Enter new rating (PG, PG13, NC16, M18, R21): ");
							ratingStr = s.nextLine();
							movieController.setMovieRating(ratingStr);
							break;
						case 7:
							cont = false;
							break;
							
					}
				}
				
				
		}
		//moviecontroller - retrievemoviefromdatabase
		//add, delete, or update
		//moviecontroller - deletemoviefromdatabase
		//moviecontroller - addmovietodatabase
		//moviecontroller - updatemovieindatabase
	}
	
	public static void updateShowtimes() {
		System.out.println("---UPDATE SHOWTIMES---");
		int choice;
		String cineplex, movie, date, time, name, is3Dstr, hall, cinemaCode;
		boolean is3D;
		boolean cont = true;
		
		System.out.println("Cineplexes:");
		cineplexController.printAllCineplexNames();
		System.out.println();
		do {
			System.out.println("Enter Cineplex: ");
			cineplex = s.nextLine();
		}while(!cineplexController.getNewCineplex(cineplex));
		
		System.out.println("Movies: ");
		movieController.printAllMovieNames();
		System.out.println();
		
		do {
			System.out.println("Enter Movie: ");
			movie = s.nextLine();
		}while(!movieController.getNewMovie(movie));
		
		
		while(cont) {
			System.out.println();
			System.out.println("Listings: ");
			listingController.printAllListingsBasic(cineplexController.getCurrentCineplex(), movieController.getCurrentMovie());
			System.out.println();
			System.out.println("What would you like to do?\n"
					+ "1. Add Showtime\n"
					+ "2. Delete Showtime\n"
					+ "3. Update Showtime\n"
					+ "4. Delete all showtimes\n"
					+ "5. Exit\n");
					
			choice = Integer.parseInt(s.nextLine());
			switch(choice) {
				case 1:
					System.out.println("---ADD SHOWTIME---");
					do {
						System.out.println("Is it a 3D screening (Y/N): ");
						is3Dstr = s.nextLine();
					}while(!is3Dstr.equals("Y") && !is3Dstr.equals("N"));
					
					if(is3Dstr.equals("Y"))
						is3D = true;
					else
						is3D = false;
					
					do {
						System.out.println("Enter cinema hall number (1-3): ");
						hall = s.nextLine();
						cinemaCode = cineplexController.getCurrentCineplex().getCode() + "0" + hall;
						
					}while(!cinemaController.getNewCinema(cineplexController.getCurrentCineplex(), cinemaCode));
					
					while(true) {
						System.out.println("Enter new date (yyyy/MM/dd): ");
						date = s.nextLine();
						System.out.println("Enter new time (HH:mm): ");
						time = s.nextLine();
						
						if(listingController.setNewListing(date, time, movieController.getCurrentMovie(), cinemaController.getCurrentCinema(), is3D)) {
							if(listingController.checkIfListingExists())
								System.out.println("There is already a listing at this cinema.");
							else
								break;
						}
						else
							System.out.println("Please re-enter the date and time.");
					}
					listingController.addListingToDatabase();
					System.out.println("Success!");
					break;
				case 2:
					System.out.println("---DELETE SHOWTIME---");
					while(true) {
						System.out.println("Enter date (yyyy/MM/dd): ");
						date = s.nextLine();
						System.out.println("Enter time (HH:mm): ");
						time = s.nextLine();
						
						if(listingController.getNewListing(time, date, movie, cineplex))
							break;
						else
							System.out.println("This listing does not exist.");
					}
					listingController.deleteListingFromDatabase();
					System.out.println("Success!");
					break;
				case 3:
					System.out.println("---EDIT SHOWTIME---");
					while(true) {
						System.out.println("Enter date (yyyy/MM/dd): ");
						date = s.nextLine();
						System.out.println("Enter time (HH:mm): ");
						time = s.nextLine();
						
						if(listingController.getNewListing(time, date, movie, cineplex))
							break;
						else
							System.out.println("This listing does not exist.");
					}
					
					while(true) {
						System.out.println("Enter new time (HH:mm): ");
						time = s.nextLine();
						if(listingController.setListingDateTime(date, time))
							break;
						else
							System.out.println("Please re-enter the time.");
					}
					System.out.println("Success!");
					break;
				case 4:
					listingController.deleteMovieFromDatabase(movie);
					System.out.println("Success!");
					System.out.println();
					break;
				case 5:
					cont = false;
					break;
			}
		}
		
		
		//ask for cineplex -> movie -> show all listings -> enter a date and time
		//for movie in moviedao -> print all listings for each movie, in order based on cineplex, movie
		//listingocntroller - printalllistings (while same date and movie, print time only)
		//listingcontroller - remove all listings for a specific movie
		//listingcontroller - add listing to database
		//listingcontroller - remove listing from database
		//listingcontroller - update listing in database
	}
	
	public static void configureSystemSettings() {
		System.out.println("---CONFIGURE SYSTEM SETTINGS---");
		System.out.println("What do you want to do?\n" 
				+ "1. Configure Price\n"
				+ "2. Configure Holidays\n"
				+ "3. Configure Customer View\n"
				+ "4. Reset System (!!!)\n"
				+ "5. Exit\n");
		
		int choice = Integer.parseInt(s.nextLine());
		
		switch(choice) {
			case 1: 
				configurePrice();
				break;
			case 2:
				configureHol();
				break;
			case 3:
				configureView();
				break;
			case 4:
				resetSystem();
				break;
			default:
				break;
		}
				
		//bookingpricecontroller - set meal price, set  discount
		//ticketpricecontroller - set base price, set 3D surcharge, set hol surcharge, set preview surcharge, set senior citizen surcharge, platinum cinema surcharge
		//moviecontroller - whether customers can sort by idk what 
		
//				+ "1. Update Base Price\n"
//				+ "2. Update 3D Surcharge\n"
//				+ "3. Update Holiday Surcharge\n"
//				+ "4. Update Preview Surcharge\n"
//				+ "5. Update Platinum
	}
	
	public static void configurePrice() {
		int choice;
		boolean cont = true;
		double price;
		
		while(cont) {
			System.out.println("-----------------------------");
			System.out.println("What do you want to update?\n"
					+ "1. Update Base Price\n"
					+ "2. Update 3D Surcharge\n"
					+ "3. Update Holiday Surcharge\n"
					+ "4. Update Preview Surcharge\n"
					+ "5. Update Platinum Surcharge\n"
					+ "6. Update Senior Citizen Discount\n"
					+ "7. Exit\n");
			System.out.println("-----------------------------");
			
			choice = Integer.parseInt(s.nextLine());
			switch(choice) {
				case 1: 
					System.out.println("Current price: " + ticketPriceController.getTicketBasePrice());
					System.out.println("Enter new price: ");
					price = Double.parseDouble(s.nextLine());
					ticketPriceController.setTicketBasePrice(price);
					break;
				case 2: 
					System.out.println("Current 3D surcharge: " + ticketPriceController.getTicket3D());
					System.out.println("Enter new surcharge: ");
					price = Double.parseDouble(s.nextLine());
					ticketPriceController.setTicket3D(price);
					break;
				case 3:
					System.out.println("Current Holiday surcharge: " + ticketPriceController.getTicketHol());
					System.out.println("Enter new surcharge: ");
					price = Double.parseDouble(s.nextLine());
					ticketPriceController.setTicketHol(price);
					break;
				case 4:
					System.out.println("Current Preview surcharge: " + ticketPriceController.getTicketPreview());
					System.out.println("Enter new surcharge: ");
					price = Double.parseDouble(s.nextLine());
					ticketPriceController.setTicketPreview(price);
					break;
				case 5:
					System.out.println("Current Platinum surcharge: " + ticketPriceController.getTicketPlat());
					System.out.println("Enter new surcharge: ");
					price = Double.parseDouble(s.nextLine());
					ticketPriceController.setTicketPlat(price);
					break;
				case 6:
					System.out.println("Current Senior discount: " + ticketPriceController.getTicketSeniorCitizen());
					System.out.println("Enter new discount (0<discount<1): ");
					price = Double.parseDouble(s.nextLine());
					ticketPriceController.setTicketSeniorCitizen(price);
					break;
				default:
					cont = false;
					break;
					
			}
		}
	}
	
	public static void configureHol() {
		boolean cont = true;
		int choice;
		String name, date;
		
		while(cont) {
			if(!holidayController.printAllHolidays())
				System.out.println("There are no holidays in the system.");
			System.out.println("What do you want to do? \n"
					+ "1. Add Holiday\n"
					+ "2. Delete Holiday\n"
					+ "3. Exit\n");
			System.out.println("-----------------------------");
			choice = Integer.parseInt(s.nextLine());
			switch(choice) {
				case 1:
					System.out.println("Enter holiday name: ");
					name = s.nextLine();
					while(true) {
						System.out.println("Enter date: ");
						date = s.nextLine();
						if(holidayController.setNewHol(name, date))
							break;
						else
							System.out.println("Please re-enter the date.");		
					}
					holidayController.addHol();
					System.out.println("Success!");
					break;
				case 2:
					while(true) {
						System.out.println("Enter holiday name: ");
						name = s.nextLine();
						if(holidayController.getNewHol(name))
							break;
						else
							System.out.println("This holiday does not exist.");
					}
					holidayController.deleteHol();
					System.out.println("Success!");
					break;
				default:
					cont = false;
					break;
					
			}
		}
		
	}
	public static void configureView() {
		int choice;
		boolean cont = true;
		
		System.out.println("---CONFIGURE MOVIE VIEW---");
		while(cont) {
			System.out.println("What do you want to do? \n"
					+ "1. Sort Top 5 by Ticket Sales ONLY\n"
					+ "2. Sort Top 5 by Overall Rating ONLY\n"
					+ "3. Sort Top 5 by BOTH\n"
					+ "4. View Top 5 by Ticket Sales\n"
					+ "5. View Top 5 by Overall Rating\n"
					+ "6. Exit\n");
			System.out.println("-----------------------------");
			
			choice = Integer.parseInt(s.nextLine());
			
			switch(choice) {
				case 1:
					movieController.setFilter(0);
					break;
				case 2:
					movieController.setFilter(1);
					break;
				case 3:
					movieController.setFilter(2);
					break;
				case 4:
					movieController.sortByTotalSales();
					movieController.printTopFiveMovies();
					break;
				case 5:
					movieController.sortByOverallRating();
					movieController.printTopFiveMovies();
					break;
				default:
					cont = false;
					break;
			}
			
		}
		
	}
	/**
	 * Initialise controller classes.
	 */
	public static void initialise() {
		
		movieController = new MovieController();
		listingController = new ListingController();
		cineplexController = new CineplexController();
		cinemaController = new CinemaController();
		ticketPriceController = new TicketPriceController();
		holidayController = new HolidayController();
	}
	/**
	 * Resets all data in system.
	 */
	public static void resetSystem() {
		String choice;
		do {
			System.out.println("All data will be cleared. Are you sure? (Y/N)");
			choice = s.nextLine();
		}while(!choice.equals("Y") && !choice.equals("N"));
		
		if(!choice.equals("Y")) {
			return;
		}
		
		movieController.reset();
		holidayController.reset();
		listingController.reset();
		User.initialise();
		User.reset();
		User.end();
		
		
	}
	/**
	 * Finalises database.
	 */
	
	public static void end() {
		movieController.close();
		listingController.close();
		holidayController.close();
		cineplexController.close();
		cinemaController.close();
	}
	
	/**
	 * Returns whether the program should continue running.
	 * @return cont.
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
}
