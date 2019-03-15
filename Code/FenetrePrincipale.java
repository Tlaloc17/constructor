import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.awt.event.ComponentListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/** 
 * Definit la fenetre principale du jeu
 */

public class FenetrePrincipale extends JFrame implements ActionListener, ComponentListener {
		
		private MoveComponents panelMove;
		private PanelBackGround panelBG;
		private JButton btnDessiner;
		private JButton btnRetour;
		private JTabbedPane tabs;
		private PanelListeForme[] listePanel;
		private Donnees donnees;
		private Timer refresh = new Timer(10, this);


		/**
		 * Constructeur de la fenetre princiaple
		 * 
		 * @param longueur Longueur de la fenetre
		 * @param largeur Largeur de la fenetre
		 * 
		 * @see PanelListeForme
		 * @see MoveComponents
		 * @see Donnees
		 */
		
	public FenetrePrincipale(int longueur, int largeur){
		
		super("Construis ta structure"); //definit le nom de la fenetre
		setSize(longueur,largeur); //definit la taille de la fenetre
        setMinimumSize(new Dimension(800, 600)); //Definit la fenetre minimale
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelMove = new MoveComponents();
		
		//widgets

		
		btnDessiner = new JButton("Dessiner une forme");
		btnDessiner.addActionListener(this);
		
		btnRetour = new JButton("Menu");
		btnRetour.addActionListener(this);
		
		this.addComponentListener(this);
		
		tabs = new JTabbedPane();
        
	
		
		// conteneur principal
		
		JPanel principal = new JPanel(new BorderLayout());
		setContentPane(principal);
		
		JPanel commandes = new JPanel();
		commandes.setBackground(Color.lightGray);
		principal.add(commandes, BorderLayout.SOUTH);
		
		panelBG = new PanelBackGround();
		LayoutManager overlay = new OverlayLayout(panelBG);
		panelBG.setLayout(overlay);
		principal.add(panelBG, BorderLayout.CENTER);
		
		panelMove = new MoveComponents();
		panelBG.add(panelMove);
		
		donnees=new Donnees(this);	
		listePanel=donnees.getTab();
		
		// ajout des boutons a commandes

		commandes.add(btnDessiner);
		commandes.add(btnRetour);
		
		//onglets
		
		for(int i=0; i<listePanel.length; i++){
			tabs.addTab(listePanel[i].getTitre(), listePanel[i].getScroll());
		}
		
		principal.add(tabs, BorderLayout.EAST);
		
		//Rendre la fenetre visible
		setVisible(true);
		
		//Set le fond d'ecran de depart du jeu
		panelBG.setBG(new ImageIcon("/Ressources/background.png"));

		
	}
	
	/** 
	 * Ecouteur pour les boutons
	 * <i> Bouton Importer </i> ouvre un FileChoser pour importer une image
	 * <i> Bouton Dessiner </i> ouvre une FenetreDessin
	 * <i> Bouton Retour </i> ferme la fenetre et ouvre la fenetre menu
	 * 
	 * @see FenetreDessin
	 * 
	 */
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==btnDessiner){ //un clic sur "Dessiner" ouvre la fenetre de dessin
			FenetreDessin dessin = new FenetreDessin(this);
		}
        
		else if(e.getSource()==btnRetour){
			FenetreMenu fenetre = new FenetreMenu();
			this.dispose();
		}
		else if(e.getSource()==refresh){
			repaint();
			panelBG.repaint();
		}
		
    }
	
	/**return le panel contenant la patate et les images ajoutees
	 * @see MoveComponents
	 */
	public MoveComponents getMoveComponents(){
		return panelMove;
	}
	
	/**
	 * @return Le panel avec les boutons des images  creees
	 */
	public PanelListeFormeImport getPanelImport(){
		return donnees.getPanImp();
	}
	
	/**
	 * @return Le Panel de fond du jeu
	 */
	public PanelBackGround getPanelBG(){
		return panelBG;
	}
	
	/**
	 * Methode qui change la taille du fonc lorsque la fenetre est redimensionnee
	 */
	public void componentResized(ComponentEvent e) {
        panelBG.setBG(panelBG.getBG());           
    }
    
	@Override 
    public void componentHidden(ComponentEvent e){}
    public void componentShown(ComponentEvent e){}
    public void componentMoved(ComponentEvent e){}
	
	public static void main(String[] args) {

		new FenetrePrincipale(1000,1000);
		
	}
}


