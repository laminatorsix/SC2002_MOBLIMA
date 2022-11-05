package moblima.main;
import java.util.Scanner;

import moblima.controller.*;

public class MoblimaApp {
	private static Scanner s = new Scanner(System.in);
//	private static Dao<Movie> movieDao;
//	
//	public static void main(String[] args) {
		
//		movieDao = new MovieDao();
//		
//		String[] cast1 = {"Michael Sheen", "David Tennant"};
//		Movie movie1 = new Movie("Good Omens", MovieStatus.NOWSHOWING, "Amazing show", cast1);
//		movieDao.add(movie1);
//		
//		movieDao.printAll();
//	}
	public static void checkBookingHistory() {
		System.out.println("Enter your email address or mobile number: ");
		String emailMobile;
		//try retrieve customer from database
		//check if email or number exists
		
		//print booking history
	}
	
	
	public static void bookTicket() {
		//create moviecontroller object
		//1.Print List of Movies Available
//		3. Ask which movie to book for.
		System.out.println("Enter a Movie: ");
		String movie = s.next();
//		//check if movie exists if not enter again
		//Print all showtimes for that movie from each cineplex - use for loop and cineplex list
//		3. Ask for a Cineplex.
		
		System.out.println("Enter a Cineplex: ");
		String cineplex = s.next();
//		4. Show all Listings for that movie at that Cineplex.
		//check if cineplex exists if not enter again
		//check if there are listings if not enter again
		
//		5. Ask which Listing they want -> they choose by typing date in
		System.out.println("Choose a Date (DD-MM-YYYY): ");
		String date = s.next();
		boolean yes;
		//print out listings for that movie at that Cineplex at that date
		
		System.out.println("Choose a Time (HH:MM): ");
		String time = s.next();
		
		String dateTime = date + " " + time;
		//create and try to retrieve listing; if doesn't exist then ask to enter again
		//print seats
		
		System.out.println("Choose a row: ");
		int row = s.nextInt();
		System.out.println("Choose a column: ");
		int col = s.nextInt();
//		6. Ask them to choose a seat.
		//form seat object 
//		6. Ask if they want a set meal.
		System.out.println("Would you like to purchase a set meal? (Y/N): ");
		String input = s.next();
		if(input == "Y") {
			//set set meal
		}
		else if(input == "N") {
			//set set meal
		}
//		7. Ask for their details
//		- Name, Email, Number, Senior Citizen?
		
		System.out.println("Enter your name: ");
		String name = s.next();
		System.out.println("Enter your email address: ");
		String email = s.next();
		System.out.println("Enter your mobile number: ");
		String mobile = s.next();
		System.out.println("Are you over 60 years old? (Y/N): ");
		input = s.next();
		while(input != "Y" || input != "N") {
			System.out.println("Please enter a valid response. ");
			input = s.next();
		}
		if(input == "Y") {
			//set senior citizen
		}
		else if(input == "N") {
			//set senior citizen
		}
		
		System.out.println("Booking has been made. Here are your details: ");
		//print booking details
	}
	
	
	public static boolean adminLogin() {
		System.out.println("Please enter the password: ");
		return false;
		//adminlogincontroller
		
	}
	
	public static void userModule() {
		showUserMenu();
		System.out.println("Enter your choice: ");
		int choice = s.nextInt();
		switch(choice) {
			case(1):
				System.out.println("Enter Movie Name: ");
				String movieName = s.next();
				//moviecontroller - retrievemoviefromdatabase
				//moviecontroller - printmoviedetails
				//moviereviewcontroller - printmoviereviews
				break;
			case(2):
				//moviecontroller choose whether to sort by sales or rating
				//moviecontroller - print all movies
				break;
			case(3):
				bookTicket();
				break;
			case(4):
				checkBookingHistory();
				break;
			default:
				break;
		}
		
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
				//moviecontroller - print all movies
				System.out.println("Enter Movie Name: ");
				String movieName = s.next();
				
				//moviecontroller - retrievemoviefromdatabase
				//add, delete, or update
				//moviecontroller - deletemoviefromdatabase
				//moviecontroller - addmovietodatabase
				//moviecontroller - updatemovieindatabase
				
				break;
			case(2): //Create/Update/Remove cinema showtimes and the movies to be shown
				//ask for cineplex -> movie -> show all listings -> enter a date and time
				//for movie in moviedao -> print all listings for each movie, in order based on cineplex, movie
				//listingocntroller - printalllistings (while same date and movie, print time only)
				//listingcontroller - remove all listings for a specific movie
				//listingcontroller - add listing to database
				//listingcontroller - remove listing from database
				//listingcontroller - update listing in database
				break;
			case(3): //configure system settings 
				//bookingpricecontroller - set meal price, set  discount
				//ticketpricecontroller - set base price, set 3D surcharge, set hol surcharge, set preview surcharge, set senior citizen surcharge, platinum cinema surcharge
				//
				
				break;
			case(4):
				//logout and exit
				break;
			default:
				break;
		}
		
	}
	public static void showUserMenu() {
		System.out.println("1. Search Movies\n" //print movie details
	                     + "2. View Movies\n" //view all movies
						 + "3. Buy Ticket\n" //purchase ticket
						 + "4. View Booking History\n" //print booking history of customer
						 + "5. Exit\n");
		
//		1. Search/List movie
//		2. View movie details – including reviews and ratings
//		3. Check seat availability and selection of seat/s.
//		4. Book and purchase ticket
//		5. View booking history
//		6. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings
	}
	
	public static void showAdminMenu() {
		System.out.println("1. Create/Update/Remove Movie Listing\n" //edit movie
						+ "2. Create/Update/Remove Cinema Showtimes/Available Movies\n" //edit listings
						+ "3. Configure System Settings"//edit all the prices etc 
						+ "4. Logout"); //logout and return to main page
		//1. Login
//		2. Create/Update/Remove movie listing
//		3. Create/Update/Remove cinema showtimes and the movies to be shown
//		4. Configure system settings
	}
	public static void main(String[] args) {
		
		//AdminLogin = new AdminLogin()
		boolean admin = false;
		while(true) {
			System.out.println("Enter '0' for Admin, '1' for Customer, '2' to exit: ");
			int res = s.nextInt();
			switch(res) {
				case(0):
					//invoke adminlogincontroller
					showAdminMenu();
					admin = true;
					break;
				case(1):
					showUserMenu();
					admin = false;
					break;
				case(2):
					return;
				default:
			}
			
			//admin functions
			if(admin == true) {
				while(true) {
					adminModule();
				}
			}
			//user functions
			else if(admin == false) {
				while(true) {
					userModule();
				}
			}
		}
		

	}
	
	

}
