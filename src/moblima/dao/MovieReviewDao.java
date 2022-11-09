package moblima.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import moblima.view.*;

import moblima.model.*;

/**
 * Reads from and writes to movie_reviews.dat
 * 
 *
 */
public class MovieReviewDao implements Dao<MovieReview>{
	@SuppressWarnings("unchecked")
	List<MovieReview> movieReviews;
	MovieReviewView v = new MovieReviewView();
	//List<MovieReview> movieReviewsSpecific;
	MovieDao movieDao;
	/**
	 * Constructor for MovieReviewDao
	 */
	public MovieReviewDao() {
		movieReviews = (ArrayList)SerializeDB.readSerializedObject("data/movie_reviews.dat");
		movieDao = new MovieDao();
		//Initialize if empty
		if(movieReviews == null) {
			List<MovieReview> a = new ArrayList<>();
			movieReviews = a; 
		}
	}
	
	@Override
	public Optional<MovieReview> get(long id){
		return Optional.ofNullable(movieReviews.get((int) id));
	}
	
	@Override
	public List<MovieReview> getAll(){
		return movieReviews;
	}
	
	/**
	 * Print all movie reviews for a movie (Sorted)
	 * @param movie
	 */
	public void printAll(Movie movie){
		for(int i = 0; i < movieReviews.size(); i++) {
			MovieReview m = (MovieReview)movieReviews.get(i);
			if(m.getMovie().getName().equals(movie.getName())) {
				v.printMovieReview(m.getRating(), m.getContent(), m.getTime());
				System.out.println();
			}
			
			
		}
	}
	
	//update overall rating and update movie stats
	@Override
	public void add(MovieReview movieReview) {
		movieReviews.add(movieReview);
		
		movieDao.updateRating(movieReview.getMovie(), movieReview.getRating(), true);
	}
	
	//update overall rating
	@Override
	public void delete(MovieReview movieReview) {
		if(movieReviews!= null && movieReviews.contains(movieReview)) {
			movieReviews.remove(movieReview);
		}
		movieDao.updateRating(movieReview.getMovie(), movieReview.getRating(), false);
		
	}
	/**
	 * Clears all movie reviews.
	 */
	public void clear() {
		movieReviews.clear();
	}
	/**
	 * Updates database.
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/movie_reviews.dat", movieReviews);
		movieDao.end();
	}
	//UPDATES
//	public void update(Movie MovieReview, int i, String n) {
//		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
//		switch(i) {
//			case 0:
//				m.setName(n);
//				break;
//			case 1:
//				m.setDesc(n);
//				break;
//		}
//		SerializeDB.writeSerializedObject("data/movie.dat", movies);
//	}
//	
//	public void update(Movie movie, String[] c) {
//		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
//		movie.setCast(c);
//		SerializeDB.writeSerializedObject("data/movie.dat", movies);
//	}
//	
//	public void update(Movie movie, MovieStatus s) {
//		Movie m = (Movie)(movies.get(movies.indexOf(movie)));
//		movie.setStatus(s);
//		if(s == MovieStatus.ENDOFSHOWING)
//			movies.remove(m);
//		SerializeDB.writeSerializedObject("data/movie.dat", movies);
//		
//	}
	
	
}
