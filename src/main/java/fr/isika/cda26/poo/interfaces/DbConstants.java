package fr.isika.cda26.poo.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DbConstants {
	
	String INVOICES_DIRECTORY_PATH = "src/main/resources/invoicesDb";
	String MUTUAL_DIRECTORY_PATH = "src/main/resources/mutualDb";
	String PERSON_DIRECTORY_PATH = "src/main/resources/personsDb";
	String CLIENT_DIRECTORY_PATH = "src/main/resources/personsDb/clientsDb";
	String DOCTOR_DIRECTORY_PATH = "src/main/resources/personsDb/doctorsDb";
	String EMPLOYEE_DIRECTORY_PATH = "src/main/resources/personsDb/employeesDb";
	String PRODUCT_DIRECTORY_PATH = "src/main/resources/productsDb";
	String MEDICATION_DIRECTORY_PATH = "src/main/resources/productsDb/medicationsDb";
	String NAME_OF_DBFILES = "/dbFile.bin";
	
	List<String> DIRECTORIES_FOR_PRODUCTS = new ArrayList<String>(
			Arrays.asList(MEDICATION_DIRECTORY_PATH + NAME_OF_DBFILES));
	List<String> ALL_DIRECTORIES_PATH = new ArrayList<String>(
			Arrays.asList(INVOICES_DIRECTORY_PATH, MUTUAL_DIRECTORY_PATH, PERSON_DIRECTORY_PATH, CLIENT_DIRECTORY_PATH,
					DOCTOR_DIRECTORY_PATH, EMPLOYEE_DIRECTORY_PATH, PRODUCT_DIRECTORY_PATH, MEDICATION_DIRECTORY_PATH));
	List<String> DIRECTORIES_FOR_FILES_PATH = new ArrayList<String>(
			Arrays.asList(INVOICES_DIRECTORY_PATH, MUTUAL_DIRECTORY_PATH, CLIENT_DIRECTORY_PATH,
					DOCTOR_DIRECTORY_PATH, EMPLOYEE_DIRECTORY_PATH, MEDICATION_DIRECTORY_PATH));
	
	
	int NAME_SIZE = 20;
	int INT_SIZE = 4;
	String FILLING_CHAR = "*";
	int DELETE_ID = -1;
	int TEL_NUMBER_SIZE = 1;
	int POSTAL_INDEX_SIZE = 5;
	int ID_SIZE = 1;
	
	int MEDICATION_SIZE = 64 ;
	int[] MEDICATION_DB_MASK = new int[] {0, 4, 44, 48, 52, 56, 60};
	
}
