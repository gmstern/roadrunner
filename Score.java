import java.awt.*;
import javax.swing.*;

public class Score {
    int scoreTotal = 0;
    
    public JLabel setScore(){
        JLabel labelScore = new JLabel();
        labelScore.setText("Score: " + this.scoreTotal);
        labelScore.setForeground(Color.black);
        labelScore.setFont(new Font("Serif", Font.BOLD, 24));
        labelScore.setBounds(200, 25, 100, 100);

        return labelScore;
    }

    //Method to update JLabel
    public JLabel updateScore(){
        this.scoreTotal += 10;
        System.out.println("Score: " + this.scoreTotal);
        return setScore();
    }
}