import java.awt.*;
import javax.swing.*;

public class Lives {
    int livesLeft = 3;
    String lives = "Lives: " + livesLeft;
    
    public JLabel setLives(){
        JLabel labelLives = new JLabel();
        labelLives.setText(lives);
        labelLives.setForeground(Color.black);
        labelLives.setFont(new Font("Serif", Font.BOLD, 24));
        labelLives.setBounds(200, 75, 100, 100);

        return labelLives;
    }

    /*Method to update JLabel
    public Jlabel getLives(){

    }*/
}