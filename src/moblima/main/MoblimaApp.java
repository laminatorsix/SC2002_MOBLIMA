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
	
	
	
	
	

	
	
	public static void main(String[] args) {
		
		//AdminLogin = new AdminLogin()
		boolean admin = false;
		while(true) {
			System.out.println("Enter '0' for Admin, '1' for Customer, '2' to exit: ");
			int res = s.nextInt();
			switch(res) {
				case(0):
					//invoke adminlogincontroller
					Admin.showAdminMenu();
					admin = true;
					break;
				case(1):
					User.showUserMenu();
					admin = false;
					break;
				case(2):
					return;
				default:
			}
			
			//admin functions
			if(admin == true) {
				while(true) {
					Admin.adminModule();
				}
			}
			//user functions
			else if(admin == false) {
				while(true) {
					User.userModule();
				}
			}
		}
		

	}
	
	

}
