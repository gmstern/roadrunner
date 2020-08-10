import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage; 

// Class that creates, updates, and places the player icon.
public class Player {
    BufferedImage imgLeft = null;
    BufferedImage imgRight = null;
    private int playerX, playerY;
    Boolean isRight = false;
    private int playerWidth, playerHeight;

    // Constructor
    public Player(int x, int y){
        this.playerX = x;
        this.playerY = y;
    }

    // Method to  return left player image as JLabel.
    public JLabel getLeftBird(){
        BufferedImage imageLeft = null;
        try
        {
            imageLeft = ImageIO.read(new File("leftBird.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageLeftIcon = new ImageIcon(imageLeft);
        this.playerWidth = imageLeftIcon.getIconWidth();
        this.playerHeight = imageLeftIcon.getIconHeight();
        JLabel jLabelLeft = new JLabel();
        jLabelLeft.setIcon(imageLeftIcon);
        jLabelLeft.setBounds(this.playerX, this.playerY, this.playerWidth + 20, this.playerHeight + 20);
        this.isRight = false;
        return jLabelLeft;
    }

    // Method to return right player image as JLabel.
    public JLabel getRightBird(){
        BufferedImage imageRight = null;
        try
        {
            imageRight = ImageIO.read(new File("rightBird.png"));
        }
        catch (Exception e)
        {
        e.printStackTrace();
        System.exit(1);
        }
        ImageIcon imageRightIcon = new ImageIcon(imageRight);
        this.playerWidth = imageRightIcon.getIconWidth();
        this.playerHeight = imageRightIcon.getIconHeight();
        JLabel jLabelRight = new JLabel();
        jLabelRight.setIcon(imageRightIcon);
        jLabelRight.setBounds(this.playerX, this.playerY, this.playerWidth + 20, this.playerHeight + 20);
        this.isRight = true;
        return jLabelRight;
    }

    // Method to update player position.
    public void updatePlayer(boolean leftPressed, boolean rightPressed) {

        if (leftPressed == true){
            this.playerX -= 50;
            this.isRight = false;
        }
        else if (rightPressed == true){
            this.playerX += 50;
            this.isRight = true;
        }
    }

    // Method to update player image.
    public JLabel updateImage(){
        JLabel updatedImg;

        if (this.isRight == true){
            updatedImg = getRightBird();
            return updatedImg;
        }
        else if (this.isRight == false){
            updatedImg = getLeftBird();
            return updatedImg;
        }    
        else {
            return null;
        }
    }
    
    // Method to return player's x position as type int.
	public int getPlayerX() {
		return this.playerX;
	}

    // Method to return player's y position as type int.
	public int getPlayerY() {
		return this.playerY;
	}

    // Method to set player's x position as type int.
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

    // Method to set player's y position as type int.
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
    }
    
    // Method to return player's direction as type Boolean.
    public Boolean isPlayerRight(){
            return this.isRight;
    }

    //Return player width
	public int getPlayerWidth() {
		return this.playerWidth;
    }

     //Return player height
	public int getPlayerHeight() {
		return this.playerHeight;
	}

}

    



 
   
       
    