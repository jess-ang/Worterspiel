package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LivesIcons extends JLabel
{
	private ImageIcon lives3;
	private ImageIcon lives2;
	private ImageIcon lives1;
	private ImageIcon lives0;

	
	public LivesIcons() {
		generateLivesImg();
		setIcon(lives3);		
	}
	
	private void generateLivesImg() {
		lives3 = new ImageIcon(LivesIcons.class.getResource("/lives/vidas3.png"));
		lives2 = new ImageIcon(LivesIcons.class.getResource("/lives/vidas2.png"));
		lives1 = new ImageIcon(LivesIcons.class.getResource("/lives/vidas1.png"));
		lives0 = new ImageIcon(LivesIcons.class.getResource("/lives/vidas0.png"));
	}
	
	public void setLivesImg(int lives) {
		switch(lives){
			case 0: setIcon(lives0); 
					break;
			case 1: setIcon(lives1); 
					break;
			case 2: setIcon(lives2); 
					break;
			case 3: setIcon(lives3); 
					break;
			default: break;
		}
	}
	
}
