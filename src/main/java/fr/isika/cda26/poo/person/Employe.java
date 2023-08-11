package fr.isika.cda26.poo.person;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Employee of the pharmacy. Heritage from class ObjectOfDB :  Person.
 * @author Thibault SALGUES
 *
 */
public class Employe extends Person {
	
//********************************** ATTRIBUTS *****************************************
	private String function;
	private int employeeId;
	public static int numberOfEmployees = 0;


//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 * @param function
	 */
	public Employe(String name, String forename, int telNumber, String city, int postalindex, String function) {
		super(name, forename, telNumber, city, postalindex);
		this.function = function;
		this.employeeId = numberOfEmployees;
		this.numberOfEmployees ++;
	}


//********************************** GUETTERS / SETTERS ***********************************
	/**
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}


	/**
	 * @param function the function to set
	 */
	public void setFunction(String function) {
		this.function = function;
	}


	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}


	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
			this.setFunction(prepareAttributeToBeWrite(NAME_SIZE, this.getFunction()));
			
			String fileToWrite = EMPLOYEE_DIRECTORY_PATH + NAME_OF_DBFILES;
			try {
				RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
				raf.seek(raf.length());
				raf.writeInt(this.getEmployeeId());
				raf.writeChars(this.getName());
				raf.writeChars(this.getForename());
				raf.writeChars(this.getCity());
				raf.writeInt(this.getTelNumber());
				raf.writeInt(this.getPostalindex());
				raf.writeChars(this.getFunction());
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


	@Override
	public void modifyObjectInDb(int rank, Object object) {
		// TODO Auto-generated method stub
		
	}
	}

