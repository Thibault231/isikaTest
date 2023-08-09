package fr.isika.cda26.poo.product;

/**
 * Mother class for all the medcations sell in the pharmacy. Heritage from ObjectOfDb : Product. 
 * @author LENOVO
 *
 */
public class Medication extends Product {
	
//********************************** ATTRIBUTS *****************************************
	private int type;
	private int medicationId;
	private int baseOfRefund;
	public static int numberOfMedications = 0;


//********************************** CONSTRUCTORS **************************************	
	/**
	 * Full constructor.
	 * @param name
	 * @param price
	 * @param rateTVA
	 * @param amount
	 * @param type
	 * @param medicationId
	 * @param baseOfRefund
	 */
	public Medication(String name, int price, int rateTVA, int amount, int type, int medicationId, int baseOfRefund) {
		super(name, price, rateTVA, amount);
		this.type = type;
		this.medicationId = medicationId;
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




	@Override
	public void writeObjectInDb() {
		
	}

}
