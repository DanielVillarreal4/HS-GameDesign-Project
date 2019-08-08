import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class SmartEnemy extends GameObject
{
	private GameObject player;
	private Handler trail;
	private int size;

	public SmartEnemy( int x, int y, ID id, GameObject player)
	{
		super(x, y, id);

		trail = new Handler();
		this.player = player;

		initVels();

		size = Config.defaultEnemySize;
		
	}

	private void initVels()
	{
		int diffX = player.getX() + (Config.playerSize/4) + player.getVelX() * 10 - x;
		int diffY = player.getY() + (Config.playerSize/4) + player.getVelY() * 10 - y;

		for(int i = 30; i > 0; i--)
		{
			velX = diffX / i;
			if(Math.abs(velX) > 0)
				break;
		}
		for(int i = 30; i > 0; i--)
		{
			velY = diffY / i;
			if(Math.abs(velY) > 0)
				break;
		}
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, size, size);
	}

	public void tick()
	{
		size = Config.defaultEnemySize;
		initVels();

		x += velX;
		y += velY;

		x = Game.clamp(x, size, 0, Config.gameWidth);
		y = Game.clamp(y, size, 0, Config.gameHeight);

		trail.addObject(new Trail(x , y, ID.Trail,  Color.BLUE, size, size, 0.05f, trail));
		trail.tick();
	}

	public void render(Graphics g)
	{
		size = Config.defaultEnemySize;
		g.setColor(Config.SEColor);
		g.fillRect(x, y, size, size);
		
		trail.render(g);
	}
}
