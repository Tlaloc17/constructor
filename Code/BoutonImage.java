import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

/** Bouton utilise dans les onglets de la fenetre principale
 * @see PanelListeForme
 * @see PanelListeFormeImport
 */
public class BoutonImage extends JButton {
	
	private ImageIcon icon; 
	private ImageIcon img;
	
	/** Constructeur
	 * @param img Image que ce bouton doit contenir
	 */
	public BoutonImage(ImageIcon img){
		
		super();
		setSize(100,100);
		this.img = img;
		ImageIcon scaledImg = new ImageIcon(img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		this.icon = scaledImg;
		setIcon(icon);
	}
	
	/** @return l'image originale
	 */
	public ImageIcon getIcon(){
		return icon;
	}
	
	/**
	 * @return l'image modifiee pour etre contenue dans le bouton
	 */
	public ImageIcon getImage(){
		return img;
	}
}
