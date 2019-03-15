import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * @author ManonSophieClaire
 *
 */
public class FenetreDessin extends JFrame implements MouseListener, MouseMotionListener, ActionListener{
	
	//Declaration des elements graphiques
    
    private int x1; 
    private int y1;
    
    private LinkedList<Figure> listeFigure = new LinkedList<Figure>();
    
    private JPanel drawArea = new JPanel(); //Panel Dessin
    private JPanel imagePanel; //Panel ou est stockee l'image finale
    private JPanel objetFigure;
    private JPanel objetCreer;
    private JPanel objetBouton;
    private JPanel objetParam;
    
    private JLabel haut; 
	private JLabel larg; 
    private JLabel xLabel;
    private JLabel yLabel;
    
    private JLabel rouge;
    private JLabel vert;
    private JLabel bleu;
    
    private JLabel remplir;
    
    private JSpinner spinnerH; //Hauteur de la figure
    private JSpinner spinnerL; //Largeur de la figure
    private JSpinner spinnerX; //Position en X de la figure
    private JSpinner spinnerY; //Position en Y de la figure
    
    private JSlider sliderR; //Slider pour le rouge
    private JSlider sliderG;//Slider pour le vert
    private JSlider sliderB;//Slider pour le bleu
    
    private JCheckBox rempli; //CheckBox pour choisir l'etat de la forme (remplie ou non)
	
	private JButton btnR;  //Creation Rectangle
	private JButton btnC;  // Creation Oval
    private JButton btnT;  // Creation Triangle
    private JButton analyse; //Analyser la figure
    private BoutonAjouter ajouter; //Ajouter la figure créée à l'image finale
    private JButton reinitD; //Reinitialiser le dessin
    private JButton reinitI; //Reinitialiser l'image finale
    private JButton btnCouleur; //Changer la couleur des formes creees
    private JButton exporter; //Enregistrer l'image finale et l'ajouter dans : Images Importees
    
    private Color couleur;
    
    private BufferedImage dessin; //Image du dessin à la main qui va être analysée
    private BufferedImage expDessin; //Image du dessin final qui va être ajoutée à Images Importées
	private	Graphics2D gDrawA; //Graphics de la zone de dessin à la main
	private Graphics2D gDessin; 
	private Graphics2D gImage;
	private Graphics2D gExpDessin;
	
	private FenetrePrincipale f;
	private PanelListeFormeImport pI;
	
