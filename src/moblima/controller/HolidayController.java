package moblima.controller;
import moblima.model.Holiday;
import moblima.dao.HolidaysDao;


public class HolidayController {
	private Holiday model;
	private HolidaysDao dao;
	
	/**
	 * Default constructor for HolidayController.
	 */
	public HolidayController() {
		this.dao = new HolidaysDao();
	}
	/**
	 * Retrieves holiday from database.
	 * @param name
	 * @return success.
	 */
	public boolean getNewHol(String name) {
		this.model = dao.getHoliday(name);
		if(model == null)
			return false;
		return true;
	}
	/**
	 * Creates new holiday.
	 * @param name
	 * @param date
	 * @return success
	 */
	public boolean setNewHol(String name, String date) {
		int year, day, month;
		String[] dateArr;
		if(date.length() != 10)
			return false;
		
		dateArr = date.split("/");
		year = Integer.parseInt(dateArr[0]);
		month = Integer.parseInt(dateArr[1]);
		day = Integer.parseInt(dateArr[2]);
		this.model = new Holiday(year, day, month, name);
		return true;
	}
	/**
	 * Add holiday to database.
	 */
	public void addHol() {
		dao.add(model);
	}
	/**
	 * Remove holiday from database.
	 */
	public void deleteHol() {
		dao.delete(model);
	}
	/**
	 * Prints all holidays
	 * @return success.
	 */
	public boolean printAllHolidays() {
		return dao.printAll();
	}
	/**
	 * Clears all holidays.
	 */
	public void reset() {
		dao.clear();
	}
	/**
	 * Updates database.
	 */
	public void close() {
		dao.end();
	}
}
