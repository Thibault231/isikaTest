package fr.isika.cda26.poo.person;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.isika.cda26.poo.invoice.Invoice;
import fr.isika.cda26.poo.mutual.HealthMutual;

/**
 * Client of the pharmacy. Heritage from ObjectOfDB : Person.
 * @author Thibault SALGUES
 *
 */
public class Client extends Person {
	
//********************************** ATTRIBUTS *****************************************
	private List<Invoice> invoicesList;
	private int mainDoctorId;
	private int firstMutualId;
	private int complementaryMutualId;
	private int clientId;
	public static int numberOfClients = 0;
	


//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 * @param invoicesList
	 * @param firstMutual
	 * @param complementaryMutual
	 */
	public Client(String name, String forename, int telNumber, String city, int postalindex, int mainDoctorId,
			int firstMutualId, int complementaryMutualId) {
		super(name, forename, telNumber, city, postalindex);
		this.invoicesList = new ArrayList<Invoice>();
		this.mainDoctorId = mainDoctorId;
		this.firstMutualId = firstMutualId;
		this.complementaryMutualId = complementaryMutualId;
		this.clientId = numberOfClients;
		this.numberOfClients ++;
	}


//********************************** GUETTERS / SETTERS ***********************************
	/**
	 * @return the invoicesList
	 */
	public List<Invoice> getInvoicesList() {
		return invoicesList;
	}

	/**
	 * @param invoicesList the invoicesList to set
	 */
	public void setInvoicesList(List<Invoice> invoicesList) {
		this.invoicesList = invoicesList;
	}

	/**
	 * @return the mainDoctorId
	 */
	public int getMainDoctorId() {
		return mainDoctorId;
	}

	/**
	 * @param mainDoctorId the mainDoctorId to set
	 */
	public void setMainDoctorId(int mainDoctorId) {
		this.mainDoctorId = mainDoctorId;
	}

	/**
	 * @return the firstMutualId
	 */
	public int getFirstMutualId() {
		return firstMutualId;
	}

	/**
	 * @param firstMutualId the firstMutualId to set
	 */
	public void setFirstMutualId(int firstMutualId) {
		this.firstMutualId = firstMutualId;
	}

	/**
	 * @return the complementaryMutualId
	 */
	public int getComplementaryMutualId() {
		return complementaryMutualId;
	}

	/**
	 * @param complementaryMutualId the complementaryMutualId to set
	 */
	public void setComplementaryMutualId(int complementaryMutualId) {
		this.complementaryMutualId = complementaryMutualId;
	}

	/**
	 * @return the clientId
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	
//********************************** OVERRIDEN METHODS **********************************
	/**
	 * Overriden from Class ObjectOfDB: Write the employee object in the Binary DB.
	 */
	@Override
	public void writeObjectInDb() {
			this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));
			this.setForename(prepareAttributeToBeWrite(NAME_SIZE, this.getForename()));
			this.setCity(prepareAttributeToBeWrite(NAME_SIZE,this.getCity()));
			
			String fileToWrite = CLIENT_DIRECTORY_PATH + NAME_OF_DBFILES;
			try {
				RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
				raf.seek(raf.length());
				raf.writeInt(this.getClientId());
				raf.writeChars(this.getName());
				raf.writeChars(this.getForename());
				raf.writeChars(this.getCity());
				raf.writeInt(this.getTelNumber());
				raf.writeInt(this.getPostalindex());
				raf.writeInt(this.getMainDoctorId());
				raf.writeInt(this.getFirstMutualId());
				raf.writeInt(this.getComplementaryMutualId());
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
