import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.awt.Rectangle;

public class Player extends GameObject
{
	private Handler trail;
	private int size;

	public Player(int x, int y, ID id)
	{
		super(x, y, id);
		trail = new Handler();

		size = Config.playerSize;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, size, size);
	}

	public void tick()
	{
		size = Config.playerSize;
		x += velX;
		y += velY;

		x = Game.teleport(x, size, 0, Config.gameWidth);
		y = Game.teleport(y, size, 0, Config.gameHeight);

		collision();

		trail.addObject(new Trail(x , y, ID.Trail, Config.playerColor, size, size, 0.1f, trail));
		trail.tick();
	}

	private void collision()
	{
		for(GameObject object: Config.handler.list)
			switch(object.getID())
			{
				case BasicEnemy:
				case FastEnemy:
				case SmartEnemy:
				case SmartBossEnemy:
				case Bullet:
				case BossEnemy:
					if(getBounds().intersects(object.getBounds()))
						Config.HEALTH--;

					if(Config.HEALTH <= 0)
					{
					   Config.state = State.End;
					   Config.game.addMouseListener(Config.end);
					}

					break;
				default:
					break;
			}
	}

	public void render(Graphics g)
	{
		size = Config.playerSize;
		g.setColor(Config.playerColor);
		g.fillRect(x, y, size, size);

		trail.render(g);
	}
}
