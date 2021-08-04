package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class GameLabel extends JLabel{
	private Font labelFont; 
	
	public GameLabel() {
		labelFont = new Font("serif", Font.PLAIN, 25);
		this.setFont(labelFont);
		this.setForeground(Color.BLACK);
	}
}