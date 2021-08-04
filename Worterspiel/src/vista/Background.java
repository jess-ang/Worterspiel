package vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background {

	private JLabel opaqueBack;	
	private JLabel animBack;

	public Background() {
		this.createBack();
	}
	
	// Crea el fondo del juego
	public void createBack(){
		this.opaqueBack = new JLabel();	
		this.animBack = new JLabel();
		ImageIcon opaqueImg = new ImageIcon(Background.class.getResource("/back/opaque.png"));
		ImageIcon animImg = new ImageIcon(new ImageIcon(Background.class.getResource("/back/animated.gif")).getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT));
		this.opaqueBack.setIcon(opaqueImg);
		this.animBack.setIcon(animImg);
	}

	// Establece las coordenadas del fondo y lo agrega un panel
	public void addBack(JPanel panel){
		this.opaqueBack.setBounds(0,0,960,670);
		this.animBack.setBounds(0,0,960,670);
		panel.add(opaqueBack);
		panel.add(animBack);
	}

}
