package moblima.model;

import java.io.Serializable;

/**
 * Represents a cinema in a particular cineplex.
 */
public class Cinema implements Serializable{
	private static final long serialVersionUID = -2257382588272118502L;
	Cineplex cineplex;
	boolean isPlatinum;
	String code;
	
	 
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + cineplex.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Cinema)) {
            return false;
        }

        Cinema cinema = (Cinema) o;

        return cinema.code.equals(code) &&
                cinema.cineplex.equals(cineplex);
    }
	    
	/**
	 * Constructor for Cinema.
	 * @param cineplex The cineplex this Cinema is located in.
	 * @param isPlatinum Whether this Cinema is Platinum.
	 * @param cinemaCount Number of cinemas in that specific Cineplex.
	 */
	public Cinema(Cineplex cineplex, boolean isPlatinum, int cinemaCount) {
		this.cineplex = cineplex;
		this.isPlatinum = isPlatinum;
		this.code = generateCode(cinemaCount); 
	}
	
	//GETTERS
	/**
	 * Gets the cineplex that this Cinema is located in.
	 * @return cineplex This Cinema's cineplex.
	 */
	public Cineplex getCineplex() {return cineplex;}
	/**
	 * Gets the code for this Cinema.
	 * @return code This Cinema's code.
	 */
	public String getCode() {return code;}
	/**
	 * Gets whether or not this Cinema is Platinum.
	 * @return isPlatinum Whether this Cinema is Platinum.
	 */
	public boolean isPlatinum() {return isPlatinum;}
	
	//SETTERS
	/**
	 * Updates this Cinema's cineplex.
	 * @param cineplex This Cinema's new cineplex.
	 */
	public void setCineplex(Cineplex cineplex) {this.cineplex = cineplex;}
	/**
	 * Updates this Cinema's code.
	 * @param code This Cinema's new code.
	 */
	public void setCode(String code) {this.code = code;}
	/**
	 * Updates this Cinema's Platinum status.
	 * @param isPlatinum This Cinema's new Platinum status.
	 */
	public void isPlatinum(boolean isPlatinum) {this.isPlatinum = isPlatinum;}
	/**
	 * Generates this Cinema's ID code.
	 * @param cinemaCount The number of cinemas in the specific Cineplex.
	 * @return this Cinema's ID code.
	 */
	public String generateCode(int cinemaCount) {
		int curr = cinemaCount;
		String res = this.cineplex.getCode() + "0" + Integer.toString(curr);
		return res;
		
	}
}
