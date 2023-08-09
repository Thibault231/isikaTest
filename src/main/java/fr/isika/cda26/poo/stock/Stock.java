package fr.isika.cda26.poo.stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.interfaces.BddConstants;
import fr.isika.cda26.poo.person.Client;
import fr.isika.cda26.poo.product.Medication;
import fr.isika.cda26.poo.product.Product;

/**
 * Stock of products of the pharmacy.
 * 
 * @author Thibault SALGUES
 *
 */
public final class Stock implements BddConstants {

//********************************** ATTRIBUTS *****************************************
	private String name;
	private List<Product> productsList;

//********************************** CONSTRUCTORS **************************************	
	/**
	 * Full constructor.
	 * 
	 * @param name
	 */
	public Stock(String name) {
		productsList = new ArrayList<Product>();
		this.name = name;
	}

//********************************** SPECIFIC PUBLIC METHODS ****************************		

	/**
	 * Print all products of the stock, writed it in the DB, with their amount.
	 * 
	 * @param newMedication
	 */
	public void addNewMedication(Medication newMedication) {
		this.productsList.add(newMedication);
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
}
