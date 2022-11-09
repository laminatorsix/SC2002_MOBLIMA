package moblima.dao;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import moblima.model.Holiday;
import moblima.model.DateTime;

public class HolidaysDao implements Dao<Holiday>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8445600784490139362L;
	List<Holiday> holidays;
	/**
	 * Constructor for HolidaysDAO.
	 */
	@SuppressWarnings("unchecked")
	public HolidaysDao() {
		holidays = (ArrayList)SerializeDB.readSerializedObject("data/holidays.dat");
		if(holidays == null) {
			List<Holiday> a = new ArrayList<>();
			holidays = a;
		}
	}
	
	/**
	 * Retrieves Holiday from holidays.dat based on index.
	 * @param id Index of this Holiday in list.
	 */
	@Override
	public Optional<Holiday> get(long id){
		return Optional.ofNullable(holidays.get((int) id));
	}
	
	/**
	 * Retrieves all Holidays from holidays.dat
	 * @return list of Holidays.
	 */
	@Override
    public List<Holiday> getAll(){
		return holidays;
	}
    
	/**
	 * Retrieves Holiday from Database.
	 * @param name
	 * @return
	 */
	public Holiday getHoliday(String name) {
		for(int i = 0; i < holidays.size(); i++) {
			Holiday c = (Holiday)holidays.get(i);
			if(c.getName().equals(name))
				return c;
		}
		return null;
	}
	/**
	 * Checks if a particular date is a holiday.
	 * @param dt DateTime object.
	 * @return Whether it is a holiday.
	 */
	public boolean checkHoliday(DateTime dt) {
		for(int i = 0; i < holidays.size(); i++) {
			Holiday c = (Holiday)holidays.get(i);
			if(dt.getDate().equals(c.getDate())) 
				return true;
		}
		return false;
	}
	/**
	 * Prints all Holidays.
	 * @return success
	 */
	public boolean printAll() {
		if(holidays.size() == 0)
			return false;
		for(int i = 0; i < holidays.size(); i++) {
			Holiday c = (Holiday)holidays.get(i);
			System.out.println("Name: " + c.getName());
			System.out.println("Date: " + c.getDate());
			System.out.println();
		}
		return true;
	}
	
	/**
	 * Adds a Holiday to holidays.dat.
	 * @param holiday The Holiday to be added.
	 */
	@Override
    public void add(Holiday holiday) {
		if(holidays != null && holidays.contains(holiday)) {
			holidays.remove(holiday);
		}
		holidays.add(holiday);
	}
    
	/**
	 * Deletes a Holiday from holidays.dat
	 * @param holiday The Holiday to be deleted.
	 * 
	 */
	@Override
    public void delete(Holiday holiday) {
		if(holidays != null && holidays.contains(holiday)) {
			holidays.remove(holiday);
		}
	};
	
	/**
	 * Clears all holidays.
	 */
	public void clear() {
		holidays.clear();
	}
	/**
	 * Writes updated data to holidays.dat
	 */
	public void end() {
		SerializeDB.writeSerializedObject("data/holidays.dat", holidays);
	}
}
