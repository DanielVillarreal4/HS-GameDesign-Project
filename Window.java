import java.io.Serializable;
import java.awt.Canvas;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas implements Serializable
{
	private static final long serialVersionUID = -6654181549305397135L;

	private JFrame frame;
	private String title;
	private Game game;
	
	public Window(String title, Game game)
	{
	   this.title = title;
	   this.game = game;
	   windowSettings();

	   game.start();
	}

	private void windowSettings()
	{
	   int width = Config.gameWidth;
	   int height = Config.gameHeight;
	    
	   frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);

		Insets insets = frame.getInsets();
		width += insets.left + insets.right;
		height+= insets.top + insets.bottom;

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
	}

	public void newWindow()
	{
	   frame.dispose();
	   windowSettings();
	}
}
