import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EH7
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--)
		{
			if (a[i] % 2 == 1)
			{
				System.out.println(a[i]);
				break;
			}
		}
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] % 2 == 1)
			{
				System.out.println(a[i]);
				break;
			}
		}
		for (int i = a.length - 1; i >= 0; i--)
		{
			if (a[i] % 2 == 0)
			{
				System.out.println(a[i]);
				break;
			}
		}
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] % 2 == 0)
			{
				System.out.println(a[i]);
				break;
			}
		}
	}

}
