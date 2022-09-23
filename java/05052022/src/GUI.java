import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GUI extends JFrame
{
	public GUI()
	{
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval((50), 50, 100, 150);
		g.setColor(Color.red);
		g.fillRect(200, 50, 100, 200);
		g.fillOval((50), 50, 100, 150);
		g.fillOval((50), 50, 100, 150);
	}
	public static void main(String[] args) {
		new GUI();
	}
}
