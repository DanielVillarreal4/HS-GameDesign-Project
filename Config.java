import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;
/*
 *@compile !javac -cp .;./jars/lwjgl.jar;./jars/slick.jar Game.java
 *
 */

public class Config
{
   public static int gameWidth, gameHeight, HEALTH;
   public static double aspectRatio, hudRatio;
   public static boolean running, teleport;
   public static State state;

   public static int defaultEnemySize, bossEnemySize;
   public static int bulletSpeed, bulletSize;
   public static double playerVelocity, velocityFactor;
   public static int menuWidth, menuHeight;

   private static int largeFontSize, smallFontSize;
   public static Font largeFont, smallFont, hudFont;

   public static int playerSize;
   public static Color playerColor, SEColor;
   public static Color background;

   public static Window window;
   public static Avatar playerAvatar;

   public static Handler handler;

   public static HUD hud;

   public static Settings settings;
   public static Menu menu;
   public static Game game;
   public static End end;
   public static AudioPlayer audio;
   public static float pitch;
   public static float volume;

   public static Random random;

   public Config(Game game, Handler handler, HUD hud, Menu menu, Settings settings, End end, AudioPlayer audio)
   {
      this.handler = handler;
      this.hud = hud;
      this.menu = menu;
      this.game = game;
      this.end = end;
      this.settings = settings;

      this.audio = audio;
      pitch = 0.525f;
      volume = 1.0f;
      audio.getMusic("menu").loop(pitch, volume);

      window = null;

      aspectRatio = 9.0 / 16.0;
      hudRatio = 1.0;
      gameWidth = 1080;
      gameHeight = (int)(gameWidth * aspectRatio);
      
      HEALTH = 100;

      playerAvatar = Avatar.Jose;

      running = false;
      teleport = true;

      state = State.Start;
      game.addMouseListener(menu);

      defaultEnemySize = 16;
      bossEnemySize    = 64;
      bulletSpeed      = 16;
      bulletSize       = 16;

      playerVelocity = 5.0;
      velocityFactor = 3.0;

      menuWidth = 200;
      menuHeight = 50;

      playerSize = 32;
      playerColor = Color.WHITE;
      SEColor = Color.WHITE;
      background = Color.lightGray;

      largeFontSize = 50;
      smallFontSize = 30;

      largeFont = new Font("times new roman", 1, largeFontSize);
      smallFont = new Font("times new roman", 1, smallFontSize);

      random = new Random();
   }

   public static void addWindow(String title, Game game)
   {
      window = new Window(title, game);
   }

   public static void updateWindow(int width, double ratio, Avatar avatar)
   {
      double scaleFactor = (double)width / (double)gameWidth;
      double playerRatio = 1.0;
      hudRatio = scaleFactor;
      
      gameWidth = width;
      gameHeight = (int)(width * ratio);
      aspectRatio = ratio;

      if(avatar == Avatar.Beta)
      {
	 if(playerAvatar == Avatar.Jose)
	    playerRatio = 4.0/3.0;
	 else if(playerAvatar == Avatar.DK)
	    playerRatio = 4.0/2.0;
      }
      else if(avatar == Avatar.Jose)
      {
	 if(playerAvatar == Avatar.Beta)
	    playerRatio = 3.0/4.0;
	 else if(playerAvatar == Avatar.DK)
	    playerRatio = 3.0/2.0;
      }
      else if(avatar == Avatar.DK)
      {
	 if(playerAvatar == Avatar.Beta)
	    playerRatio = 2.0/4.0;
	 else if(playerAvatar == Avatar.Jose)
	    playerRatio = 2.0/3.0;
      }

      playerAvatar = avatar;
      playerSize *= playerRatio;
      playerVelocity *= (1.0 / playerRatio);
      velocityFactor *= (1.0 / playerRatio);

      playerSize *= scaleFactor;
      defaultEnemySize *= scaleFactor;
      bossEnemySize *= scaleFactor;
      bulletSize *= scaleFactor;
      menuWidth *= scaleFactor;
      menuHeight *= scaleFactor;

      largeFontSize *= scaleFactor;
      smallFontSize *= scaleFactor;
      largeFont = new Font("times new roman", 1, largeFontSize);
      smallFont = new Font("times new roman", 1, smallFontSize);

      for(int i = 0; i < handler.list.size(); i++)
      {
	 GameObject object = handler.list.get(i);
	 object.setX((int)(object.getX() * scaleFactor));
	 object.setY((int)(object.getY() * scaleFactor));
      }

      window.newWindow();
   }
}
