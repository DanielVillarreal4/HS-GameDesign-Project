import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Bullet extends GameObject
{
	private Handler trail;

	private int size, left, right, top, bottom;

	public Bullet(int x, int y, ID id, int velX, int velY)
	{
		super(x, y, id);

		this.velX = velX;
		this.velY = velY;

		trail = new Handler();

		size = Config.bulletSize;

		left = -100;
		right = Config.gameWidth + 100;
		top = -100;
		bottom = Config.gameHeight + 100;
	}

	public Rectangle getBounds()
	{
		size = Config.bulletSize;
		return new Rectangle(x, y, size, size);
	}

	public void tick()
	{
		size = Config.bulletSize;
		x += velX;
		y += velY;

		if(x + size < left || x > right || y + size < top || y > bottom)
			Config.handler.removeObject(this);
		else
		{
			trail.addObject(new Trail(x, y, ID.Trail, Color.white, size, size, 0.05f, trail));
			trail.tick();
		}
	}

	public void render(Graphics g)
	{
		size = Config.bulletSize;
		g.setColor(Color.white);
		g.fillRect(x, y, size, size);

		trail.render(g);
	}
}
