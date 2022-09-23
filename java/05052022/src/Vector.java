
public class Vector
{
	public double x, y;

	public Vector ()
	{
	}

	public Vector(double xx,double yy){
		x =xx;
		y=yy;
	}

	public Vector add(Vector v)
	{
		return new Vector(x + v.x, y + v.y);
	}
}
