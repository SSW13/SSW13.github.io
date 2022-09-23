import java.util.Scanner;

public class EB_9
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		for (int i = 50000; i >= 1; i--)
		{
			sum = sum+(1.0/i);
		}
			System.out.println(sum);

	}

}
