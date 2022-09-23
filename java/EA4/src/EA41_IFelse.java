import java.util.Scanner;

public class EA41_IFelse
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a > 13)
		{
			if (b != 6)
			{
				System.out.println("A");
			} else
			{
				if (c <= 7)
				{
					System.out.println("B");
				} else
				{
					System.out.println("C");

				}
			}
		} else
		{
			if (b <= 16)
			{
				System.out.println("D");

			} else
			{
				if (c > 6)
				{
					System.out.println("E");
				} else
				{
					System.out.println("F");
				}

			}
		}

	}

}
