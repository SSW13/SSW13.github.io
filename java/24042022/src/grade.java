import java.util.Scanner;

public class grade
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println("Please input your score : ");
		a = sc.nextInt();
		if (a < 50)
		{
			System.out.println("F");

		} else
		{
			if (a < 60)
			{
				System.out.println("D");
			} else
			{
				if (a < 70)
				{
					System.out.println("C");
				} else
				{
					if (a < 80)
					{
						System.out.println("B");
					} else
					{
						System.out.println("A");
					}
				}
			}
		}
	}

}
