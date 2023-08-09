import fr.isika.cda26.poo.db.DbInit;
import fr.isika.cda26.poo.mutual.HealthMutual;
import fr.isika.cda26.poo.person.Client;
import fr.isika.cda26.poo.person.Doctor;
import fr.isika.cda26.poo.person.Employe;
import fr.isika.cda26.poo.pharmacy.Pharmacy;
import fr.isika.cda26.poo.product.Medication;

public class Main {

	public static void main(String[] args) {
		// Create BDD
		DbInit pharmacyDB = new DbInit();
		// MAJ to null DB.
		pharmacyDB.eraseFilesContents();

		// Create Pharmacy
		Pharmacy healthForall = new Pharmacy("Health for All", "M. Pichon");

		// createTrainingSet Persons

		HealthMutual mutual1 = new HealthMutual("MGEN", false);
		HealthMutual mutual2 = new HealthMutual("InfoHealth", true);
		Doctor doctor1 = new Doctor("Petit", "Jean", 607080901, "Toulouse", 31000, "Generalist");
		Client client1 = new Client("Zorro", "DelaVega", 123456789, "Toulouse", 31100, 0, 0, 1);
		Client client2 = new Client("Batman", "Ashimself", 987654321, "Toulouse", 31200, 0, -1, 1);
		Employe employee1 = new Employe("Karadock", "Glouton", 239584733, "Toulouse", 31300, "Sale");

		// add TrainingSet to Pharmacy
		healthForall.addNewEmployee(employee1);
		healthForall.addNewMutual(mutual1);
		healthForall.addNewMutual(mutual2);
		healthForall.addNewDoctor(doctor1);
		healthForall.addNewClient(client1);
		healthForall.addNewClient(client2);

		// create TrainingSet Products
		Medication medication1 = new Medication("Pilulle smiley", 150, 20, 1000, 0, 100);
		Medication medication2 = new Medication("Pansement cool", 3, 10, 2000, 4, 10);

		// add TrainningSet to Stock
		healthForall.getStock().addNewMedication(medication1);
		healthForall.getStock().addNewMedication(medication2);

		// Get and print all the products of the Stock. 
		healthForall.getStock().printAllProductsInStock();
		
		// Get and print all the persons of the Pharmacy.
		
		// Open Pharmacy
		// Menu: 1-Create / 2-Consult / 3- Stock / 4-Payment and invoice / 5- MAJ DB.
		// 1- Create 1:Client 2: Doctor 3: Health care mutual
		// 2- Consult 1:Client 2: Doctor 3: Health care mutual
		// 2-* 1-Print all 2- Search
		// 2-*-2 1-Invoices
		// 3- 1-Print 2-Search a product 3-Modify
		// 4- 1-Create invoice 2-Search invoice
		// 5-
	}

}