	public FenetreDessin(FenetrePrincipale f){
		
		//On definit le nom de la fenetre
		super("Draw Your Figures");
		
		//Attributs avec valeurs en parametre
		this.f = f;
		pI = f.getPanelImport();
		
		//Dimensions de la fenetre graphique 
		this.setSize(1200, 700);
        this.setResizable(false);
		
		//Ferme le programme avec la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Creation des elements visibles sur la fenetre

        haut = new JLabel("H");
        larg = new JLabel("L");
        xLabel = new JLabel("X");
        yLabel = new JLabel("Y");
        
        rouge = new JLabel("R");
        vert = new JLabel("V");
        bleu = new JLabel("B");
        
        remplir = new JLabel("Remplir");
        
        analyse = new JButton("Analyse");
        ajouter = new BoutonAjouter(null);
        reinitD = new JButton("Reinitialiser Dessin");
        reinitI = new JButton("Reinitialiser Image");
        exporter = new JButton("Exporter");
        
        btnR = new JButton("Créer Rectangle");
        btnC = new JButton("Créer Oval");
        btnT = new JButton("Créer Triangle");
        
        btnCouleur = new JButton("Selectionner Couleur");
        
        spinnerH = new JSpinner(new SpinnerNumberModel(300, 0, 600, 10));
		spinnerL = new JSpinner(new SpinnerNumberModel(250, 0, 500, 10));
		spinnerX = new JSpinner(new SpinnerNumberModel(250, 0, 500, 10));
		spinnerY = new JSpinner(new SpinnerNumberModel(0, 0, 600, 10));
		
		sliderR = new JSlider(0,255,0);
		sliderG = new JSlider(0,255,0);
		sliderB = new JSlider(0,255,0);
		
		rempli = new JCheckBox();
        
        
		//Creation des conteneurs
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		JPanel monPanelCommande = new JPanel(new GridLayout(4,0));
        
        imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setPreferredSize(new Dimension(600,600));
        imagePanel.setLocation(0,0);
        imagePanel.setOpaque(true);
        
        objetFigure = new JPanel(new FlowLayout());
        objetCreer = new JPanel(new FlowLayout());
        objetBouton = new JPanel(new FlowLayout());
        objetParam = new JPanel(new FlowLayout());
       
        drawArea.setBackground(new Color(240,240,240));
		
		//Mise en place du conteneur principal dans la fenetre
        this.setContentPane(cadrePrincipal);
        
        //Mise en place des conteneurs dans le conteneur principal
        cadrePrincipal.add(monPanelCommande, BorderLayout.SOUTH);
        cadrePrincipal.add(drawArea, BorderLayout.CENTER);
        cadrePrincipal.add(imagePanel, BorderLayout.WEST);
        
        
        //Mise en place des widgets dans les autres conteneurs
        objetBouton.add(analyse);
        objetBouton.add(reinitD);
        objetBouton.add(reinitI);
        objetBouton.add(ajouter);
        objetBouton.add(exporter);

        objetFigure.add(haut);
        objetFigure.add(spinnerH);
        objetFigure.add(larg);
        objetFigure.add(spinnerL);
        objetFigure.add(xLabel);
        objetFigure.add(spinnerX);
        objetFigure.add(yLabel);
        objetFigure.add(spinnerY);
        
        objetCreer.add(btnR);
        btnR.setEnabled(false);
        objetCreer.add(btnC);
        btnC.setEnabled(false);
        objetCreer.add(btnT);
        btnT.setEnabled(false);
        
        objetParam.add(rouge);
        objetParam.add(sliderR);
        objetParam.add(vert);
        objetParam.add(sliderG);
        objetParam.add(bleu);
        objetParam.add(sliderB);
        objetParam.add(btnCouleur);
        objetParam.add(remplir);
        objetParam.add(rempli);
        
        monPanelCommande.add(objetBouton);
        monPanelCommande.add(objetFigure);
        monPanelCommande.add(objetCreer);
        monPanelCommande.add(objetParam);
        
        //Ecouteurs
        drawArea.addMouseListener(this);
        drawArea.addMouseMotionListener(this);
        
        analyse.addActionListener(this);
        reinitD.addActionListener(this);
        reinitI.addActionListener(this);
        ajouter.addActionListener(this);
        exporter.addActionListener(this);
        
        btnR.addActionListener(this);
        btnC.addActionListener(this);
        btnT.addActionListener(this);
        
        btnCouleur.addActionListener(this);
        
        //Rendre la fenetre visible
        this.setVisible(true);
        
        //Creation des graphics. Doit etre fait apres setVisible(true)
        dessin = new BufferedImage(drawArea.getWidth(), drawArea.getHeight(), BufferedImage.TYPE_INT_ARGB);
        gDessin = dessin.createGraphics();
        
        expDessin = new BufferedImage(imagePanel.getWidth(), imagePanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
        gExpDessin = expDessin.createGraphics();
        
        gExpDessin.setColor(Color.WHITE);
        gExpDessin.fillRect(0, 0, imagePanel.getWidth(), imagePanel.getHeight());
        gExpDessin.setColor(Color.BLACK);
        
        gDrawA = (Graphics2D)drawArea.getGraphics();
        gImage = (Graphics2D)imagePanel.getGraphics();
        
        gImage.setColor(Color.WHITE);
        gImage.fillRect(0, 0, imagePanel.getWidth(), imagePanel.getHeight());
        
    }
    
    /**
     * //Recupere la position de la souris lorsque que l'on clique dessus.
     */
    public void mousePressed(MouseEvent e){ 
        this.x1=e.getX(); 
        this.y1=e.getY();
    }
    
    /**
     * Forme un dessin noir lorsque la souris est cliquee et bougee (drag)
     */
    public void mouseDragged(MouseEvent e){ 
		gDessin.setStroke(new BasicStroke(5));
		gDrawA.setStroke(new BasicStroke(5));
		
		gDrawA.setColor(Color.BLACK); //Couleur de l'image visible
		gDessin.setColor(Color.WHITE); //Couleur de l'image invisible (canevas qui sera transformé en image à analyser)
		
		gDessin.drawLine(this.x1, this.y1, e.getX(), e.getY());
		gDrawA.drawLine(this.x1, this.y1, e.getX(), e.getY());
		
		mouseMoved(e);
	}
    
    /**
     * //Recupere la position de la souris lorsqu'elle est deplacee
     */
    public void mouseMoved(MouseEvent e){ 
		this.x1 = e.getX();
		this.y1 = e.getY();
	}
    
    @Override 
    public void mouseReleased(MouseEvent arg) {}
    public void mouseEntered(MouseEvent evt) {}  
    public void mouseExited(MouseEvent evt){}
    public void mouseClicked(MouseEvent evt){}
	
 
    /** 
     * Methode listant les ecouteurs de la fenetre en fonction de la source
     */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnR){ //Source : Bouton Rectangle
			
			//Récupère les données des Spinners
            int hauteurR = (int)spinnerH.getValue();
            int largeurR = (int)spinnerL.getValue();
            int xR = (int)spinnerX.getValue();
            int yR = (int)spinnerY.getValue();
            
			//Création de la figure
            Point pR = new Point(xR,yR);
            Rectangle monRectangle = new Rectangle(largeurR, hauteurR, pR, couleur, rempli.isSelected());
            
            
            gDrawA.setColor(new Color(240,240,240)); //Couleur de la toile de dessin
			gDrawA.fillRect(0, 0, drawArea.getWidth(), drawArea.getHeight()); //Efface tout dessin précédent
			
			affListe(); //Dessine toutes les formes déjà ajoutée
            monRectangle.dessiner(gDrawA); //Dessine le dernier rectangle créé
            
            ajouter.setFigure(monRectangle); //Ajoute la figure au bouton ajouter
            gImage.setColor(Color.BLACK);
            
        }
        
