package moblima.model;

import java.io.Serializable;

/** 
 * Represents a Moviegoer.
 */
public class Moviegoer implements Serializable{
	private static final long serialVersionUID = -7774634211972681136L;
	private String name;
	private String mobile;
	private String email;
	private boolean isSeniorCitizen;
	
	/**
	 * Constructor for Moviegoer.
	 * @param name
	 * @param mobile
	 * @param email
	 * @param isSeniorCitizen
	 */
	public Moviegoer(String name, String mobile, String email, boolean isSeniorCitizen) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.isSeniorCitizen = isSeniorCitizen;
	}
	//GETTERS
	/**
	 * Gets the name of this Moviegoer.
	 * @return this Moviegoer's name.
	 */
	public String getName() {return name;}
	/**
	 * Gets the mobile number of this Moviegoer.
	 * @return this Moviegoer's mobile number.
	 */
	public String getMobile() {return mobile;}
	/**
	 * Gets the email of this Moviegoer.
	 * @return this Moviegoer's email.
	 */
	public String getEmail() {return email;}
	/**
	 * Checks whether this Moviegoer is a senior citizen.
	 * @return whether this Moviegoer is a senior citizen.
	 */
	public boolean isSeniorCitizen() {return isSeniorCitizen;}
	
	//SETTERS
	/**
	 * Updates the name of this Moviegoer.
	 * @param name This Moviegoer's name.
	 */
	public void setName(String name) {this.name = name;}
	/**
	 * Updates the mobile number of this Moviegoer.
	 * @param mobile This Moviegoer's mobile number.
	 */
	public void setMobile(String mobile) {this.mobile = mobile;}
	/**
	 * Updates the email of this Moviegoer.
	 * @param email This Moviegoer's email.
	 */
	public void setEmail(String email) {this.email = email;}
	/**
	 * Updates whether this Moviegoer is a senior citizen.
	 * @param isSeniorCitizen Whether this Moviegoer is a senior citizen.
	 */
	public void isSeniorCitizen(boolean isSeniorCitizen) {this.isSeniorCitizen = isSeniorCitizen;}
}

