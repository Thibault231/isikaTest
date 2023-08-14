package fr.isika.cda26.poo.jFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.isika.cda26.poo.db.DbManager;

public class ButonsStock {
//********************************** ATTRIBUTES **************************
	private StockCards stockCards;
	private DbManager dbManager;
	public JButton butonDisplay;
	public JButton butonSearch;
	public JButton butonDisplayProduct;
	public JButton butonModifyProduct;
	public JButton butonCreateProduct;
	public JButton butonDeleteProduct;

	/**
	 * Full constructor.
	 * @param newStockCards
	 */
	public ButonsStock(StockCards newStockCards) {
//********************************** ATTRIBUTES VALUES **************************
		this.stockCards = newStockCards;
		this.dbManager = new DbManager();
		this.butonDisplay = new JButton("Display all stock");
		this.butonSearch = new JButton("Search a product");
		this.butonDisplayProduct = new JButton(">> Detail about this product");
		this.butonModifyProduct = new JButton(">> Modify this product");
		this.butonCreateProduct = new JButton("Create a new product");
		this.butonDeleteProduct = new JButton(">> Delete this product");

		
//********************************** BUTONS ACTIONS **************************
		butonDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stockCards.cl.show(stockCards.content, stockCards.listContent[0]);
			}
		});

		butonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stockCards.cl.show(stockCards.content, stockCards.listContent[0]);
			}
		});

		butonDisplayProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stockCards.cl.show(stockCards.content, stockCards.listContent[2]);
			}
		});

		butonModifyProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stockCards.cl.show(stockCards.content, stockCards.listContent[3]);
			}
		});

		butonCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stockCards.cl.show(stockCards.content, stockCards.listContent[1]);
			}
		});

		
		/**
		 * Delete medication, using its Id and print the result in a new window.
		 */
		butonDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean success;

				try {
					int productIdInt = Integer.parseInt((String) (stockCards.jtf.getText()));
					success = dbManager.deleteOneMedication(productIdInt);
				} catch (Exception e) {
					success = false;
				}
				if (success) {
					stockCards.area.setText("The medication with Id " + (String) (stockCards.jtf.getText())
							+ " has been successfull deleted.");
				} else {
					stockCards.area.setText("No medication found with Id " + (String) (stockCards.jtf.getText()));
				}

				stockCards.cl.show(stockCards.content, stockCards.listContent[1]);

			}

		});
	}
}
