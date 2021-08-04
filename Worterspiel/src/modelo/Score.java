package modelo;

public class Score {
	
	private int points;
	private final int rightGuess=10;

	public Score() {
		setPoints(0);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getRightGuess() {
		return rightGuess;
	}

	public void incPoints() {		
		setPoints(getPoints()+getRightGuess());
	}
	
	public String showStringPts() {
		return Integer.toString(getPoints());		
	}
	
}
