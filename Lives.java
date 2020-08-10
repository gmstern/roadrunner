import java.awt.*;
import javax.swing.*;

public class Lives {
    int livesLeft = 3;
    
    public JLabel setLives(){
        JLabel labelLives = new JLabel();
        labelLives.setText("Lives: " + this.livesLeft);
        labelLives.setForeground(Color.black);
        labelLives.setFont(new Font("Serif", Font.BOLD, 24));
        labelLives.setBounds(200, 75, 100, 100);

        return labelLives;
    }

    //Method to update JLabel
    public JLabel updateLives(){
        this.livesLeft--;
        System.out.println("Lives Left: " + this.livesLeft);
        return setLives();
        
    }

    public int getLives(){
        return this.livesLeft;
    }
}