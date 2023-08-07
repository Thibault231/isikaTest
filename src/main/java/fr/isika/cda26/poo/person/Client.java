package fr.isika.cda26.poo.person;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.invoice.Invoice;
import fr.isika.cda26.poo.mutual.HealthMutual;

/**
 * Client of the pharmacy. Heritage from Person.
 * @author Thibault SALGUES
 *
 */
public class Client extends Person {
	
//********************************** ATTRIBUTS *****************************************
	private List<Invoice> invoicesList;
	private Doctor mainDoctor;
	private HealthMutual firstMutual;
	private HealthMutual complementaryMutual;


//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 * @param invoicesList
	 * @param firstMutual
	 * @param complementaryMutual
	 */
	public Client(String name, String forename, int telNumber, String city, int postalindex, Doctor mainDoctor,
			HealthMutual firstMutual, HealthMutual complementaryMutual) {
		super(name, forename, telNumber, city, postalindex);
		this.invoicesList = new ArrayList<Invoice>();
		this.mainDoctor = mainDoctor;
		this.firstMutual = firstMutual;
		this.complementaryMutual = complementaryMutual;
	}
	
}
