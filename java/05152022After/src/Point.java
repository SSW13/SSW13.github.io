
public class Point implements Cloneable
{
	public double x, y;

	public Point()
	{

	}

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		String result = "(" + Double.toString(x) + "," + Double.toString(y) + ")";
		return result;
	}

	public boolean equals(Object o)
	{
		if (o instanceof Point)
		{
			Point pp = (Point) o;
			return pp.x == x && pp.y == y;
		} else
			return false;
	}

	public Point copyAll()
	{
		return new Point(this.x, this.y);
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
