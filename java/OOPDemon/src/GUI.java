import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel
{
	public Bar bar[][];
	public Ball ball;

	public GUI()
	{
		ball = new Ball();
		bar = new Bar[5][5];
		for (int i = 0; i < bar.length; i++)
		{
			for (int j = 0; j < bar[0].length; j++)
			{
				bar[i][j] = new Bar(j * 152 + 20, i * 22 + 20);
			}
		}

		Thread t = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(20);
					} catch (Exception e)
					{
					}
					ball.move();
					for (int i = 0; i < bar.length; i++)
					{
						for (int j = 0; j < bar[0].length; j++)
						{
							if ( !bar[i][j].isDead && bar[i][j].isCollision(ball))
							{
								bar[i][j].isDead = true;
								ball.vel.setY(ball.vel.getY()*-1);
							}
						}
					}
					repaint();
				}
			}
		});
		t.start();

		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 500);
		f.setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		for (int i = 0; i < bar.length; i++)
		{
			for (int j = 0; j < bar[0].length; j++)
			{
				if (!bar[i][j].isDead)
				{
					bar[i][j].draw(g);
				}
			}
		}
		ball.draw(g);
	}

	public static void main(String[] args)
	{
		new GUI();
	}

}
