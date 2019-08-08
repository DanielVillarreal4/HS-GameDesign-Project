import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class SmartBossEnemy extends GameObject
{
	private GameObject player;
	private Handler trail;
	private boolean hasTrailHandler;
	private int size;

	public SmartBossEnemy( int x, int y, ID id, GameObject player)
	{
		super(x, y, id);

		trail = new Handler();
		this.player = player;
		size = 96;

		initVels();
		
	}

	private void initVels()
	{
		int diffX = player.getX() + player.getVelX() * 15 - 32 - x;
		int diffY = player.getY() + player.getVelY() * 15 - 32 - y;

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
		initVels();

		x += velX;
		y += velY;

		x = Game.clamp(x, 16, 0, Config.gameWidth);
		y = Game.clamp(y, 16, 0, Config.gameHeight);

		trail.addObject(new Trail(x , y, ID.Trail,  Color.WHITE, 96, 96, 0.05f, trail));
		trail.tick();
	}

	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, 96, 96);
		
		trail.render(g);
	}
}
