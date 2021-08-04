package modelo;

public class Life {
	private int lives;
	
	public Life() {
		setLives(3);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public void decLives() {		
		setLives(getLives()-1);
	}
	
	public String showStringLives() {
		return Integer.toString(getLives());		
	}
	
}
