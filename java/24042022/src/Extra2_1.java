
public class Extra2_1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int i = 0;
		double a = 50000000;
		double b = 70000000;
		while (true)
		{
			a = a * 1.03;
			b = b * 1.02;
			i++;
			if (a >= b)
			{
				break;
			}
			System.out.print(i);
		}
		

	}

}
