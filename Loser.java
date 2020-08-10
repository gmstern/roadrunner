import java.io.File;
import java.io.InputStream;
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
import javax.swing.*;

// Class to notify player game is over
public class Loser {

    // Method that notifies player of loss and returns JLabel
    public JLabel gameOver() {
        BufferedImage imageLose = null;
        try
        {
            InputStream is = Roadrunner.class.getResourceAsStream("/youLose.png");
            imageLose = ImageIO.read(is);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageLoseIcon = new ImageIcon(imageLose);
        JLabel jLabelLose = new JLabel();
        jLabelLose.setIcon(imageLoseIcon);
        jLabelLose.setBounds(300, 300, imageLoseIcon.getIconWidth() + 20, imageLoseIcon.getIconHeight() + 20);
     
        return jLabelLose;
     }

}
