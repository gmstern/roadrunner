import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage; 
import java.util.Random;

// Class that creates the sprites for the game
public class Sprite {
    final int SPRITE_Y_START = 160;
    final String LIZARD_PATH = "lizard.png";
    final String CAR_PATH = "car.png";
    final String CACTUS_PATH = "cactus.png";
    Boolean isHarmful = null;
    private int spriteX, spriteY;
    private BufferedImage image;
    private String filePath;
    public static Random generator = new Random();
    
    //Constructor. Takes in image path and sets up as JLABEL
    public Sprite (){
        this.spriteX = setSpriteX();
        this.spriteY =  SPRITE_Y_START;
        this.filePath = this.getSpritePath();

        if (this.filePath == LIZARD_PATH){
            this.isHarmful = false;
        }
        else {
            this.isHarmful = true;
        }
    }
    
    // Method to create and randomly place Sprite. Returns updated JLabel.
    public JLabel getSprite(){
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
    public void updateSpriteY(int speed){
            this.spriteY += speed;
        }

    //Method to update and move sprite down screen each frame
    public JLabel updateImage(){
        JLabel updatedImg;
        updatedImg = getSprite();
        return updatedImg;
    }
     // Method to return sprite y position as type int.
	public int getSpriteY() {
		return this.spriteY;
    }

    // Method to randomly generate Sprites
    public String getSpritePath(){
        String spritePath = "";
        String[] spriteArray = { LIZARD_PATH, CAR_PATH, CACTUS_PATH };
        int spriteIndex = generator.nextInt(spriteArray.length);
        switch (spriteIndex) {
        case 0:
            spritePath = LIZARD_PATH;
            break;
        case 1:
            spritePath = CAR_PATH;
            break;
        case 2: 
            spritePath = CACTUS_PATH;
            break;
        }
        return spritePath;
    }
}