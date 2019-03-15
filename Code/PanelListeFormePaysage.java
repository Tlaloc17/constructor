import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class PanelListeFormePaysage extends PanelListeForme {
	
	private PanelBackGround panelBG;
	
	
	public PanelListeFormePaysage(LinkedList<ImageIcon> liste, MoveComponents panelMove, PanelBackGround panelBG){
		super(liste, "Paysage", panelMove);
		this.panelBG = panelBG;
		ajouterBoutons();
		
	}
	
	public void ajouterBoutons(){
	for(int i = 0 ; i<getListe().size() ; i++){
			BoutonImage btn = new BoutonImage(getListe().get(i));
			btn.setOpaque(true);
			EcouteurBoutonsPaysage ebtn = new EcouteurBoutonsPaysage(panelBG);
			btn.addActionListener(ebtn);
			conteneur.add(btn);
			
		}
	}
}
