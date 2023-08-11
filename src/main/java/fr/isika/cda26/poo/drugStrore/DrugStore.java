package fr.isika.cda26.poo.drugStrore;

import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.db.DbManager;
import fr.isika.cda26.poo.mutual.HealthMutual;
import fr.isika.cda26.poo.person.Client;
import fr.isika.cda26.poo.person.Doctor;
import fr.isika.cda26.poo.person.Employe;
import fr.isika.cda26.poo.stock.Stock;

/**
 * Drug store generate as a real shop.
 * @author Thibault SALGUES
 *
 */
public final class DrugStore {

//********************************** ATTRIBUTS *****************************************
	private String name;
	private String owner;
	private Stock stock;
	private List<Client> clientsList;
	private List<Doctor> doctorsList;
	private List<HealthMutual> mutualsList;
	private ArrayList<Employe> employeesList;
	
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
	public DrugStore(String name, String owner) {
		this.name = name;
		this.owner = owner;
		this.stock = new Stock("Stock of medications");
		this.clientsList = new ArrayList<Client>();
		this.doctorsList = new ArrayList<Doctor>();
		this.mutualsList = new ArrayList<HealthMutual>();
		this.employeesList = new ArrayList<Employe>();
	}

	
//********************************** GUETTERS / SETTERS ***********************************	
	/**
	 * Getter for stock attribute of the drug store.
	 * @return the stock (:Stock)
	 */
	public Stock getStock() {
		return stock;
	}


//********************************** OVERRIDEN METHODS **********************************
	/**
	 * Overridden from Class Object: Present myAt attribute of the object.
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
	 * Add a new client to the p drug store and write it in the DB.
	 * @param newClient
	 */
	public void addNewClient(Client newClient) {
		clientsList.add(newClient);
		System.out.println("New client added to the clients list.");
		newClient.writeObjectInDb();
		System.out.println("New client added in the DB.");
	}
	
	/**
	 *  Add a new doctor to the drug store and write it in the DB.
	 * @param newDoctor
	 */
	public void addNewDoctor(Doctor newDoctor) {
		doctorsList.add(newDoctor);
		System.out.println("New doctor added to the doctors list.");
		newDoctor.writeObjectInDb();
		System.out.println("New doctor added in the DB.");
	}
	
	/**
	 *  Add a new mutual to the pharmacy and write it in the DB.
	 * @param newMutual
	 */
	public void addNewMutual(HealthMutual newMutual) {
		mutualsList.add(newMutual);
		System.out.println("New mutual added to the mutuals list.");
		newMutual.writeObjectInDb();
		System.out.println("New mutual added in the DB.");
	}
	
	/**
	 *  Add an new employee to the  drug store and write it in the DB.
	 * @param newEmployee
	 */
	public void addNewEmployee(Employe newEmployee) {
		employeesList.add(newEmployee);
		System.out.println("New employee added to the employees list.");
		newEmployee.writeObjectInDb();
		System.out.println("New employee added in the DB.");
	}
}
