
public class RectangleTest
{

	public static void main(String[] args)
	{
		Point p = new Point(20,30);
		Rectangle r = new Rectangle(p , 100,200);
		System.out.println(r);
		r.width += 30;
		r.height += 30;
		p.x += 2;
		System.out.println(r);
		r.grow(20, 20);
		r.move(-5, -5);
		System.out.println(r);
		Point a = new Point(20,30);
		try
		{
			Object copy = a.clone();
			System.out.println(a == copy);
			System.out.println(copy);
			a.x = 40;
			System.out.println(a);
			System.out.println(copy);
		} catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
