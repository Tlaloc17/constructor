import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

/**
 * @author ManonSophieClaire
 *
 */
public class PanelBackGround extends JPanel {
	
	private ImageIcon bg = new ImageIcon("Ressources/background.png");
	
	/**
	 * Constructor
	 */
	public PanelBackGround(){
		
		setBackground(Color.WHITE);
		
		}
	
	/**
	 * Methode qui redefinit la methode d'affichage du panel pour correspondre a une image de paysage/background
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image image = bg.getImage();
		Image newimg = image.getScaledInstance(this.getWidth(), this.getHeight(),  java.awt.Image.SCALE_SMOOTH); //Permet de changer la taille de l'image en fonction du panel
		g.drawImage(image, 0, 0, null);
	}
		
	/** Methode qui permet de changer l'image affichee par le panel
	 * @param img Image qui sert de fond au panel
	 * @see EcouteurBoutonsPaysage 
	 */
	public void setBG(ImageIcon img){
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(this.getWidth(), this.getHeight(),  java.awt.Image.SCALE_SMOOTH);
		bg = new ImageIcon(newimg);
		repaint();	
		
	}
	
	public ImageIcon getBG(){
		return bg;
	}
}

