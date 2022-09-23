
public class cat
{

	double x, y;
	static double z;

	public String toString()
	{
		return String.format("x=%f,y=%f,z=%f", x, y, z);
	}
	
	public static void say() {
		System.out.println(z+"MEOW!!");
	}

}
