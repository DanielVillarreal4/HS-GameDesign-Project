import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject
{
   private int count, size;
   private Handler trail;

   public BasicEnemy(int x, int y, ID id)
   {
      super(x, y, id);

      trail = new Handler();
      initVels();
      size = Config.defaultEnemySize;
   }
   
   private void initVels()
   {
	    velX = Config.random.nextInt(21) - 10;
	    velY = Config.random.nextInt(21) - 10;
	    count = 0;
   }
   public Rectangle getBounds()
   {
      return new Rectangle(x, y, size, size);
   }

   public void tick()
   {
      size = Config.defaultEnemySize;

      count++;
   	
      if(count % (Config.random.nextInt(75) + 25) == 0)
	{
	   initVels();
	}

	x += velX;
	y += velY;

	 x = Game.clamp(x, size, 0, Config.gameWidth);
	 if(x == 0) velX = Config.random.nextInt(11);
	 if(x == Config.gameWidth - (size -1)) velX = Config.random.nextInt(10) - 10;

	 y = Game.clamp(y, size, 0, Config.gameHeight);
	 if(y == 0) velY = Config.random.nextInt(11);
	 if(y == Config.gameWidth - (size -1)) velY = Config.random.nextInt(10) - 10;

	 trail.addObject(new Trail(x , y, ID.Trail,  Color.magenta, size, size, 0.05f, trail));
	 trail.tick();
   }

   public void render(Graphics g)
   {
      size = Config.defaultEnemySize;
	 g.setColor(Color.magenta);
	 g.fillRect(x, y, size, size);
	 
	 trail.render(g);
   }
}
