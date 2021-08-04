package vista;

import main.Main;

import modelo.Answer;
import modelo.ColorQuiz;
import modelo.Util.Games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class ColorGame extends QuizGame{
	
	private ArrayList<ColorButton> buttonList;
	private ColorQuiz quiz;
	private Controlador controller;

	public ColorGame(Main rootGame) {		
		super(rootGame);
		this.controller = new Controlador();
		this.quiz = new ColorQuiz();
		
		this.generateBtn(); 
		this.setLayout(null);
		this.setComponentsBounds();
		this.addToPanel(this);	
		this.background.addBack(this);
		this.addController();
		
		Collections.shuffle(this.buttonList);//revuelvo los botones para mostrarlos en posiciones aleatorias
		Collections.shuffle(quiz.getIndex());// revuelve los indices enteros almacenados en el arraylist index
		
		this.setBtnColors();
		this.setQuestionLabel();
	}
	
	//Crea 12 botones guardados en un arrayList
	public void generateBtn() {
		this.buttonList = new ArrayList<>();
		for(int i=0;i<btnNum;i++)
			this.buttonList.add(new ColorButton());
	}
	
	//Agrega el controlador a los botones del arrayList y los agrega al panel
	public void addController() {
		for(ColorButton x: buttonList) {			
			x.addActionListener(controller);
			super.btnPanel.add(x);			
		}
	}
	
	// Asigna los colores a los botones del arraylist
	public void setBtnColors() {
		int id, index=0; 
		for(ColorButton x: buttonList) {
			id = this.quiz.getAnswersList().get(quiz.getIndex().get(index)).getAnswerNum();	
			x.setBtnID(id);
			x.setBackground(this.quiz.getBtnColor().get(quiz.getIndex().get(index)));
			index++;
		}
	}
	
	// Asigna la pregunta al label
	public void setQuestionLabel() {
		int firstIndex=0;
		Answer question = quiz.getAnswersList().get(quiz.getIndex().get(firstIndex));
		quiz.getAskedQuestions().add(question);
		questionLabel.setText(question.getAnswer());
		//System.out.println(question.getAnswer());
	}
	
	private class Controlador implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ColorButton b = (ColorButton)e.getSource();
			int firstIndex=0;
			Answer rightAns = quiz.getAnswersList().get(quiz.getIndex().get(firstIndex));
			boolean endgame = false;
			
			if(quiz.getAskedQuestions().size()==quiz.getPlays())
				endgame = true;
				
			// Si la pregunta y la respuesta coinciden
			if (b.getBtnID()==rightAns.getAnswerNum()) {
				getScore().incPoints();
				scoreLabel.setText("Puntos: "+getScore().showStringPts());
								
				if(!endgame) {
					Collections.shuffle(buttonList);//revuelvo los botones para mostrarlos en posiciones aleatorias					
					do {
						Collections.shuffle(quiz.getIndex());// revuelve los indices enteros almacenados en el arraylist index
						rightAns = quiz.getAnswersList().get(quiz.getIndex().get(firstIndex));
					} while(quiz.getAskedQuestions().contains(rightAns));					
					setBtnColors();
					setQuestionLabel();
				}
				else {					
					for(ColorButton x : buttonList) { //desactiva los botones
						x.setEnabled(false);						
					}
					ImageIcon image = new ImageIcon(NumberGame.class.getResource("/endgame/won.png"));
					String msg = "Ganaste! Quieres jugar de nuevo?";
					EndWindow won = new EndWindow(rootGame);
					won.showMsg(Games.COLORGAME,msg,image);					
				}					
			}
			else {
				getLife().decLives();
				livesIcons.setLivesImg(getLife().getLives());
				if(getLife().getLives()==0) {
					for(ColorButton x : buttonList) { //desactiva los botones
						x.setEnabled(false);
					}
					ImageIcon image = new ImageIcon(NumberGame.class.getResource("/endgame/lost.png"));
					String msg = "Perdiste! Quieres jugar de nuevo?";
					EndWindow lost = new EndWindow(rootGame);
					lost.showMsg(Games.COLORGAME,msg,image);				
				}				
			}
		}
	}
}
