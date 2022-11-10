package moblima.model;

import java.io.Serializable;

/**
 * Represents a holiday.
 */
public class Holiday implements Serializable{
	private static final long serialVersionUID = -3680580361932733139L;
	private DateTime dateTime;
	private String name;
	
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + dateTime.getDate().hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Holiday)) {
            return false;
        }

        Holiday holiday = (Holiday) o;

        return holiday.dateTime.getDate().equals(dateTime.getDate()) &&
                holiday.name.equals(name);
    }
	
	
	/**
	 * Constructor for Holiday.
	 * @param year
	 * @param day
	 * @param month
	 * @param name Holiday name.
	 */
	public Holiday(int year, int day, int month, String name) {
		this.dateTime = new DateTime(year, day, month);
		this.name = name;
	}
	/**
	 * Gets date of this holiday (string).
	 * @return
	 */
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
