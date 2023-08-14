package fr.isika.cda26.poo.jFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class StockFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public StockFrame() {

//********************************** FRAME PARAMETERS **************************
		this.setTitle("Manage with stock");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

//********************************** CARDS LAYOUT *******************************	
		final CardLayout cl = new CardLayout();
		final JPanel content = new JPanel();

		final String[] listContent = { "arrivalCard", "deletedCard", "detailProductCard", "modifyProductCard" };

		JPanel arrivalCard = new JPanel();
		JTextField jtf = new JTextField("0");
		JLabel label = new JLabel("Product Id : ");
		JPanel top = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLUE);
		top.add(label);
		top.add(jtf);
		GridLayout gl0 = new GridLayout(3, 1);
		arrivalCard.setLayout(gl0);
		arrivalCard.add(new JPanel());
		arrivalCard.add(top);
		arrivalCard.add(new JPanel());

		JPanel deletedCard = new JPanel();
		deletedCard.setBackground(Color.red);

		JPanel detailProductCard = new JPanel();
		detailProductCard.setBackground(Color.green);

		JPanel modifyProductCard = new JPanel();
		modifyProductCard.setBackground(Color.blue);
		
		
//********************************** ADD CARDS TO LAYOUT ************************
		content.setLayout(cl);
		content.add(arrivalCard, listContent[0]);
		content.add(deletedCard, listContent[1]);
		content.add(detailProductCard, listContent[2]);
		content.add(modifyProductCard, listContent[3]);
		this.getContentPane().add(content, BorderLayout.CENTER);
		


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
				cl.show(content, listContent[0]);
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

//********************************** CREATE BUTONS *******************************

		JButton butonDisplay = new JButton("Display all stock");
		butonDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[0]);
			}
		});

		JButton butonSearch = new JButton("Search a product");
		butonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[0]);
			}
		});

		JButton butonDisplayProduct = new JButton(">> Detail about this product");
		butonDisplayProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[2]);
			}
		});

		JButton butonModifyProduct = new JButton(">> Modify this product");
		butonModifyProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[3]);
			}
		});

		JButton butonCreateProduct = new JButton("Create a new product");
		butonCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[1]);
			}
		});

		JButton butonDeleteProduct = new JButton(">> Delete this product");
		butonDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[1]);
			}
		});

//********************************** ADD BUTONS TO PANE *******************************
		butonPane1.add(butonDisplay);
		butonPane2.add(butonDisplayProduct);
		butonPane1.add(butonSearch);
		butonPane1.add(butonCreateProduct);
		butonPane2.add(butonDeleteProduct);
		butonPane2.add(butonModifyProduct);
		this.getContentPane().add(butonPane1, BorderLayout.SOUTH);
		this.getContentPane().add(butonPane2, BorderLayout.EAST);

//********************************** SET VISIBLE *******************************
		this.setVisible(true);
	}
}
