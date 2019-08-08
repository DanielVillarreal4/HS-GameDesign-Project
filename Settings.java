import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;
/*
 * *@compile !javac -cp .;./jars/lwjgl.jar;./jars/slick.jar *.java
 *@run java -Djava.library.path=./libs -cp .;./jars/jogg-0.0.7.jar;./jars/jorbis-0.0.15.jar;./jars/lwjgl.jar;./jars/slick.jar Game
 */

public class Settings extends MouseAdapter
{
   private int width, height;
   private int gameWidth;
   private int playerSize, playerVelocity, velocityFactor;
   private double aspectRatio;
   private Avatar avatar;
   private Color playerColor;
   private boolean changed;

   private Color background;

   private void initialize()
   {
      width  = Config.menuWidth;
      height = Config.menuHeight;
      gameWidth = Config.gameWidth;
      aspectRatio = Config.aspectRatio;
      avatar = Config.playerAvatar;

      playerSize = Config.playerSize;
      playerVelocity = (int)Config.playerVelocity;
      velocityFactor = (int)Config.velocityFactor;
      playerColor = Config.playerColor;

      background = Config.background;

      changed = false;
   }
   public void mouseClicked(MouseEvent e)
   {
      if(!changed)
	 initialize();

      int mX = e.getX(), mY = e.getY();

	   //1080 Clicked
      double xPos = ((Config.gameWidth/5.0) * 2.0) - (Config.menuWidth/2.0);
      double yPos = ((Config.gameHeight/17.0) * 3.0) - (Config.menuHeight/2.0);
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(gameWidth != 1080)
	 {
	    changed = true;
	    gameWidth = 1080;
	 }
      }
		 //720 Clicked
      xPos = (Config.gameWidth /5.0 * 3.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 3.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(gameWidth != 720)
	 {
	    changed = true;
	    gameWidth = 720;
	 }
      }
      //480 Clicked
      xPos = (Config.gameWidth /5.0 * 4.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 3.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(gameWidth != 480)
	 {
	    changed = true;
	    gameWidth = 480;
	 }
      }
      //16:9 Clicked
      xPos = (Config.gameWidth /5.0 * 2.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 5.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(aspectRatio != (9.0 / 16.0))
	 {
	    changed = true;
	    aspectRatio = (9.0 / 16.0);
	 }
      }
      //4:3 Clicked
      xPos = ((Config.gameWidth /5.0) * 3.0) - (Config.menuWidth/2.0) ;
      yPos = ((Config.gameHeight / 17.0) * 5.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(aspectRatio != (3.0 / 4.0))
	 {
	    changed = true;
	    aspectRatio = (3.0 / 4.0);
	 }
      }
      //Beta Clicked
      xPos = ((Config.gameWidth /5.0) * 2.0) - (Config.menuWidth/2.0) ;
      yPos = ((Config.gameHeight / 17.0) * 7.0) - (Config.menuHeight /2.0);
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(avatar != Avatar.Beta)
	 {
	    changed = true;
	    avatar = Avatar.Beta;
	 }
      }
      //Jose Clicked
      xPos = (Config.gameWidth /5.0 * 3.0) - (Config.menuWidth/2.0) ;
      yPos = (Config.gameHeight / 17.0 * 7.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
	 if(avatar != Avatar.Jose)
	 {
	    changed = true;
	    avatar = Avatar.Jose;
	 }
      }
      //DK Clicked
      xPos = (Config.gameWidth /5.0 * 4.0) - (Config.menuWidth/2.0);	
      yPos = (Config.gameHeight / 17.0 * 7.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
      {
	 System.out.println("Clicked");
  	 if(avatar != Avatar.DK)
	 {
  	    changed = true;
  	    avatar = Avatar.DK;
	 }
      }
	   
	    //Red Clicked
	    xPos = (Config.gameWidth /5.0 * 2.0) - (Config.menuWidth/2.0) ;
	    yPos = (Config.gameHeight / 17.0 * 9.0) - Config.menuHeight /2.0;
	   if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	       System.out.println("Clicked");
	       if(playerColor != Color.RED)
		     {
			changed = true;
			playerColor = Color.RED;
		     }
	    }
	    //Blue Clicked
	    xPos = (Config.gameWidth /5.0 * 4.0) - (Config.menuWidth/2.0) ;
	    yPos = (Config.gameHeight / 17.0 * 9.0) - Config.menuHeight /2.0;
	   if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	       System.out.println("Clicked");
	       if(playerColor != Color.BLUE)
		     {
			changed = true;
			playerColor = Color.BLUE;
		     }
	    }
	    //White Clicked
	    xPos = (Config.gameWidth /5.0 * 3.0) - (Config.menuWidth/2.0) ;
	    yPos = (Config.gameHeight / 17.0 * 9.0) - Config.menuHeight /2.0;
	   if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	       System.out.println("Clicked");
	       if(playerColor != Color.WHITE)
		     {
			changed = true;
			playerColor = Color.WHITE;
		     }
	    }
	    //Cyan Clicked
	    xPos = (Config.gameWidth /5.0 * 2.0) - (Config.menuWidth/2.0) ;
	    yPos = (Config.gameHeight / 17.0 * 11.0) - Config.menuHeight /2.0;
	   if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	       System.out.println("Clicked");
	       if(background != Color.CYAN)
		     {
			changed = true;
			background = Color.CYAN;
		     }
	    }
	    //Gray Clicked
	    xPos = (Config.gameWidth  /  5.0 * 3.0) -  (Config.menuWidth/2.0);
	    yPos = (Config.gameHeight / 17.0 * 11.0) - Config.menuHeight /2.0;
	   if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	       System.out.println("Clicked");
	       if(background != Color.lightGray)
		     {
			changed = true;
			background = Color.lightGray;
		     }
	    }

	    //OK Clicked
	    xPos = (Config.gameWidth /3.0 * 1.0) - (Config.menuWidth/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 15.0 - Config.menuHeight /2.0;
	    if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	       if(changed)
	       {
		  Config.playerColor = playerColor;
		  Config.background = background;

		  Config.updateWindow(gameWidth, aspectRatio, avatar);

		  changed = false;
	       }
	      Config.state = State.Menu;
	      Config.game.removeMouseListener(Config.settings);
	      Config.game.addMouseListener(Config.menu);
	    }
	    //Cancel Clicked
	    xPos = (Config.gameWidth /3.0 * 2.0) - (Config.menuWidth/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 15.0 - Config.menuHeight /2.0;
	    if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	    {
	      initialize();

	      Config.state = State.Menu;
	      Config.game.removeMouseListener(Config.settings);
	      Config.game.addMouseListener(Config.menu);
	    }

	}

   public void mousePressed(MouseEvent e)
   {
      boolean play = false;
      int mX = e.getX(), mY = e.getY();

      //1080 Clicked
      double xPos = ((Config.gameWidth/5.0) * 2.0) - (Config.menuWidth/2.0);
      double yPos = ((Config.gameHeight/17.0) * 3.0) - (Config.menuHeight/2.0);
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      //720 Clicked
      xPos = (Config.gameWidth /5.0 * 3.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 3.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      //480 Clicked
      xPos = (Config.gameWidth /5.0 * 4.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 3.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;
      
      //16:9 Clicked
      xPos = (Config.gameWidth /5.0 * 2.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 5.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      //4:3 Clicked
      xPos = ((Config.gameWidth /5.0) * 3.0) - (Config.menuWidth/2.0) ;
      yPos = ((Config.gameHeight / 17.0) * 5.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      //Beta Clicked
      xPos = ((Config.gameWidth /5.0) * 2.0) - (Config.menuWidth/2.0) ;
      yPos = ((Config.gameHeight / 17.0) * 7.0) - (Config.menuHeight /2.0);
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      //Jose Clicked
      xPos = (Config.gameWidth /5.0 * 3.0) - (Config.menuWidth/2.0) ;
      yPos = (Config.gameHeight / 17.0 * 7.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      //DK Clicked
      xPos = (Config.gameWidth /5.0 * 4.0) - (Config.menuWidth/2.0);	
      yPos = (Config.gameHeight / 17.0 * 7.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;
	   
	    //Red Clicked
      xPos = (Config.gameWidth /5.0 * 2.0) - (Config.menuWidth/2.0) ;
      yPos = (Config.gameHeight / 17.0 * 9.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

	    //Blue Clicked
      xPos = (Config.gameWidth /5.0 * 4.0) - (Config.menuWidth/2.0) ;
      yPos = (Config.gameHeight / 17.0 * 9.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

	    //White Clicked
      xPos = (Config.gameWidth /5.0 * 3.0) - (Config.menuWidth/2.0) ;
      yPos = (Config.gameHeight / 17.0 * 9.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

	    //Cyan Clicked
      xPos = (Config.gameWidth /5.0 * 2.0) - (Config.menuWidth/2.0) ;
      yPos = (Config.gameHeight / 17.0 * 11.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

	    //Gray Clicked
      xPos = (Config.gameWidth  /  5.0 * 3.0) -  (Config.menuWidth/2.0);
      yPos = (Config.gameHeight / 17.0 * 11.0) - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

	    //OK Clicked
      xPos = (Config.gameWidth /3.0 * 1.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 15.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

	    //Cancel Clicked
      xPos = (Config.gameWidth /3.0 * 2.0) - (Config.menuWidth/2.0) ;
      yPos = Config.gameHeight / 17.0 * 15.0 - Config.menuHeight /2.0;
      if(mouseOver(mX, mY, (int)xPos, (int)yPos, Config.menuWidth, Config.menuHeight))
	 play = true;

      if(play)
	 Config.audio.getSound("select").play();
   }
	public void mouseReleased(MouseEvent e){}

	public void tick(){}

	private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height)
	{return mouseX > x &&  mouseX < (x+width) && mouseY > y && mouseY < (y+height);}

	public void render(Graphics g)
	{
	    width = Config.menuWidth;
	    height = Config.menuHeight;

	    g.setColor(Color.WHITE);
	    g.setFont(Config.largeFont);
	    double xPos = ((Config.gameWidth / 2.0) - (g.getFontMetrics().stringWidth("Settings"))  / 2.0);
	    double yPos = ((Config.gameHeight/17.0) * 1.0) + g.getFontMetrics().getHeight() /4.0;
	    g.drawString("Settings", (int)xPos, (int)yPos);

	    g.setColor(Color.WHITE);
	    g.setFont(Config.smallFont);
	    xPos = ((Config.gameWidth / 5.0) * 1.0) - (g.getFontMetrics().stringWidth("Resolution: ")  / 2.0);
	    yPos = ((Config.gameHeight/17.0) * 3.0) + g.getFontMetrics().getHeight() /4.0;
	    g.drawString("Resolution:", (int)xPos, (int)yPos);

	   //1080 Box
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 3.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //1080 Settings
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (g.getFontMetrics().stringWidth("1080")/2.0);
	    yPos = (Config.gameHeight /17.0 * 3.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("1080", (int)xPos, (int)yPos);

	   //720 Box
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 3.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	    //720 Text
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (g.getFontMetrics().stringWidth("720")/2.0);
	    yPos = (Config.gameHeight /17.0 * 3.0) + (g.getFontMetrics().getHeight()/4.0)+1;
	    g.drawString("720", (int)xPos, (int)yPos);

	   // 480 Box
	    g.setColor(Color.BLACK);
	    xPos = ((Config.gameWidth /5.0) * 4.0) - (width/2.0) ;
	    yPos = ((Config.gameHeight /17.0* 3.0) - (height /2.0));
	    g.fillRect((int)xPos, (int)yPos, width, height);

	   // 480 Text
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 4.0) - (g.getFontMetrics().stringWidth("480")/2.0);
	    yPos = (Config.gameHeight /17.0 * 3.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("480", (int)xPos, (int)yPos);

	    //AsepctR
	    g.setColor(Color.WHITE);
	    xPos = ((Config.gameWidth / 5.0) * 1.0) - (g.getFontMetrics().stringWidth("Aspect Ratio: ")  / 2.0);
	    yPos = ((Config.gameHeight/17.0) * 5.0) + g.getFontMetrics().getHeight() /4.0;
	    g.drawString("Aspect Ratio: ", (int)xPos, (int)yPos);

	   //16:9 Box
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 5.0 - (height /2.0);
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //16:9 Text
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (g.getFontMetrics().stringWidth("1080")/2.0);
	    yPos = (Config.gameHeight /17.0 * 5.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("16:9", (int)xPos, (int)yPos);

	   // 4:3 Box
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (width/2.0);
	    yPos = Config.gameHeight / 17.0 * 5.0 - (height /2.0);
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   // 4:3 Text
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (g.getFontMetrics().stringWidth("720")/2.0);
	    yPos = (Config.gameHeight /17.0 * 5.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("4:3", (int)xPos, (int)yPos);

	    //Player Box
	    g.setColor(Color.WHITE);
	    xPos = ((Config.gameWidth / 5.0) * 1.0) - (g.getFontMetrics().stringWidth("Player: ")  / 2.0);
	    yPos = ((Config.gameHeight/17.0) * 7.0) + g.getFontMetrics().getHeight() /4.0;
	    g.drawString("Player: ", (int)xPos, (int)yPos);
	    
	   //BetaBox
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 7.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //Beta Text 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (g.getFontMetrics().stringWidth("Beta")/2.0);
	    yPos = (Config.gameHeight /17.0 * 7.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Beta", (int)xPos, (int)yPos);

	   //JoseBox
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 7.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //JoseText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (g.getFontMetrics().stringWidth("Jose")/2.0);
	    yPos = (Config.gameHeight /17.0 * 7.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Jose", (int)xPos, (int)yPos);

	   //DKBox
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 4.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 7.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //DKText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 4.0) - (g.getFontMetrics().stringWidth("DK")/2.0);
	    yPos = (Config.gameHeight /17.0 * 7.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("DK", (int)xPos, (int)yPos);

	    //PlayerColorBox
	    g.setColor(Color.WHITE);
	    xPos = ((Config.gameWidth / 5.0) * 1.0) - (g.getFontMetrics().stringWidth("Player Color: ")  / 2.0);
	    yPos = ((Config.gameHeight/17.0) * 9.0) + g.getFontMetrics().getHeight() /4.0;
	    g.drawString("Player Color: ", (int)xPos, (int)yPos);
	    
	   //REDBox
	    g.setColor(Color.RED);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 9.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //REDText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (g.getFontMetrics().stringWidth("Red")/2.0);
	    yPos = (Config.gameHeight /17.0 * 9.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Red", (int)xPos, (int)yPos);

	   //BLACKBox
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 9.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //BLACKText 
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (g.getFontMetrics().stringWidth("White")/2.0);
	    yPos = (Config.gameHeight /17.0 * 9.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("White", (int)xPos, (int)yPos);

	   //BLUEBox
	    g.setColor(Color.BLUE);
	    xPos = (Config.gameWidth /5.0 * 4.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 9.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //BLUEText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 4.0) - (g.getFontMetrics().stringWidth("Blue")/2.0);
	    yPos = (Config.gameHeight /17.0 * 9.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Blue", (int)xPos, (int)yPos);

	    //BackgroundBox
	    g.setColor(Color.WHITE);
	    xPos = ((Config.gameWidth / 5.0) * 1.0) - (g.getFontMetrics().stringWidth("Background: ")  / 2.0);
	    yPos = ((Config.gameHeight/17.0) * 11.0) + g.getFontMetrics().getHeight() /4.0;
	    g.drawString("Background: ", (int)xPos, (int)yPos);

	   //CyanFill
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 11.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);

	    //CyanBorder
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 11.0 - height /2.0;
	    g.drawRect((int)xPos, (int)yPos, width, height);
   
	   //CyanText 
	    g.setColor(Color.CYAN);
	    xPos = (Config.gameWidth /5.0 * 2.0) - (g.getFontMetrics().stringWidth("Cyan")/2.0);
	    yPos = (Config.gameHeight /17.0 * 11.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Cyan", (int)xPos, (int)yPos);

	   //GrayBox
	    g.setColor(Color.GRAY);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 11.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //GrayText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /5.0 * 3.0) - (g.getFontMetrics().stringWidth("Gray")/2.0);
	    yPos = (Config.gameHeight /17.0 * 11.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Gray", (int)xPos, (int)yPos);

	   //OK
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /3.0 * 1.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 15.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //OKText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /3.0 * 1.0) - (g.getFontMetrics().stringWidth("OK")/2.0);
	    yPos = (Config.gameHeight /17.0 * 15.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("OK", (int)xPos, (int)yPos);

	   //Cancel
	    g.setColor(Color.BLACK);
	    xPos = (Config.gameWidth /3.0 * 2.0) - (width/2.0) ;
	    yPos = Config.gameHeight / 17.0 * 15.0 - height /2.0;
	    g.fillRect((int)xPos, (int)yPos, width, height);
   
	   //CancelText 
	    g.setColor(Color.WHITE);
	    xPos = (Config.gameWidth /3.0 * 2.0) - (g.getFontMetrics().stringWidth("Cancel")/2.0);
	    yPos = (Config.gameHeight /17.0 * 15.0) + (g.getFontMetrics().getHeight()/4.0);
	    g.drawString("Cancel", (int)xPos, (int)yPos);
	}
}
