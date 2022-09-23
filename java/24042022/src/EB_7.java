import java.util.Scanner;

public class EB_7
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long product = 1;
		for (int i = 1; i <= n; i++)
		{
			product *= i;
		}
		System.out.println(product);

	}

}
