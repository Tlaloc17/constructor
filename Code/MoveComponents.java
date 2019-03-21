import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/** JPanel permettant de bouger les Labels qu'il contient avec la souris */
public class MoveComponents extends JPanel {
 
	/** Constructeur */
    public MoveComponents() {
 
        setLayout(null);
		setBackground(new Color(255,255,255,0));
		setOpaque(false);
        ComponentMove listener = new ComponentMove(this);
      
        addMouseListener(listener);
        addMouseMotionListener(listener);
 
    }
    
    /**
     * Permet de faire une sauvegarde du panel (avec ses Label)
     */
    public void sauvegarder(){
        File f = new File ("save.objet");
 
        try{
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (f));
            oos.writeObject(this);
            oos.close();
        }catch (IOException exception){
            System.out.println ("Erreur lors de l'ecriture : " + exception.getMessage());
        }
    } 
 
}
   
