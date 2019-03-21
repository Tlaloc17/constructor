import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
	
/**Ecouteur pour les boutons contenant les images 
 * @see BoutonImage
 * @see MoveComponents
 */
public class EcouteurBoutons implements ActionListener {

	private MoveComponents movePanel; 
		
	/**Constructeur
	 * @param movePanel Panel contenant la patate qui recevra les images 
	 */
	public EcouteurBoutons(MoveComponents movePanel) {
		this.movePanel = movePanel;
	}
	
	/** Action engendree par l'appui sur un bouton BoutonImage
	 * @see LabelImage
	 */
	
	public void actionPerformed(ActionEvent e) {
		BoutonImage bouton = (BoutonImage)e.getSource();
		
		ImageIcon image = bouton.getImage();
		
		LabelImage label = new LabelImage(image);
		
		label.setLocation(30,30);

		movePanel.add(label);
		movePanel.validate();
		movePanel.repaint();
		
		
	}

}
