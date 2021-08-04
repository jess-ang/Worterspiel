package vista;

import main.Main;

import modelo.Util.Games;
import modelo.Answer;
import modelo.NumberQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class NumberGame extends QuizGame{
	
	private ArrayList<NumButton> buttonList;
	private NumberQuiz quiz;
	private Controlador controller; 
	
	public NumberGame(Main rootGame) {			
		super(rootGame);
		this.controller = new Controlador();		
		this.quiz = new NumberQuiz();
		
		this.generateBtn(); 
		this.setLayout(null);
		this.setComponentsBounds();
		this.addToPanel(this);	
		this.background.addBack(this);
		this.addController();
		
		Collections.shuffle(this.buttonList);//revuelvo los botones para mostrarlos en posiciones aleatorias
		Collections.shuffle(this.quiz.getIndex());// revuelve los indices enteros almacenados en el arraylist index
		
		this.setBtnNumbers();		
		this.setQuestionLabel();
	}
	
	//Crea 12 botones guardados en un arrayList
	public void generateBtn() {
		this.buttonList = new ArrayList<>();
		for(int i=0;i<btnNum;i++)
			this.buttonList.add(new NumButton());
	}
	
	//Agrega el controlador a los botones del arrayList y los agrega al panel
	public void addController() {
		for(NumButton x: buttonList) {			
			x.addActionListener(controller);
			super.btnPanel.add(x);			
		}
	}
	
	// Asigna los digitos a los botones del arraylist
	public void setBtnNumbers() {
		int number, index=0;
		for(NumButton x: buttonList) {
			number = this.quiz.getAnswersList().get(this.quiz.getIndex().get(index++)).getAnswerNum();	
			x.setText(Integer.toString(number));			
		}
	}
	
	// Asigna la pregunta al label
	public void setQuestionLabel() {
		int firstIndex=0;
		Answer question = quiz.getAnswersList().get(quiz.getIndex().get(firstIndex));
		quiz.getAskedQuestions().add(question);
		questionLabel.setText(question.getAnswer());
	}

	private class Controlador implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			NumButton b = (NumButton)e.getSource();
			int firstIndex=0;
			Answer rightAns = quiz.getAnswersList().get(quiz.getIndex().get(firstIndex));
			boolean endgame = false;			
			
			if(quiz.getAskedQuestions().size()==quiz.getPlays())
				endgame = true;
				
			// Si la pregunta y la respuesta coinciden
			if (Integer.parseInt(b.getText())==(rightAns.getAnswerNum())) {
				getScore().incPoints();
				scoreLabel.setText("Puntos: "+getScore().showStringPts());
								
				if(!endgame) {
					Collections.shuffle(buttonList);//revuelvo los botones para mostrarlos en posiciones aleatorias					
					do {
						Collections.shuffle(quiz.getIndex());// revuelve los indices enteros almacenados en el arraylist index
						rightAns = quiz.getAnswersList().get(quiz.getIndex().get(firstIndex));
					} while(quiz.getAskedQuestions().contains(rightAns));					
					setBtnNumbers();
					setQuestionLabel();
				}
				else {					
					for(NumButton x : buttonList) { //desactiva los botones
						x.setEnabled(false);						
					}
					ImageIcon image = new ImageIcon(NumberGame.class.getResource("/endgame/won.png"));
					String msg = "Ganaste! Quieres jugar de nuevo?";
					EndWindow won = new EndWindow(rootGame);
					won.showMsg(Games.NUMBERGAME,msg,image);				
				}					
			}
			else {
				getLife().decLives();
				livesIcons.setLivesImg(getLife().getLives());
				if(getLife().getLives()==0) {
					for(NumButton x : buttonList) { //desactiva los botones
						x.setEnabled(false);
					}					
					ImageIcon image = new ImageIcon(NumberGame.class.getResource("/endgame/lost.png"));
					String msg = "Perdiste! Quieres jugar de nuevo?";
					EndWindow lost = new EndWindow(rootGame);
					lost.showMsg(Games.NUMBERGAME,msg,image);		
				}				
			}
		}
	}
}
