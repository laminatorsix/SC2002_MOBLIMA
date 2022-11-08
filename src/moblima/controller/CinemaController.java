package moblima.controller;
import moblima.model.Cinema;
import moblima.model.Cineplex;
import moblima.dao.CinemaDao;

/**
 * Represents controller for Cinema.
 * Mostly reads and writes to cinema database.
 *
 */
public class CinemaController {
	private Cinema model;
	private CinemaDao dao;
	
	/**
	 * Default constructor for CinemaController.
	 */
	public CinemaController() {
		this.dao = new CinemaDao();
	}
	/**
	 * Returns current Cinema object.
	 * @return model.
	 */
	public Cinema getCurrentCinema() {
		return model;
	}
	/**
	 * Retrieves Cinema from database.
	 * @param cineplex
	 * @param code
	 * @return
	 */
	public boolean getNewCinema(Cineplex cineplex, String code) {
		Cinema c = dao.getCinema(cineplex, code);
		if(c == null)
			return false;
		this.model = c;
		return true;
	}
	
	/**
	 * Updates database.
	 */
	public void close() {
		dao.end();
	}
}
