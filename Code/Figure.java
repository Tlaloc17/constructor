import javax.swing.*;
import java.awt.*;

/** Interface pour les classes Oval, Rectangle, Triangle 
 * @see Oval
 * @see Rectangle
 * @see Triangle
 */
abstract public class Figure {
    
    private Point pointAncrage;
    private Color couleur;
    private boolean filled;
    
    /** Constructeur
     * @param p point d'ancrage de la figure
     * @param c couleur de la figure
     * @param filled <i>true</i> si la figure est remplie, <i>false</i> sinon
     */
    public Figure(Point p, Color c, Boolean filled){
        
        pointAncrage = p;
        this.filled = filled;
        couleur = c;
        
    }
    /**@return le point d'ancrage de la figure */
    public Point getPoint(){
        return pointAncrage;
    }
    
    /**@return la couleur de la figure */
    public Color getCouleur(){
		return couleur;
	}
	
    /** @return l'état rempli ou non rempli de la figure */
	public boolean getFilled(){
		return filled;
	}
    
	/** Dessine la figure */
    abstract void dessiner(Graphics g);
    
    public Point getPointA(){
        return pointAncrage;
    }
        
}
