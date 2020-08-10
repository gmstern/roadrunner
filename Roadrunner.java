import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Rectangle;

// Class that creates game object and contains main game logic.
public class Roadrunner extends JPanel implements ActionListener, KeyListener{
   private static final long serialVersionUID = 1L;
   private JFrame frame;
   private JLayeredPane pane;
   private boolean isLeftPressed = false;
   private boolean isRightPressed = false;
   private Player player;
   private JLabel leftBird;
   private JLabel rightBird;
   private Sprite sprite;
   private JLabel spriteLabel;
   private Score score;
   private Lives lives;
   private Loser loser;
   private JLabel livesLabel;
   private JLabel scoreLabel;

   // Construcor
   public Roadrunner() {
      frame = new JFrame("Roadrunner");
      pane = new JLayeredPane();
      frame.addKeyListener(this);
      frame.setFocusable(true);
      frame.setFocusTraversalKeysEnabled(false);
      score = new Score();
      lives = new Lives();
   }

   // Main Method
   public static void main(final String[] args) throws InterruptedException {
      // creates basic window
      Roadrunner game = new Roadrunner();
      game.pane.setPreferredSize(new Dimension(950, 800));
      game.frame.setSize(950, 800);
      game.frame.setResizable(false);
      game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // add background to pane
      final JLabel bg = Background.getBackground();
      game.pane.add(bg, JLayeredPane.DEFAULT_LAYER, 2);

      // add score and lives to pane
      game.livesLabel = game.lives.setLives();
      game.scoreLabel = game.score.setScore();
      game.pane.add(game.livesLabel, JLayeredPane.DEFAULT_LAYER, 0);
      game.pane.add(game.scoreLabel, JLayeredPane.DEFAULT_LAYER, 0);

      // add initial player to pane
      game.player = new Player(350, 650);
      game.leftBird = game.player.getLeftBird();
      game.pane.add(game.leftBird, JLayeredPane.DEFAULT_LAYER, 1);

      // add arrows to pane
      final JLabel leftArrow = Button.getLeftArrow();
      final JLabel rightArrow = Button.getRightArrow();
      game.pane.add(leftArrow, JLayeredPane.DEFAULT_LAYER, 1);
      game.pane.add(rightArrow, JLayeredPane.DEFAULT_LAYER, 1);

      // complete frame set up
      game.frame.add(game.pane);
      game.frame.pack();
      game.frame.setLocationRelativeTo(null);
      game.frame.setVisible(true);

      // Main Game Loop to create sprites, detect collisons, and update score and lives.
      game.sprite = new Sprite();
      game.spriteLabel = game.sprite.getSprite();
      game.pane.add(game.spriteLabel, JLayeredPane.DEFAULT_LAYER, 0);
      
      int speed = 15;
      while (game.lives.getLives() >  0) {
         game.pane.remove(game.spriteLabel);
         if (game.sprite.getSpriteY() < 670) {
            game.sprite.updateSpriteY(speed);
            game.spriteLabel = game.sprite.getSprite();
            game.pane.add(game.spriteLabel, JLayeredPane.DEFAULT_LAYER, 0);
         }
         if (game.sprite.getSpriteY() >= 670) {
            game.pane.remove(game.spriteLabel);
            speed += 2;
            game.sprite = new Sprite();
            game.spriteLabel = game.sprite.getSprite();
            game.pane.add(game.spriteLabel, JLayeredPane.DEFAULT_LAYER, 0);
         }
         // Collision detection
         Rectangle playerBounds = new Rectangle(game.player.getPlayerX(), game.player.getPlayerY(), game.player.getPlayerWidth(), game.player.getPlayerHeight());
         Rectangle spriteBounds = new Rectangle(game.sprite.getSpriteX(), game.sprite.getSpriteY(), game.sprite.getSpriteWidth(), game.sprite.getSpriteHeight());
   
         if(playerBounds.intersects(spriteBounds)){ 
            if(game.sprite.isHarmful() == true){
               game.pane.remove(game.spriteLabel);
               game.pane.remove(game.livesLabel);
               game.livesLabel = game.lives.updateLives(); 
               game.pane.add(game.livesLabel, JLayeredPane.DEFAULT_LAYER, 0);
               
               game.frame.add(game.pane);
               game.frame.pack();
               game.frame.setLocationRelativeTo(null);
               game.frame.setVisible(true);
               game.pane.revalidate();
               game.pane.repaint();
               game.sprite = new Sprite();
   
            } 
            else if (game.sprite.isHarmful() == false) {
               game.pane.remove(game.spriteLabel);
               game.pane.remove(game.scoreLabel);
               game.scoreLabel = game.score.updateScore(); 
               game.pane.add(game.scoreLabel, JLayeredPane.DEFAULT_LAYER, 0);

               game.frame.add(game.pane);
               game.frame.pack();
               game.frame.setLocationRelativeTo(null);
               game.frame.setVisible(true);
               game.pane.revalidate();
               game.pane.repaint();
               game.sprite = new Sprite();

            } 
         }

         game.frame.add(game.pane);
         game.frame.pack();
         game.frame.setLocationRelativeTo(null);
         game.frame.setVisible(true);
         game.pane.revalidate();
         game.pane.repaint();

         Thread.sleep(100);
      }

      // Once zero lives, player loses and game ends
      game.loser = new Loser();
      game.pane.add(game.loser.gameOver(), JLayeredPane.DEFAULT_LAYER, 0);
  }

