import java.awt.*;
//import javax.management.timer.Timer;
import javax.swing.*;
//import javax.swing.plaf.PanelUI;
import java.awt.event.*;

// Class that creates game object and contains main game logic.
public class Roadrunner extends JPanel implements ActionListener, KeyListener{
   /**
    *
    */
   private static final long serialVersionUID = 1L;
   JFrame frame = new JFrame("Roadrunner");
   JLayeredPane pane = new JLayeredPane();
   boolean isLeftPressed = false;
   boolean isRightPressed = false;
   Player player;
   JLabel leftBird;
   JLabel rightBird;
   //Timer t = new Timer();
   double x = 0, y = 0, velx = 0, vely = 0;

   // Construcor
   public Roadrunner() {
      //t.start();
      frame.addKeyListener(this);
      frame.setFocusable(true);
      frame.setFocusTraversalKeysEnabled(false);
   }

   // Main Method
   public static void main(final String[] args) throws Exception {
      // creates basic window
      Roadrunner game = new Roadrunner();
      game.pane.setPreferredSize(new Dimension(950, 800));
      game.frame.setSize(950, 800);
      game.frame.setResizable(false);
      game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // add background
      final JLabel bg = Background.getBackground();
      game.pane.add(bg, JLayeredPane.DEFAULT_LAYER, 1);

      // add initial player to frame
      game.player = new Player(350, 650);
      game.leftBird = game.player.getLeftBird();
      game.pane.add(game.leftBird, JLayeredPane.DEFAULT_LAYER, 0);

      // add arrows to frame
      final JLabel leftArrow = Button.getLeftArrow();
      final JLabel rightArrow = Button.getRightArrow();
      game.pane.add(leftArrow, JLayeredPane.DEFAULT_LAYER, 0);
      game.pane.add(rightArrow, JLayeredPane.DEFAULT_LAYER, 0);

      // complete frame set up
      game.frame.add(game.pane);
      game.frame.pack();
      game.frame.setLocationRelativeTo(null);
      game.frame.setVisible(true);

      // Add Game Logic Here
      // Add Action Listener for any click to begin game

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
   if (code == 37){
      return true;
   }
   else {
      return false;
   }
}

// Method to determine if right key is pressed and returns boolean.
public boolean isRightKeyPressed(KeyEvent e){
   int code = e.getKeyCode();
   if (code == 39){
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