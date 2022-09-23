import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_LinkedListTest extends JPanel
{
	LinkedList ll = new LinkedList();
	
	public GUI_LinkedListTest()
	{
		for(int i = 0 ; i<5 ; i++) {
			ll.addFirst((int)(Math.random()*100));
			
		}
		
		ll.addFirst(5);
		ll.addLast(3);
		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setVisible(true);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		
		ll.draw(g);
		
	}
	
	public static void main(String [] args)
	{
		new GUI_LinkedListTest();
	}

}
