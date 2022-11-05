package moblima.model;

/**
 * Represents a cineplex.
 * One cineplex contains several cinemas.
 */
public class Cineplex {
	private static String lastCode = "0";
	private int cinemaCount;
	private String name;
	private String code;
	
	/**
	 * Constructor for Cineplex.
	 * @param name This Cineplex's name.
	 * @param code This Cineplex's ID code.
	 */
	public Cineplex(String name, String code) {
		this.name = name;
		this.code = code;
		lastCode = code;
		cinemaCount = 0;
	}
	
	//GETTERS
	/**
	 * Gets the name of this Cineplex.
	 * @return this Cineplex's name.
	 */
	public String getName() {return name;}
	/**
	 * Gets the ID code of this Cineplex.
	 * @return this Cineplex's ID code.
	 */
	public String getCode() {return code;}
	
	/**
	 * Gets the cinema count of this Cineplex.
	 * @return this Cineplex's cinema count.
	 */
	public int getCinemaCount() {return cinemaCount;}
	
	//SETTERS
	/**
	 * Updates the name of this Cineplex.
	 * @param name This Cineplex's name.
	 */
	public void setName(String name) {this.name = name;}
	/**
	 * Updates the ID code of this Cineplex.
	 * @param code This Cineplex's ID code.
	 */
	public void setCode(String code) {this.code = code;}
	
	public void incrementCinemaCount() {this.cinemaCount += 1;}
	
	/**
	 * Generates ID code of this Cineplex.
	 * @return This Cineplex's generated ID code.
	 */
	public String generateCode() {
		int curr = Integer.parseInt(lastCode) + 1;
		return Integer.toString(curr);
	}
}
