package moblima.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import moblima.model.Moviegoer;

public class MoviegoerDao implements Dao<Moviegoer>{
	List<Moviegoer> moviegoers;
	/**
	 * Constructor for MoviegoerDAO.
	 */
	@SuppressWarnings("unchecked")
	public MoviegoerDao() {
		moviegoers = (ArrayList)SerializeDB.readSerializedObject("data/moviegoer.dat");
		if(moviegoers == null) {
			List<Moviegoer> a = new ArrayList<>();
			moviegoers = a;
		}
	}
	
	/**
	 * Retrieves Moviegoer from moviegoer.dat based on index.
	 * @param id Index of this Moviegoer in list.
	 */
	@Override
	public Optional<Moviegoer> get(long id){
		return Optional.ofNullable(moviegoers.get((int) id));
	}
	
	/**
	 * Retrieves all Moviegoers from moviegoer.dat
	 * @return list of Moviegoers.
	 */
	@Override
    public List<Moviegoer> getAll(){
		return moviegoers;
	}
    
	
	/**
	 * Adds a Moviegoer.
	 * @param moviegoer The Moviegoer to be added.
	 */
	@Override
    public void add(Moviegoer moviegoer) {
		if(moviegoers != null && moviegoers.contains(moviegoer)) {
			moviegoers.remove(moviegoer);
		}
		moviegoers.add(moviegoer);
	}
	
	/**
	 * Retrieves an existing moviegoer.
	 * @param email
	 * @param mobile
	 * @return
	 */
	public Moviegoer retrieveMoviegoer(String email, String mobile) {
		for(int i = 0; i < moviegoers.size(); i++) {
			Moviegoer m = (Moviegoer)moviegoers.get(i);
			if(email.equals(m.getEmail()) || mobile.equals(m.getMobile())) {
				return m;
			}
		}
		return null;
	}
	/**
	 * Checks if a Moviegoer exists.
	 * @param email
	 * @param mobile
	 * @return
	 */
	public boolean checkMoviegoerExists(String email, String mobile) {
		for(int i = 0; i < moviegoers.size(); i++) {
			Moviegoer m = (Moviegoer)moviegoers.get(i);
			if(email.equals(m.getEmail()) || mobile.equals(m.getMobile())) {
				return true;
			}
		}
		return false;
	}
    
	/**
	 * Deletes a Moviegoer from moviegoer.dat
	 * @param moviegoer The Moviegoer to be deleted.
	 * 
	 */
	@Override
    public void delete(Moviegoer moviegoer) {
		if(moviegoers != null && moviegoers.contains(moviegoer)) {
			moviegoers.remove(moviegoer);
		}
	};
	
	/**
	 * Writes updated data to moviegoer.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/moviegoer.dat", moviegoers);
	}
}

