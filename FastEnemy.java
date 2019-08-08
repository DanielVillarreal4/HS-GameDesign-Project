import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class FastEnemy extends GameObject
{
	private int count, size;
	private Handler trail;
	private Random random;

	public FastEnemy( int x, int y, ID id)
	{
		super(x, y, id);

		trail = new Handler();
		random = new Random();

		velX = 10;
		velY = 10;
		count = 0;
		size = Config.defaultEnemySize;
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 16, 16);
	}

	private void initVels()
	{
	   velX = (random.nextInt(21) - 10) * 2;
	   velY = (random.nextInt(21) - 10) * 2;
	   count = 0;
	}

	public void tick()
	{
		size = Config.defaultEnemySize;
		count++;

		if(count % (random.nextInt(75) + 25) == 0)
		   initVels();

		x += velX;
		y += velY;

		x = Game.clamp(x, size, 0, Config.gameWidth);
		if(x == 0)			      velX =  random.nextInt(11)       * 2;
		if(x == Config.gameWidth - (size -1)) velX = (random.nextInt(10) - 10) * 2;

		y = Game.clamp(y, size, 0, Config.gameHeight);
		if(y == 0)			       velY =  random.nextInt(11)       * 2;
		if(y == Config.gameHeight - (size -1)) velY = (random.nextInt(10) - 10) * 2;

		trail.addObject(new Trail(x, y, ID.Trail, Color.BLACK, size, size, 0.05f, trail));
		trail.tick();
	}

	public void render(Graphics g)
	{
		size = Config.defaultEnemySize;
		g.setColor(Color.BLACK);
		g.fillRect(x, y, size, size);
		
		trail.render(g);
	}
}
