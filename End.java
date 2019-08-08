import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;

public class End extends MouseAdapter
{
   private int width, height;

   public End() {width  = Config.menuWidth; height = Config.menuHeight;}
	public void mouseClicked(MouseEvent e)
	{
	   int mX = e.getX();
	   int mY = e.getY();

	   //Quit
	   double xPos = (Config.gameWidth / 2.0)     - (width  / 2.0);
	   double yPos =  Config.gameHeight/ 5.0 * 4.0 - height  / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height)) System.exit(0);

	   //Play Again?
	   yPos =  Config.gameHeight/ 5.0 * 3.0 - height  / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height)) 
	   {
	      Config.handler.clearEnemies();
	      Config.handler.removePlayer();

	      Config.hud.setScore(0);
	      Config.hud.setLevel(1);
	      Config.HEALTH = 100;

	      Config.game.removeMouseListener(Config.end);
	      Config.game.addMouseListener(Config.menu);
	      Config.state = State.Menu;
	      Config.audio.getMusic("game").stop();
	      Config.audio.getMusic("menu").loop(Config.pitch, Config.volume);

	   }
	}

	public void mousePressed(MouseEvent e)
	{
	   boolean play = false;

	   width = Config.menuWidth;
	   height = Config.menuHeight;

	   int mX = e.getX();
	   int mY = e.getY();

	   //Quit
	   double xPos = (Config.gameWidth / 2.0)     - (width  / 2.0);
	   double yPos =  Config.gameHeight/ 5.0 * 4.0 - height  / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height)) System.exit(0);
	   play = true;

	   //Play Again?
	   yPos =  Config.gameHeight/ 5.0 * 3.0 - height  / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height)) 
	   play = true;

	   if(play)
	      Config.audio.getSound("select").play();
	}
	public void mouseReleased(MouseEvent e){}

	private boolean mouseOver(int mX, int mY, int x , int y, int w, int h)
	{
	   return mX > x && mX < (x + w) && mY > y && mY < (y + h);
	}
	public void tick()
	{
	   width = Config.menuWidth;
	   height = Config.menuHeight;
	}

	public void render(Graphics g)
	{
	   width = Config.menuWidth;
	   height = Config.menuHeight;

	   g.setColor(Color.BLACK);

	   //Play Again?
	   double xPos = (Config.gameWidth / 2.0)       - (width  / 2.0);
	   double yPos = (Config.gameHeight/ 5.0) * 3.0 - (height / 2.0);
	   for(int t = 0; t <4; t++)
	      g.drawRect((int)xPos + t, (int)yPos + t, width - (2 * t), height - (2 * t));

	   //Quit
	   yPos = ((Config.gameHeight/ 5.0) * 4.0) - (height / 2.0);
	   for(int t = 0; t <4; t++)
	      g.drawRect((int)xPos + t, (int)yPos + t, width - (2 * t), height - (2 * t));

	   g.setFont(Config.largeFont);
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth("Game Over") /2.0;
	   yPos = Config.gameHeight/5.0 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString("Game Over", (int)xPos, (int)yPos);

	   g.setFont(Config.smallFont);
	   String s = "Score = " + ((Config.hud.getLevel() - 1) * 200 + Config.hud.getScore());
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth(s) /2.0;
	   yPos = Config.gameHeight/5.0 * 2 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString(s , (int)xPos, (int)yPos);

	   g.setFont(Config.smallFont);
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth("Play Again?") /2.0;
	   yPos = Config.gameHeight/5.0 * 3.0 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString("Play Again?", (int)xPos, (int)yPos);

	   g.setFont(Config.smallFont);
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth("Quit") /2.0;
	   yPos = Config.gameHeight/5.0 * 4.0 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString("Quit", (int)xPos, (int)yPos);
	}
}
