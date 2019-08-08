import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;

public class KeyInput extends KeyAdapter
{
   private int playerVelocity, velocityFactor, initVel, factor;

   private boolean up, down, left, right, shift;

   public KeyInput()
   {
      initVel = (int)Config.playerVelocity;
      factor  = (int)Config.velocityFactor;
      up    = false;
      down  = false;
      left  = false;
      right = false;
      shift = false;
   }

   public void keyPressed(KeyEvent e)
   {
   initVel = (int)Config.playerVelocity;
   factor  = (int)Config.velocityFactor;
   
   int key = e.getKeyCode();

   if(key == KeyEvent.VK_ESCAPE)
   {
      if(Config.state == State.Game)
      {
	 Config.state = State.Menu;
	 Config.game.addMouseListener(Config.menu);
	 Config.audio.getMusic("game").stop();
	 Config.audio.getMusic("menu").loop(Config.pitch, Config.volume);
      }

      else if(Config.state == State.Menu)
      {
	 Config.state = State.Game;
	 Config.game.removeMouseListener(Config.menu);
	 Config.audio.getMusic("menu").stop();
	 Config.audio.getMusic("game").loop(Config.pitch, Config.volume);
      }
   }
		      
   for(GameObject object: Config.handler.list)
   {
      if(object.getID() == ID.Player)
      {
	 if(key == KeyEvent.VK_W) {object.setVelY(-5); up   = true; down  = false;}
	 if(key == KeyEvent.VK_S) {object.setVelY(5); down  = true; up    = false;}
	 if(key == KeyEvent.VK_A) {object.setVelX(-5); left = true; right = false;}
	 if(key == KeyEvent.VK_D) {object.setVelX(5); right = true; left  = false;}

	 if(key == KeyEvent.VK_SHIFT) shift = true;

	 if(shift)
	 {
	    int velY = object.getVelY();
	    int velX = object.getVelX();

	    if(velY > initVel)  velY =  initVel;
      	    if(velX > initVel)  velX =  initVel;
	    if(velY < -initVel) velY = -initVel;
	    if(velX < -initVel) velX = -initVel;

	    object.setVelY(velY * factor);
	    object.setVelX(velX * factor);
	 }	
      }
   }
}

public void keyReleased(KeyEvent e)
{
   initVel = (int)Config.playerVelocity;
   factor  = (int)Config.velocityFactor;

   int key = e.getKeyCode();

   for(GameObject object: Config.handler.list)
   {
      if(object.getID() == ID.Player)
      {
	 if(key == KeyEvent.VK_W) up    =  false; //object.setVelY(0);
	 if(key == KeyEvent.VK_S) down  =  false;
	 if(key == KeyEvent.VK_A) left  =  false;
	 if(key == KeyEvent.VK_D) right =  false;


	 if(!up   && !down ) object.setVelY(0);
	 if(!left && !right) object.setVelX(0);


	 if(key == KeyEvent.VK_SHIFT) shift = false;
	 if(!shift)
	 {
	    int velY = object.getVelY();
	    int velX = object.getVelX();

	       if(velY > initVel)  velY =  initVel;
	       if(velX > initVel)  velX =  initVel;
	       if(velY < -initVel) velY = -initVel;
	       if(velX < -initVel) velX = -initVel;
				
	       object.setVelY(velY);			
	       object.setVelX(velX);
	    }
	 }
      }
   }
}
