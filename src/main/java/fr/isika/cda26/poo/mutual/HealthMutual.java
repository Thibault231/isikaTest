package fr.isika.cda26.poo.mutual;

import java.io.IOException;
import java.io.RandomAccessFile;

import fr.isika.cda26.poo.db.ObjectOfDB;
import fr.isika.cda26.poo.interfaces.DbConstants;

/**
 * Mutual for client reimbursement. Heritage from class ObjectOfDB.
 * 
 * @author LENOVO
 *
 */
public final class HealthMutual extends ObjectOfDB implements DbConstants {

//********************************** ATTRIBUTS *****************************************
	private String name;
	private Boolean overRefunds;
	private int mutualId;
	public static int numberOfMutuals = 0;

//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * 
	 * @param name
	 * @param overRefunds
	 */
	public HealthMutual(String name, Boolean overRefunds) {
		this.name = name;
		this.overRefunds = overRefunds;
		this.mutualId = numberOfMutuals;
		this.numberOfMutuals++;
	}

//********************************** GUETTERS / SETTERS ***********************************	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the overRefunds
	 */
	public Boolean getOverRefunds() {
		return overRefunds;
	}

	/**
	 * @param overRefunds the overRefunds to set
	 */
	public void setOverRefunds(Boolean overRefunds) {
		this.overRefunds = overRefunds;
	}

	/**
	 * @return the mutualId
	 */
	public int getMutualId() {
		return mutualId;
	}

	/**
	 * @param mutualId the mutualId to set
	 */
	public void setMutualId(int mutualId) {
		this.mutualId = mutualId;
	}

//********************************** OVERRIDEN METHODS **********************************
	/**
	 * Overriden from Class ObjectOfDB: Write the mutual object in the Binary DB
	 * file.
	 */
	@Override
	public void writeObjectInDb() {
		this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));

		String fileToWrite = MUTUAL_DIRECTORY_PATH + NAME_OF_DBFILES;
		try {
			RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
			raf.seek(raf.length());
			raf.writeInt(this.getMutualId());
			raf.writeChars(this.getName());
			raf.writeBoolean(this.getOverRefunds());
			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void printProductFromDbFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findLatestInstanceId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
