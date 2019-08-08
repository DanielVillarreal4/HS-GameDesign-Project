import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class HUD
{
	private int level, score;
	private double x, y, w, h, row1, row2, fontSize;
	private Font font;

	public HUD()
	{
		score = 0;
		level = 1;

		x = 15.0;
		y = 15.0;
		w = 200.0;
		h = 32.0;
		row1 = 68.0;
		row2 = 90.0;
		fontSize = 22.0;
		font = new Font("times new roman", 0, (int)fontSize);
	}

	public void tick()
	{
		Config.HEALTH = Game.clamp(Config.HEALTH, 1, 0, 100); 
		score++;
	}

	public void render(Graphics g)
	{
	   if(Config.hudRatio != 1.0)
	   {
	    x *= Config.hudRatio;
	    y *= Config.hudRatio;
	    w *= Config.hudRatio;
	    h *= Config.hudRatio;
	    row1 *= Config.hudRatio;
	    row2 *= Config.hudRatio;

	    fontSize *= Config.hudRatio;
	    font = new Font("times new roman", 0, (int)fontSize);

	    Config.hudRatio = 1.0;
	   }
	   int health = (int)(Config.HEALTH * 2 * Config.hudRatio);
	   
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, (int)w, (int)h);

		if(Config.HEALTH > 50)
		g.setColor(Color.GREEN);

		else if(Config.HEALTH > 20)
		g.setColor(Color.YELLOW);

		else
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, (int)((Config.HEALTH / 100.0) * w), (int)h);

		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, (int)w, (int)h);

		g.setFont(font);
		g.drawString("Score: " + score, (int)x, (int)row1);
		g.drawString("Level: " + level, (int)x, (int)row2);

	 }

	public int getScore()
	{ 
		return score;
	}
	public void setScore(int score) 
	{ 
		this.score = score;
	}

	public int getLevel()
	{ 
		return level;
	}
	public void setLevel(int level) 
	{ 
		this.level = level;
	}
}
