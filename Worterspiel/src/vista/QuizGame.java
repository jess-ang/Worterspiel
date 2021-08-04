package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import modelo.Life;

public abstract class QuizGame extends Game{

	protected JLabel dog;
	protected GameLabel questionLabel;
	protected Life life;
	protected LivesIcons livesIcons;
	protected GameLabel lifeLabel;
	protected JLabel livesBox;
	protected JPanel btnPanel;

	public Life getLife() {
		return life;
	}
	
	public QuizGame(Main rootGame) {
		super(rootGame);
		this.life = new Life();	
		this.createWidgets();
	}

	// Crea los cuadros de vida y puntaje
	public void createStatusBox(){
		super.createStatusBox();
		this.livesBox = new JLabel();
		ImageIcon lives = new ImageIcon(QuizGame.class.getResource("/lives/livesbox.png"));
		this.livesBox.setIcon(lives);
		this.lifeLabel = new GameLabel();
		this.lifeLabel.setText("Vidas");
	}

	// Crea pregunta, puntaje, vida y panel de botones
	public void createWidgets() {
		this.createStatusBox();
		this.createDog();
		this.questionLabel = new GameLabel();
		this.livesIcons = new LivesIcons();
		this.btnPanel = new JPanel();		
	}

	// Crea el perro con dialogo
	protected void createDog(){
		dog = new JLabel();
		ImageIcon dogImg = new ImageIcon(QuizGame.class.getResource("/dog.png"));
		dog.setIcon(dogImg);		
	}

		// Establece las coordenadas de los componentes
	public void setComponentsBounds(){		
		super.setComponentsBounds();
		lifeLabel.setBounds(104,50,120,36);
		livesIcons.setBounds(180,25,370,90);
		livesBox.setBounds(76,25,370,90);
		questionLabel.setBounds(660,168,264,36);
		dog.setBounds(620,-15,960,670);
		btnPanel.setBounds(72,140,480,360);
		btnPanel.setOpaque(false);
	}

	// Agrega los componentes a un panel
	protected void addToPanel(JPanel panel){
		super.addToPanel(panel);
		panel.add(lifeLabel);		
		panel.add(livesIcons);
		panel.add(livesBox);
		panel.add(questionLabel);
		panel.add(dog);
		panel.add(btnPanel);
	}
	
	protected abstract void setQuestionLabel();

}
