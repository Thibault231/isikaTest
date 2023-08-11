package fr.isika.cda26.poo.jFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setTitle("Bouton");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		GridLayout gl = new GridLayout(2, 2);
		gl.setHgap(5);
		gl.setVgap(5);
		this.setLayout(gl);

		JButton buton0 = new JButton("Add - Modify - Delete");
		JButton buton1 = new JButton("Search");
		JButton buton2 = new JButton("Manage with Stock");
		JButton buton3 = new JButton("Payment and Invoice");

		this.getContentPane().add(buton0);
		this.getContentPane().add(buton1);
		this.getContentPane().add(buton2);
		this.getContentPane().add(buton3);

		final JFrame currentFrame = this;
		buton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				StockFrame stockFrame = new StockFrame();
				currentFrame.dispose();
			}
		});
		
		this.setVisible(true);
	}
}
