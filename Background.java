import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.InputStream;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.io.*;
import java.awt.image.BufferedImage; 
import java.awt.Image; 

// Class that creates and places the background image.
public class Background{
   BufferedImage img = null;

   // Method to return background as JLabel.
   public static JLabel getBackground(){
      BufferedImage image = null;
      try
      {
        InputStream is = Roadrunner.class.getResourceAsStream("/road.png");
        image = ImageIO.read(is);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
      ImageIcon imageIcon = new ImageIcon(image);
      JLabel jLabel = new JLabel();
      jLabel.setIcon(imageIcon);
      jLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
      return jLabel;
   }
}
   
