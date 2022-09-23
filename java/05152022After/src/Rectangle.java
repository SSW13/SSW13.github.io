
public class Rectangle implements Cloneable
{
	public Point corner;
	public double width, height;

	public Rectangle()
	{
		// TODO Auto-generated constructor stub
	}

	public Rectangle(Point corner, double width, double height)
	{
		this.corner = corner;
		this.width = width;
		this.height = height;
	}

	public String toString()
	{
		return "RECT : " + corner + " w : " + width + " h : " + height;
	}

	public void grow(double dx, double dy)
	{
		this.width += dx;
		this.height += dy;
	}

	public void move(double dx, double dy)
	{
		this.corner.x += dx;
		this.corner.y += dy;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
