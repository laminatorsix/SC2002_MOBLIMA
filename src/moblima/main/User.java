package moblima.main;

import java.util.Scanner;
import moblima.controller.*;

public class User {
	private static Scanner s = new Scanner(System.in);
	
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
	
	public static void userModule() {
		User.showUserMenu();
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
				User.bookTicket();
				break;
			case(4):
				User.checkBookingHistory();
				break;
			default:
				break;
		}
		
	}
	
	public static void showMovieDetails() {
		
	}
	public static void showAllMovies() {
		
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
	
	public static void checkBookingHistory() {
		System.out.println("Enter your email address or mobile number: ");
		String emailMobile;
		//try retrieve customer from database
		//check if email or number exists
		
		//print booking history
	}
}
