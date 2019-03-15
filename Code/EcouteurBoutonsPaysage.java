import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
	
/**
 * @author ManonSophieClaire
 *
 */

public class EcouteurBoutonsPaysage implements ActionListener {

	private PanelBackGround panelBG; 
		
	/** Constructor
	 * @param panelBG Prend le panel "fond" de la fen�tre pour agir dessus
	 */
	public EcouteurBoutonsPaysage(PanelBackGround panelBG) {
		this.panelBG = panelBG;
	}
		
	/**
	 * Action engendr�e par l'appui sur un bouton de la cat�gorie Paysage
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		BoutonImage bouton = (BoutonImage)e.getSource();
		
		ImageIcon image = bouton.getImage();
		panelBG.setBG(image);

		panelBG.validate();
		panelBG.repaint();
		
		
	}

}
