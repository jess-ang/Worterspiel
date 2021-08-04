package modelo;

import java.util.ArrayList;

public abstract class Quiz {

	protected final ArrayList<Answer> answersList;
	protected final ArrayList<Answer> askedQuestions;
	protected final ArrayList<Integer> index;
	protected final int plays=10; //define el numero de jugadas

	public Quiz(){
		this.askedQuestions = new ArrayList<>();
		this.answersList = generateAnswers();
		this.index = new ArrayList<>();
		this.generateIndexes();	
	}

	public ArrayList<Answer> getAnswersList() {
		return answersList;
	}

	public ArrayList<Answer> getAskedQuestions() {
		return askedQuestions;
	}

	public ArrayList<Integer> getIndex() {
		return index;
	}

	public int getPlays() {
		return plays;
	}

	//Genero un ArrayList contenedor de los indices de answersList
	protected void generateIndexes(){
		int answListSize = this.answersList.size();		
		for(int i=0;i<answListSize;i++) { 
			this.index.add(i,i);  
		}
	}

	protected abstract ArrayList<Answer> generateAnswers();

}
