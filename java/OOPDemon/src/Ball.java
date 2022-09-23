import java.awt.Color;
import java.awt.Graphics;

public class Ball
{
	public int R, G, B, Size;
	public Vector pos, vel;

	public Ball()
	{
		R = (int) (Math.random() * 255);
		G = (int) (Math.random() * 255);
		B = (int) (Math.random() * 255);
		Size = 20;
		pos = new Vector();
		pos.setX((int) (Math.random() * 200));
		pos.setY((int) (Math.random() * 200 + 250));

		vel = new Vector();
		vel.setX((int) (Math.random() * 20 - 10));
		vel.setY((int) (Math.random() * 20 - 10+5));
	}

	public void draw(Graphics g)
	{
		g.setColor(new Color(R, G, B));
		g.fillOval((int) pos.getX()-Size, (int) pos.getY()-Size, 2*Size, 2*Size);
	}

	public void move()
	{
		pos = pos.add(vel);
		if (pos.getX() + Size > 800)
		{
			pos.setX(800 - Size);
			vel.setX(vel.getX() * -1);
		}

		if (pos.getY() + Size > 500)
		{
			pos.setY(500 - Size);
			vel.setY(vel.getY() * -1);
		}
		if (pos.getX() - Size < 0)
		{

			pos.setX(0 + Size);
			vel.setX(vel.getX() * -1);
		}

		if (pos.getY() - Size < 0)
		{
			pos.setY(0 + Size);
			vel.setY(vel.getY() * -1);
		}
	}
}
