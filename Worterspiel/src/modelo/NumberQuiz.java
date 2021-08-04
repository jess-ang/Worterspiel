package modelo;

import java.util.ArrayList;

public class NumberQuiz extends Quiz{

	public NumberQuiz() {
		super();
	}
		
	//Funcion que genera los numeros del quiz
	protected ArrayList<Answer> generateAnswers() {
		String u = "\u00FC",o="\u00F6", b="\u03B2";	//u00E4	ä
		ArrayList<Answer> ans = new ArrayList<>(); 
		ans.add(new Answer("null",0));
		ans.add(new Answer("eins",1));
		ans.add(new Answer("zwei",2));
		ans.add(new Answer("drei",3));
		ans.add(new Answer("vier",4));
		ans.add(new Answer("f"+u+"nf",5));
		ans.add(new Answer("sechs",6));
		ans.add(new Answer("sieben",7));
		ans.add(new Answer("acht",8));
		ans.add(new Answer("neun",9));
		ans.add(new Answer("zehn",10));
		ans.add(new Answer("elf",11));
		ans.add(new Answer("zw"+o+"lf",12));
		ans.add(new Answer("dreizehn",13));
		ans.add(new Answer("vierzehn",14));
		ans.add(new Answer("f"+u+"nfzehn",15));
		ans.add(new Answer("sechzehn",16));
		ans.add(new Answer("siebzehn",17));
		ans.add(new Answer("achtzehn",18));
		ans.add(new Answer("neunzehn",19));
		ans.add(new Answer("zwanzig",20));
		ans.add(new Answer("drei"+b+"ig",30));
		ans.add(new Answer("vierzig",40));
		ans.add(new Answer("f"+u+"nfzig",50));
		ans.add(new Answer("sechzig",60));
		ans.add(new Answer("siebzig",70));
		ans.add(new Answer("achtzig",80));
		ans.add(new Answer("neunzig",90));
		return ans;
	}
	
	
}