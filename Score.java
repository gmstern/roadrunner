import java.awt.*;
import javax.swing.*;

// Class that updates and displays score
public class Score {
    int scoreTotal = 0;
    
    // Method to set score and returns JLabel
    public JLabel setScore(){
        JLabel labelScore = new JLabel();
        labelScore.setText("Score: " + this.scoreTotal);
        labelScore.setForeground(Color.black);
        labelScore.setFont(new Font("Serif", Font.BOLD, 24));
        labelScore.setBounds(200, 25, 200, 100);

        return labelScore;
    }

    // Method to update score and returns JLabel
    public JLabel updateScore(){
        this.scoreTotal += 10;
        return setScore();
    }
}