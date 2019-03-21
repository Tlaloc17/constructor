import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * @author ManonSophieClaire
 *
 */
public class AddTransparency{
    
    String nomCourant;
    
  /** Constructor
 * @throws IOException
 */
AddTransparency() throws IOException{
    
    File inFile = new File("Ressources/ImagesImportees","file.png");
    BufferedImage image = ImageIO.read(inFile);

    Image transpImg1 = TransformWhiteToTransparency(image, Color.WHITE);
    BufferedImage resultImage1 = ImageToBufferedImage(transpImg1, image.getWidth(), image.getHeight());
	nomCourant = genererNom();
	
    File outFile1 = new File("Ressources/ImagesImportees", nomCourant);
    ImageIO.write(resultImage1, "png", outFile1);

  }

  /**
 * @param image L'image que l'on veut rendre transparente
 * @param color La couleur que l'on veut rendre transparente sur l'image
 * @return L'image transparente (avec des problemes sur les bords de l'image)
 */
private Image TransformWhiteToTransparency(BufferedImage image,Color color){
    ImageFilter filter = new RGBImageFilter()
    
    {
      public int markerRGB = color.getRGB() | 0xFFFFFFFF; 
       
      public final int filterRGB(final int x, final int y, final int rgb)
         {
            if ((rgb | 0xFF000000) >= markerRGB)
            {
               // Mark the alpha bits as zero - transparent
               return 0x00FFFFFF & rgb;
            }
            else
            {
               // nothing to do
               return rgb;
            }
         }
    };

    ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
      return Toolkit.getDefaultToolkit().createImage(ip);
  }

  /**
 * @param image Une image de type Image que l'on veut transformer en BufferedImage
 * @param width Largeur de l'image de base
 * @param height Hauteur de l'image de base
 * @return L'image transformee en BufferedImage
 */
private BufferedImage ImageToBufferedImage(Image image, int width, int height)
  {
    BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = dest.createGraphics();
    g2.drawImage(image, 0, 0, null);
    g2.dispose();
    return dest;
  }
  
  /**
 * @return Nom du fichier cree par la creation d'une forme personnalisee
 */
public String genererNom() {
	  
		String nom = "";
		
		try{
			BufferedReader file = new BufferedReader(new FileReader("Ressources/index.txt"));
			
			String line;
			String linePlusUn;
			
			line = file.readLine();
			int i = Integer.parseInt(line)+1;
			linePlusUn = ""+i;
			line = linePlusUn;
			
			nom = "ImageImportee"+linePlusUn+".png";
			
			FileOutputStream File = new FileOutputStream("Ressources/index.txt");
			File.write(linePlusUn.getBytes());
			
			file.close();
			File.close();
			
        }
        catch (Exception e)
        {
                System.out.println("Problem reading file.");
        }
        
        return nom;
	}
	
	public String getNomCourant(){
		return nomCourant;
	}
}