        if(e.getSource() == btnC){ //Source : Bouton Oval
			
			//Récupère les données des Spinners
            int hauteurC = (int)spinnerH.getValue();
            int largeurC = (int)spinnerL.getValue();
            int xC = (int)spinnerX.getValue();
            int yC = (int)spinnerY.getValue();
            
            //Création de la figure
            Point pC = new Point(xC,yC);
            Oval monOval = new Oval(largeurC, hauteurC, pC, couleur, rempli.isSelected());
            
            gDrawA.setColor(new Color(240,240,240)); //Couleur de la toile de dessin
			gDrawA.fillRect(0, 0, drawArea.getWidth(), drawArea.getHeight()); //Efface tout dessin précédent
			
			affListe(); //Dessine toutes les formes déjà ajoutée
            monOval.dessiner(gDrawA); //Dessine le dernier oval créé
            
            ajouter.setFigure(monOval); //Ajoute la figure au bouton ajouter
            gImage.setColor(Color.BLACK);
        }
        
        if(e.getSource() == btnT){ //Source : Bouton Triangle
			
			//Récupère les données des Spinners
            int hauteurT = (int)spinnerH.getValue(); 
            int largeurT = (int)spinnerL.getValue();
            int xT = (int)spinnerX.getValue();
            int yT = (int)spinnerY.getValue();
            
            //Création de la figure
            Point pT = new Point(xT,yT);
            Triangle monTriangle = new Triangle(hauteurT, largeurT, pT, couleur, rempli.isSelected());
            
            gDrawA.setColor(new Color(240,240,240)); //Couleur de la toile de dessin
			gDrawA.fillRect(0, 0, drawArea.getWidth(), drawArea.getHeight()); //Efface tout dessin précédent
			
			affListe(); //Dessine toutes les formes déjà ajoutée
            monTriangle.dessiner(gDrawA); //Dessine le dernier triangle créé
            
            ajouter.setFigure(monTriangle); //Ajoute la figure au bouton ajouter
            gImage.setColor(Color.BLACK);
        }
        
