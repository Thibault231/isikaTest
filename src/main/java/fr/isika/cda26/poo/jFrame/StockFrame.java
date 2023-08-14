package fr.isika.cda26.poo.jFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class StockFrame extends JFrame {

//********************************** ATTRIBUTES **************************
	private static final long serialVersionUID = 1L;
	private StockCards stockCards = new StockCards();
	private ButonsStock butonsStock = new ButonsStock(stockCards);

	/**
	 * Generate the window for Stock management.
	 */
	public StockFrame() {

//********************************** FRAME PARAMETERS **************************
		this.setTitle("Manage with stock");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

//********************************** ADD CARDS TO LAYOUT ************************
		this.getContentPane().add(stockCards.content, BorderLayout.CENTER);

//********************************** CREATE MENU BAR **************************
		JMenuBar menuBar = new JMenuBar();
		JMenu admMenu = new JMenu("Menu ADM");
		JMenu returnMenu = new JMenu("Return");
		JMenu paymentMenu = new JMenu("Payment");

		JMenuItem item1 = new JMenuItem("Search Person");
		JMenuItem item2 = new JMenuItem("Modify Person");
		JMenuItem item3 = new JMenuItem("Delete Person");

		JMenuItem item4 = new JMenuItem("return Main frame");
		JMenuItem item5 = new JMenuItem("return Stock frame");

		final JFrame currentFrame = this;
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame mainkFrame = new MainFrame();
				currentFrame.dispose();
			}
		});

		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stockCards.cl.show(stockCards.content, stockCards.listContent[0]);
			}
		});

		admMenu.add(item1);
		admMenu.addSeparator();
		admMenu.add(item2);
		admMenu.addSeparator();
		admMenu.add(item3);

		returnMenu.add(item4);
		returnMenu.addSeparator();
		returnMenu.add(item5);

		menuBar.add(admMenu);
		menuBar.add(paymentMenu);
		menuBar.add(returnMenu);
		this.setJMenuBar(menuBar);

//********************************** CREATE BUTONS-PANES **************************	
		JPanel butonPane1 = new JPanel();
		butonPane1.setBackground(Color.GRAY);

		JPanel butonPane2 = new JPanel();
		butonPane2.setLayout(new BoxLayout(butonPane2, BoxLayout.PAGE_AXIS));
		butonPane2.setBackground(Color.GRAY);
		GridLayout gl1 = new GridLayout(3, 1);
		gl1.setHgap(5);
		gl1.setVgap(5);
		butonPane2.setLayout(gl1);
		

//********************************** ADD BUTONS TO PANE *******************************
		butonPane1.add(butonsStock.butonDisplay);
		butonPane2.add(butonsStock.butonDisplayProduct);
		butonPane1.add(butonsStock.butonSearch);
		butonPane1.add(butonsStock.butonCreateProduct);
		butonPane2.add(butonsStock.butonDeleteProduct);
		butonPane2.add(butonsStock.butonModifyProduct);
		this.getContentPane().add(butonPane1, BorderLayout.SOUTH);
		this.getContentPane().add(butonPane2, BorderLayout.EAST);

//********************************** SET VISIBLE *******************************
		this.setVisible(true);
	}

}
