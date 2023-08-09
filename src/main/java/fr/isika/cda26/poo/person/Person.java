package fr.isika.cda26.poo.person;

import fr.isika.cda26.poo.db.ObjectOfDB;
import fr.isika.cda26.poo.interfaces.BddConstants;

/**
 * Abstract class for all person's role in the pharmacy.
 * @author Thibault SALGUES
 *
 */
public abstract class Person extends ObjectOfDB implements BddConstants {
//********************************** ATTRIBUTS *****************************************
	protected String name;
	protected String forename;
	protected int telNumber;
	protected String city;
	protected int postalindex;

	
//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 */
	public Person(String name, String forename, int telNumber, String city, int postalindex) {
		this.name = name;
		this.forename = forename;
		this.telNumber = telNumber;
		this.city = city;
		this.postalindex = postalindex;
	}

//********************************** GUETTERS / SETTERS ***********************************
	/**
	 * Setter for name attribute.
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Getter for name attribute.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Setter for forname attribute.
	 * @return the forename
	 */
	public String getForename() {
		return forename;
	}


	/**
	 * Getter for forname attribute.
	 * @param forename the forename to set
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}


	/**
	 * Setter for telNumber attribute.
	 * @return the telNumber
	 */
	public int getTelNumber() {
		return telNumber;
	}


	/**
	 * Getter for telNulber attribute.
	 * @param telNumber the telNumber to set
	 */
	public void setTelNumber(int telNumber) {
		this.telNumber = telNumber;
	}


	/**
	 * Setter for city attribute.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * Getter for city attribute.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * Setter for postalIndex attribute.
	 * @return the postalindex
	 */
	public int getPostalindex() {
		return postalindex;
	}


	/**
	 * Setter for postalIndex attribute.
	 * @param postalindex the postalindex to set
	 */
	public void setPostalindex(int postalindex) {
		this.postalindex = postalindex;
	}


}
