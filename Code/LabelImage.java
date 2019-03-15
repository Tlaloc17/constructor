import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

/** Label cree au clic sur un BoutonImage contenant l'image du bouton
 * @see BoutonImage
 * @see EcouteurBoutons
 */
public class LabelImage extends JLabel {
	
	private ImageIcon icon; 

	/** Constructeur
	 * @param img Image a mettre dans le label, obtenue par le bouton
	 */
	public LabelImage(ImageIcon img){
		super();
		icon = img;
		setEnabled(false);
		setOpaque(false);
		setSize(img.getIconWidth(),img.getIconHeight());
	}
	
	
	/** Override Paint
	 * Change la forme de dessin du label avec l'image selectionnee
	 */
	public void paint(Graphics g){
		icon.paintIcon(this, g, 5, 5);
	}
		
}
