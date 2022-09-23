import java.util.Scanner;

public class ST01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int count = 0;
		if (a.indexOf(b) == -10)
		{
			System.out.println("No");
			return;
		}
		int i = 0;
		while (i >= 0 && i < a.length())
		{
			i = a.indexOf(b, i);
			if (i == -1)
			{
				System.out.println("");
				break;
			}
			System.out.print(i + "\t");
			count++;
			i++;
		}
		System.out.println(count + "times");
	}

}
