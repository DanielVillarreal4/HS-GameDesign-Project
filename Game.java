import java.io.Serializable;
import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SlickException;
import java.lang.reflect.Field;

/*
 * *@compile !javac -cp .;./jars/lwjgl.jar;./jars/slick.jar *.java
 * @run java -cp .;./jars/jogg-0.0.7.jar;./jars/jorbis-0.0.15.jar;./jars/lwjgl.jar;./jars/slick.jar Game
 *
 * jar cvfm Game.jar Manifest.txt *.class *.java jars libs sound
 * jar xvf Game.jar jars libs sound
 *
 *@run java -Djava.library.path=./libs -cp .;./jars/jogg-0.0.7.jar;./jars/jorbis-0.0.15.jar;./jars/lwjgl.jar;./jars/slick.jar Game
 */

public class Game extends Canvas implements Runnable, Serializable
{
   private static final long serialVersionUID = -3039251693953568281L;

   private Thread thread;
   private Handler handler, particle;
   private HUD hud;
   private Spawn spawn;
   private Menu menu;
   private Settings settings;
   private Random random;
   private End end;
   private AudioPlayer audio;
   
   public Game()
   {
      handler = new Handler();
      particle = new Handler();
      hud = new HUD();
      spawn = new Spawn();
      menu = new Menu();
      end = new End();
      audio = new AudioPlayer();
      settings = new Settings();

      new Config(this, handler, hud, menu, settings, end, audio);

      thread = new Thread(this);

      this.addKeyListener(new KeyInput());

      Config.addWindow("Let's Build a Game!", this);
      
      random = new Random();

      for(int i = 0; i <= 30; i++)
      {
	 int x = random.nextInt(Config.gameWidth);
	 int y = random.nextInt(Config.gameHeight);
	 particle.addObject(new MenuParticle(x, y, ID.MenuParticle));
      }
   }

   public synchronized void start()
   {
      thread.start();
      Config.running = true;
   }

   public synchronized void stop()
   {
      try
      {
      	thread.join();
	Config.running = false;
      }
      catch(Exception e)
      {
      	e.printStackTrace();
      }
   }

   public void run()
   {
      this.requestFocus();
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;

      while(Config.running)	
      {
	 long now = System.nanoTime();
	 delta += (now - lastTime) / ns;
         lastTime = now;

	 while(delta >= 1)
	 {
	    tick();
	    delta--;
	 }

	 if(Config.running)
	    render();
	    frames++;

	 if(System.currentTimeMillis() - timer > 1000)
	 {
	    timer += 1000;
	    System.out.println("FPS: " + frames);
	    frames = 0;
	 }
      }
      stop();
   }

   private void tick()
   {
      if(Config.state == State.Game)
      {
	 hud.tick();
	 handler.tick();
	 spawn.tick();
      }

      else if(Config.state == State.Menu || Config.state == State.Start)
      {
	 particle.tick();
	 menu.tick();
      }

      else if(Config.state == State.Settings)
      {
	 particle.tick();
	 settings.tick();
      }
      else if(Config.state == State.End)
      {
	 particle.tick();
	 end.tick();
      }
   }

   private void render()
   {
      BufferStrategy bs = this.getBufferStrategy();

      if(bs == null)
      {
	 this.createBufferStrategy(3);
	 bs = this.getBufferStrategy();
      }
	    
      Graphics g = bs.getDrawGraphics();

      g.setColor(Config.background);
      g.fillRect(0, 0, Config.gameWidth, Config.gameHeight);

      if(Config.state == State.Game)
      {
	 hud.render(g);
	 handler.render(g);
	 spawn.render(g);
      }
      else if(Config.state == State.Menu || Config.state == State.Start)
      {
	 particle.render(g);
	 menu.render(g);
      }
      else if(Config.state == State.Settings)
      {
	 particle.render(g);
	 settings.render(g);
      }
      else if(Config.state == State.End)
      {
	 particle.render(g);
	 end.render(g);
      }
      
      
      g.dispose();
      bs.show();
   }

   public static int teleport(int pos, int pix, int min, int max)
   {
      if(Config.teleport)
      {
	 if((pos + pix) <= 0) return max - 1;
	 if(pos >= max) return min - pix + 1;

	 return pos;
      }
      else
	 return clamp(pos, pix, min, max);
   }

   public static int clamp(int pos, int pix, int min, int max)
   {
      if(pos <= min)
         return min;
      if(pos + (pix - 1) >= max)
         return max - (pix - 1);
      return pos;
   }

   public static void main(String[] args)
   {
      try
      {
	 System.setProperty("java.library.path", "./libs");
	 Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
	 fieldSysPath.setAccessible(true);
	 fieldSysPath.set(null, null);
      }
      catch(Exception e)
      {
	 e.printStackTrace();
      }
      new Game();
   }

}
