import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage; 

// Class that creates and places the background image.
public class Background{
   BufferedImage img = null;

   // Method to return background as JLabel.
   public static JLabel getBackground(){
      BufferedImage image = null;
      try
      {
        image = ImageIO.read(new File("road.png"));
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
   
