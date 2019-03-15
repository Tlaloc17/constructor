import java.awt.Point;
import javax.swing.*;
import java.awt.*;

/**Figure ovale pour le dessin */
public class Oval extends Figure {

    private int hauteur;
    private int largeur;
    
    /** Constructeur
     * @param haut Hauteur de l'ovale
     * @param larg Largeur de l'ovale
     * @param p Point d'ancrage de la figure
     * @param c Couleur de la figure
     * @param filled <i> true </i> si la figure est remplie, <i> false </i> sinon   
     * @see Figure
     */
    public Oval(int haut, int larg, Point p, Color c, boolean filled) {
        super(p,c,filled);
        hauteur = haut;
        largeur = larg;
        
    }
    /** Dessine l'ovale */
    public void dessiner(Graphics g){
		g.setColor(this.getCouleur());
		if(this.getFilled() == true){
			g.fillOval((int)getPointA().getX(), (int)getPointA().getY(), hauteur, largeur);
		}else{
			g.drawOval((int)getPointA().getX(), (int)getPointA().getY(), hauteur, largeur);
		}
    }
}
