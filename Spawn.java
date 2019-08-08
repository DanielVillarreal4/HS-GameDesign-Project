import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Spawn
{
   public void tick()
   {
      int w = Config.random.nextInt(Config.gameWidth);
      int h = Config.random.nextInt(Config.gameHeight);

      if(Config.hud.getScore() % 200 == 0 && Config.hud.getScore() != 0)
      {
	 Config.hud.setScore(0);
	 Config.hud.setLevel(Config.hud.getLevel() + 1);
      }
      
      if(Config.hud.getLevel() == 1 && Config.hud.getScore() == 1)
      {
	 Config.teleport = true;
	 //Config.handler.clearEnemies();
	 
	    //Config.handler.addObject(new SmartEnemy(w,h,ID.SmartEnemy, getPlayer()));

	 Config.handler.addObject(new Player(Config.gameWidth/2 - 16, Config.gameHeight/2 - 16, ID.Player));

	 for(int i = 0; i < 11; i++)
	    Config.handler.addObject(new BasicEnemy(w,h,ID.BasicEnemy));
      }

      else if(Config.hud.getLevel() == 3 && Config.hud.getScore() == 0)
      {
	 Config.handler.addObject(new SmartEnemy(w, h, ID.SmartEnemy, getPlayer()));
	 //Config.handler.addObject(new SmartEnemy(w, h, ID.SmartEnemy, getPlayer()));
      }
      else if(Config.hud.getLevel() == 5 && Config.hud.getScore() == 1)
      {
	 Config.handler.clearEnemies();
	 for(int i = 0; i < 6; i++)
	 {
	    Config.handler.addObject(new BasicEnemy(w, h,ID.BasicEnemy));
	 }
	 //Config.handler.addObject(new BossEnemy(Config.gameWidth/5 * 2 - 32, Config.gameHeight/5 * 2, ID.BossEnemy));
	 //Config.handler.addObject(new BossEnemy(Config.gameWidth/5 * 4 - 32, Config.gameHeight/5 * 4, 200, ID.BossEnemy));
	 Config.handler.addObject(new BossEnemy(Config.gameWidth/5 * 2 - 32, Config.gameHeight/5 * 2, ID.BossEnemy));
	 Config.handler.addObject(new BossEnemy(Config.gameWidth/5 * 4 - 32, Config.gameHeight/5 * 4, 200, ID.BossEnemy));
	 Config.teleport = false;
      }

    
      else if(Config.hud.getLevel() == 10 && Config.hud.getScore() == 0)
      {
	 Config.handler.clearEnemies();
	 Config.teleport = true;
	 for(int i = 0; i < 11; i++)
	 {
	    Config.handler.addObject(new BasicEnemy(w,h,ID.BasicEnemy));
	    Config.handler.addObject(new FastEnemy(w,h,ID.FastEnemy));
	 }
      }
      else if(Config.hud.getLevel() == 9 && Config.hud.getScore() == 0)
      {
      }
      else if(Config.hud.getLevel() == 13 && Config.hud.getScore() == 0)
      {
	 Config.handler.addObject(new SmartEnemy(w, h, ID.SmartEnemy, getPlayer()));
      }
      else if(Config.hud.getLevel() == 11 && Config.hud.getScore() == 0)
      {
      }
      else if(Config.hud.getLevel() == 15 && Config.hud.getScore() == 0)
      {
	 Config.handler.clearEnemies();
	 Config.teleport = false;
	 Config.handler.addObject(new BossEnemy(Config.gameWidth/5 * 2 - 32, Config.gameHeight/5 * 2, ID.BossEnemy));
	 Config.handler.addObject(new BossEnemy(Config.gameWidth/5 * 4 - 32, Config.gameHeight/5 * 4, 200, ID.BossEnemy));
	 for(int i = 0; i <= 5; i++)
	 {
	    Config.handler.addObject(new BasicEnemy(w,h,ID.BasicEnemy));
	    Config.handler.addObject(new FastEnemy(w,h,ID.FastEnemy));
	 }
      }
   }


   /*private GameObject getPlayer()
   {
      for(GameObject object: Config.handler.list)
	 if(object.getID() == ID.Player)
	
      else if(Config.hud.getLevel() == 5 && Config.hud.getScore() == 0)
      {
	 Config.teleport = true;
	 Config.handler.clearEnemies();
	 
	    Config.handler.addObject(new SmartEnemy(w,h,ID.SmartEnemy, getPlayer()));

	 for(int i = 0; i < 11; i++)
	    Config.handler.addObject(new FastEnemy(w,h,ID.FastEnemy));
      }
      else if(Config.hud.getLevel() == 5 && Config.hud.getScore() == 0)
      {
      }
	 
   }
*/

   private GameObject getPlayer()
   {
      for(GameObject object: Config.handler.list)
	 if(object.getID() == ID.Player)
	    return object;

	 return null;
   }
   public void render(Graphics g){}
}
