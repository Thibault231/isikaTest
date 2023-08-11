package fr.isika.cda26.poo.stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.db.DbManager;
import fr.isika.cda26.poo.interfaces.DbConstants;
import fr.isika.cda26.poo.person.Client;
import fr.isika.cda26.poo.product.Medication;
import fr.isika.cda26.poo.product.Product;

/**
 * Stock of products of the pharmacy.
 * 
 * @author Thibault SALGUES
 *
 */
public final class Stock implements DbConstants {

//********************************** ATTRIBUTS *****************************************
	private String name;

//********************************** CONSTRUCTORS **************************************	
	/**
	 * Full constructor.
	 * 
	 * @param name
	 */
	public Stock(String name) {
		this.name = name;
	}

//********************************** SPECIFIC PUBLIC METHODS ****************************		

	/**
	 * Add a new medication in the stock and write it in the DB, with their amount.
	 * 
	 * @param newMedication
	 */
	public void addNewMedication(Medication newMedication) {
		newMedication.setMedicationId(newMedication.findLatestInstanceId() + 1);
		System.out.println("New medication added to the stock list.");
		newMedication.writeObjectInDb();
	}

	/**
	 * Print all products from all the DB files of the Product directory.
	 * 
	 * @return (:List<Product>)
	 */
	public void printAllProductsInStock() {
		Medication medication = new Medication(null, 0, 0, 0, 0, 0);
		medication.printProductFromDbFile();
	}

	/**
	 * Delete object of the stock from it's associated Db file.
	 */
	public void deleteProduct(int objectId, String type) {
		DbManager dbManager = new DbManager();
		if (type.toLowerCase().equals("medication")) {
			dbManager.deleteOneMedication(objectId);
		}

	}
	
	/**
	 * Modify object attributes of the stock from it's associated Db file.
	 * @param objectId
	 * @param objectToModify
	 */
	public void modifyProduct(int objectId, Object objectToModify) {
		DbManager dbManager = new DbManager();
		if (objectToModify instanceof Medication) {
			dbManager.modifyMedication(objectId, (Medication)(objectToModify));
		}
	}

}