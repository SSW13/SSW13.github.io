import java.util.Scanner;

public class ST03Parindome
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		for (int i = 0; i < a.length() / 2; i++)
		{
			if (a.charAt(i) != a.charAt(a.length() - 1 - i))
			{
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}

}
