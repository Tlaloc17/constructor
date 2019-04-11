import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**Classe permattant le deplacement a la souris et la suppression par un clic droit */
    public class ComponentMove implements  MouseListener, MouseMotionListener {
 
        private boolean move;
        private int relx;
        private JComponent component;
        private int rely;
        private Container container;
 
        /**Constructeur
         * @param container Label qui contient les Label 
         */
        public ComponentMove(Container container) {
            this.container=container;
        }
        
        /** Action a executer lors d'un clic dans le Panel
         * Si un Label est deja selectionne, un clic le fixe
         * Sinon on selectionne le Label le plus proche de la souris et on peut commencer le mouvement
         * Si c'est un clic droit, le Label est supprime
         */
        public void mousePressed(MouseEvent e) {
            if ( move ) {
                move=false; // arret du mouvement
                component.setBorder(null); // on  supprime la bordure noire
                component=null;
            } else {
                component = getComponent(e.getX(),e.getY()); // on memorise le composant en deplacement
                if ( component!=null ) {
                    container.setComponentZOrder(component,0); // place le composant le plus haut possible
                    relx = e.getX()-component.getX(); // on memorise la position relative
                    rely = e.getY()-component.getY(); // on memorise la position relative
                    move=true; // demarrage du mouvement
                    component.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // on indique le composant selectionne par une bordure noire
                }
            }
            
             if (e.getModifiers() == MouseEvent.BUTTON3_MASK){
				component = getComponent(e.getX(),e.getY()); // on memorise le composant en deplacement
                if (component!=null) {
					container.remove(component);
					container.repaint();
				}
			}
        }
 
        /** Donne le premier composant qui correspont aux coordonnees de la souris
         * @param x Coordonnee x du curseur de la souris
         * @param y Coordonnee y du curseur de la souris
         * @return le composant ou null si il n'y a pas de composant sous la souris
         */
        private JComponent getComponent(int x, int y) {
            // on recherche le premier composant qui correspond aux coordonnees de la souris
            for(Component component : container.getComponents()) {
                if ( component instanceof JComponent && component.getBounds().contains(x, y) ) {
                    return (JComponent)component;
                }
            }
            return null;
        }
 
       /**Mouvement du Label par mouvement de la souris */
        public void mouseMoved(MouseEvent e) {
            if ( move ) {
                // si on deplace
                component.setLocation(e.getX()-relx, e.getY()-rely);
            }
        }
        
        

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

 
}
