package vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

import modelo.Score;

public abstract class Game extends JPanel{
	protected Main rootGame;
	protected Score score;
	protected GameLabel scoreLabel;
	protected JLabel scoreBox;
	protected final int btnNum=12;
	protected BackButton backMenu;
	protected HelpButton helpBtn;
	protected Background background;

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	public Game(Main rootGame){
		this.rootGame = rootGame;
		this.background = new Background();
		this.backMenu = new BackButton(rootGame);
		this.helpBtn = new HelpButton();
		this.score = new Score();
	}	
	
	// Crea el cuadro de puntaje
	protected void createStatusBox(){
		this.scoreBox = new JLabel();
		ImageIcon score = new ImageIcon(Game.class.getResource("/scorebox.png"));
		this.scoreBox.setIcon(score);
		this.scoreLabel = new GameLabel();
		scoreLabel.setText("Puntos: "+getScore().showStringPts());
	}

	protected abstract void createWidgets();
	
	// Establece las coordenadas de los componentes
	protected void setComponentsBounds(){
		helpBtn.setBounds(767,37,66,66);
		backMenu.setBounds(845,37,66,66);
		scoreLabel.setBounds(410,50,180,36);
		scoreBox.setBounds(380,25,370,90);		
	}

	// Agrega los componentes a un panel
	protected void addToPanel(JPanel panel){
		panel.add(backMenu);
		panel.add(helpBtn);
		panel.add(scoreLabel);
		panel.add(scoreBox);
	}
	
	//Crea 12 botones y son agregados en un arrayList
	protected abstract void generateBtn();

}