import java.awt.*;
import javax.swing.*;

// Class that updates and displays amount of lives left
public class Lives {
    int livesLeft = 3;
    
    // Method to set lives and returns JLabel
    public JLabel setLives(){
        JLabel labelLives = new JLabel();
        labelLives.setText("Lives: " + this.livesLeft);
        labelLives.setForeground(Color.black);
        labelLives.setFont(new Font("Serif", Font.BOLD, 24));
        labelLives.setBounds(200, 75, 100, 100);

        return labelLives;
    }

    //Method to update lives left and returns JLabel
    public JLabel updateLives(){
        this.livesLeft--;
        return setLives();
        
    }

    // Method to get lives left and returns an int
    public int getLives(){
        return this.livesLeft;
    }
}