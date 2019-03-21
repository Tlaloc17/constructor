import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Score extends JFrame implements ActionListener{
        
        
      // Création des différents tableaux
	    
	    private JPanel cadreScore;
	    private JPanel cadreStructure;
        private JPanel cadrePrincipal;
        private JPanel cadreGrid;
        private JButton btnMenu;
     // Instanciation
        
        private JLabel labelScore;
        private JLabel labelStructure;
        
        
       
    public Score() {
		super("Tableau des meilleurs scores"); // pour mettre un titre
		
        
		//Dimensions de la fenetre graphique et fermeture
		
		labelScore = new JLabel("Classement des meilleurs scores: ");// en-tete
		labelStructure = new JLabel("Accéder aux structures correspondantes: ");//pour la saisie du nom
	    btnMenu = new JButton ("Menu: ");
        btnMenu.addActionListener(this); // connection au bouton
	    
	    // panneau des scores
	    JPanel cadreScore= new JPanel();  // important
		cadreScore.setBackground(Color.gray);
		cadreScore.add(labelScore);
				
		
		// définition du panneau des structures
		JPanel cadreStructure= new JPanel();
		cadreStructure.setBackground(Color.lightGray);
		cadreStructure.add(labelStructure);
		
		// Panneau grig
		JPanel cadreGrid= new JPanel(new GridLayout());
		cadreGrid.add(cadreScore);
		cadreGrid.add(cadreStructure);
		
		
		// Définition du panneau principal avec orientaion et tout des composants
		JPanel cadrePrincipal= new JPanel(new BorderLayout()); //borderLayout va donner les directions
		cadrePrincipal.add(cadreGrid, BorderLayout.CENTER);
		
		cadrePrincipal.add(btnMenu, BorderLayout.SOUTH);
		


        this.setSize(1400,1000) ; // réler la taille plus tard
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(cadrePrincipal);
		
		setVisible(true);
		
	
	}
	    public void actionPerformed(ActionEvent e){  // Permet de faire le lien entre la fenêtre menu à l'aide du bouton
		
        if(e.getSource() == btnMenu){
			
            new FenetreMenu();
            this.dispose(); 
        }
        }
        
public static void main(String[] args) {

		new Score(); // Permet de juste afficher notre fenetre
		
	}
}

