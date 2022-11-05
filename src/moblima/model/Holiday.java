package moblima.model;

/**
 * Represents a holiday.
 */
public class Holiday {
	private DateTime dateTime;
	private String name;
	
	
	/**
	 * Constructor for Holiday.
	 * @param dateTime
	 */
	public Holiday(DateTime dateTime, String name) {
		this.dateTime = dateTime;
		this.name = name;
	}
	
	public String getDate() {return dateTime.getDate();}
	/**
	 * Gets DateTime of this Holiday.
	 * @return this Holiday's DateTime.
	 */
	public DateTime getDTObj() {return dateTime;}
	
	/**
	 * Gets name of this Holiday.
	 * @return this Holiday's name.
	 */
	public String getName() {return name;}
	/**
	 * Updates date of this Holiday.
	 * @param dateTime This Holiday's date.
	 */
	public void setDateTime(DateTime dateTime) {this.dateTime = dateTime;}
	/**
	 * Updates name of this Holiday.
	 * @param name This Holiday's name.
	 */
	public void setName(String name) {this.name = name;}
}
