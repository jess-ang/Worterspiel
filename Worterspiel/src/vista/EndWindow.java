package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import main.Main;
import modelo.Util.Games;

public class EndWindow
{
	private Main game;

	public EndWindow(Main game) {
		this.game = game;
	}
	public void showMsg(Games game,String message,ImageIcon icon)
    {
    	UIManager UI=new UIManager();
    	Color backColor = new Color(67,255,180);
    	 UI.put("OptionPane.background", backColor);
    	 UI.put("Panel.background", backColor);
    	 int reply = JOptionPane.showConfirmDialog(null, getOptionPanel(message), "Se acabo el juego", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,icon);
         if (reply == JOptionPane.YES_OPTION) {
        	this.game.setGame(game); 
         }
         else {
        	 this.game.setGame(Games.MAINMENU);
         }
    }

    private JPanel getOptionPanel(String message)
    {
        JPanel panel = new JPanel();
        try
        {
        	Font labelFont = new Font("serif", Font.PLAIN, 20);
            JLabel label = new JLabel(message);
            label.setFont(labelFont);
            panel.add(label);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return panel;
    }
}