import java.awt.Point;
import javax.swing.*;
import java.awt.*;

/**Figure rectangle pour le dessin */
public class Rectangle extends Figure {
	
    private int hauteur;
    private int largeur;

    /** Constructeur
     * @param haut Hauteur du rectangle
     * @param larg Largeur du rectangle
     * @param p Point d'ancrage de la figure
     * @param c Couleur de la figure
     * @param filled <i> true </i> si la figure est remplie, <i> false </i> sinon   
     * @see Figure
     */
    public Rectangle(int haut, int larg, Point p, Color c, boolean filled) {
        
        super(p,c,filled);
        
        hauteur =  haut;
        largeur = larg;
    }
    
    /** Dessine le rectangle */
    public void dessiner(Graphics g){
        g.setColor(this.getCouleur());
		if(this.getFilled() == true){
			g.fillRect((int)getPointA().getX(), (int)getPointA().getY(), hauteur, largeur);
		}else{
			g.drawRect((int)getPointA().getX(), (int)getPointA().getY(), hauteur, largeur);
		}
    }
}
