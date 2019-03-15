import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/** Fenetre s'ouvrant à l'execution du jeu */
public class FenetreMenu extends JFrame implements ActionListener{
	

    //Déclaration des elements graphiques de la fenêtre
   
	private JButton boutonJeu;
    private JButton boutonScore;
    private JLabel texte;

    /**
     * Constructor 
     */
    public FenetreMenu() {

        //Définition du nom de la fenetre
        super("Menu");

        //Dimensions de la fenetre graphique et fermeture
        this.setSize(800,450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Création des éléments visibles sur la fenetre
        boutonJeu= new JButton("Nouvelle Structure");
        boutonScore= new JButton("Tableau des scores");
        texte = new JLabel("<html>Bienvenue dans la soufflerie 2.0,<br>testez vos maquettes en toute simplicité</html>");
        
        //Image en fond
        Icon fond = new ImageIcon("Ressources/FondAccueil.jpg");
        JLabel BackGround = new JLabel();
        BackGround.setIcon(fond);
        
		//Je lie les boutons à l'écouteur de la fenêtre
		boutonJeu.addActionListener(this);
        
        //Création d'un conteneur principal
        JPanel conteneurPrincipal = new JPanel();
        conteneurPrincipal.setLayout(null);
       
        //Ajout des éléments graphiques au conteneur principal
		conteneurPrincipal.add(boutonJeu);
		conteneurPrincipal.add(boutonScore);
		conteneurPrincipal.add(texte);
        conteneurPrincipal.add(BackGround);
        
        boutonJeu.setBounds((this.getWidth())-170, (this.getHeight())-130, 135, 20);
        boutonScore.setBounds((this.getWidth())-170, (this.getHeight())-80, 135, 20);
        texte.setBounds((this.getWidth()/4)-150, (this.getHeight()/2)-150, 300, 50);
        BackGround.setBounds(0,0,800,450);
        
        //Mise en place du conteneur principal dans la fenetre
        this.setContentPane(conteneurPrincipal);
        
        //Rendre la fenêtre visible
        this.setResizable(false);
        this.setVisible(true);
        
        
    }
    
    /** Action engendree par le clic sur un des deux boutons de la fenetre
     * Pour le bouton 
     * Pour le bouton 
     * 
     * @see MoveComponents
     */
    
    public void actionPerformed(ActionEvent e){
		
        if(e.getSource() == boutonJeu){
			
            new FenetrePrincipale(1000,1000);
            this.dispose(); 
        }  
    }

	public static void main(String[] args) {

		new FenetreMenu();
		
	}

}


