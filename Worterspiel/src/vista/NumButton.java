package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class NumButton extends JButton{

		private Color btnColor;
		private Font btnFont;
	
	public NumButton() {
		changeAppearance();
	}
		
	public void changeAppearance() {
		btnColor = new Color(35,185,183);
		btnFont = new Font("serif", Font.PLAIN, 75);
		this.setPreferredSize(new Dimension(113,113));
		this.setBackground(btnColor);
		this.setForeground(Color.WHITE);
		this.setOpaque(true);
		this.setFont(btnFont);
	}
	
}
