import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**Sous-classe de PanelListeForme prenant en charge les images importées par l'utilisateur */
public class PanelListeFormeImport extends PanelListeForme {
	
	/** Conctructeur
	 * @param panelMove Panel qui contiendra l'affichage des image au clic sur un bouton
	 */
	 LinkedList<ImageIcon> liste;
	 
	public PanelListeFormeImport(LinkedList<ImageIcon> liste, MoveComponents panelMove){
		super(liste, "Images Importees", panelMove);
	}
	
	/** Ajoute une image à la listte des images importées et crée son bouton
	 * @param img Image à importer 
	 */
	public void addImported(ImageIcon img){
		
		EcouteurBoutons ebtn = new EcouteurBoutons(getMovePanel());
		BoutonImage btn = new BoutonImage(img);
		btn.addActionListener(ebtn);
		btn.setOpaque(true);
		conteneur.add(btn);
		conteneur.repaint();
		
	}
	
}
