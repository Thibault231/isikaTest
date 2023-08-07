package fr.isika.cda26.poo.pharmacy;

import java.util.List;

import fr.isika.cda26.poo.mutual.HealthMutual;
import fr.isika.cda26.poo.person.Client;
import fr.isika.cda26.poo.person.Doctor;
import fr.isika.cda26.poo.stock.Stock;

/**
 * Pharmacy generate as a real shop.
 * @author LENOVO
 *
 */
public final class Pharmacy {

//********************************** ATTRIBUTS *****************************************
	private String name;
	private String owner;
	private Stock stock;
	private List<Client> clientsList;
	private List<Doctor> doctorsList;
	private List<HealthMutual> mutualList;
	
//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor
	 * @param name
	 * @param owner
	 * @param stock
	 * @param clientsList
	 * @param doctorsList
	 * @param mutualList
	 */
	public Pharmacy(String name, String owner, Stock stock, List<Client> clientsList, List<Doctor> doctorsList,
			List<HealthMutual> mutualList) {
		this.name = name;
		this.owner = owner;
		this.stock = stock;
		this.clientsList = clientsList;
		this.doctorsList = doctorsList;
		this.mutualList = mutualList;
	}
	
	

}
