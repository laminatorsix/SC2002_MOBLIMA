package moblima.main;
import java.util.Scanner;
import moblima.model.Array;
import moblima.controller.*;
import moblima.model.MovieRating;
import moblima.model.MovieStatus;
public class Admin {
	private static Scanner s = new Scanner(System.in);
	private static AdminLoginController adminLoginController = new AdminLoginController();
	private static MovieController movieController = new MovieController();
	public static ListingController listingController = new ListingController();
	
	public static boolean adminLogin() {
		do {
			System.out.println("Please enter the password (Type 0 to exit): ");
			String pw = s.nextLine();
			if(adminLoginController.verifyLogin(pw)) {
				System.out.println("Success!");
				return true;
			}
			if(pw == "0")
				return false; //exit
			System.out.println("Wrong password!");
		}
		while(true);
	}
	
	public static void showAdminMenu() {
		System.out.println("1. Create/Update/Remove Movie Listing\n" //edit movie
						+ "2. Create/Update/Remove Cinema Showtimes/Available Movies\n" //edit listings
						+ "3. Configure System Settings"//edit all the prices etc 
						+ "4. Logout"); //logout and return to main page
	}
	
//	1. Login
//	2. Create/Update/Remove movie listing
//	3. Create/Update/Remove cinema showtimes and the movies to be shown
//	4. Configure system settings
	public static void adminModule() {
		showAdminMenu();
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();
		switch(choice) {
			case(1): //Create/Update/Remove movie listing
				updateMovie();
				
				break;
			case(2): //Create/Update/Remove cinema showtimes and the movies to be shown
				
				break;
			case(3): //configure system settings 
				
				
				break;
			case(4):
				//logout and exit
				break;
			default:
				break;
		}
		
	}
	
	
	
	public static void updateMovie() {
		System.out.println("---UPDATE MOVIE---");
		String name, desc, dir, cast, statusStr, ratingStr;
		String[] castArr;
		MovieStatus status;
		MovieRating rating;
		boolean cont = true;
		
		System.out.println("What would you like to do?\n" 
						+ "1. Add new movie\n"
						+ "2. Delete movie\n"
						+ "3. Update movie details\n");
		
		switch(s.nextInt()) {
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
				System.out.println("Enter movie status (PREVIEW, NOWSHOWING, ENDOFSHOWING): ");
				status = MovieStatus.valueOf(s.nextLine());
				System.out.println("Enter movie rating (PG, PG13, NC16, M18, R21): ");
				rating = MovieRating.valueOf(s.nextLine());
				
				movieController.setNewMovie(name, status, desc, dir, castArr, rating);
				break;
			case 2: //delete movie
				System.out.println("---DELETE MOVIE---");
				movieController.printAllMovies();
				
				System.out.println("Enter name of movie to be deleted:");
				name = s.nextLine();
				
				movieController.getNewMovie(name);
				while(movieController.getMovie() == null) {
					System.out.println("This movie does not exist. Enter another name:");
					name = s.nextLine();
					movieController.getNewMovie(name);
				}
				
				movieController.deleteMovieFromDatabase(movieController.getMovie());
				break;
			case 3: //update movie
				System.out.println("---UPDATE MOVIE---");
				movieController.printAllMovies();
				System.out.println("Enter name of movie to be updated: ");
				name = s.nextLine();
				movieController.getNewMovie(name);
				while(movieController.getMovie() == null) {
					System.out.println("This movie does not exist. Enter another name:");
					name = s.nextLine();
					movieController.getNewMovie(name);
				}
				
				while(cont) {
					System.out.println("What would you like to update?"
							+ "1. Name\n"
							+ "2. Description\n"
							+ "3. Director\n"
							+ "4. Cast\n"
							+ "5. Status\n"
							+ "6. Rating\n"
							+ "7. Exit\n");
					
					switch(s.nextInt()) {
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
		//ask for cineplex -> movie -> show all listings -> enter a date and time
		//for movie in moviedao -> print all listings for each movie, in order based on cineplex, movie
		//listingocntroller - printalllistings (while same date and movie, print time only)
		//listingcontroller - remove all listings for a specific movie
		//listingcontroller - add listing to database
		//listingcontroller - remove listing from database
		//listingcontroller - update listing in database
	}
	
	public static void configureSystemSettings() {
		//bookingpricecontroller - set meal price, set  discount
		//ticketpricecontroller - set base price, set 3D surcharge, set hol surcharge, set preview surcharge, set senior citizen surcharge, platinum cinema surcharge
		//moviecontroller - whether customers can sort by idk what 
		
	}
}
