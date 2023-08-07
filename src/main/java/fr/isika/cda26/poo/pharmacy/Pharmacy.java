package fr.isika.cda26.poo.pharmacy;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.mutual.HealthMutual;
import fr.isika.cda26.poo.person.Client;
import fr.isika.cda26.poo.person.Doctor;
import fr.isika.cda26.poo.stock.Stock;

/**
 * Pharmacy generate as a real shop.
 * @author Thibault SALGUES
 *
 */
public final class Pharmacy {

//********************************** ATTRIBUTS *****************************************
	private String name;
	private String owner;
	private Stock stock;
	private List<Client> clientsList;
	private List<Doctor> doctorsList;
	private List<HealthMutual> mutualsList;
	
//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor
	 * @param name
	 * @param owner
	 * @param stock
	 * @param clientsList
	 * @param doctorsList
	 * @param mutualsList
	 */
	public Pharmacy(String name, String owner) {
		this.name = name;
		this.owner = owner;
		this.stock = new Stock();
		this.clientsList = new ArrayList<Client>();
		this.doctorsList = new ArrayList<Doctor>();
		this.mutualsList = new ArrayList<HealthMutual>();
	}

	
//********************************** OVERRIDEN METHODS **********************************
	/**
	 * Overriden from MotherClass: Present myAt attribute of the object.
	 * 
	 * @return (: String)
	 */
	@Override
	public String toString() {
		return "Pharmacy [name=" + name + ", owner=" + owner + ", stock=" + stock + ", clientsList=" + clientsList
				+ ", doctorsList=" + doctorsList + ", mutualList=" + mutualsList + "]";
	}

//********************************** SPECIFIC PUBLIC METHODS ****************************	
	/**
	 * Add a new client to the pharmacy and write it in the DB.
	 * @param newClient
	 */
	public void addNewClient(Client newClient) {
		clientsList.add(newClient);
		System.out.println("New client added to the clients list.");
	}
	
	/**
	 *  Add a new doctor to the pharmacy and write it in the DB.
	 * @param newDoctor
	 */
	public void addNewDoctor(Doctor newDoctor) {
		doctorsList.add(newDoctor);
		System.out.println("New doctor added to the doctors list.");
	}
	
	/**
	 *  Add a new mutual to the pharmacy and write it in the DB.
	 * @param newMutual
	 */
	public void addNewMutual(HealthMutual newMutual) {
		mutualsList.add(newMutual);
		System.out.println("New mutual added to the mutuals list.");
	}
}