        if(e.getSource() == reinitD){ //Source : Bouton Réinitialiser Dessin
			//Réinitialse ce que l'on voit (à droite, la toile de dessin)
			gDrawA.setColor(new Color(240,240,240));
			gDrawA.fillRect(0, 0, drawArea.getWidth(), drawArea.getHeight());
			
			//Réinitialse ce que l'on ne voit pas (à droite, la toile de l'image qui va être analysée)
			gDessin.setColor(Color.BLACK);
			gDessin.fillRect(0, 0, drawArea.getWidth(), drawArea.getHeight());
			
			//Empêche la création de figure
			btnC.setEnabled(false);
			btnR.setEnabled(false);
			btnT.setEnabled(false);
		}
		
		if(e.getSource() == reinitI){ //Source : Bouton Réinitialiser Image
			//Réinitialse ce que l'on voit (à gauche, la toile de l'image finale)
			gImage.setColor(Color.WHITE);
			gImage.fillRect(0, 0, imagePanel.getWidth(), imagePanel.getHeight());
			//Réinitialse ce que l'on ne voit pas (à gauche, la toile de l'image qui va être exportée)
            gExpDessin.setColor(Color.WHITE);
            gExpDessin.fillRect(0, 0, imagePanel.getWidth(), imagePanel.getHeight());
            
            reinitListe();//Supprime les élements dans la liste de figures
		}
		
		if(e.getSource() == ajouter){ //Source : Bouton ajouter
			Figure figurePartielle = ajouter.getFigure(); //La dernière figure stockée dans ajouter
			gImage.setStroke(new BasicStroke(5));
			figurePartielle.dessiner(gImage); //Dessine la figure sur le caneva visible de l'image finale
			figurePartielle.dessiner(gExpDessin); //Dessine la figure sur le caneva invisible de l'image finale (pour export)
			listeFigure.add(figurePartielle); //Ajouter la figure dans la liste de figures de l'image finale
		}
			
		
		if(e.getSource() == analyse){ //Source : Bouton analyser
			imageToArray iTA = new imageToArray(); //Classe qui permet d'analyser le dessin effectué
			
			iTA.analyser(dessin);
			
			if(iTA.getFormeAnalysee() == "Rectangle"){
				btnR.setEnabled(true);
				btnC.setEnabled(false);
				btnT.setEnabled(false);
			}else if(iTA.getFormeAnalysee() == "Cercle"){
				btnR.setEnabled(false);
				btnC.setEnabled(true);
				btnT.setEnabled(false);
			}else if(iTA.getFormeAnalysee() == "Triangle"){
				btnR.setEnabled(false);
				btnC.setEnabled(false);
				btnT.setEnabled(true);
			}	
		}
		
		if(e.getSource() == btnCouleur){ //Source : Bouton Couleur - Change la couleur de la prochaine forme créée
			int R = sliderR.getValue();
			int G = sliderG.getValue();
			int B = sliderB.getValue();
			
			couleur = new Color(R,G,B);
		}
		
		if(e.getSource() == exporter){ //Source : Bouton Exporter - Enregistre l'image finale dans Images Importées
			export();
		}
    }
    
    /**
     * Permet de dessiner toutes les formes deja ajoutees sur le caneva de dessin courant
     */
    public void affListe(){ 
		gDrawA.setColor(Color.BLACK);
		for(int i = 0; i<listeFigure.size(); i++){
			listeFigure.get(i).dessiner(gDrawA);
		}
	}
	
	/**
	 * Methode qui reinitialise la liste des figures stockees pour l'image finale
	 */
	public void reinitListe(){
		listeFigure = new LinkedList<Figure>();
	}
	
	/**
	 * Methode qui permet d'exporter l'image personnalisee avec des figures
	 */
	public void export(){
	
       File imageFile = new File("Ressources/ImagesImportees/file.png");
       
        try{
			
            ImageIO.write(expDessin, "png", imageFile);
            AddTransparency at = new AddTransparency();
            ImageIcon imFigure = new ImageIcon("Ressources/ImagesImportees/"+at.getNomCourant());
            pI.addImported(imFigure);
            repaint();
        
        }catch(Exception ex){}
	}
	
	public BufferedImage getExpDessin() {
		return expDessin;
	}

}

