package fr.isika.cda26.poo.stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

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
	 * Print all products of the stock, writed it in the DB, with their amount.
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
	 * Change the id of the object to -1 and rebase the DB file of medications.
	 */
	public void deleteOneMedication(int objectId) {
		int readenId = DELETE_ID;
		int iterator = 0;
		String fileName = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
			while (readenId != objectId) {
				rf.seek(MEDICATION_SIZE * iterator);
				readenId = rf.readInt();
				iterator += 1;
			}
			rf.seek(MEDICATION_SIZE * (iterator-1));
			rf.writeInt(DELETE_ID);
			rf.close();
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		rebaseMedicationDb();

	}

//********************************** SPECIFIC PUBLIC METHODS ****************************
	/**
	 * Suppress all medication with Id equals to -1, then rewrite the Db.
	 */
	private void rebaseMedicationDb() {
		String fileName = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		List<Medication> medicationToKeep = new ArrayList<Medication>();
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			int numberOfMedications = (int) (rf.length()) / MEDICATION_SIZE;
			rf.close();
			for (int i = 0; i < numberOfMedications; i++) {
				Medication readenMedication = readMedicationFromDb(i);
				if (readenMedication.getMedicationId() != DELETE_ID) {
					System.out.println(readenMedication.getMedicationId());
					medicationToKeep.add(readenMedication);
				}
			}
			
			PrintWriter pw = new PrintWriter(fileName);
			pw.close();
			for (Medication medication : medicationToKeep) {
				medication.writeObjectInDb();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Extract the specified Medication Object from Medication Db.
	 * @param medicationPosition
	 * @return (:Medication)
	 */
	private Medication readMedicationFromDb(int medicationPosition) {
		Medication medicationToReturn;
		String fileName = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			rf.seek(medicationPosition*MEDICATION_SIZE);
			int medicationId = rf.readInt();
			String medicationName = "";
			for (int j = 0; j < NAME_SIZE; j++) {
				String charRead = "";
				charRead += rf.readChar();
				if (!charRead.equals(FILLING_CHAR)) {
					medicationName += charRead;
				}

			}
			int medicationPrice = rf.readInt();
			int medicationRateTVA = rf.readInt();
			int medicationAmount = rf.readInt();
			int medicationType = rf.readInt();
			int medicationBaseOfRefunds = rf.readInt();
			rf.close();
			medicationToReturn = new Medication(medicationName, medicationPrice, medicationRateTVA, medicationAmount,
					medicationType, medicationBaseOfRefunds);
			medicationToReturn.setMedicationId(medicationId);
		} catch (IOException e) {
			e.printStackTrace();
			medicationToReturn = new Medication(null, 0, 0, 0, 0, 0);
		}

		return medicationToReturn;
	}
}
