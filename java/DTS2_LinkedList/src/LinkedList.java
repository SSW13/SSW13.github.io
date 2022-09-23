import java.awt.Color;
import java.awt.Graphics;

public class LinkedList
{
	public Node header;
	public int size;
	public LinkedList()
	{
		// TODO Auto-generated constructor stub
		header = new Node();
		size = 0;
	}
	
	public void addFirst(int x) 
	{		
		Node  n = new Node(x);
		n.next = header.next;
		header.next = n;
	}
	public void addLast(int x) 
	{		
		Node  n = new Node(x);
		Node p = header;
		while(p.next != null) {
			p = p.next;
		}
		p.next = n;
	}
	public void draw(Graphics g) 
	{
		Node p = header;
		int i =0;
		while(p != null) {
			i++;
			g.setColor(Color.pink);
			g.fillOval(i*50+50, 200, 30, 30);
			g.setColor(Color.black);
			g.drawString(""+p.data, i*50+50+20, 220);
			g.drawLine(i*50+50+30, 215, i*50+50+50, 215);
			
			g.drawLine(i*50+50+40, 215-10, i*50+50+50, 215);
			g.drawLine(i*50+50+40, 215+10, i*50+50+50, 215);
			
			p = p.next;
		}
	}
}
