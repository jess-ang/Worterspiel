package modelo;

import java.awt.Color;
import java.util.ArrayList;

public class ColorQuiz extends Quiz{
	
	private final ArrayList<Color> btnColor;
	
	public ColorQuiz() {		
		super();
		this.btnColor = createColors();
	}
	
	public ArrayList<Color> getBtnColor() {
		return btnColor;
	}
	
	//Funcion que genera los colores del quiz
	protected ArrayList<Answer> generateAnswers() {
		ArrayList<Answer> ans = new ArrayList<>();
		String u="\u00FC", b="\u03B2";//o="\u00F6"	//u00E4	ä
		ans.add(new Answer("Rot",1));
		ans.add(new Answer("Orange",2));
		ans.add(new Answer("Gelb",3));
		ans.add(new Answer("Gr"+u+"n",4));
		ans.add(new Answer("Blau",5));
		ans.add(new Answer("Violett",6));
		ans.add(new Answer("Rosa",7));
		ans.add(new Answer("Braun",8));
		ans.add(new Answer("Grau",9));
		ans.add(new Answer("Schwarz",10));
		ans.add(new Answer("Wei"+b,11));
		ans.add(new Answer("Hellgr"+u+"n",12));
		ans.add(new Answer("Flieder",13));
		ans.add(new Answer("Hellblau",14));
		ans.add(new Answer("Pink",15));
		return ans;
	}
	
	//Funcion que genera los colores para los botones del quiz
	private ArrayList<Color> createColors() {
		ArrayList<Color> colors = new ArrayList<>();
		Color red = new Color(212,0,0);			
		Color orange = new Color(255,110,0);
		Color yellow = new Color(255,234,0);
		Color green = new Color(0,161,0);
		Color blue = new Color(24,61,240);
		Color purple = new Color(77,0,156);
		Color pink = new Color(255,113,219);
		Color brown = new Color(86,26,17);		
		Color grey = new Color(109,109,109);
		Color mint = new Color(146,255,93);
		Color lilac = new Color(129,70,255);
		Color cyan = new Color(0,183,241);
		Color magenta = new Color(236,0,172);
		
		colors.add(red);
		colors.add(orange);
		colors.add(yellow);
		colors.add(green);
		colors.add(blue);
		colors.add(purple);
		colors.add(pink);
		colors.add(brown);
		colors.add(grey);
		colors.add(Color.BLACK);
		colors.add(Color.WHITE);
		colors.add(mint);
		colors.add(lilac);
		colors.add(cyan);
		colors.add(magenta);	
		
		return colors;		
	}


}