package modelo;

public class Answer {
	private String answer;
	private int answerNum;

	public Answer(String answer, int answerNum) {
		setAnswer(answer);
		setAnswerNum(answerNum);
	}

	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}
	
}
