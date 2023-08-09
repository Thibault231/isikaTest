package fr.isika.cda26.poo.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.isika.cda26.poo.interfaces.BddConstants;

/**
 * Class for initialisation of the DB
 * 
 * @author Thibault SALGUES
 *
 */
public class DbInit implements BddConstants {

//********************************** ATTRIBUTS *****************************************
	private List<String> pathList = ALL_DIRECTORIES_PATH;

//********************************** CONSTRUCTORS **************************************	
	/**
	 * Empty constructor. Initialize the Db directories and files.
	 */
	public DbInit() {
		System.out.println("Initializing DB.");
		createDirectories();
		System.out.println("Directories created.");
		System.out.println("Initializing DB files.");
		createFiles();
		System.out.println("Files created.");
	}

//********************************** SPECIFIC PUBLIC METHODS ****************************
	/**
	 * Create directories for the DB.
	 */
	private void createDirectories() {
		for (String path : pathList) {
			File directory = new File(path);
			directory.mkdir();
			System.out.println("Creation of directory : " + path + " done.");
		}
	}

	/**
	 * Create one DB file in each DB directories.
	 */
	private void createFiles() {
		for (String path : DIRECTORIES_FOR_FILES_PATH) {
			File myNewFile = new File(path + NAME_OF_DBFILES);
			try {
				myNewFile.createNewFile();
				System.out.println("Creation of DB file for directory : " + path + " .");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error with creation of DB file for directory : " + path + " .");
				myNewFile = null;
			}

		}

	}

	/**
	 * Erase content of all Db Files.
	 */
	public void eraseFilesContents() {
		for (String path : DIRECTORIES_FOR_FILES_PATH) {
			String pathToFile = path.concat(NAME_OF_DBFILES);
			try {
				PrintWriter pw = new PrintWriter(pathToFile);
				pw.close();
				System.out.println("File " + pathToFile + " has been erased.");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error. File " + pathToFile + " hasn't been erased.");
			}
		}
	}

}
