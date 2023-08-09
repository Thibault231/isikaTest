package fr.isika.cda26.poo.product;

import fr.isika.cda26.poo.db.ObjectOfDB;
import fr.isika.cda26.poo.interfaces.BddConstants;

/**
 * Abstract class for all products sell in the pharmacy. Heritage from ObjectOfDb.
 * @author Thibault SALGUES
 *
 */
public abstract class Product extends ObjectOfDB implements BddConstants {

//********************************** ATTRIBUTS *****************************************
	protected String name;
	protected int price;
	protected int rateTVA;
	protected int amount;
	
//********************************** CONSTRUCTORS **************************************
	/**
	 * Full constructor.
	 * @param name
	 * @param price
	 * @param rateTVA
	 * @param amount
	 */
	public Product(String name, int price, int rateTVA, int amount) {
		this.name = name;
		this.price = price;
		this.rateTVA = rateTVA;
		this.amount = amount;
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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the rateTVA
	 */
	public int getRateTVA() {
		return rateTVA;
	}

	/**
	 * @param rateTVA the rateTVA to set
	 */
	public void setRateTVA(int rateTVA) {
		this.rateTVA = rateTVA;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
