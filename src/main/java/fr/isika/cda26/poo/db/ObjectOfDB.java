package fr.isika.cda26.poo.db;

public abstract class ObjectOfDB {

//********************************** SPECIFIC PUBLIC METHODS ****************************
	public abstract void writeObjectInDb();
	
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
				attributePrepared += " ";
			}
		} else {
			attributePrepared = attribute.substring(0, size);
		}
		return attributePrepared;
	}	

}
