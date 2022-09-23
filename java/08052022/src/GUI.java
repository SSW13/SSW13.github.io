import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel
{
	Ball[] balls;
	Rect[] rects;
	

	public GUI()
	{
		balls = new Ball[10];
		for (int i = 0; i < balls.length; i++)
		{
			balls[i] = new Ball();
		}
		rects = new Rect[10];
		for (int i = 0; i < rects.length; i++)
		{
			rects[i] = new Rect();
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
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					for (int i = 0; i < balls.length; i++)
					{
						balls[i].move();
					}
					for (int i = 0; i < rects.length; i++)
					{
						rects[i].move();
					}
					repaint();
				}

			}
		});
		t.start();
		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 800);
		f.setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		for (int i = 0; i < balls.length; i++)
		{
			balls[i].draw(g);
		}
		for (int i = 0; i < rects.length; i++)
		{
			rects[i].draw(g);
		}
	}

	public static void main(String[] args)
	{
		new GUI();

	}

}
