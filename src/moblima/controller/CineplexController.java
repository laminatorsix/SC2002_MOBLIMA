package moblima.controller;
import moblima.model.Cineplex;
import moblima.dao.CineplexDao;

/**
 * Controller for Cineplex class.
 * Mostly to read and write to database.
 */
public class CineplexController {
	private Cineplex model;
	private CineplexDao dao;
	
	/**
	 * Default constructor for CineplexController.
	 */
	public CineplexController() {
		this.dao = new CineplexDao();
	}
	/**
	 * Returns current Cineplex.
	 * @return model.
	 */
	public Cineplex getCurrentCineplex() {
		return model;
	}
	/**
	 * Retrieves cineplex from database.
	 * @param name Name of cineplex.
	 * @return true if cineplex exists.
	 */
	public boolean getNewCineplex(String name) {
		Cineplex cine = dao.getCineplex(name);
		if(cine == null)
			return false;
		model = cine;
		return true;
	}
	/**
	 * Prints all cineplexes.
	 */
	public void printAllCineplexes() {
		dao.printAll();
		System.out.println();
	}
	/**
	 * Prints all Cineplexes by name.
	 */
	public void printAllCineplexNames() {
		dao.printAllNames();
		System.out.println();
	}
	/**
	 * Updates database.
	 */
	public void close() {
		dao.end();
	}
}
