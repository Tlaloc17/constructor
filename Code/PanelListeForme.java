import java.awt.*;
import javax.swing.*;
import java.util.*;

/** La classe PanelListeForme cree des JScrollPane contenant les boutons associees aux formes

 */
public class PanelListeForme{
	
	private LinkedList<ImageIcon> liste;
	private String titre;
	private JScrollPane scroll;
	private MoveComponents movePanel;
	JPanel conteneur;
	
	/** Constructeur de la classe PanelListeForme
	 * 
	 * @param liste Liste des images a integrer aux boutons du panel
	 * @param titre Titre qui s'affichera comme titre de l'onglet
	 * @param movePanel Panel qui contiendra l'affichage des image au clic sur un bouton
	 * 		
	 */
	
	public PanelListeForme(LinkedList<ImageIcon> liste, String titre, MoveComponents movePanel){
		
		
		this.liste = liste;
		this.titre = titre;
		this.movePanel = movePanel;
		
		//creation des Panel
		conteneur = new JPanel(new GridLayout(0,1));
		conteneur.setOpaque(true);
		scroll = new JScrollPane(conteneur);
		
		if(this instanceof PanelListeFormePaysage == false){
			ajouterBoutons();
		}
		
		scroll.setOpaque(true);
		
		//Scroll bars
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
	}
	
	public void ajouterBoutons(){ //Creation d'un bouton pour chaque image
		
		for(int i = 0 ; i<liste.size(); i++){
			BoutonImage btn = new BoutonImage(liste.get(i));
			btn.setOpaque(true);
			EcouteurBoutons ebtn = new EcouteurBoutons(movePanel);
			btn.addActionListener(ebtn);
			conteneur.add(btn);
		}
	}
	
	/** 
	 * @return le titre de l'onglet */
	public String getTitre(){
		return titre;
	}
	
	/**
	 * @return le JScrollPanel contenant les boutons
	 */
	public JScrollPane getScroll(){
		return scroll;
	}
	
	/**
	 * @return le panel qui permet de mouvoir les objets
	 */
	public MoveComponents getMovePanel(){
		return movePanel;
	}
	
	/**
	 * @return la liste des images utilisee pour les boutons
	 */
	public LinkedList<ImageIcon> getListe(){
		return liste;
	}
	


	
}
