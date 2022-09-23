
public class Vector
{
	double x, y;

	public Vector() // constructor คือ method ที่ชื่อเหมือน class
	{
		x = 0;
		y = 0;
	}

	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vector add(Vector v)
	{
		Vector result = new Vector();
		result.x = v.x + this.x;
		result.y = v.y + this.y;
		return result;
	}
	public Vector sub(Vector v)
	{
		Vector result = new Vector();
		result.x = this.x - v.x;
		result.y = this.y - v.y;
		return result;
	}
	public Vector mul(double m)
	{
		Vector result = new Vector();
		result.x = this.x*m;
		result.y = this.y*m;
		return result;
	}
	public double dot(Vector v)
	{
		double result;
		result = this.x*v.x + this.y*v.y;
		return result;
	}
	public double size() {
		double result = Math.sqrt(x*x+y*y);
		return result;
	}
	public Vector unit() {
		double s = size();
		Vector result = new Vector();
		result.x = x/s;
		result.y = y/s;
		return result;
	}

	public String toString()
	{
		return "("+x+" "+y+")";
	}

}
