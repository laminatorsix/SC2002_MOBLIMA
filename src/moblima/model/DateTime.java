package moblima.model;
import java.io.Serializable;
import java.time.*;  
import java.time.format.DateTimeFormatter;
import moblima.dao.HolidaysDao;

/**
 * Retrieves date and time.
 *
 */
public class DateTime implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4989624435897943505L;
	private static DateTimeFormatter datef = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private static DateTimeFormatter timef = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private LocalDate date;
	private LocalTime time;
	private String dtString;
	private String tString;
	private String dString;
	private int dayOfWeek;
	private boolean isHoliday;
	
	private HolidaysDao h;
	/**
	 * Constructor for DateTime.
	 * Retrieves current date and time.
	 */
	public DateTime() {
		h = new HolidaysDao();
		date = LocalDate.now();
		time = LocalTime.now();
		
		dString = date.format(datef);
		tString = time.format(timef);
		dayOfWeek = date.getDayOfWeek().getValue();
		dtString = dString + " " + tString;
		isHoliday = h.checkHoliday(this);
		
	}
	
	/**
	 * Constructor for DateTime.
	 * Sets a specific date and time.
	 * @param year
	 * @param day
	 * @param month
	 * @param hours
	 * @param minutes
	 */
	public DateTime(int year, int day, int month, int hours, int minutes) {
		h = new HolidaysDao();
		date = LocalDate.of(year, month, day);
		time = LocalTime.of(hours, minutes, 0);
		
		dString = date.format(datef);
		tString = time.format(timef);
		dayOfWeek = date.getDayOfWeek().getValue();
		dtString = dString + " " + tString;
		isHoliday = h.checkHoliday(this);
		
	}
	/**
	 * Constructor for DateTime.
	 * Only takes in a specific date.
	 * @param year
	 * @param day
	 * @param month
	 */
	public DateTime(int year, int day, int month) {
		date = LocalDate.of(year, month, day);
		dString = date.format(datef);
	}
	
	public DateTime(int year, int day, int month, boolean isHol) {
		date = LocalDate.of(year, month, day);
		dString = date.format(datef);
		this.isHoliday = isHol;
	}
	/**
	 * Gets both date and time.
	 * @return this DateTime's date and time.
	 */
	public String getDateTime() {
		return dtString;
	}
	
	/**
	 * Gets date.
	 * @return this DateTime's date.
	 */
	public String getDate() {
		return dString;
	}
	
	/**
	 * Gets time.
	 * @return this DateTime's time.
	 */
	public String getTime() {
		return tString;
	}
	/**
	 * Gets day of the week.
	 * @return this DateTime's day of the week (int)
	 */
	public int getDay() {
		return dayOfWeek;
	}
	/**
	 * Gets whether it is a holiday.
	 * @return whether this DateTime is a holiday.
	 */
	public boolean isHol() {
		return isHoliday;
		//create new holiday object and invoke holiday dao to add to list
		//to check if is holiday, invoke holidaydao to get holiday and see if exists
		//HolidayDao.add(Holiday
	}
}
