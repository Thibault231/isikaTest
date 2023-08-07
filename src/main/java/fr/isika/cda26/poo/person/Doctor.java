package fr.isika.cda26.poo.person;

/**
 * Doctor of clients. Heritage from Person.
 * @author Thibault SALGUES
 *
 */
public class Doctor extends Person {

//********************************** ATTRIBUTS *****************************************
	private String speciality;

//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 * @param speciality
	 */
	public Doctor(String name, String forename, int telNumber, String city, int postalindex, String speciality) {
		super(name, forename, telNumber, city, postalindex);
		this.speciality = speciality;
	}
	
	

}
