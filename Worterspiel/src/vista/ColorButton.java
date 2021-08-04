package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class ColorButton extends JButton{

		private Font btnFont;
		private int btnID;
				
	public ColorButton() {
		changeAppearance();
	}
		
	public void changeAppearance() {
		btnFont = new Font("serif", Font.PLAIN, 75);
		this.setPreferredSize(new Dimension(113,113));
		this.setForeground(Color.WHITE);
		this.setOpaque(true);
		this.setFont(btnFont);
	}

	public int getBtnID() {
		return btnID;
	}

	public void setBtnID(int btnID) {
		this.btnID = btnID;
	}
	
}
