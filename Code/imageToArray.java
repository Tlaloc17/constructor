import java.util.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * @author Oscar,Axel,Emanuela,Claire
 *
 */
public class imageToArray {
	
	private String formeAnalysee;
	
	/**
	 * Constructor
	 */
	public imageToArray(){
		
		formeAnalysee = "";
		
		}
	
	/**
	 * @param dessin Image creee grace au dessin fait a la main
	 */
	public void analyser(BufferedImage dessin){
		try { 
		
			ImageIO.write(dessin, "png", new File("file.png")); 
		
			}catch (IOException ex) {}
			
			try{
			
			BufferedImage image = ImageIO.read(new File("file.png"));
			byte[][] pixels = new byte[image.getWidth()][];
			
			//Remplace l'image en noir et blanc en un tableau de 0 et de 1
			
			for (int x = 0; x < image.getWidth(); x++) {
				pixels[x] = new byte[image.getHeight()];

				for (int y = 0; y < image.getHeight(); y++) {
					if((byte)image.getRGB(x,y) == 0x00000000){
						pixels[x][y] = 0 ;
					}else{
						pixels[x][y] = 1 ;
					}
				}
			}
			
			//Decommenter pour afficher l'image recue sous forme de tableau 2D dans le terminal
			/*for(int i = 0; i < pixels.length; i++){
				System.out.println();
				for(int j  = 0; j<pixels[0].length; j++){
					System.out.print(pixels[i][j]);
				}
			}*/
			
			LinkedList<Integer> ligneG = new LinkedList<Integer>();
			
			for(int i = 0; i < pixels.length; i++){
				for(int j  = 0; j<pixels[0].length; j++){
					if(pixels[i][j] == 1){
						ligneG.add(j);
					}
				}
			}
			
			int minimumG = ligneG.get(0);
			
			for(int i =0; i < ligneG.size(); i++){
				if(ligneG.get(i) < minimumG){
					minimumG = ligneG.get(i);
				}
			}

			LinkedList<Integer> ligneD = new LinkedList<Integer>();
			
			for(int i = 0; i < pixels.length; i++){
				for(int j  = 0; j<pixels[0].length; j++){
					if(pixels[i][j] == 1){
						ligneD.add(j);
					}
				}
			}
			
			int maximumD = ligneD.get(0);
			
			for(int i =0; i < ligneD.size(); i++){
				if(ligneD.get(i) > maximumD){
					maximumD = ligneD.get(i);
				}
			}
			
			LinkedList<Integer> coloneH = new LinkedList<Integer>();
			
			for(int i = 0; i < pixels.length; i++){
				for(int j  = 0; j<pixels[0].length; j++){
					if(pixels[i][j] == 1){
						coloneH.add(i);
					}
				}
			}
			
			int minimumH = coloneH.get(0);
			
			for(int i =0; i < coloneH.size(); i++){
				if(coloneH.get(i) < minimumH){
					minimumH = coloneH.get(i);
				}
			}
			
			LinkedList<Integer> coloneB = new LinkedList<Integer>();
			
			for(int i = 0; i < pixels.length; i++){
				for(int j  = 0; j<pixels[0].length; j++){
					if(pixels[i][j] == 1){
						coloneB.add(i);
					}
				}
			}
			
			int maximumB = coloneB.get(0);
			
			for(int i =0; i < coloneB.size(); i++){
				if(coloneB.get(i) > maximumB){
					maximumB = coloneB.get(i);
				}
			}		
				
			
			byte[][] imageRe = new byte[maximumB-minimumH+1][maximumD-minimumG+1];
				
			for(int i = minimumH; i<=maximumB; i++){
				for(int j = minimumG; j<=maximumD; j++){
					imageRe[i-minimumH][j-minimumG] = pixels[i][j];
				}
			}
			
			//Decommenter pour avoir le rectangle le plus proche autour de l'image 
			/*for(int i = 0; i < imageRe.length; i++){
				System.out.println();
				for(int j  = 0; j<imageRe[0].length; j++){
					System.out.print(imageRe[i][j]);
				}
			}*/
			
			int nbOutside = 0;
			int j = 0;
			for(int i = 0; i<imageRe.length; i++){
				j = 0;
				while(imageRe[i][j] == 0 && j<imageRe.length/2){
					j++;
				}
				nbOutside += j;
			}
			//System.out.println();
			//System.out.println(nbOutside);
			
			j = 0;
			for(int i = 0; i<imageRe.length; i++){
				j = imageRe[0].length-1;
				while(imageRe[i][j] == 0 && j>imageRe.length/2){
					j--;
				}
				nbOutside += imageRe[0].length-1-j;
			}
			//System.out.println();
			//System.out.println(nbOutside);
			
			
			double nbTotal = imageRe.length*imageRe[0].length;
			double ratioExTot = nbOutside/nbTotal;
		
			//System.out.println(nbTotal);
			System.out.println(ratioExTot);
			
			if(ratioExTot < 0.15){
				System.out.println("C'est un rectangle !");
				formeAnalysee = "Rectangle";
			}else if(ratioExTot >= 0.15 && ratioExTot < 0.30){
				System.out.println("C'est un cercle !");
				formeAnalysee = "Cercle";
			}else if(ratioExTot >= 0.30){
				System.out.println("C'est un triangle !");
				formeAnalysee = "Triangle";
			}
					
			
		}catch(IOException ex){
				System.out.println(ex);
			
		}
	}
	
	/**
	 * @return formeAnalysee Un string definissant la forme (Triangle, Rectangle ou Oval)
	 */
	public String getFormeAnalysee(){
		return formeAnalysee;
	}
}
