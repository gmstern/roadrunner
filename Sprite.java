import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.awt.image.BufferedImage; 
import java.util.Random;

// Class that creates and updates the sprites
public class Sprite {
    final int SPRITE_Y_START = 160;
    final String LIZARD_PATH = "/lizard.png";
    final String CAR_PATH = "/car.png";
    final String CACTUS_PATH = "/cactus.png";
    private Boolean isHarmful = null;
    private int spriteX, spriteY;
    private BufferedImage image;
    private String filePath;
    public static Random generator = new Random();
    private int spriteWidth, spriteHeight;
    private final int MAX_SPEED = 45;
    
    // Constructor
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
            InputStream is = Roadrunner.class.getResourceAsStream(this.filePath);
            this.image = ImageIO.read(is);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(this.image);
        this.spriteWidth = imageIcon.getIconWidth();
        this.spriteHeight = imageIcon.getIconHeight();
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(this.spriteX, this.spriteY, this.spriteWidth + 20, this.spriteHeight + 20);

        return jLabel;
    }

    // Method to create and randomly select sprite x-value
    public int setSpriteX(){
        int xValue = 320 + generator.nextInt(210);
        return xValue;
    }

    // Method to update sprite Y value (i.e. speed)
    public void updateSpriteY(int speed){
           if (speed < MAX_SPEED){
            this.spriteY += speed;
           }
           else{
               this.spriteY += MAX_SPEED;
           }
        }

    //Method to update and move sprite down screen each frame
    public JLabel updateImage(){
        JLabel updatedImg;
        updatedImg = getSprite();
        return updatedImg;
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

     // Method to return sprite X value as type int
     public int getSpriteX(){
        return this.spriteX;
    }

    // Method to return sprite y position as type int
	public int getSpriteY() {
		return this.spriteY;
    }

    // Method to return sprite width as type int
	public int getSpriteWidth() {
		return this.spriteWidth;
    }

    // Method to return sprite height as type int
	public int getSpriteHeight() {
		return this.spriteHeight;
    }
    
    // Method to return whether or not sprite is harmful as type boolean
    public boolean isHarmful(){
        return this.isHarmful;
    }
}