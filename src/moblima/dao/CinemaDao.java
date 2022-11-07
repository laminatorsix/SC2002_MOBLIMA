package moblima.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import moblima.model.*;

/**
 * DAO Interface for Cinema.
 * Reads and writes to "data/cinema.dat".
 *
 */
public class CinemaDao implements Dao<Cinema>{
	List<Cinema> cinemas;
	/**
	 * Constructor for CinemaDAO.
	 */
	@SuppressWarnings("unchecked")
	public CinemaDao() {
		cinemas = (ArrayList)SerializeDB.readSerializedObject("data/cinema.dat");
		if(cinemas == null) {
			List<Cinema> a = new ArrayList<>();
			cinemas = a;
		}
	}
	
	/**
	 * Retrieves Cinema from cinema.dat based on index.
	 * @param id Index of this Cinema in list.
	 */
	@Override
	public Optional<Cinema> get(long id){
		return Optional.ofNullable(cinemas.get((int) id));
	}
	
	/**
	 * Retrieves all Cinemas from cinema.dat
	 * @return list of cinemas.
	 */
	@Override
    public List<Cinema> getAll(){
		return cinemas;
	}
    /**
     * Prints all cinemas.
     */
	public void printAll() {
		for(int i = 0; i < cinemas.size(); i++) {
			Cinema c = (Cinema)cinemas.get(i);
			System.out.println("Cineplex: " + c.getCineplex().getName());
			System.out.println("Code: " + c.getCode());
			System.out.println("Cinema: " + "Hall " + c.getCode().substring(c.getCode().length()-1));
		}
	}
	//print all cinemas at cineplex
	/**
	 * Prints all Cinemas available at a specific Cineplex.
	 * @param cineplex The Cineplex containing the Cinemas.
	 */
	public void printAllAtCineplex(Cineplex cineplex) {
		for(int i = 0; i < cinemas.size(); i++) {
			Cinema c = (Cinema)cinemas.get(i);
			if(c.getCineplex() == cineplex) {
				System.out.println("Cinema: " + "Hall " + c.getCode().substring(c.getCode().length()-1));
			}
			
		}
	}
	
	/**
	 * Gets the cinema count for a certain cineplex.
	 * @param cineplex
	 * @return cinema count.
	 */
	public int getCinemaCount(Cineplex cineplex) {
		int count = 0;
		for(int i = 0; i < cinemas.size(); i++) {
			Cinema c = (Cinema)cinemas.get(i);
			if(c.getCineplex().getName().equals(cineplex.getName())) {
				count++;
			}
		}
		return count;
	}
	/**
	 * Gets a certain cinema based on its code.
	 * @param code
	 * @return cinema
	 */
	public Cinema getCinema(Cineplex cineplex, String code) {
		for(int i = 0; i < cinemas.size(); i++) {
			Cinema c = (Cinema)cinemas.get(i);
			
			if(c.getCode().equals(code) && c.getCineplex().getName().equals(cineplex.getName())) {
				return c;
			}
		}
		return null;
	}
	/**
	 * Adds a Cinema to cinema.dat.
	 * @param cinema The Cinema to be added.
	 */
	@Override
    public void add(Cinema cinema) {
		if(cinemas != null && cinemas.contains(cinema)) {
			cinemas.remove(cinema);
		}
		cinemas.add(cinema);
	}
    
	/**
	 * Deletes a Cinema from cinema.dat
	 * @param cinema The Cinema to be deleted.
	 * 
	 */
	@Override
    public void delete(Cinema cinema) {
		if(cinemas != null && cinemas.contains(cinema)) {
			cinemas.remove(cinema);
		}
	};
	/**
	 * Deletes all cinemas.
	 */
	public void deleteAll() {
		cinemas.clear();
	}
	/**
	 * Writes updated data to cinema.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/cinema.dat", cinemas);
	}
	
}
