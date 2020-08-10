import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage; 

// Class that creates and places the arrows.
public class Button {
    BufferedImage imgLeft = null;
    BufferedImage imgRight = null;

    // Method to return left arrow image as a JLabel.
    public static JLabel getLeftArrow(){
        BufferedImage imageLeft = null;
        try
        {
            InputStream is = Roadrunner.class.getResourceAsStream("/leftArrow.png");
            imageLeft = ImageIO.read(is);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageLeftIcon = new ImageIcon(imageLeft);
        JLabel jLabelLeft = new JLabel();
        jLabelLeft.setIcon(imageLeftIcon);
        jLabelLeft.setBounds(80, 650, imageLeftIcon.getIconWidth(), imageLeftIcon.getIconHeight());
        return jLabelLeft;
    }

     // Method to return right arrow image as a JLabel.
     public static JLabel getRightArrow(){
        BufferedImage imageRight = null;
        try
        {
            InputStream isR = Roadrunner.class.getResourceAsStream("/rightArrow.png");
            imageRight = ImageIO.read(isR);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageRightIcon = new ImageIcon(imageRight);
        JLabel jLabelRight = new JLabel();
        jLabelRight.setIcon(imageRightIcon);
        jLabelRight.setBounds(750, 650, imageRightIcon.getIconWidth(), imageRightIcon.getIconHeight());
        return jLabelRight;
    }
}