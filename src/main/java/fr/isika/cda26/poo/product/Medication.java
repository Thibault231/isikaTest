package fr.isika.cda26.poo.product;

import java.io.IOException;
import java.io.RandomAccessFile;
import fr.isika.cda26.poo.interfaces.DbConstants;

/**
 * Mother class for all the medications sold in the pharmacy. Heritage from
 * ObjectOfDb : Product.
 * 
 * @author Thibault SALGUES
 *
 */
public class Medication extends Product  implements DbConstants{

//********************************** ATTRIBUTS *****************************************
	private int type;
	private int medicationId;
	private int baseOfRefund;

//********************************** CONSTRUCTORS **************************************	
	/**
	 * Full constructor.
	 * 
	 * @param name
	 * @param price
	 * @param rateTVA
	 * @param amount
	 * @param type
	 * @param baseOfRefund
	 */
	public Medication(String name, int price, int rateTVA, int amount, int type, int baseOfRefund) {
		super(name, price, rateTVA, amount);
		this.type = type;
		this.medicationId = DELETE_ID;
		this.baseOfRefund = baseOfRefund;
	}

//********************************** GUETTERS / SETTERS ***********************************
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the medicationId
	 */
	public int getMedicationId() {
		return medicationId;
	}

	/**
	 * @param medicationId the medicationId to set
	 */
	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	/**
	 * @return the baseOfRefund
	 */
	public int getBaseOfRefund() {
		return baseOfRefund;
	}

	/**
	 * @param baseOfRefund the baseOfRefund to set
	 */
	public void setBaseOfRefund(int baseOfRefund) {
		this.baseOfRefund = baseOfRefund;
	}
	
	

//********************************** OVERRIDEN METHODS **********************************
	/**
	 * Overridden from Class ObjectOfDB: Write the medication object in the
	 * associated binary DB file.
	 */
	@Override
	public void writeObjectInDb() {
		this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));

		String fileToWrite = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
			raf.seek(raf.length());
			raf.writeInt(this.getMedicationId());
			raf.writeChars(this.getName());
			raf.writeInt(this.getPrice());
			raf.writeInt(this.getRateTVA());
			raf.writeInt(this.getAmount());
			raf.writeInt(this.getType());
			raf.writeInt(this.getBaseOfRefund());
			raf.close();
			System.out.println("New medication added in the DB.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding medication in the DB.");
		}

	}

	
	/**
	 * Overridden from Class ObjectOfDB: Write the medication modifications in int's DB file place.
	 */
	@Override
	public void modifyObjectInDb(int medicationRank, Object modifiedObject) {
		Medication modifiedMedication = (Medication)(modifiedObject);
		modifiedMedication.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));

		String fileToWrite = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
			raf.seek(medicationRank*MEDICATION_SIZE + MEDICATION_DB_MASK[1]);
			raf.writeChars(modifiedMedication.getName());
			raf.writeInt(modifiedMedication.getPrice());
			raf.writeInt(modifiedMedication.getRateTVA());
			raf.writeInt(modifiedMedication.getAmount());
			raf.writeInt(modifiedMedication.getType());
			raf.writeInt(modifiedMedication.getBaseOfRefund());
			raf.close();
			System.out.println("Modifications done in the Medication DB file.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while adding modifications in the medication DB file.");
		}

	}
	
	/**
	 * Overridden from Class ObjectOfDb. Print all the products of Medication DB
	 * file.
	 * 
	 * @param fileName (:String)
	 */
	@Override
	public void printProductFromDbFile() {
		String fileName = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			for (int i = 0; i < rf.length() / MEDICATION_SIZE; i++) {
				int productId;
				String productName = "";
				String charRead;
				int productAmount;
				rf.seek(i * MEDICATION_SIZE);
				productId = rf.readInt();
				for (int j = 0; j < NAME_SIZE; j++) {
					charRead = "";
					charRead += rf.readChar();
					if (!charRead.equals(FILLING_CHAR)) {
						productName += charRead;
					}

				}
				rf.seek(i * MEDICATION_SIZE + 52);
				productAmount = rf.readInt();
				System.out.println(
						"Product ID : " + productId + ", Name : " + productName + ", in amount of : " + productAmount);
			}
			rf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Overridden from Class ObjectOfDb. Calculate the lastest Id assigned to a medication object.
	 * 
	 * @return lastestId (:int)
	 */
	@Override
	public int findLatestInstanceId() {
		int latestId;
		String fileName = MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			if (rf.length() > 0) {
				rf.seek(rf.length() - MEDICATION_SIZE);
				latestId = rf.readInt();
			}else {
				latestId = DELETE_ID;
			}
			rf.close();
			return latestId;
		} catch (IOException e) {
			e.printStackTrace();
			return latestId = DELETE_ID;
		}

	}

}
