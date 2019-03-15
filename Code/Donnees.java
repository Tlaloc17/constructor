import javax.swing.*;
import java.util.*;
import java.io.*;

/** contient les images necessaire a la creation des boutons et cree les onglets */

public class Donnees{
    
    private PanelListeForme[] tab = new PanelListeForme[9];
    private static LinkedList<ImageIcon> collectionImagesImportees;
    private PanelListeFormeImport panelImp;
    private FenetrePrincipale fen;
    private PanelBackGround panelBG;
    private MoveComponents panelMove;
    
    /**constructeur
     * @param fen Fenetre de jeu contenant les onglets
     * @see MoveComponents
     * @see PanelListeForme
     * @see PanelListeFormeImport
     */
	public Donnees(FenetrePrincipale fen) {
		
		this.fen = fen;
		this.panelBG = fen.getPanelBG();
		panelMove = fen.getMoveComponents();
		
        
        LinkedList<ImageIcon> collectionForme = new LinkedList<ImageIcon>();
        
        for(int i=1; i<6; i++){
            String nom = "Forme"+i+".png";
            //System.out.println(nom);
            ImageIcon carre = new ImageIcon("Ressources/Forme/"+nom);
            collectionForme.add(carre);
        }
		
        LinkedList<ImageIcon> collectionPaysage = new LinkedList<ImageIcon>();
        
        for(int i=1; i<10; i++){
            String nom = "Paysage"+i+".jpg";
            ImageIcon paysage = new ImageIcon("Ressources/Paysages/"+nom);
            collectionPaysage.add(paysage);
        }
        
        collectionImagesImportees = new LinkedList<ImageIcon>();
        
		for(int i=1; i<=genererIndex(); i++){
            String nom = "ImageImportee"+i+".png";
            ImageIcon importee = new ImageIcon("Ressources/ImagesImportees/"+nom);
            addImported(importee);
        }
       
        PanelListeForme panel1 = new PanelListeForme(collectionForme,"Forme",panelMove);
        PanelListeFormePaysage panel2= new PanelListeFormePaysage(collectionPaysage,panelMove,panelBG);
        panelImp = new PanelListeFormeImport(collectionImagesImportees, panelMove);
		PanelListeForme[] tabTemp = {panel1, panel2, panelImp};
        this.tab = tabTemp;
		

    }
    
	/**
	 * 
	 * @return le tableau de PanelListeForme qui sert a creer l'onglet
	 */
    public PanelListeForme[] getTab(){
        return tab;
    }
    
    /** @return le panel des images importees */
    public PanelListeFormeImport getPanImp(){
    	return panelImp;
    }
    
    public void addImported(ImageIcon im){      
    	collectionImagesImportees.add(im);
    	tab[8] = new PanelListeForme(collectionImagesImportees, "ImagesImportees", panelMove);
    }
    
    public int genererIndex() {
	  
		int i = 0;
		
		try{
			BufferedReader file = new BufferedReader(new FileReader("Ressources/index.txt"));
			
			String line;
			line = file.readLine();
			i = Integer.parseInt(line);
			
			file.close();
        }
        catch (Exception e){
                System.out.println("Problem reading file.");
		}
        return i;
	}
        
}
