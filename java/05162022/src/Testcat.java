
public class Testcat
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		cat c = new cat();
		cat d = new cat();
		c.x = 10;
		c.y = 20;
		c.z = 100;
		
		d.x=15;
		d.y=25;
		d.z = 101;
		
		System.out.println(c);
		System.out.println(d);
		
		cat.say();
	}

}
