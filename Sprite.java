import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage; 
import java.util.Random;

//TO DO: NEED TO MOVE SPRITES DOWN & REMOVE

// Class that creates the sprites for the game
public class Sprite {
    BufferedImage imgage = null;
    //BufferedImage  imgCactus = null;
    //BufferedImage imgLizard = null;
    Boolean isHarmful = null;
    private int spriteX, spriteY;
    private BufferedImage image;
    private String filePath;
    public static Random generator = new Random();

   
    /*
    Set: Create & Randomly place within bounds
    Get: Update - move down screen & interact with bird & remove
    */

    //Constructor. Takes in image path and sets up as JLABEL
    public Sprite (String imgPath, int y){
        this.spriteX = setSpriteX();
        this.spriteY =  y;
        this.filePath = imgPath;

        if (this.filePath == "lizard.png"){
            this.isHarmful = false;
        }
        else {
            this.isHarmful = true;
        }
    }

    // Method to create and randomly place Sprite. Returns updated JLabel.
    public JLabel getSprite(){
        //BufferedImage image = null;
        try
        {
            this.image = ImageIO.read(new File(this.filePath));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(this.image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(this.spriteX, this.spriteY, imageIcon.getIconWidth() + 20, imageIcon.getIconHeight() + 20);

        return jLabel;
    }

    // Method to create and randomly place sprite on game board.
    public int setSpriteX(){
        int xValue = 370 + generator.nextInt(160);
        return xValue;
    }

    // Method to update sprite yValue
    public void updateSpriteY(){
            this.spriteY += 10;
        }

    //Method to update and move sprite down screen each frame
    public JLabel updateImage(){
        JLabel updatedImg;
        
        if (this.spriteY <= 670){
            updatedImg = getSprite();
        }
        else {
            updatedImg = null;
        }
        return updatedImg;
    }
     // Method to return sprite y position as type int.
	public int getSpriteY() {
		return this.spriteY;
	}
}