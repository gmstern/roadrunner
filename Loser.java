import java.io.File;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;
import javax.swing.*;

public class Loser {

    public JLabel gameOver() {
        BufferedImage imageLose = null;
        try
        {
            imageLose = ImageIO.read(new File("youLose.png"));
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
