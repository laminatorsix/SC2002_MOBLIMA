package moblima.main;

import java.util.Scanner;
import moblima.model.*;
import moblima.dao.*;

public class TestApp {
	private static Scanner s = new Scanner(System.in);
	
	private static MovieDao movieDao;
	private static ListingsDao listingDao;
	private static CineplexDao cineplexDao;
	private static CinemaDao cinemaDao;

	public static void main(String[] args) {
		movieDao = new MovieDao();
		listingDao = new ListingsDao();
		cineplexDao = new CineplexDao();
		cinemaDao = new CinemaDao();
		
		Cineplex cine1, cine2, cine3;
		Cinema c1, c2, c3;
		boolean p = true;
		
		for(int i = 1; i < 4; i++) {
			cine1 = cineplexDao.getCineplex("JCube");
			cine2 = cineplexDao.getCineplex("Jewel");
			cine3 = cineplexDao.getCineplex("Paya Lebar");
			
			if(i != 1)
				p = false;
			
			c1 = new Cinema(cine1, p, cinemaDao.getCinemaCount(cine1)+1);
			c2 = new Cinema(cine2, p, cinemaDao.getCinemaCount(cine2)+1);
			c3 = new Cinema(cine3, p, cinemaDao.getCinemaCount(cine3)+1);
			
			cinemaDao.add(c1);
			cinemaDao.add(c2);
			cinemaDao.add(c3);
			
			
		}
		
		//cinemaDao.deleteAll();
//		for(int i = 0; i < 3; i++) {
//			
//		}
		
	
		//Cineplex cine1 = new Cineplex("Paya Lebar", cineplexDao.returnCount());
		
		//cineplexDao.add(cine1);
		//Cinema cinema1 = new Cinema()
		//Listing listing1 = new Listing(2022, 6, 3, 17, 30, movie1, )
				//int year, int day, int month, int hours, int minutes, Movie movie, Cinema cinema, boolean is3D
		//listingDao.add(null);
		String[] cast1 = {"Michael Sheen", "David Tennant"};
		Movie movie1 = new Movie("Hi", MovieStatus.NOWSHOWING, "Amazing show", "Douglas Mackinnson", cast1, MovieRating.PG13);
		//movieDao.delete(movie1);
		//movieDao.add(movie1);
		
		//movieDao.delete(movie1);
		//movieDao.delete(movie1);
		//movieDao.printAll();
		cineplexDao.printAll();
		cinemaDao.printAll();
		//movieDao.end();
		cineplexDao.end();
		cinemaDao.end();
		
		System.out.println("Done");
	}
	
	
		
}
