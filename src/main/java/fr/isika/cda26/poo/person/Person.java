package fr.isika.cda26.poo.person;

import fr.isika.cda26.poo.interfaces.BddConstants;

/**
 * Abstract class for all person's role in the pharmacy.
 * @author Thibault SALGUES
 *
 */
public abstract class Person implements BddConstants {
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



}
