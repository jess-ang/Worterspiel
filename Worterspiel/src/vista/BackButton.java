package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.Main;
import modelo.Util.Games;

public class BackButton extends JButton{
	
	private Main rootGame;

	public BackButton(Main rootGame){
		this.rootGame = rootGame;
		ImageIcon button = new ImageIcon(BackButton.class.getResource("/main.png"));
		this.setIcon(button);
		this.setBackground(new Color(67,255,180));
		this.setOpaque(true);
		BackToMenu backToMenu = new BackToMenu();
		this.addActionListener((ActionListener) backToMenu);
	}

	private class BackToMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			rootGame.setGame(Games.MAINMENU);
		}
	}
}
