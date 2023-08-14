package fr.isika.cda26.poo.jFrame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StockCards {
//********************************** ATTRIBUTES **************************
	public JTextField jtf = new JTextField();
	public CardLayout cl = new CardLayout();
	public JPanel content = new JPanel();
	public String[] listContent = { "arrivalCard", "deletedCard", "detailProductCard", "modifyProductCard" };
	
	public JPanel deletedCard = new JPanel();
	public JTextArea area = new JTextArea();

	public StockCards() {
		
// ********************************** CARDS LAYOUT *******************************
		JPanel arrivalCard = new JPanel();

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

		deletedCard.setBackground(Color.gray);

		area.setBounds(2, 2, 400, 400);
		deletedCard.add(area);

		JPanel detailProductCard = new JPanel();
		detailProductCard.setBackground(Color.green);

		JPanel modifyProductCard = new JPanel();
		modifyProductCard.setBackground(Color.blue);

		// ********************************** ADD CARDS TO LAYOUT
		// ************************
		content.setLayout(cl);
		content.add(arrivalCard, listContent[0]);
		content.add(deletedCard, listContent[1]);
		content.add(detailProductCard, listContent[2]);
		content.add(modifyProductCard, listContent[3]);
	}

}
