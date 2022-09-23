import java.util.ArrayList;
import java.util.Scanner;

public class EH10
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int b;
		for (;;)
		{
			b = sc.nextInt();
			if (b == 0)
				break;
			a.add(b);
		}
		int sumpos = 0;
		int countpos = 0;
		int sumnpos = 0;
		int countnpos = 0;
		for (int i = 0; i < a.size(); i++)
		{
			if (a.get(i) > 0)
			{
				sumpos += a.get(i);
				countpos++;
			} else
			{
				sumnpos += a.get(i);
				countnpos ++;
			}

		}
		System.out.println((double)sumpos/countpos+"\n"+(double)sumnpos/countnpos);

	}

}
