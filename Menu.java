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

public class Menu extends MouseAdapter
{
   private int width, height;

   public Menu()
   {
      width  = Config.menuWidth;
      height = Config.menuHeight;
   }
	public void mouseClicked(MouseEvent e)
	{
	   int mX = e.getX();
	   int mY = e.getY();

	   //Play
	   double xPos = Config.gameWidth / 2.0       - width  / 2.0;
	   double yPos = Config.gameHeight/ 5.0 * 2.0 - height / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height))
	   {
	      Config.state = State.Game;
	      Config.game.removeMouseListener(Config.menu);
	      Config.audio.getMusic("menu").stop();
	      Config.audio.getMusic("game").loop(Config.pitch, Config.volume);
	   }
	   //Help
	   yPos = Config.gameHeight/ 5.0 * 3.0 - height / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height))
	   //if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height))
	   {
	      Config.state = State.Settings;
	      Config.game.removeMouseListener(Config.menu);
	      Config.game.addMouseListener(Config.settings);
	   }
	   //Quit
	   yPos = Config.gameHeight/ 5.0 * 4.0 - height / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height))
	      System.exit(0);
	}

	public void mousePressed(MouseEvent e)
	{
	   boolean play = false;
	   width = Config.menuWidth;
	   height = Config.menuHeight;
	   int mX = e.getX();
	   int mY = e.getY();

	   double xPos = Config.gameWidth / 2.0       - width  / 2.0;
	   double yPos = Config.gameHeight/ 5.0 * 2.0 - height / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height))
	   play = true;

	   //Help
	   yPos = Config.gameHeight/ 5.0 * 3.0 - height / 2.0;
	   if(mouseOver(mX, mY, (int)  xPos, (int)  yPos, width, height))
	   play = true;
	   //Quit
	   yPos = Config.gameHeight/ 5.0 * 4.0 - height / 2.0;
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

	   Font font1 = new Font("times new roman", 1, 50);
	   Font font2 = new Font("times new roman", 1, 30);

	   g.setColor(Color.BLACK);


	   double xPos = Config.gameWidth / 2.0       - width  / 2.0;
	   double yPos = Config.gameHeight/ 5.0 * 2.0 - height / 2.0;
	   g.drawRect((int)xPos, (int)yPos, width, height);
	   for(int t = 0; t <4; t++)
	      g.drawRect((int)xPos + t, (int)yPos + t, width - (2 * t), height - (2 * t));

	   yPos = Config.gameHeight / 5.0 * 3.0 - height       / 2.0;
	   g.drawRect((int)xPos, (int)yPos, width, height);

	   for(int t = 0; t <4; t++)
	      g.drawRect((int)xPos + t, (int)yPos + t, width - (2 * t), height - (2 * t));
	   yPos = Config.gameHeight / 5.0 * 4.0 - height       / 2.0;
	   g.drawRect((int)xPos, (int)yPos, width, height);

	   for(int t = 0; t <4; t++)
	      g.drawRect((int)xPos + t, (int)yPos + t, width - (2 * t), height - (2 * t));
	   g.setFont(font1);
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth("Menu") /2.0;
	   yPos = Config.gameHeight/5.0 + g.getFontMetrics().getHeight()         /4.0;
	   g.drawString("Menu", (int)xPos, (int)yPos);

	   g.setFont(font2);
	   xPos = Config.gameWidth/ 2.0 - g.getFontMetrics().stringWidth("Play") /2.0;
	   yPos = Config.gameHeight/5.0 * 2.0 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString("Play", (int)xPos, (int)yPos);

	   g.setFont(font2);
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth("Settings") /2.0;
	   yPos = Config.gameHeight/5.0 * 3.0 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString("Settings", (int)xPos, (int)yPos);

	   g.setFont(font2);
	   xPos = Config.gameWidth /2.0 - g.getFontMetrics().stringWidth("Quit") /2.0;
	   yPos = Config.gameHeight/5.0 * 4.0 + g.getFontMetrics().getHeight()   /4.0;
	   g.drawString("Quit", (int)xPos, (int)yPos);
	}
}
