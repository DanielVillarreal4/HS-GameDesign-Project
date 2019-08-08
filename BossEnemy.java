import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class BossEnemy extends GameObject
{
private int size, shoot, count, spot, pauseTime;
private boolean pause;

   public BossEnemy(int x, int y, ID id)
   {
      super(x, y, id, 0, 5);

      size = Config.bossEnemySize;
      this.x = Config.gameWidth/2 - size/2;
      this.y = -size;

      pauseTime = 10;

      count = 0;
      spot  = 150;
      shoot = 20;
      pause = false;
   }

   public BossEnemy(int x, int y, int down, ID id)
   {
      super(x, y, id, 0, 2);

      size = 64;
      this.x = Config.gameWidth/2 - size/2;
      this.y = -size;
      spot = down;

      count = 0;
      pauseTime = 10;

      shoot = 20;
      pause = false;
   }

   public Rectangle getBounds()
   {
      return new Rectangle(x, y, size, size);
   }

   public void tick()
   {
      size = Config.bossEnemySize;

      if(!pause)
      {
	 x += velX;
	 y += velY;

	 if(y >= Config.gameHeight/2 - size/2)
	 {
	    count++;
	
	    if(count == shoot)
	    {
	       count = 0;
  	       shoot = Config.random.nextInt(75) + 26;
	
	       if(velX == 0)  
		  velX = -3;
	       else
	       {
		  burst();
	    
		  if(velX > 0 && velX <  25) velX++;
		  if(velX < 0 && velX > -25) velX--;
	       }
	    }
	 }
	
	    x = Game.clamp(x, size, 0, Config.gameWidth);
	    y = Game.clamp(y, 1, -size, Config.gameHeight/2 - size/2);
				
	       if(x == 0 || x == Config.gameWidth - (size - 1)) 
		  velX = -velX;
      }
	 else
	    pauseTime--;

	 if(pauseTime == 0)
	 {
	    pause = false;
	    pauseTime = 10;
	 }
   }

   private void burst()
   {
      int speed = Config.bulletSpeed;

      pause = true;

      for(int horr = -speed; horr <= speed; horr += speed)
	 for(int vert = -speed; vert <= speed; vert += speed)
	    if(horr != 0 || vert != 0)
	       Config.handler.addObject(new Bullet(x + 24, y + 24, ID.Bullet, horr, vert));
   }


   public void render(Graphics g)
   {
      size = Config.bossEnemySize;
      
      g.setColor(Color.BLACK);
      g.fillRect(x, y, size, size);
   }
}
