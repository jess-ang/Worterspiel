package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import main.Main;
import modelo.Util.Games;

public class MainMenu extends JPanel{
	private Main rootGame;
	private JLabel label;
	private JLabel gameTitle;
	private JLabel dog;
	private JButton numberGame;
	private JButton colorGame;
	private Background background;
	private Controlador controller;
	
	public MainMenu(Main rootGame) {		
		this.rootGame = rootGame;
		this.controller = new Controlador();
		this.createWidgets();
		this.addControllers();
		this.setLayout(null);
		this.addToMainMenu();
		this.setComponentsBounds();
		this.background.addBack(this);
	}
	
	//Crea los componentes del panel
	public void createWidgets() {
		this.background = new Background();
		this.gameTitle = new JLabel();
		ImageIcon img = new ImageIcon(MainMenu.class.getResource("/mainmenu/title.png"));
		this.gameTitle.setIcon(img);
		this.label = new JLabel("Selecciona un juego");
		this.label.setFont(new Font("serif", Font.PLAIN, 30));
		this.label.setForeground(Color.WHITE);
		this.createGameBtn();
		this.dog = new JLabel();
		ImageIcon dialog = new ImageIcon(MainMenu.class.getResource("/mainmenu/perro.png"));
		this.dog.setIcon(dialog);
	}
	
	//Crea los botones de los juegos
	private void createGameBtn() {
		String u="\u00FA";
		this.numberGame = new JButton("N"+u+"meros");
		this.colorGame = new JButton("Colores");
		this.changeAppearance(numberGame);
		this.changeAppearance(colorGame);
	}
		
	//Cambia la apariencia de los botones
	public void changeAppearance(JButton btn) {
		Color btnColor = new Color(35,185,183);
		Font btnFont = new Font("serif", Font.PLAIN, 30);
		btn.setPreferredSize(new Dimension(200,70));
		btn.setBackground(btnColor);
		btn.setOpaque(true);
		btn.setForeground(Color.WHITE);
		btn.setFont(btnFont);
	}
	
	//Agrega los controladores a los botones
	public void addControllers() {
	numberGame.addActionListener(controller);
	colorGame.addActionListener(controller);
	}
	
	//Agrega los componentes al menu principal
	private void addToMainMenu(){
		this.add(label);
		this.add(gameTitle);
		this.add(numberGame);
		this.add(colorGame);
		this.add(dog);
	}

	// Establece las coordenadas de los componentes
	private void setComponentsBounds(){
		gameTitle.setBounds(85,120,455,95);
		label.setBounds(180,235,390,51);
		numberGame.setBounds(212,300,170,55);
		colorGame.setBounds(212,370,170,55);
		dog.setBounds(547,-15,960,670);
	}
	
	private class Controlador implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			switch(b.getText()) {
				case "N\u00FAmeros": rootGame.setGame(Games.NUMBERGAME);
								break;
				case "Colores": rootGame.setGame(Games.COLORGAME);
								break;
			}
		}
	}
	
	
	
}
