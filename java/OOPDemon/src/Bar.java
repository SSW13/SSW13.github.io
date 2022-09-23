import java.awt.Color;
import java.awt.Graphics;

public class Bar
{
	public int R, G, B, w, h;
	public Vector pos;
	public Boolean isDead = false;

	public Bar(int x, int y)
	{
		R = (int) (Math.random() * 255);
		G = (int) (Math.random() * 255);
		B = (int) (Math.random() * 255);
		w = 150;
		h = 20;
		pos = new Vector();
		pos.setX(x);
		pos.setY(y);

	}

	public boolean isCollision(Ball b)
	{
		if (b.pos.getX() - b.Size < pos.getX() + w && b.pos.getX() - b.Size > pos.getX() && b.pos.getY() - b.Size < pos.getY() + h
				&& b.pos.getY() - b.Size > pos.getY())
		{
			return true;
		}
		return false;
	}

	public void draw(Graphics g)
	{
		g.setColor(new Color(R, G, B));
		g.fillRect((int) pos.getX(), (int) pos.getY(), w, h);
	}
}
