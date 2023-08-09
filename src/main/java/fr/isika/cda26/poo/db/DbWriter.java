package fr.isika.cda26.poo.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import fr.isika.cda26.poo.interfaces.BddConstants;
import fr.isika.cda26.poo.person.Employe;
/**
 * Write the Db files, adding and erasing persons and products.
 * @author LENOVO
 *
 */
public class DbWriter implements BddConstants {

//********************************** ATTRIBUTS *****************************************
	private Object objectToWrite;

//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param objectToWrite
	 */
	public DbWriter(Object objectToWrite) {
		this.objectToWrite = objectToWrite;
		
	}

//********************************** CONSTRUCTORS **************************************
	/**
	 * Getter for objectToWrite attribute.
	 * @return the objectToWrite (:Object)
	 */
	public Object getObjectToWrite() {
		return objectToWrite;
	}

	/**
	 * Setter for objectToWrite attribute.
	 * @param objectToWrite the objectToWrite to set
	 */
	public void setObjectToWrite(Object objectToWrite) {
		this.objectToWrite = objectToWrite;
	}
	
	
}
