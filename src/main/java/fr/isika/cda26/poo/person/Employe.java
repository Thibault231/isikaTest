package fr.isika.cda26.poo.person;

public class Employe extends Person {
	
//********************************** ATTRIBUTS *****************************************
	private String function;


//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 * @param function
	 */
	public Employe(String name, String forename, int telNumber, String city, int postalindex, String function) {
		super(name, forename, telNumber, city, postalindex);
		this.function = function;
	}

}
