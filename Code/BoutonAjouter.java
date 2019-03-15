import javax.swing.*;
import java.awt.*;

/** Bouton utilisé dans la classe fenêtre dessin
 * */

public class BoutonAjouter extends JButton {
	
	private Figure fig; 

	/**constructeur
     * @param fig Figure dessinée à ajouter au dessin
     * */
     
	public BoutonAjouter(Figure fig){
		super("Ajouter");
	}
	
	/** @return La figure qui doit être ajoutée 
	 * @see Figure
	 */
	public Figure getFigure(){
		return fig;
	}
	
	/**@param fig La Figure que ce bouton doit ajouter au dessin
	 * @see Figure
	 */
	public void setFigure(Figure fig){
		this.fig = fig;
	}
		
}
