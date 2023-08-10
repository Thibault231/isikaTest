package fr.isika.cda26.poo.db;

import fr.isika.cda26.poo.interfaces.DbConstants;

public abstract class ObjectOfDB implements DbConstants {

//********************************** SPECIFIC PUBLIC METHODS ****************************
	public abstract void writeObjectInDb();
	
	public abstract void printProductFromDbFile();
	
	public abstract int findLatestInstanceId();
	
	
	/**
	 * Resize attribute for binary writing.
	 * @param size
	 * @param attribute
	 * @return
	 */
	public String prepareAttributeToBeWrite(int size, String attribute) {
		String attributePrepared = "";
		if(attribute.length() <= size) {
			attributePrepared = attribute;
			for(int i = attribute.length() ; i < size; i++) {
				attributePrepared += FILLING_CHAR;
			}
		} else {
			attributePrepared = attribute.substring(0, size);
		}
		return attributePrepared;
	}
	
	

}
