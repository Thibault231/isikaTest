package fr.isika.cda26.poo.person;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Doctor of clients. Heritage from ObjectOfDB : Person.
 * @author Thibault SALGUES
 *
 */
public class Doctor extends Person {

//********************************** ATTRIBUTS *****************************************
	private String speciality;
	private int doctorId;
	public static int numberOfDoctors = 0;

//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param forename
	 * @param telNumber
	 * @param city
	 * @param postalindex
	 * @param speciality
	 */
	public Doctor(String name, String forename, int telNumber, String city, int postalindex, String speciality) {
		super(name, forename, telNumber, city, postalindex);
		this.speciality = speciality;
		this.doctorId = numberOfDoctors;
		this.numberOfDoctors ++;
	}

//********************************** GUETTERS / SETTERS ***********************************
	/**
	 * @return the speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

//********************************** OVERRIDEN METHODS **********************************
	/**
	 * Overriden from Class ObjectOfDB: Write the doctor object in the Binary DB.
	 */
	@Override
	public void writeObjectInDb() {
			this.setName(prepareAttributeToBeWrite(NAME_SIZE, this.getName()));
			this.setForename(prepareAttributeToBeWrite(NAME_SIZE, this.getForename()));
			this.setCity(prepareAttributeToBeWrite(NAME_SIZE,this.getCity()));
			this.setSpeciality(prepareAttributeToBeWrite(NAME_SIZE, this.getSpeciality()));
			
			String fileToWrite = DOCTOR_DIRECTORY_PATH + NAME_OF_DBFILES;
			try {
				RandomAccessFile raf = new RandomAccessFile(fileToWrite, "rw");
				raf.seek(raf.length());
				raf.writeInt(this.getDoctorId());
				raf.writeChars(this.getName());
				raf.writeChars(this.getForename());
				raf.writeChars(this.getCity());
				raf.writeInt(this.getTelNumber());
				raf.writeInt(this.getPostalindex());
				raf.writeChars(this.getSpeciality());
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
