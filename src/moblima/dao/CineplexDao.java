package moblima.dao;
import moblima.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CineplexDao implements Dao<Cineplex>{
	List<Cineplex> cineplexes;
	/**
	 * Constructor for CineplexDAO.
	 */
	@SuppressWarnings("unchecked")
	public CineplexDao() {
		cineplexes = (ArrayList)SerializeDB.readSerializedObject("data/cineplex.dat");
		if(cineplexes == null) {
			List<Cineplex> a = new ArrayList<>();
			cineplexes = a;
		}
	}
	
	/**
	 * Retrieves Cineplex from cineplex.dat based on index.
	 * @param id Index of this Cineplex in list.
	 */
	@Override
	public Optional<Cineplex> get(long id){
		return Optional.ofNullable(cineplexes.get((int) id));
	}
	
	/**
	 * Retrieves all Cineplexes from cineplex.dat
	 * @return list of cineplexes.
	 */
	@Override
    public List<Cineplex> getAll(){
		return cineplexes;
	}
    
	/**
	 * Retrieves Cineplex by Name.
	 * @param name Name of Cineplex.
	 * @return Cineplex.
	 */
	public Cineplex getCineplex(String name){
		for(int i = 0; i < cineplexes.size(); i++) {
			Cineplex c = (Cineplex)cineplexes.get(i);
			if(name.toLowerCase().equals(c.getName().toLowerCase())) {
				return c;
			}
		}
		return null;
	}
	
	
	/**
	 * Prints all Cineplexes.
	 */
	public void printAll() {
		for(int i = 0; i < cineplexes.size(); i++) {
			Cineplex c = (Cineplex)cineplexes.get(i);
			System.out.println("Cineplex: " + c.getName());
			System.out.println("Code: " + c.getCode());
			System.out.println();
		}
	}
	/**
	 * Prints all Cineplex names.
	 */
	public void printAllNames() {
		for(int i = 0; i < cineplexes.size(); i++) {
			Cineplex c = (Cineplex)cineplexes.get(i);
			System.out.println(c.getName());
		}
	}
	/**
	 * Gets number of cineplexes.
	 * @return number of cineplexes.
	 */
	public int getCineplexCount() {
		return cineplexes.size();
	}
	/**
	 * Adds a Cineplex to cineplex.dat.
	 * @param cineplex The Cineplex to be added.
	 */
	@Override
    public void add(Cineplex cineplex) {
		if(cineplexes != null && cineplexes.contains(cineplex)) {
			cineplexes.remove(cineplex);
		}
		cineplexes.add(cineplex);
	}
    
	/**
	 * Deletes a Cineplex from cineplex.dat
	 * @param cineplex The Cineplex to be deleted.
	 * 
	 */
	@Override
    public void delete(Cineplex cineplex) {
		if(cineplexes != null && cineplexes.contains(cineplex)) {
			cineplexes.remove(cineplex);
		}
	};
	
	/**
	 * Writes updated data to movie.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/cineplex.dat", cineplexes);
	}
}
