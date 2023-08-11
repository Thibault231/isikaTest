package fr.isika.cda26.poo.jFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StockFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public StockFrame() {
		this.setTitle("Manage with stock");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		JButton buton0 = new JButton("Return main frame");
		this.getContentPane().add(buton0, BorderLayout.SOUTH);

		
		final JFrame currentFrame = this;
		buton0.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainFrame mainkFrame = new MainFrame();
				currentFrame.dispose();
			}
		});


		this.setVisible(true);
	}
}