  // Method to detect when key pressed and updates player - interrupts sequence of main method
  @Override
  public void keyPressed(KeyEvent e) {
   if (isLeftKeyPressed(e) == true){
      this.isLeftPressed = true;
      //remove current player
      if (this.player.isPlayerRight() == true){
         this.pane.remove(this.rightBird);
      }
      else {
         this.pane.remove(this.leftBird);
      }
      
      // update and add new player JLabel
      player.updatePlayer(this.isLeftPressed, this.isRightPressed);
      this.leftBird = player.updateImage();
      this.pane.add(this.leftBird, JLayeredPane.DEFAULT_LAYER, 0);
      this.frame.add(this.pane);
      this.frame.pack();
      this.frame.setLocationRelativeTo(null);
      this.frame.setVisible(true);
   }
   else {
      this.isLeftPressed = false;
   }
   if (isRightKeyPressed(e) == true){
      this.isRightPressed = true;
      //remove current player
      if (this.player.isPlayerRight() == true){
         this.pane.remove(this.rightBird);
      }
      else {
         this.pane.remove(this.leftBird);
      }
      
      // update and add new player
      player.updatePlayer(this.isLeftPressed, this.isRightPressed);
      this.rightBird = player.updateImage();
      this.pane.add(this.rightBird, JLayeredPane.DEFAULT_LAYER, 0);
      this.frame.add(this.pane);
      this.frame.pack();
      this.frame.setLocationRelativeTo(null);
      this.frame.setVisible(true);
   }
   else {
      this.isRightPressed = false;
   }
   this.pane.revalidate();
   this.pane.repaint();
  }

  // Method to determine if left key is pressed and returns boolean.
  public boolean isLeftKeyPressed(KeyEvent e){
   int code = e.getKeyCode();
   if (code == 37 && this.player.getPlayerX() >= 160){
      return true;
   }
   else {
      return false;
   }
}

// Method to determine if right key is pressed and returns boolean.
public boolean isRightKeyPressed(KeyEvent e){
   int code = e.getKeyCode();
   if (code == 39 && this.player.getPlayerX() <= 580){
      return true;
   }
   else {
      return false;
   }
}

@Override
public void keyTyped(KeyEvent e) {
   // TODO Auto-generated method stub

}

@Override
public void keyReleased(KeyEvent e) {
   // TODO Auto-generated method stub

}

@Override
public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub

}

}