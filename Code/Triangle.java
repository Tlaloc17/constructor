import java.awt.Point;
import javax.swing.*;
import java.awt.*;

/**Figure triangle pour le dessin */
public class Triangle extends Figure {
    private int hauteur;
    private int base;    

    /** Constructeur
     * @param haut Hauteur du triangle
     * @param basis Largeur de la base du triangle
     * @param p Point d'ancrage de la figure
     * @param c Couleur de la figure
     * @param filled <i> true </i> si la figure est remplie, <i> false </i> sinon   
     * @see Figure
     */
    public Triangle(int haut, int basis, Point p, Color c, boolean filled) {
        
        super(p,c,filled);
        hauteur =  haut;
        base = basis;
  
    }
    
    /**Dessine le triangle */
    public void dessiner(Graphics g){
		int[] x = {(int)getPointA().getX(), (int)getPointA().getX()-base/2, (int)getPointA().getX()+base/2};
		int[] y = {(int)getPointA().getY(),(int)getPointA().getY()+hauteur,(int)getPointA().getY()+hauteur};
		
        g.setColor(this.getCouleur());
		if(this.getFilled() == true){
			g.fillPolygon(x,y,3);
		}else{
			g.drawPolygon(x,y,3);
		}
    }
}
