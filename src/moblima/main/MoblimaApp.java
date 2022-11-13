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
		boolean cont = true;
		int res;
		int filter = 0;
		//AdminLogin = new AdminLogin()
		int admin = -1;
		while(cont) {
			System.out.println("Enter '0' for Admin, '1' for Customer, '2' to exit: ");
			res = Integer.parseInt(s.nextLine());
			switch(res) {
				case 0:
					if(!Admin.adminLogin()) {
						break;
					}
						
					admin = 1;
					break;
				case 1:
					admin = 0;
					break;
				default:
					cont = false;
					break;
			}
			
			if(admin == -1) {
				continue;
			}
				
			if(admin == 1) {
				Admin.initialise();
				while(Admin.returnCont()) {
					Admin.adminModule();
					filter = Admin.getFilter();
				}
				Admin.end();
				
			}
			//user functions
			else if(admin == 0) {
				User.initialise();
				System.out.println("Filter: " + filter);
				User.setFilter(filter);
				while(User.returnCont()) {
					User.userModule();
				}
				User.end();
				
			}
			
			admin = -1;
			Admin.setCont();
			User.setCont();
			System.out.println("Exited.");
		}
		
		
		System.out.println("End of program.");
	}
	
	

}
