
public class VectorMain
{
	public static void main(String arags[])
	{
		Vector a = new Vector();
		a.x = 3;
		a.y = 4;
		Vector b = new Vector();
		b.x = 3;
		b.y = 4;

		System.out.println(a.dot(b));
		System.out.println(a.size());
		System.out.println(a.unit());
	}
}
