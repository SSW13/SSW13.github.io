import java.util.Arrays;
import java.util.Scanner;

public class test_loop
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[10];

		for (int i = 0; i < x.length; i++)
		{
			x[i] = sc.nextInt();
		}

		for (int j = 0; j < x.length; j++)
		{
			for (int i = 0; i < x.length - 1 - j; i++)
			{
				if (x[i] < x[i + 1])
				{
					int t = x[i];
					x[i] = x[i + 1];
					x[i + 1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(x));
	}

}
