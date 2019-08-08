import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject
{
	private int count, size;
	private Handler trail;
	private Color color;
	private Random random;
	private int R, G, B;

	public MenuParticle(int x, int y, ID id)
	{
		super(x, y, id);

		trail = new Handler();

		velX = 10;
		velY = 10;
		count = 0;
		random = new Random();
		size = Config.defaultEnemySize;

		R = random.nextInt(256);
		G = random.nextInt(256);
		B = random.nextInt(256);
		color = new Color(R, G, B, 125);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 16, 16);
	}
	private void initVels()
	{
	   velX = (random.nextInt(16) - 15);
	   velY = (random.nextInt(16) - 15);
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

		R++; G++; B++;
		if(R > 255) R = 0;
		if(G > 255) G = 0;
		if(B > 255) B = 0;
		color = new Color(R, G, B, 75);

		trail.addObject(new Trail(x, y, ID.Trail, color, size, size, 0.05f, trail));
		trail.tick();
	}

	public void render(Graphics g)
	{
		size = Config.defaultEnemySize;
		g.setColor(color);
		g.fillRect(x, y, size/2, size/2);
		
		trail.render(g);
	}
}
