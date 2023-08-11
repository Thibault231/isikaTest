package fr.isika.cda26.poo.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.interfaces.DbConstants;
import fr.isika.cda26.poo.person.Employe;
import fr.isika.cda26.poo.product.Medication;
/**
 * Manage with Db files for deleting, adding, modifying and erasing persons and products objects.
 * @author LENOVO
 *
 */
public class DbManager implements DbConstants {

//********************************** ATTRIBUTS *****************************************
	private String name;

//********************************** CONSTRUCTORS **************************************
	/**
	 * Empty constructor.
	 * @param objectToWrite
	 */
	public DbManager() {
		this.name = "Db Manager";
		
	}

//********************************** SPECIFIC PUBLIC METHODS ****************************
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
	
	/**
	 * Find the rank of the medication in Db file and modify the attributes of the object in Db.
	 * @param objectId
	 * @param objectToModify
	 */
	public void modifyMedication(int objectId, Medication objectToModify) {
		int medicationRank = findRankInDb(objectId, MEDICATION_DIRECTORY_PATH);
		if (medicationRank != DELETE_ID) {
			objectToModify.modifyObjectInDb(medicationRank, (Object)(objectToModify));
		} else {
			System.out.println("No medication found with this Id.");
		}
		
		
	}
	
//********************************** SPECIFIC PRIVATE METHODS ****************************
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
					medicationToKeep.add(readenMedication);
				}
			}
			
			PrintWriter pw = new PrintWriter(fileName);
			pw.close();
			System.out.println("Db file deleted.");
			for (Medication medication : medicationToKeep) {
				medication.writeObjectInDb();
			}
			System.out.println("Db file created.");
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
	
	/**
	 * Find and return the rank of an object in it's associated Db file.
	 * @param objectId
	 * @param pathOfObjectDirectory
	 * @return objectRank (:int)
	 */
	private int findRankInDb(int objectId, String pathOfObjectDirectory) {
		int objectRank;
		int iterator = 0;
		int readenId = DELETE_ID;
		String fileName = pathOfObjectDirectory + NAME_OF_DBFILES;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
			while (readenId != objectId) {
				rf.seek(MEDICATION_SIZE * iterator);
				readenId = rf.readInt();
				iterator += 1;
			}
			objectRank = iterator - 1;
			rf.close();
						
		} catch (IOException e) {
			objectRank = DELETE_ID;
			e.printStackTrace();
		}
		
		return objectRank;
		
	}
	
	
}
