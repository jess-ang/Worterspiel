package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class HelpButton extends JButton{

	// Crea el boton de ayuda
	public HelpButton() {
		ImageIcon button = new ImageIcon(HelpButton.class.getResource("/help.png"));
		this.setIcon(button);
		this.setBackground(new Color(67,255,180));
		this.setOpaque(true);
		Help help = new Help();
		this.addActionListener(help);
	}
	
	public void showHelpMsg() {
    	UIManager UI=new UIManager();
    	Color backColor = new Color(67,255,180);
    	UI.put("OptionPane.background", backColor);
    	UI.put("Panel.background", backColor);
    	Font labelFont = new Font("serif", Font.PLAIN, 20);
        JLabel label = new JLabel("Haz clic en el cuadro correspondiente a la palabra.");
        label.setFont(labelFont);
        label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(null,label,"Ayuda",JOptionPane.PLAIN_MESSAGE,null);
	}
	
	private class Help implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			showHelpMsg();
		}
	}
}
