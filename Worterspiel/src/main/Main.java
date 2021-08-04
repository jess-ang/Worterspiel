package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Util.Games;
import vista.ColorGame;
import vista.MainMenu;
import vista.NumberGame;

public class Main extends JFrame{
	private JPanel panel;
	
	public Main() {
		String o="\u00F6";
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(960,600);
		this.setResizable(false);
		this.setTitle("W"+o+"rterspiel");	
		this.panel=new MainMenu(this); 
		this.add(panel);
		this.setVisible(true);
	}
	
	public void setGame(Games game){
		this.removePanel();
		switch(game) {
		case NUMBERGAME:  
						this.panel = new NumberGame(this);
						this.setContentPane(this.panel);
						this.revalidate();
						break;
		case COLORGAME:
						this.panel = new ColorGame(this);
						this.setContentPane(this.panel);
						this.revalidate();
						break;
		case MAINMENU:
						this.panel = new MainMenu(this);
						this.setContentPane(this.panel);
						this.revalidate();
						break;
		}
	}
	
	
	public void removePanel() {
		this.getContentPane().remove(this.panel);
		
	}
	
	
	public static void main(String[] args) {
		Main newGame = new Main();		
	}

}
