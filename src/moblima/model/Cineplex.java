package moblima.model;

import java.io.Serializable;

/**
 * Represents a cineplex.
 * One cineplex contains several cinemas.
 */
public class Cineplex implements Serializable{
	private static final long serialVersionUID = 7106053299717003889L;
	private String name;
	private String code;
	
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Cineplex)) {
            return false;
        }

        Cineplex cineplex = (Cineplex) o;

        return cineplex.code.equals(code) &&
                cineplex.name.equals(name);
    }
	
	/**
	 * Constructor for Cineplex.
	 * @param name This Cineplex's name.
	 * @param count The total number of Cineplexes so far.
	 */
	public Cineplex(String name, int count) {
		this.name = name;
		this.code = generateCode(count);
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
	
	
	/**
	 * Generates ID code of this Cineplex.
	 * @return This Cineplex's generated ID code.
	 */
	public String generateCode(int count) {
		int curr = count + 1;
		return Integer.toString(curr);
	}
}
